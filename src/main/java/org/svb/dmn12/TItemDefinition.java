
package org.svb.dmn12;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tItemDefinition complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tItemDefinition">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.omg.org/spec/DMN/20180521/MODEL/}tNamedElement">
 *       &lt;choice>
 *         &lt;sequence>
 *           &lt;element name="typeRef" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *           &lt;element name="allowedValues" type="{http://www.omg.org/spec/DMN/20180521/MODEL/}tUnaryTests" minOccurs="0"/>
 *         &lt;/sequence>
 *         &lt;element name="itemComponent" type="{http://www.omg.org/spec/DMN/20180521/MODEL/}tItemDefinition" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/choice>
 *       &lt;attribute name="typeLanguage" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *       &lt;attribute name="isCollection" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *       &lt;anyAttribute processContents='lax' namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tItemDefinition", namespace = "http://www.omg.org/spec/DMN/20180521/MODEL/", propOrder = {
    "typeRef",
    "allowedValues",
    "itemComponent"
})
public class TItemDefinition
    extends TNamedElement
{

    @XmlElement(namespace = "http://www.omg.org/spec/DMN/20180521/MODEL/")
    protected String typeRef;
    @XmlElement(namespace = "http://www.omg.org/spec/DMN/20180521/MODEL/")
    protected TUnaryTests allowedValues;
    @XmlElement(namespace = "http://www.omg.org/spec/DMN/20180521/MODEL/")
    protected List<TItemDefinition> itemComponent;
    @XmlAttribute(name = "typeLanguage")
    @XmlSchemaType(name = "anyURI")
    protected String typeLanguage;
    @XmlAttribute(name = "isCollection")
    protected Boolean isCollection;

    /**
     * Gets the value of the typeRef property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTypeRef() {
        return typeRef;
    }

    /**
     * Sets the value of the typeRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTypeRef(String value) {
        this.typeRef = value;
    }

    /**
     * Gets the value of the allowedValues property.
     * 
     * @return
     *     possible object is
     *     {@link TUnaryTests }
     *     
     */
    public TUnaryTests getAllowedValues() {
        return allowedValues;
    }

    /**
     * Sets the value of the allowedValues property.
     * 
     * @param value
     *     allowed object is
     *     {@link TUnaryTests }
     *     
     */
    public void setAllowedValues(TUnaryTests value) {
        this.allowedValues = value;
    }

    /**
     * Gets the value of the itemComponent property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the itemComponent property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItemComponent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TItemDefinition }
     * 
     * 
     */
    public List<TItemDefinition> getItemComponent() {
        if (itemComponent == null) {
            itemComponent = new ArrayList<TItemDefinition>();
        }
        return this.itemComponent;
    }

    /**
     * Gets the value of the typeLanguage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTypeLanguage() {
        return typeLanguage;
    }

    /**
     * Sets the value of the typeLanguage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTypeLanguage(String value) {
        this.typeLanguage = value;
    }

    /**
     * Gets the value of the isCollection property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isIsCollection() {
        if (isCollection == null) {
            return false;
        } else {
            return isCollection;
        }
    }

    /**
     * Sets the value of the isCollection property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsCollection(Boolean value) {
        this.isCollection = value;
    }

}
