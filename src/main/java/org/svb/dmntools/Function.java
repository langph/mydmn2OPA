package org.svb.dmntools;

import javax.xml.bind.annotation.XmlElement;

public class Function {

    private String feelFunction;
    private String opaFunction;
    private Integer Arguments;

    public String getFeelFunction() {
        return feelFunction;
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

    public Integer getArguments() {
        return Arguments;
    }

    @XmlElement(name = "arg")
    public void setArguments(Integer arguments) {
        Arguments = arguments;
    }

}
