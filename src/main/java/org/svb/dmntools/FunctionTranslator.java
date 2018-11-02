package org.svb.dmntools;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

@XmlRootElement(name = "functions")
public class FunctionTranslator {
    List<Function> functions;

    public List<Function> getFunctions() {
        return functions;
    }

    @XmlElement(name = "function")
    public void setFunctions(List<Function> functions) {
        this.functions = functions;
    }

    public void add(Function function) {
        if (this.functions == null) {
            this.functions = new ArrayList<Function>();
        }
        this.functions.add(function);

    }


    public static FunctionTranslator readFunctionFile(){

        try {

            File file = new File("./src/main/functions.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(FunctionTranslator.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            FunctionTranslator fun = (FunctionTranslator) jaxbUnmarshaller.unmarshal(file);
            System.out.println(fun);

            return fun;

        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return null;
    }

    public String transformFunctions(String inputDMN){

        List<Function> matchedFunctions = new ArrayList<Function>();
        String transformedInput = "";

        matchedFunctions = this.matchFunctions(inputDMN);

        for (Function fu: matchedFunctions ){
           transformedInput =  this.transformFunction(fu, inputDMN);
        }

        return  transformedInput;
    }

    private String transformFunction(Function matchedFunction, String inputDMN){


        List<List<String>> functionArguments = new ArrayList<List<String>>();
        List<String> argsId = Arrays.asList("a","b","c",",d","e","f");
        List<String> functionArgument;
        int leftCharacterIndex;
        int rightCharacterIndex;
        int functionIndex;
        String argument;
        String DMN;

        // find feel function
        functionIndex = inputDMN.indexOf(matchedFunction.getFeelFunctionName());
        leftCharacterIndex = inputDMN.indexOf("(", functionIndex);

        // put arguments in array
        for (int i = 0; i < matchedFunction.getArguments(); i++){

            // set left character index
            if (i > 0) { leftCharacterIndex = inputDMN.indexOf(",", functionIndex); }

            // set right character index
            if (i == matchedFunction.getArguments() - 1 ) {
                rightCharacterIndex = inputDMN.indexOf(")", functionIndex);
            } else {
                rightCharacterIndex = inputDMN.indexOf(",", functionIndex);
            }
            // make array
            functionArgument = new ArrayList<String>(2);
            // find and fill array items
            functionArgument.add("[" + argsId.get(i) + "]");
            argument = inputDMN.substring(leftCharacterIndex + 1, rightCharacterIndex );
            functionArgument.add(argument);
            functionArguments.add(functionArgument);
            // set function index for the next argument
            functionIndex = leftCharacterIndex;
        }

        // place in OPA function, respecting the order of the arguments, they might be changed in OPA
        // this cannot be done in one loop
        leftCharacterIndex = inputDMN.indexOf("(", inputDMN.indexOf(matchedFunction.getFeelFunctionName())) ;
        rightCharacterIndex = inputDMN.indexOf(")", leftCharacterIndex);
        String opaFunction = matchedFunction.getOpaFunction();
        String feelFunction = matchedFunction.getFeelFunctionName() + inputDMN.substring(leftCharacterIndex, rightCharacterIndex + 1);

        for (List<String> arg : functionArguments){
            opaFunction = opaFunction.replace(arg.get(0),arg.get(1));
        }

        DMN = inputDMN.replace(feelFunction,opaFunction);


        return DMN;
    }


    private List<Function> matchFunctions(String inputDMN){

        List<Function> matchedFunctions = new ArrayList<Function>();
        // search for matches in input string

        for (Function fu : this.functions){
            if (inputDMN.indexOf(fu.getFeelFunctionName())!= -1) {
                matchedFunctions.add(fu);
            }
        }
        return matchedFunctions;
    }
}
