
package org.svb.dmn12;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tInformationRequirement complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tInformationRequirement">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.omg.org/spec/DMN/20180521/MODEL/}tDMNElement">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element name="requiredDecision" type="{http://www.omg.org/spec/DMN/20180521/MODEL/}tDMNElementReference"/>
 *           &lt;element name="requiredInput" type="{http://www.omg.org/spec/DMN/20180521/MODEL/}tDMNElementReference"/>
 *         &lt;/choice>
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
@XmlType(name = "tInformationRequirement", namespace = "http://www.omg.org/spec/DMN/20180521/MODEL/", propOrder = {
    "requiredDecision",
    "requiredInput"
})
public class TInformationRequirement
    extends TDMNElement
{

    @XmlElement(namespace = "http://www.omg.org/spec/DMN/20180521/MODEL/")
    protected TDMNElementReference requiredDecision;
    @XmlElement(namespace = "http://www.omg.org/spec/DMN/20180521/MODEL/")
    protected TDMNElementReference requiredInput;

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

}
