
package org.svb.dmn12;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tLiteralExpression complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tLiteralExpression">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.omg.org/spec/DMN/20180521/MODEL/}tExpression">
 *       &lt;choice minOccurs="0">
 *         &lt;element name="text" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="importedValues" type="{http://www.omg.org/spec/DMN/20180521/MODEL/}tImportedValues"/>
 *       &lt;/choice>
 *       &lt;attribute name="expressionLanguage" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *       &lt;anyAttribute processContents='lax' namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tLiteralExpression", namespace = "http://www.omg.org/spec/DMN/20180521/MODEL/", propOrder = {
    "text",
    "importedValues"
})
public class TLiteralExpression
    extends TExpression
{

    @XmlElement(namespace = "http://www.omg.org/spec/DMN/20180521/MODEL/")
    protected String text;
    @XmlElement(namespace = "http://www.omg.org/spec/DMN/20180521/MODEL/")
    protected TImportedValues importedValues;
    @XmlAttribute(name = "expressionLanguage")
    @XmlSchemaType(name = "anyURI")
    protected String expressionLanguage;

    /**
     * Gets the value of the text property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getText() {
        return text;
    }

    /**
     * Sets the value of the text property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setText(String value) {
        this.text = value;
    }

    /**
     * Gets the value of the importedValues property.
     * 
     * @return
     *     possible object is
     *     {@link TImportedValues }
     *     
     */
    public TImportedValues getImportedValues() {
        return importedValues;
    }

    /**
     * Sets the value of the importedValues property.
     * 
     * @param value
     *     allowed object is
     *     {@link TImportedValues }
     *     
     */
    public void setImportedValues(TImportedValues value) {
        this.importedValues = value;
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
