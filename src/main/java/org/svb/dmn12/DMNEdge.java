
package org.svb.dmn12;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;


/**
 * <p>Java class for DMNEdge complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DMNEdge">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.omg.org/spec/DMN/20180521/DI/}Edge">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.omg.org/spec/DMN/20180521/DMNDI/}DMNLabel" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="dmnElementRef" use="required" type="{http://www.w3.org/2001/XMLSchema}QName" />
 *       &lt;anyAttribute processContents='lax' namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DMNEdge", namespace = "http://www.omg.org/spec/DMN/20180521/DMNDI/", propOrder = {
    "dmnLabel"
})
public class DMNEdge
    extends Edge
{

    @XmlElement(name = "DMNLabel", namespace = "http://www.omg.org/spec/DMN/20180521/DMNDI/")
    protected DMNLabel dmnLabel;
    @XmlAttribute(name = "dmnElementRef", required = true)
    protected QName dmnElementRef;

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

}
