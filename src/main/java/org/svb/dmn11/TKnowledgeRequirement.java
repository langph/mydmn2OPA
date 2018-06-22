
package org.svb.dmn11;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tKnowledgeRequirement complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tKnowledgeRequirement">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="requiredKnowledge" type="{http://www.omg.org/spec/DMN/20151101/dmn.xsd}tDMNElementReference"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tKnowledgeRequirement", namespace = "http://www.omg.org/spec/DMN/20151101/dmn.xsd", propOrder = {
    "requiredKnowledge"
})
public class TKnowledgeRequirement {

    @XmlElement(namespace = "http://www.omg.org/spec/DMN/20151101/dmn.xsd", required = true)
    protected TDMNElementReference requiredKnowledge;

    /**
     * Gets the value of the requiredKnowledge property.
     * 
     * @return
     *     possible object is
     *     {@link TDMNElementReference }
     *     
     */
    public TDMNElementReference getRequiredKnowledge() {
        return requiredKnowledge;
    }

    /**
     * Sets the value of the requiredKnowledge property.
     * 
     * @param value
     *     allowed object is
     *     {@link TDMNElementReference }
     *     
     */
    public void setRequiredKnowledge(TDMNElementReference value) {
        this.requiredKnowledge = value;
    }

}
