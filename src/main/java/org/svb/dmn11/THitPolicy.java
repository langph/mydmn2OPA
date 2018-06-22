
package org.svb.dmn11;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tHitPolicy.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="tHitPolicy">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="UNIQUE"/>
 *     &lt;enumeration value="FIRST"/>
 *     &lt;enumeration value="PRIORITY"/>
 *     &lt;enumeration value="ANY"/>
 *     &lt;enumeration value="COLLECT"/>
 *     &lt;enumeration value="RULE ORDER"/>
 *     &lt;enumeration value="OUTPUT ORDER"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tHitPolicy", namespace = "http://www.omg.org/spec/DMN/20151101/dmn.xsd")
@XmlEnum
public enum THitPolicy {

    UNIQUE("UNIQUE"),
    FIRST("FIRST"),
    PRIORITY("PRIORITY"),
    ANY("ANY"),
    COLLECT("COLLECT"),
    @XmlEnumValue("RULE ORDER")
    RULE_ORDER("RULE ORDER"),
    @XmlEnumValue("OUTPUT ORDER")
    OUTPUT_ORDER("OUTPUT ORDER");
    private final String value;

    THitPolicy(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static THitPolicy fromValue(String v) {
        for (THitPolicy c: THitPolicy.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
