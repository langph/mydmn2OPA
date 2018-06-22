
package org.svb.dmn11;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tList">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.omg.org/spec/DMN/20151101/dmn.xsd}tExpression">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.omg.org/spec/DMN/20151101/dmn.xsd}expression" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType(name = "tList", namespace = "http://www.omg.org/spec/DMN/20151101/dmn.xsd", propOrder = {
    "expression"
})
public class TList
    extends TExpression
{

    @XmlElementRef(name = "expression", namespace = "http://www.omg.org/spec/DMN/20151101/dmn.xsd", type = JAXBElement.class, required = false)
    protected List<JAXBElement<? extends TExpression>> expression;

    /**
     * Gets the value of the expression property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the expression property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExpression().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link TExpression }{@code >}
     * {@link JAXBElement }{@code <}{@link TInvocation }{@code >}
     * {@link JAXBElement }{@code <}{@link TRelation }{@code >}
     * {@link JAXBElement }{@code <}{@link TContext }{@code >}
     * {@link JAXBElement }{@code <}{@link TList }{@code >}
     * {@link JAXBElement }{@code <}{@link TDecisionTable }{@code >}
     * {@link JAXBElement }{@code <}{@link TFunctionDefinition }{@code >}
     * {@link JAXBElement }{@code <}{@link TLiteralExpression }{@code >}
     * 
     * 
     */
    public List<JAXBElement<? extends TExpression>> getExpression() {
        if (expression == null) {
            expression = new ArrayList<JAXBElement<? extends TExpression>>();
        }
        return this.expression;
    }

}
