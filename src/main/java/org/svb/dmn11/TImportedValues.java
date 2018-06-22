
package org.svb.dmn11;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tImportedValues complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tImportedValues">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.omg.org/spec/DMN/20151101/dmn.xsd}tImport">
 *       &lt;sequence>
 *         &lt;element name="importedElement" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *       &lt;attribute name="expressionLanguage" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tImportedValues", namespace = "http://www.omg.org/spec/DMN/20151101/dmn.xsd", propOrder = {
    "importedElement"
})
public class TImportedValues
    extends TImport
{

    @XmlElement(namespace = "http://www.omg.org/spec/DMN/20151101/dmn.xsd", required = true)
    protected String importedElement;
    @XmlAttribute(name = "expressionLanguage")
    @XmlSchemaType(name = "anyURI")
    protected String expressionLanguage;

    /**
     * Gets the value of the importedElement property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImportedElement() {
        return importedElement;
    }

    /**
     * Sets the value of the importedElement property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImportedElement(String value) {
        this.importedElement = value;
    }

    /**
     * Gets the value of the expressionLanguage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpressionLanguage() {
        return expressionLanguage;
    }

    /**
     * Sets the value of the expressionLanguage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpressionLanguage(String value) {
        this.expressionLanguage = value;
    }

}
