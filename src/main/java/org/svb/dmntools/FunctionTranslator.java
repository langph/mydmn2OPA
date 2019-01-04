package org.svb.dmntools;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

@XmlRootElement(name = "functions")
public class FunctionTranslator {

    private List<Function> functions;
    //public static FunctionTranslator ft;


    @XmlElement(name = "function")
    public void setFunctions(List<Function> functions) {
        this.functions = functions;
    }



    public void add(Function function) {
        if (this.functions == null) {
            this.functions = new ArrayList<>();
        }
        this.functions.add(function);
    }

    public void createFunctionInstances(){

        Function fu = new Function();

        fu.setFeelFunction("contains\\((\".*\"),(\".*\")\\)");
        fu.setOpaFunction("Contains($1;$2)");
        this.add(fu);

        fu = new Function();
        fu.setFeelFunction("lower case\\((\".*\")\\)");
        fu.setOpaFunction("Lower($1)");
        this.add(fu);

        fu = new Function();
        fu.setFeelFunction("upper case\\((\".*\")\\)");
        fu.setOpaFunction("Upper($1)");
        this.add(fu);


        fu = new Function();
        fu.setFeelFunction("starts with\\((\".*\"),(\".*\")\\)");
        fu.setOpaFunction("StartsWith($1;$2)");
        this.add(fu);

        fu = new Function();
        fu.setFeelFunction("ends with\\((\".*\"),(\".*\")\\)");
        fu.setOpaFunction("EndsWith($1;$2)");
        this.add(fu);

        fu = new Function();
        fu.setFeelFunction("string\\((\".*\")\\)");
        fu.setOpaFunction("Text($1)");
        this.add(fu);

        fu = new Function();
        fu.setFeelFunction("string length\\((\".*\")\\)");
        fu.setOpaFunction("Length($1)");
        this.add(fu);

        fu = new Function();
        fu.setFeelFunction("substring\\((\".*\"),(\\d*),(\\d*)\\)");
        fu.setOpaFunction("Substring($1;$2;$3)");
        this.add(fu);

        fu = new Function();
        fu.setFeelFunction("date\\((\"[12]\\d{3}-(?:0[1-9]|1[0-2])-(?:0[1-9]|[12]\\d|3[01])\")\\)");
        fu.setOpaFunction("Date($1)");
        this.add(fu);

        fu = new Function();
        fu.setFeelFunction("date\\(([12]\\d{3}),(\\d{2}),(\\d{2})\\)");
        fu.setOpaFunction("Date($1;$2;$3)");
        this.add(fu);

        fu = new Function();
        fu.setFeelFunction("([12]\\d{3}-(?:0[1-9]|1[0-2])-(?:0[1-9]|[12]\\d|3[01]))\\s?([+-])\\s?[P](\\d\\d?)[D]");
        fu.setOpaFunction("AddDays($1;$2)");
        this.add(fu);

        fu = new Function();
        fu.setFeelFunction("([12]\\d{3}-(?:0[1-9]|1[0-2])-(?:0[1-9]|[12]\\d|3[01]))\\s?([+-])\\s?[P](\\d\\d?)[M]");
        fu.setOpaFunction("AddMonths($1;$2)");
        this.add(fu);

        fu = new Function();
        fu.setFeelFunction("([12]\\d{3}-(?:0[1-9]|1[0-2])-(?:0[1-9]|[12]\\d|3[01]))\\s?([+-])\\s?[P](\\d\\d?)[Y]");
        fu.setOpaFunction("AddYears($1;$2)");
        this.add(fu);

    }

    // not implemented because of escape problems in xml
    public static FunctionTranslator readFunctionFile(String folder){

        try {

            File file = new File("./src/main/functions.xml");
            //File file = new File( folder + "/functions.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(FunctionTranslator.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
           // ft = (FunctionTranslator) jaxbUnmarshaller.unmarshal(file);

           // System.out.println(ft);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    String transformFunctions(String inputDMN){

        String transformedInput = inputDMN;

        for (Function fu: this.functions){

            if (transformedInput.matches(fu.getFeelFunction())) {
               transformedInput =  transformedInput.replaceAll(fu.getFeelFunction(), fu.getOpaFunction());
            }
        }

        transformedInput = transformedInput.replace(".", "," );
        return  transformedInput;
    }

}
