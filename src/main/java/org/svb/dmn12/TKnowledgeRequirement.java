
package org.svb.dmn12;

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
 *     &lt;extension base="{http://www.omg.org/spec/DMN/20180521/MODEL/}tDMNElement">
 *       &lt;sequence>
 *         &lt;element name="requiredKnowledge" type="{http://www.omg.org/spec/DMN/20180521/MODEL/}tDMNElementReference"/>
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
@XmlType(name = "tKnowledgeRequirement", namespace = "http://www.omg.org/spec/DMN/20180521/MODEL/", propOrder = {
    "requiredKnowledge"
})
public class TKnowledgeRequirement
    extends TDMNElement
{

    @XmlElement(namespace = "http://www.omg.org/spec/DMN/20180521/MODEL/", required = true)
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
