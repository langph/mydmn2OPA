
package org.svb.dmn12;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tContextEntry complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tContextEntry">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.omg.org/spec/DMN/20180521/MODEL/}tDMNElement">
 *       &lt;sequence>
 *         &lt;element name="variable" type="{http://www.omg.org/spec/DMN/20180521/MODEL/}tInformationItem" minOccurs="0"/>
 *         &lt;element ref="{http://www.omg.org/spec/DMN/20180521/MODEL/}expression"/>
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
@XmlType(name = "tContextEntry", namespace = "http://www.omg.org/spec/DMN/20180521/MODEL/", propOrder = {
    "variable",
    "expression"
})
public class TContextEntry
    extends TDMNElement
{

    @XmlElement(namespace = "http://www.omg.org/spec/DMN/20180521/MODEL/")
    protected TInformationItem variable;
    @XmlElementRef(name = "expression", namespace = "http://www.omg.org/spec/DMN/20180521/MODEL/", type = JAXBElement.class)
    protected JAXBElement<? extends TExpression> expression;

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
     * Gets the value of the expression property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link TRelation }{@code >}
     *     {@link JAXBElement }{@code <}{@link TInvocation }{@code >}
     *     {@link JAXBElement }{@code <}{@link TExpression }{@code >}
     *     {@link JAXBElement }{@code <}{@link TFunctionDefinition }{@code >}
     *     {@link JAXBElement }{@code <}{@link TDecisionTable }{@code >}
     *     {@link JAXBElement }{@code <}{@link TList }{@code >}
     *     {@link JAXBElement }{@code <}{@link TContext }{@code >}
     *     {@link JAXBElement }{@code <}{@link TLiteralExpression }{@code >}
     *     
     */
    public JAXBElement<? extends TExpression> getExpression() {
        return expression;
    }

    /**
     * Sets the value of the expression property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link TRelation }{@code >}
     *     {@link JAXBElement }{@code <}{@link TInvocation }{@code >}
     *     {@link JAXBElement }{@code <}{@link TExpression }{@code >}
     *     {@link JAXBElement }{@code <}{@link TFunctionDefinition }{@code >}
     *     {@link JAXBElement }{@code <}{@link TDecisionTable }{@code >}
     *     {@link JAXBElement }{@code <}{@link TList }{@code >}
     *     {@link JAXBElement }{@code <}{@link TContext }{@code >}
     *     {@link JAXBElement }{@code <}{@link TLiteralExpression }{@code >}
     *     
     */
    public void setExpression(JAXBElement<? extends TExpression> value) {
        this.expression = value;
    }

}
