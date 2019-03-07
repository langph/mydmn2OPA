
package org.svb.dmn12;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tOrganizationUnit complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tOrganizationUnit">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.omg.org/spec/DMN/20180521/MODEL/}tBusinessContextElement">
 *       &lt;sequence>
 *         &lt;element name="decisionMade" type="{http://www.omg.org/spec/DMN/20180521/MODEL/}tDMNElementReference" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="decisionOwned" type="{http://www.omg.org/spec/DMN/20180521/MODEL/}tDMNElementReference" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType(name = "tOrganizationUnit", namespace = "http://www.omg.org/spec/DMN/20180521/MODEL/", propOrder = {
    "decisionMade",
    "decisionOwned"
})
public class TOrganizationUnit
    extends TBusinessContextElement
{

    @XmlElement(namespace = "http://www.omg.org/spec/DMN/20180521/MODEL/")
    protected List<TDMNElementReference> decisionMade;
    @XmlElement(namespace = "http://www.omg.org/spec/DMN/20180521/MODEL/")
    protected List<TDMNElementReference> decisionOwned;

    /**
     * Gets the value of the decisionMade property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the decisionMade property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDecisionMade().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TDMNElementReference }
     * 
     * 
     */
    public List<TDMNElementReference> getDecisionMade() {
        if (decisionMade == null) {
            decisionMade = new ArrayList<TDMNElementReference>();
        }
        return this.decisionMade;
    }

    /**
     * Gets the value of the decisionOwned property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the decisionOwned property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDecisionOwned().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TDMNElementReference }
     * 
     * 
     */
    public List<TDMNElementReference> getDecisionOwned() {
        if (decisionOwned == null) {
            decisionOwned = new ArrayList<TDMNElementReference>();
        }
        return this.decisionOwned;
    }

}
