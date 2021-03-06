
package org.svb.dmn11;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tBusinessKnowledgeModel complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tBusinessKnowledgeModel">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.omg.org/spec/DMN/20151101/dmn.xsd}tDRGElement">
 *       &lt;sequence>
 *         &lt;element name="encapsulatedLogic" type="{http://www.omg.org/spec/DMN/20151101/dmn.xsd}tFunctionDefinition" minOccurs="0"/>
 *         &lt;element name="variable" type="{http://www.omg.org/spec/DMN/20151101/dmn.xsd}tInformationItem" minOccurs="0"/>
 *         &lt;element name="knowledgeRequirement" type="{http://www.omg.org/spec/DMN/20151101/dmn.xsd}tKnowledgeRequirement" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="authorityRequirement" type="{http://www.omg.org/spec/DMN/20151101/dmn.xsd}tAuthorityRequirement" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType(name = "tBusinessKnowledgeModel", namespace = "http://www.omg.org/spec/DMN/20151101/dmn.xsd", propOrder = {
    "encapsulatedLogic",
    "variable",
    "knowledgeRequirement",
    "authorityRequirement"
})
public class TBusinessKnowledgeModel
    extends TDRGElement
{

    @XmlElement(namespace = "http://www.omg.org/spec/DMN/20151101/dmn.xsd")
    protected TFunctionDefinition encapsulatedLogic;
    @XmlElement(namespace = "http://www.omg.org/spec/DMN/20151101/dmn.xsd")
    protected TInformationItem variable;
    @XmlElement(namespace = "http://www.omg.org/spec/DMN/20151101/dmn.xsd")
    protected List<TKnowledgeRequirement> knowledgeRequirement;
    @XmlElement(namespace = "http://www.omg.org/spec/DMN/20151101/dmn.xsd")
    protected List<TAuthorityRequirement> authorityRequirement;

    /**
     * Gets the value of the encapsulatedLogic property.
     * 
     * @return
     *     possible object is
     *     {@link TFunctionDefinition }
     *     
     */
    public TFunctionDefinition getEncapsulatedLogic() {
        return encapsulatedLogic;
    }

    /**
     * Sets the value of the encapsulatedLogic property.
     * 
     * @param value
     *     allowed object is
     *     {@link TFunctionDefinition }
     *     
     */
    public void setEncapsulatedLogic(TFunctionDefinition value) {
        this.encapsulatedLogic = value;
    }

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

    /**
     * Gets the value of the knowledgeRequirement property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the knowledgeRequirement property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getKnowledgeRequirement().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TKnowledgeRequirement }
     * 
     * 
     */
    public List<TKnowledgeRequirement> getKnowledgeRequirement() {
        if (knowledgeRequirement == null) {
            knowledgeRequirement = new ArrayList<TKnowledgeRequirement>();
        }
        return this.knowledgeRequirement;
    }

    /**
     * Gets the value of the authorityRequirement property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the authorityRequirement property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAuthorityRequirement().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TAuthorityRequirement }
     * 
     * 
     */
    public List<TAuthorityRequirement> getAuthorityRequirement() {
        if (authorityRequirement == null) {
            authorityRequirement = new ArrayList<TAuthorityRequirement>();
        }
        return this.authorityRequirement;
    }

}
