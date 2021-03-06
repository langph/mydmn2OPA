
package org.svb.dmn12;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DMNDI complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DMNDI">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.omg.org/spec/DMN/20180521/DMNDI/}DMNDiagram" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.omg.org/spec/DMN/20180521/DMNDI/}DMNStyle" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DMNDI", namespace = "http://www.omg.org/spec/DMN/20180521/DMNDI/", propOrder = {
    "dmnDiagram",
    "dmnStyle"
})
public class DMNDI {

    @XmlElement(name = "DMNDiagram", namespace = "http://www.omg.org/spec/DMN/20180521/DMNDI/")
    protected List<DMNDiagram> dmnDiagram;
    @XmlElement(name = "DMNStyle", namespace = "http://www.omg.org/spec/DMN/20180521/DMNDI/")
    protected List<DMNStyle> dmnStyle;

    /**
     * Gets the value of the dmnDiagram property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dmnDiagram property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDMNDiagram().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DMNDiagram }
     * 
     * 
     */
    public List<DMNDiagram> getDMNDiagram() {
        if (dmnDiagram == null) {
            dmnDiagram = new ArrayList<DMNDiagram>();
        }
        return this.dmnDiagram;
    }

    /**
     * Gets the value of the dmnStyle property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dmnStyle property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDMNStyle().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DMNStyle }
     * 
     * 
     */
    public List<DMNStyle> getDMNStyle() {
        if (dmnStyle == null) {
            dmnStyle = new ArrayList<DMNStyle>();
        }
        return this.dmnStyle;
    }

}
