
package org.svb.dmn12;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tContext complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tContext">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.omg.org/spec/DMN/20180521/MODEL/}tExpression">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.omg.org/spec/DMN/20180521/MODEL/}contextEntry" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType(name = "tContext", namespace = "http://www.omg.org/spec/DMN/20180521/MODEL/", propOrder = {
    "contextEntry"
})
public class TContext
    extends TExpression
{

    @XmlElement(namespace = "http://www.omg.org/spec/DMN/20180521/MODEL/")
    protected List<TContextEntry> contextEntry;

    /**
     * Gets the value of the contextEntry property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the contextEntry property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContextEntry().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TContextEntry }
     * 
     * 
     */
    public List<TContextEntry> getContextEntry() {
        if (contextEntry == null) {
            contextEntry = new ArrayList<TContextEntry>();
        }
        return this.contextEntry;
    }

}
