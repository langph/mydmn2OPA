
package org.svb.dmn11;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tDecisionRule complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tDecisionRule">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.omg.org/spec/DMN/20151101/dmn.xsd}tDMNElement">
 *       &lt;sequence>
 *         &lt;element name="inputEntry" type="{http://www.omg.org/spec/DMN/20151101/dmn.xsd}tUnaryTests" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="outputEntry" type="{http://www.omg.org/spec/DMN/20151101/dmn.xsd}tLiteralExpression" maxOccurs="unbounded"/>
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
@XmlType(name = "tDecisionRule", namespace = "http://www.omg.org/spec/DMN/20151101/dmn.xsd", propOrder = {
    "inputEntry",
    "outputEntry"
})
public class TDecisionRule
    extends TDMNElement
{

    @XmlElement(namespace = "http://www.omg.org/spec/DMN/20151101/dmn.xsd")
    protected List<TUnaryTests> inputEntry;
    @XmlElement(namespace = "http://www.omg.org/spec/DMN/20151101/dmn.xsd", required = true)
    protected List<TLiteralExpression> outputEntry;

    /**
     * Gets the value of the inputEntry property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the inputEntry property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInputEntry().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TUnaryTests }
     * 
     * 
     */
    public List<TUnaryTests> getInputEntry() {
        if (inputEntry == null) {
            inputEntry = new ArrayList<TUnaryTests>();
        }
        return this.inputEntry;
    }

    /**
     * Gets the value of the outputEntry property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the outputEntry property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOutputEntry().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TLiteralExpression }
     * 
     * 
     */
    public List<TLiteralExpression> getOutputEntry() {
        if (outputEntry == null) {
            outputEntry = new ArrayList<TLiteralExpression>();
        }
        return this.outputEntry;
    }

}
