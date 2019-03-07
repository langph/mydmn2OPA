
package org.svb.dmn12;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tAssociation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tAssociation">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.omg.org/spec/DMN/20180521/MODEL/}tArtifact">
 *       &lt;sequence>
 *         &lt;element name="sourceRef" type="{http://www.omg.org/spec/DMN/20180521/MODEL/}tDMNElementReference"/>
 *         &lt;element name="targetRef" type="{http://www.omg.org/spec/DMN/20180521/MODEL/}tDMNElementReference"/>
 *       &lt;/sequence>
 *       &lt;attribute name="associationDirection" type="{http://www.omg.org/spec/DMN/20180521/MODEL/}tAssociationDirection" default="None" />
 *       &lt;anyAttribute processContents='lax' namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tAssociation", namespace = "http://www.omg.org/spec/DMN/20180521/MODEL/", propOrder = {
    "sourceRef",
    "targetRef"
})
public class TAssociation
    extends TArtifact
{

    @XmlElement(namespace = "http://www.omg.org/spec/DMN/20180521/MODEL/", required = true)
    protected TDMNElementReference sourceRef;
    @XmlElement(namespace = "http://www.omg.org/spec/DMN/20180521/MODEL/", required = true)
    protected TDMNElementReference targetRef;
    @XmlAttribute(name = "associationDirection")
    protected TAssociationDirection associationDirection;

    /**
     * Gets the value of the sourceRef property.
     * 
     * @return
     *     possible object is
     *     {@link TDMNElementReference }
     *     
     */
    public TDMNElementReference getSourceRef() {
        return sourceRef;
    }

    /**
     * Sets the value of the sourceRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link TDMNElementReference }
     *     
     */
    public void setSourceRef(TDMNElementReference value) {
        this.sourceRef = value;
    }

    /**
     * Gets the value of the targetRef property.
     * 
     * @return
     *     possible object is
     *     {@link TDMNElementReference }
     *     
     */
    public TDMNElementReference getTargetRef() {
        return targetRef;
    }

    /**
     * Sets the value of the targetRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link TDMNElementReference }
     *     
     */
    public void setTargetRef(TDMNElementReference value) {
        this.targetRef = value;
    }

    /**
     * Gets the value of the associationDirection property.
     * 
     * @return
     *     possible object is
     *     {@link TAssociationDirection }
     *     
     */
    public TAssociationDirection getAssociationDirection() {
        if (associationDirection == null) {
            return TAssociationDirection.NONE;
        } else {
            return associationDirection;
        }
    }

    /**
     * Sets the value of the associationDirection property.
     * 
     * @param value
     *     allowed object is
     *     {@link TAssociationDirection }
     *     
     */
    public void setAssociationDirection(TAssociationDirection value) {
        this.associationDirection = value;
    }

}
