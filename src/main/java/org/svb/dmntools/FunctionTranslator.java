package org.svb.dmntools;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


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

        Function fu;

        fu = new Function();
        fu.setFeelFunction("contains\\(([^;,\\n\\r]*?),([^;,\\n\\r]*?)\\)");
        fu.setOpaFunction("Contains($1;$2)");
        fu.setRegex(false);
        this.add(fu);

        fu = new Function();
        fu.setFeelFunction("lower case\\(([^;,\\n\\r]*?)\\)");
        fu.setOpaFunction("Lower($1)");
        fu.setRegex(false);
        this.add(fu);

        fu = new Function();
        //fu.setFeelFunction("upper case\\(((?:.*|(?R))?)\\)"); recursive, not supported bij Java
        fu.setFeelFunction("upper case\\(([^;,\\n\\r]*?)\\)");
        fu.setOpaFunction("Upper($1)");
        fu.setRegex(false);
        this.add(fu);


        fu = new Function();
        fu.setFeelFunction("starts with\\((.*?),(.*?)\\)");
        fu.setOpaFunction("StartsWith($1;$2)");
        fu.setRegex(false);
        this.add(fu);

        fu = new Function();
        fu.setFeelFunction("ends with\\((.*?),(.*?)\\)");
        fu.setOpaFunction("EndsWith($1;$2)");
        fu.setRegex(false);
        this.add(fu);

        fu = new Function();
        fu.setFeelFunction("string\\((.*?)\\)");
        fu.setOpaFunction("Text($1)");
        fu.setRegex(false);
        this.add(fu);

        fu = new Function();
        fu.setFeelFunction("string length\\((.*?)\\)");
        fu.setOpaFunction("Length($1)");
        fu.setRegex(false);
        this.add(fu);

        fu = new Function();
        fu.setFeelFunction("substring\\((.*?),(\\d*?),(\\d*?)\\)");
        fu.setOpaFunction("Substring($1;$2;$3)");
        fu.setRegex(false);
        this.add(fu);

        fu = new Function();
        fu.setFeelFunction("date\\((\"[12]\\d{3}-(?:0[1-9]|1[0-2])-(?:0[1-9]|[12]\\d|3[01])\")\\)");
        fu.setOpaFunction("MakenDatum($1)");
        fu.setRegex(false);
        this.add(fu);

        fu = new Function();
        fu.setFeelFunction("date\\(([12]\\d{3}),(\\d{2}),(\\d{2})\\)");
        fu.setOpaFunction("MakenDatum($1;$2;$3)");
        fu.setRegex(false);
        this.add(fu);

        fu = new Function();
        fu.setFeelFunction("([12]\\d{3}-(?:0[1-9]|1[0-2])-(?:0[1-9]|[12]\\d|3[01]))\\s?([+-])\\s?[P](\\d\\d?)[D]");
        fu.setOpaFunction("AddDays($1;$2$3)");
        fu.setRegex(true);
        this.add(fu);

        fu = new Function();
        fu.setFeelFunction("([12]\\d{3}-(?:0[1-9]|1[0-2])-(?:0[1-9]|[12]\\d|3[01]))\\s?([+-])\\s?[P](\\d\\d?)[M]");
        fu.setOpaFunction("AddMonths($1;$2$3)");
        fu.setRegex(true);
        this.add(fu);

        fu = new Function();
        fu.setFeelFunction("([12]\\d{3}-(?:0[1-9]|1[0-2])-(?:0[1-9]|[12]\\d|3[01]))\\s?([+-])\\s?[P](\\d\\d?)[Y]");
        fu.setOpaFunction("AddYears($1;$2$3)");
        fu.setRegex(true);
        this.add(fu);

    }

    public String transformFunctions(String inputDMN){

        // Java does not support recursive regex expressions, and therefore does not always return
        // the correct result with functions inside functions.
        // So until this changes or another solution is found, we only use it if needed: If the transformation is
        // more difficult then just changing the name of the function.
        // Really ugly solution, but no choice for now.

        String transformedInput = inputDMN;

        for (Function fu: this.functions){

            if (fu.getRegex()) {
                transformedInput = this.regexTransform(transformedInput, fu);
            } else {
                transformedInput = transformedInput.replace(fu.getFeelFunctionName(),fu.getOpaFunctionName());
            }
        }
        transformedInput = transformedInput.replace(",", ";" );
        return  transformedInput;
    }


    private String regexTransform(String inputDMN, Function fu){
        String transformedInput = inputDMN;

        Pattern p = Pattern.compile(fu.getFeelFunction());
        Matcher m = p.matcher(transformedInput);
        if (m.find()){
            transformedInput =  transformedInput.replaceAll(fu.getFeelFunction(), fu.getOpaFunction());
            System.out.println("Gevonden " + fu.getFeelFunction() + "Input: " + inputDMN);
        }

        return transformedInput;
    }
}
