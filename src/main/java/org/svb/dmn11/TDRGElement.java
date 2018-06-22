
package org.svb.dmn11;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tDRGElement complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tDRGElement">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.omg.org/spec/DMN/20151101/dmn.xsd}tNamedElement">
 *       &lt;anyAttribute processContents='lax' namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tDRGElement", namespace = "http://www.omg.org/spec/DMN/20151101/dmn.xsd")
@XmlSeeAlso({
    TKnowledgeSource.class,
    TBusinessKnowledgeModel.class,
    TInputData.class,
    TDecision.class
})
public class TDRGElement
    extends TNamedElement
{


}
