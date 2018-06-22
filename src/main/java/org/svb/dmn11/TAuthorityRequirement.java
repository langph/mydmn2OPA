
package org.svb.dmn11;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tAuthorityRequirement complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tAuthorityRequirement">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="requiredDecision" type="{http://www.omg.org/spec/DMN/20151101/dmn.xsd}tDMNElementReference"/>
 *         &lt;element name="requiredInput" type="{http://www.omg.org/spec/DMN/20151101/dmn.xsd}tDMNElementReference"/>
 *         &lt;element name="requiredAuthority" type="{http://www.omg.org/spec/DMN/20151101/dmn.xsd}tDMNElementReference"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tAuthorityRequirement", namespace = "http://www.omg.org/spec/DMN/20151101/dmn.xsd", propOrder = {
    "requiredDecision",
    "requiredInput",
    "requiredAuthority"
})
public class TAuthorityRequirement {

    @XmlElement(namespace = "http://www.omg.org/spec/DMN/20151101/dmn.xsd")
    protected TDMNElementReference requiredDecision;
    @XmlElement(namespace = "http://www.omg.org/spec/DMN/20151101/dmn.xsd")
    protected TDMNElementReference requiredInput;
    @XmlElement(namespace = "http://www.omg.org/spec/DMN/20151101/dmn.xsd")
    protected TDMNElementReference requiredAuthority;

    /**
     * Gets the value of the requiredDecision property.
     * 
     * @return
     *     possible object is
     *     {@link TDMNElementReference }
     *     
     */
    public TDMNElementReference getRequiredDecision() {
        return requiredDecision;
    }

    /**
     * Sets the value of the requiredDecision property.
     * 
     * @param value
     *     allowed object is
     *     {@link TDMNElementReference }
     *     
     */
    public void setRequiredDecision(TDMNElementReference value) {
        this.requiredDecision = value;
    }

    /**
     * Gets the value of the requiredInput property.
     * 
     * @return
     *     possible object is
     *     {@link TDMNElementReference }
     *     
     */
    public TDMNElementReference getRequiredInput() {
        return requiredInput;
    }

    /**
     * Sets the value of the requiredInput property.
     * 
     * @param value
     *     allowed object is
     *     {@link TDMNElementReference }
     *     
     */
    public void setRequiredInput(TDMNElementReference value) {
        this.requiredInput = value;
    }

    /**
     * Gets the value of the requiredAuthority property.
     * 
     * @return
     *     possible object is
     *     {@link TDMNElementReference }
     *     
     */
    public TDMNElementReference getRequiredAuthority() {
        return requiredAuthority;
    }

    /**
     * Sets the value of the requiredAuthority property.
     * 
     * @param value
     *     allowed object is
     *     {@link TDMNElementReference }
     *     
     */
    public void setRequiredAuthority(TDMNElementReference value) {
        this.requiredAuthority = value;
    }

}
