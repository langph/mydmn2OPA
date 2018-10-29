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




    public static void readFunctionFile(){

        try {

            File file = new File("./src/main/functions.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(FunctionTranslator.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            FunctionTranslator functions = (FunctionTranslator) jaxbUnmarshaller.unmarshal(file);
            System.out.println(functions);

        } catch (JAXBException e) {
            e.printStackTrace();
        }


    }

    public static String transformFunction(String feelFunction){


        return null;
    }

    public static boolean matchFunction(String feelFunction){


        return false;
    }



}
