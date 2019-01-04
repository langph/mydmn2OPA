package org.svb.dmntools;

import javax.xml.bind.annotation.XmlElement;

public class Function {

    private String feelFunction;
    private String opaFunction;

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


}
