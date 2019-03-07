
package org.svb.dmn12;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tBuiltinAggregator.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="tBuiltinAggregator">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="SUM"/>
 *     &lt;enumeration value="COUNT"/>
 *     &lt;enumeration value="MIN"/>
 *     &lt;enumeration value="MAX"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tBuiltinAggregator", namespace = "http://www.omg.org/spec/DMN/20180521/MODEL/")
@XmlEnum
public enum TBuiltinAggregator {

    SUM,
    COUNT,
    MIN,
    MAX;

    public String value() {
        return name();
    }

    public static TBuiltinAggregator fromValue(String v) {
        return valueOf(v);
    }

}
