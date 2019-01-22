package org.svb.dmntools;

import javax.xml.bind.annotation.XmlElement;

public class Function {

    private String feelFunction;
    private String opaFunction;
    private Boolean regex;

    public Boolean getRegex() {
        return regex;
    }

    public void setRegex(Boolean regex) {
        this.regex = regex;
    }


    public String getFeelFunction() {
        return feelFunction;
    }

    public String getOpaFunctionName(){

        String name = "";
        int index = this.opaFunction.indexOf("(");

        if (index > 0) {
            name = this.opaFunction.substring(0, index);
        }

        return name;
    }

    public String getFeelFunctionName(){

        String name = "";
        int index = this.feelFunction.indexOf("\\");

        if (index > 0) {
            name = this.feelFunction.substring(0, index);
        }

        return name;
    }

    @XmlElement(name = "feel")
    public void setFeelFunction(String feelFunction) {

        this.feelFunction = feelFunction;
    }

    public String getOpaFunction() {

        return opaFunction;
    }

    @XmlElement(name = "opa")
    public void setOpaFunction(String opaFunction) {
        this.opaFunction = opaFunction;
    }


}
