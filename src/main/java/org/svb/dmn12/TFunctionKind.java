
package org.svb.dmn12;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tFunctionKind.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="tFunctionKind">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="FEEL"/>
 *     &lt;enumeration value="Java"/>
 *     &lt;enumeration value="PMML"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tFunctionKind", namespace = "http://www.omg.org/spec/DMN/20180521/MODEL/")
@XmlEnum
public enum TFunctionKind {

    FEEL("FEEL"),
    @XmlEnumValue("Java")
    JAVA("Java"),
    PMML("PMML");
    private final String value;

    TFunctionKind(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TFunctionKind fromValue(String v) {
        for (TFunctionKind c: TFunctionKind.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
