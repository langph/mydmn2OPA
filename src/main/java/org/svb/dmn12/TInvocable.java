
package org.svb.dmn12;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tInvocable complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tInvocable">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.omg.org/spec/DMN/20180521/MODEL/}tDRGElement">
 *       &lt;sequence>
 *         &lt;element name="variable" type="{http://www.omg.org/spec/DMN/20180521/MODEL/}tInformationItem" minOccurs="0"/>
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
@XmlType(name = "tInvocable", namespace = "http://www.omg.org/spec/DMN/20180521/MODEL/", propOrder = {
    "variable"
})
@XmlSeeAlso({
    TBusinessKnowledgeModel.class,
    TDecisionService.class
})
public class TInvocable
    extends TDRGElement
{

    @XmlElement(namespace = "http://www.omg.org/spec/DMN/20180521/MODEL/")
    protected TInformationItem variable;

    /**
     * Gets the value of the variable property.
     * 
     * @return
     *     possible object is
     *     {@link TInformationItem }
     *     
     */
    public TInformationItem getVariable() {
        return variable;
    }

    /**
     * Sets the value of the variable property.
     * 
     * @param value
     *     allowed object is
     *     {@link TInformationItem }
     *     
     */
    public void setVariable(TInformationItem value) {
        this.variable = value;
    }

}
