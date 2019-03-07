
package org.svb.dmn12;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tDecisionService complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tDecisionService">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.omg.org/spec/DMN/20180521/MODEL/}tInvocable">
 *       &lt;sequence>
 *         &lt;element name="outputDecision" type="{http://www.omg.org/spec/DMN/20180521/MODEL/}tDMNElementReference" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="encapsulatedDecision" type="{http://www.omg.org/spec/DMN/20180521/MODEL/}tDMNElementReference" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="inputDecision" type="{http://www.omg.org/spec/DMN/20180521/MODEL/}tDMNElementReference" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="inputData" type="{http://www.omg.org/spec/DMN/20180521/MODEL/}tDMNElementReference" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType(name = "tDecisionService", namespace = "http://www.omg.org/spec/DMN/20180521/MODEL/", propOrder = {
    "outputDecision",
    "encapsulatedDecision",
    "inputDecision",
    "inputData"
})
public class TDecisionService
    extends TInvocable
{

    @XmlElement(namespace = "http://www.omg.org/spec/DMN/20180521/MODEL/")
    protected List<TDMNElementReference> outputDecision;
    @XmlElement(namespace = "http://www.omg.org/spec/DMN/20180521/MODEL/")
    protected List<TDMNElementReference> encapsulatedDecision;
    @XmlElement(namespace = "http://www.omg.org/spec/DMN/20180521/MODEL/")
    protected List<TDMNElementReference> inputDecision;
    @XmlElement(namespace = "http://www.omg.org/spec/DMN/20180521/MODEL/")
    protected List<TDMNElementReference> inputData;

    /**
     * Gets the value of the outputDecision property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the outputDecision property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOutputDecision().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TDMNElementReference }
     * 
     * 
     */
    public List<TDMNElementReference> getOutputDecision() {
        if (outputDecision == null) {
            outputDecision = new ArrayList<TDMNElementReference>();
        }
        return this.outputDecision;
    }

    /**
     * Gets the value of the encapsulatedDecision property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the encapsulatedDecision property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEncapsulatedDecision().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TDMNElementReference }
     * 
     * 
     */
    public List<TDMNElementReference> getEncapsulatedDecision() {
        if (encapsulatedDecision == null) {
            encapsulatedDecision = new ArrayList<TDMNElementReference>();
        }
        return this.encapsulatedDecision;
    }

    /**
     * Gets the value of the inputDecision property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the inputDecision property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInputDecision().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TDMNElementReference }
     * 
     * 
     */
    public List<TDMNElementReference> getInputDecision() {
        if (inputDecision == null) {
            inputDecision = new ArrayList<TDMNElementReference>();
        }
        return this.inputDecision;
    }

    /**
     * Gets the value of the inputData property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the inputData property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInputData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TDMNElementReference }
     * 
     * 
     */
    public List<TDMNElementReference> getInputData() {
        if (inputData == null) {
            inputData = new ArrayList<TDMNElementReference>();
        }
        return this.inputData;
    }

}
