
package org.svb.dmn12;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tInputClause complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tInputClause">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.omg.org/spec/DMN/20180521/MODEL/}tDMNElement">
 *       &lt;sequence>
 *         &lt;element name="inputExpression" type="{http://www.omg.org/spec/DMN/20180521/MODEL/}tLiteralExpression"/>
 *         &lt;element name="inputValues" type="{http://www.omg.org/spec/DMN/20180521/MODEL/}tUnaryTests" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;anyAttribute processContents='lax' namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tInputClause", namespace = "http://www.omg.org/spec/DMN/20180521/MODEL/", propOrder = {
    "inputExpression",
    "inputValues"
})
public class TInputClause
    extends TDMNElement
{

    @XmlElement(namespace = "http://www.omg.org/spec/DMN/20180521/MODEL/", required = true)
    protected TLiteralExpression inputExpression;
    @XmlElement(namespace = "http://www.omg.org/spec/DMN/20180521/MODEL/")
    protected TUnaryTests inputValues;

    /**
     * Gets the value of the inputExpression property.
     * 
     * @return
     *     possible object is
     *     {@link TLiteralExpression }
     *     
     */
    public TLiteralExpression getInputExpression() {
        return inputExpression;
    }

    /**
     * Sets the value of the inputExpression property.
     * 
     * @param value
     *     allowed object is
     *     {@link TLiteralExpression }
     *     
     */
    public void setInputExpression(TLiteralExpression value) {
        this.inputExpression = value;
    }

    /**
     * Gets the value of the inputValues property.
     * 
     * @return
     *     possible object is
     *     {@link TUnaryTests }
     *     
     */
    public TUnaryTests getInputValues() {
        return inputValues;
    }

    /**
     * Sets the value of the inputValues property.
     * 
     * @param value
     *     allowed object is
     *     {@link TUnaryTests }
     *     
     */
    public void setInputValues(TUnaryTests value) {
        this.inputValues = value;
    }

}
