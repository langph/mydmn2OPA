
package org.svb.dmn12;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tExpression complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tExpression">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.omg.org/spec/DMN/20180521/MODEL/}tDMNElement">
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
@XmlType(name = "tExpression", namespace = "http://www.omg.org/spec/DMN/20180521/MODEL/")
@XmlSeeAlso({
    TRelation.class,
    TDecisionTable.class,
    TContext.class,
    TFunctionDefinition.class,
    TList.class,
    TInvocation.class,
    TLiteralExpression.class
})
public class TExpression
    extends TDMNElement
{

    @XmlAttribute(name = "typeRef")
    protected String typeRef;

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
