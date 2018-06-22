
package org.svb.dmn11;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tDecisionTableOrientation.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="tDecisionTableOrientation">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Rule-as-Row"/>
 *     &lt;enumeration value="Rule-as-Column"/>
 *     &lt;enumeration value="CrossTable"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tDecisionTableOrientation", namespace = "http://www.omg.org/spec/DMN/20151101/dmn.xsd")
@XmlEnum
public enum TDecisionTableOrientation {

    @XmlEnumValue("Rule-as-Row")
    RULE_AS_ROW("Rule-as-Row"),
    @XmlEnumValue("Rule-as-Column")
    RULE_AS_COLUMN("Rule-as-Column"),
    @XmlEnumValue("CrossTable")
    CROSS_TABLE("CrossTable");
    private final String value;

    TDecisionTableOrientation(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TDecisionTableOrientation fromValue(String v) {
        for (TDecisionTableOrientation c: TDecisionTableOrientation.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
