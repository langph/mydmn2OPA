
package org.svb.dmn12;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tElementCollection complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tElementCollection">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.omg.org/spec/DMN/20180521/MODEL/}tNamedElement">
 *       &lt;sequence>
 *         &lt;element name="drgElement" type="{http://www.omg.org/spec/DMN/20180521/MODEL/}tDMNElementReference" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType(name = "tElementCollection", namespace = "http://www.omg.org/spec/DMN/20180521/MODEL/", propOrder = {
    "drgElement"
})
public class TElementCollection
    extends TNamedElement
{

    @XmlElement(namespace = "http://www.omg.org/spec/DMN/20180521/MODEL/")
    protected List<TDMNElementReference> drgElement;

    /**
     * Gets the value of the drgElement property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the drgElement property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDrgElement().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TDMNElementReference }
     * 
     * 
     */
    public List<TDMNElementReference> getDrgElement() {
        if (drgElement == null) {
            drgElement = new ArrayList<TDMNElementReference>();
        }
        return this.drgElement;
    }

}
