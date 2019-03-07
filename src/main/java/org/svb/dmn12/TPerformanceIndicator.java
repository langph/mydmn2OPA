
package org.svb.dmn12;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tPerformanceIndicator complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tPerformanceIndicator">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.omg.org/spec/DMN/20180521/MODEL/}tBusinessContextElement">
 *       &lt;sequence>
 *         &lt;element name="impactingDecision" type="{http://www.omg.org/spec/DMN/20180521/MODEL/}tDMNElementReference" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType(name = "tPerformanceIndicator", namespace = "http://www.omg.org/spec/DMN/20180521/MODEL/", propOrder = {
    "impactingDecision"
})
public class TPerformanceIndicator
    extends TBusinessContextElement
{

    @XmlElement(namespace = "http://www.omg.org/spec/DMN/20180521/MODEL/")
    protected List<TDMNElementReference> impactingDecision;

    /**
     * Gets the value of the impactingDecision property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the impactingDecision property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getImpactingDecision().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TDMNElementReference }
     * 
     * 
     */
    public List<TDMNElementReference> getImpactingDecision() {
        if (impactingDecision == null) {
            impactingDecision = new ArrayList<TDMNElementReference>();
        }
        return this.impactingDecision;
    }

}
