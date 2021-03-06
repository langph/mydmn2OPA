
package org.svb.dmn12;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;


/**
 * <p>Java class for DMNShape complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DMNShape">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.omg.org/spec/DMN/20180521/DI/}Shape">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.omg.org/spec/DMN/20180521/DMNDI/}DMNLabel" minOccurs="0"/>
 *         &lt;element ref="{http://www.omg.org/spec/DMN/20180521/DMNDI/}DMNDecisionServiceDividerLine" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="dmnElementRef" use="required" type="{http://www.w3.org/2001/XMLSchema}QName" />
 *       &lt;attribute name="isListedInputData" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="isCollapsed" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *       &lt;anyAttribute processContents='lax' namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DMNShape", namespace = "http://www.omg.org/spec/DMN/20180521/DMNDI/", propOrder = {
    "dmnLabel",
    "dmnDecisionServiceDividerLine"
})
public class DMNShape
    extends Shape
{

    @XmlElement(name = "DMNLabel", namespace = "http://www.omg.org/spec/DMN/20180521/DMNDI/")
    protected DMNLabel dmnLabel;
    @XmlElement(name = "DMNDecisionServiceDividerLine", namespace = "http://www.omg.org/spec/DMN/20180521/DMNDI/")
    protected DMNDecisionServiceDividerLine dmnDecisionServiceDividerLine;
    @XmlAttribute(name = "dmnElementRef", required = true)
    protected QName dmnElementRef;
    @XmlAttribute(name = "isListedInputData")
    protected Boolean isListedInputData;
    @XmlAttribute(name = "isCollapsed")
    protected Boolean isCollapsed;

    /**
     * Gets the value of the dmnLabel property.
     * 
     * @return
     *     possible object is
     *     {@link DMNLabel }
     *     
     */
    public DMNLabel getDMNLabel() {
        return dmnLabel;
    }

    /**
     * Sets the value of the dmnLabel property.
     * 
     * @param value
     *     allowed object is
     *     {@link DMNLabel }
     *     
     */
    public void setDMNLabel(DMNLabel value) {
        this.dmnLabel = value;
    }

    /**
     * Gets the value of the dmnDecisionServiceDividerLine property.
     * 
     * @return
     *     possible object is
     *     {@link DMNDecisionServiceDividerLine }
     *     
     */
    public DMNDecisionServiceDividerLine getDMNDecisionServiceDividerLine() {
        return dmnDecisionServiceDividerLine;
    }

    /**
     * Sets the value of the dmnDecisionServiceDividerLine property.
     * 
     * @param value
     *     allowed object is
     *     {@link DMNDecisionServiceDividerLine }
     *     
     */
    public void setDMNDecisionServiceDividerLine(DMNDecisionServiceDividerLine value) {
        this.dmnDecisionServiceDividerLine = value;
    }

    /**
     * Gets the value of the dmnElementRef property.
     * 
     * @return
     *     possible object is
     *     {@link QName }
     *     
     */
    public QName getDmnElementRef() {
        return dmnElementRef;
    }

    /**
     * Sets the value of the dmnElementRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link QName }
     *     
     */
    public void setDmnElementRef(QName value) {
        this.dmnElementRef = value;
    }

    /**
     * Gets the value of the isListedInputData property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsListedInputData() {
        return isListedInputData;
    }

    /**
     * Sets the value of the isListedInputData property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsListedInputData(Boolean value) {
        this.isListedInputData = value;
    }

    /**
     * Gets the value of the isCollapsed property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isIsCollapsed() {
        if (isCollapsed == null) {
            return false;
        } else {
            return isCollapsed;
        }
    }

    /**
     * Sets the value of the isCollapsed property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsCollapsed(Boolean value) {
        this.isCollapsed = value;
    }

}
