
package org.svb.dmn12;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tOutputClause complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tOutputClause">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.omg.org/spec/DMN/20180521/MODEL/}tDMNElement">
 *       &lt;sequence>
 *         &lt;element name="outputValues" type="{http://www.omg.org/spec/DMN/20180521/MODEL/}tUnaryTests" minOccurs="0"/>
 *         &lt;element name="defaultOutputEntry" type="{http://www.omg.org/spec/DMN/20180521/MODEL/}tLiteralExpression" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="typeRef" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;anyAttribute processContents='lax' namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tOutputClause", namespace = "http://www.omg.org/spec/DMN/20180521/MODEL/", propOrder = {
    "outputValues",
    "defaultOutputEntry"
})
public class TOutputClause
    extends TDMNElement
{

    @XmlElement(namespace = "http://www.omg.org/spec/DMN/20180521/MODEL/")
    protected TUnaryTests outputValues;
    @XmlElement(namespace = "http://www.omg.org/spec/DMN/20180521/MODEL/")
    protected TLiteralExpression defaultOutputEntry;
    @XmlAttribute(name = "name")
    protected String name;
    @XmlAttribute(name = "typeRef")
    protected String typeRef;

    /**
     * Gets the value of the outputValues property.
     * 
     * @return
     *     possible object is
     *     {@link TUnaryTests }
     *     
     */
    public TUnaryTests getOutputValues() {
        return outputValues;
    }

    /**
     * Sets the value of the outputValues property.
     * 
     * @param value
     *     allowed object is
     *     {@link TUnaryTests }
     *     
     */
    public void setOutputValues(TUnaryTests value) {
        this.outputValues = value;
    }

    /**
     * Gets the value of the defaultOutputEntry property.
     * 
     * @return
     *     possible object is
     *     {@link TLiteralExpression }
     *     
     */
    public TLiteralExpression getDefaultOutputEntry() {
        return defaultOutputEntry;
    }

    /**
     * Sets the value of the defaultOutputEntry property.
     * 
     * @param value
     *     allowed object is
     *     {@link TLiteralExpression }
     *     
     */
    public void setDefaultOutputEntry(TLiteralExpression value) {
        this.defaultOutputEntry = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

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

}
