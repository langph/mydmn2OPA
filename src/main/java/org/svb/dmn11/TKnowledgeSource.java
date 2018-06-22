
package org.svb.dmn11;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tKnowledgeSource complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tKnowledgeSource">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.omg.org/spec/DMN/20151101/dmn.xsd}tDRGElement">
 *       &lt;sequence>
 *         &lt;element name="authorityRequirement" type="{http://www.omg.org/spec/DMN/20151101/dmn.xsd}tAuthorityRequirement" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="owner" type="{http://www.omg.org/spec/DMN/20151101/dmn.xsd}tDMNElementReference" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="locationURI" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *       &lt;anyAttribute processContents='lax' namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tKnowledgeSource", namespace = "http://www.omg.org/spec/DMN/20151101/dmn.xsd", propOrder = {
    "authorityRequirement",
    "type",
    "owner"
})
public class TKnowledgeSource
    extends TDRGElement
{

    @XmlElement(namespace = "http://www.omg.org/spec/DMN/20151101/dmn.xsd")
    protected List<TAuthorityRequirement> authorityRequirement;
    @XmlElement(namespace = "http://www.omg.org/spec/DMN/20151101/dmn.xsd")
    protected String type;
    @XmlElement(namespace = "http://www.omg.org/spec/DMN/20151101/dmn.xsd")
    protected TDMNElementReference owner;
    @XmlAttribute(name = "locationURI")
    @XmlSchemaType(name = "anyURI")
    protected String locationURI;

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

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the owner property.
     * 
     * @return
     *     possible object is
     *     {@link TDMNElementReference }
     *     
     */
    public TDMNElementReference getOwner() {
        return owner;
    }

    /**
     * Sets the value of the owner property.
     * 
     * @param value
     *     allowed object is
     *     {@link TDMNElementReference }
     *     
     */
    public void setOwner(TDMNElementReference value) {
        this.owner = value;
    }

    /**
     * Gets the value of the locationURI property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocationURI() {
        return locationURI;
    }

    /**
     * Sets the value of the locationURI property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocationURI(String value) {
        this.locationURI = value;
    }

}
