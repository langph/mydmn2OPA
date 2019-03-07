
package org.svb.dmn12;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tDecision complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tDecision">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.omg.org/spec/DMN/20180521/MODEL/}tDRGElement">
 *       &lt;sequence>
 *         &lt;element name="question" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="allowedAnswers" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="variable" type="{http://www.omg.org/spec/DMN/20180521/MODEL/}tInformationItem" minOccurs="0"/>
 *         &lt;element name="informationRequirement" type="{http://www.omg.org/spec/DMN/20180521/MODEL/}tInformationRequirement" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="knowledgeRequirement" type="{http://www.omg.org/spec/DMN/20180521/MODEL/}tKnowledgeRequirement" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="authorityRequirement" type="{http://www.omg.org/spec/DMN/20180521/MODEL/}tAuthorityRequirement" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="supportedObjective" type="{http://www.omg.org/spec/DMN/20180521/MODEL/}tDMNElementReference" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="impactedPerformanceIndicator" type="{http://www.omg.org/spec/DMN/20180521/MODEL/}tDMNElementReference" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="decisionMaker" type="{http://www.omg.org/spec/DMN/20180521/MODEL/}tDMNElementReference" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="decisionOwner" type="{http://www.omg.org/spec/DMN/20180521/MODEL/}tDMNElementReference" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="usingProcess" type="{http://www.omg.org/spec/DMN/20180521/MODEL/}tDMNElementReference" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="usingTask" type="{http://www.omg.org/spec/DMN/20180521/MODEL/}tDMNElementReference" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.omg.org/spec/DMN/20180521/MODEL/}expression" minOccurs="0"/>
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
@XmlType(name = "tDecision", namespace = "http://www.omg.org/spec/DMN/20180521/MODEL/", propOrder = {
    "question",
    "allowedAnswers",
    "variable",
    "informationRequirement",
    "knowledgeRequirement",
    "authorityRequirement",
    "supportedObjective",
    "impactedPerformanceIndicator",
    "decisionMaker",
    "decisionOwner",
    "usingProcess",
    "usingTask",
    "expression"
})
public class TDecision
    extends TDRGElement
{

    @XmlElement(namespace = "http://www.omg.org/spec/DMN/20180521/MODEL/")
    protected String question;
    @XmlElement(namespace = "http://www.omg.org/spec/DMN/20180521/MODEL/")
    protected String allowedAnswers;
    @XmlElement(namespace = "http://www.omg.org/spec/DMN/20180521/MODEL/")
    protected TInformationItem variable;
    @XmlElement(namespace = "http://www.omg.org/spec/DMN/20180521/MODEL/")
    protected List<TInformationRequirement> informationRequirement;
    @XmlElement(namespace = "http://www.omg.org/spec/DMN/20180521/MODEL/")
    protected List<TKnowledgeRequirement> knowledgeRequirement;
    @XmlElement(namespace = "http://www.omg.org/spec/DMN/20180521/MODEL/")
    protected List<TAuthorityRequirement> authorityRequirement;
    @XmlElement(namespace = "http://www.omg.org/spec/DMN/20180521/MODEL/")
    protected List<TDMNElementReference> supportedObjective;
    @XmlElement(namespace = "http://www.omg.org/spec/DMN/20180521/MODEL/")
    protected List<TDMNElementReference> impactedPerformanceIndicator;
    @XmlElement(namespace = "http://www.omg.org/spec/DMN/20180521/MODEL/")
    protected List<TDMNElementReference> decisionMaker;
    @XmlElement(namespace = "http://www.omg.org/spec/DMN/20180521/MODEL/")
    protected List<TDMNElementReference> decisionOwner;
    @XmlElement(namespace = "http://www.omg.org/spec/DMN/20180521/MODEL/")
    protected List<TDMNElementReference> usingProcess;
    @XmlElement(namespace = "http://www.omg.org/spec/DMN/20180521/MODEL/")
    protected List<TDMNElementReference> usingTask;
    @XmlElementRef(name = "expression", namespace = "http://www.omg.org/spec/DMN/20180521/MODEL/", type = JAXBElement.class, required = false)
    protected JAXBElement<? extends TExpression> expression;

    /**
     * Gets the value of the question property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQuestion() {
        return question;
    }

    /**
     * Sets the value of the question property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQuestion(String value) {
        this.question = value;
    }

    /**
     * Gets the value of the allowedAnswers property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAllowedAnswers() {
        return allowedAnswers;
    }

    /**
     * Sets the value of the allowedAnswers property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAllowedAnswers(String value) {
        this.allowedAnswers = value;
    }

    /**
     * Gets the value of the variable property.
     * 
     * @return
     *     possible object is
     *     {@link TInformationItem }
     *     
     */
    public TInformationItem getVariable() {
        return variable;
    }

    /**
     * Sets the value of the variable property.
     * 
     * @param value
     *     allowed object is
     *     {@link TInformationItem }
     *     
     */
    public void setVariable(TInformationItem value) {
        this.variable = value;
    }

    /**
     * Gets the value of the informationRequirement property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the informationRequirement property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInformationRequirement().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TInformationRequirement }
     * 
     * 
     */
    public List<TInformationRequirement> getInformationRequirement() {
        if (informationRequirement == null) {
            informationRequirement = new ArrayList<TInformationRequirement>();
        }
        return this.informationRequirement;
    }

    /**
     * Gets the value of the knowledgeRequirement property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the knowledgeRequirement property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getKnowledgeRequirement().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TKnowledgeRequirement }
     * 
     * 
     */
    public List<TKnowledgeRequirement> getKnowledgeRequirement() {
        if (knowledgeRequirement == null) {
            knowledgeRequirement = new ArrayList<TKnowledgeRequirement>();
        }
        return this.knowledgeRequirement;
    }

    /**
     * Gets the value of the authorityRequirement property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the authorityRequirement property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAuthorityRequirement().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TAuthorityRequirement }
     * 
     * 
     */
    public List<TAuthorityRequirement> getAuthorityRequirement() {
        if (authorityRequirement == null) {
            authorityRequirement = new ArrayList<TAuthorityRequirement>();
        }
        return this.authorityRequirement;
    }

    /**
     * Gets the value of the supportedObjective property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the supportedObjective property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSupportedObjective().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TDMNElementReference }
     * 
     * 
     */
    public List<TDMNElementReference> getSupportedObjective() {
        if (supportedObjective == null) {
            supportedObjective = new ArrayList<TDMNElementReference>();
        }
        return this.supportedObjective;
    }

    /**
     * Gets the value of the impactedPerformanceIndicator property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the impactedPerformanceIndicator property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getImpactedPerformanceIndicator().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TDMNElementReference }
     * 
     * 
     */
    public List<TDMNElementReference> getImpactedPerformanceIndicator() {
        if (impactedPerformanceIndicator == null) {
            impactedPerformanceIndicator = new ArrayList<TDMNElementReference>();
        }
        return this.impactedPerformanceIndicator;
    }

    /**
     * Gets the value of the decisionMaker property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the decisionMaker property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDecisionMaker().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TDMNElementReference }
     * 
     * 
     */
    public List<TDMNElementReference> getDecisionMaker() {
        if (decisionMaker == null) {
            decisionMaker = new ArrayList<TDMNElementReference>();
        }
        return this.decisionMaker;
    }

    /**
     * Gets the value of the decisionOwner property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the decisionOwner property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDecisionOwner().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TDMNElementReference }
     * 
     * 
     */
    public List<TDMNElementReference> getDecisionOwner() {
        if (decisionOwner == null) {
            decisionOwner = new ArrayList<TDMNElementReference>();
        }
        return this.decisionOwner;
    }

    /**
     * Gets the value of the usingProcess property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the usingProcess property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUsingProcess().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TDMNElementReference }
     * 
     * 
     */
    public List<TDMNElementReference> getUsingProcess() {
        if (usingProcess == null) {
            usingProcess = new ArrayList<TDMNElementReference>();
        }
        return this.usingProcess;
    }

    /**
     * Gets the value of the usingTask property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the usingTask property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUsingTask().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TDMNElementReference }
     * 
     * 
     */
    public List<TDMNElementReference> getUsingTask() {
        if (usingTask == null) {
            usingTask = new ArrayList<TDMNElementReference>();
        }
        return this.usingTask;
    }

    /**
     * Gets the value of the expression property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link TRelation }{@code >}
     *     {@link JAXBElement }{@code <}{@link TInvocation }{@code >}
     *     {@link JAXBElement }{@code <}{@link TExpression }{@code >}
     *     {@link JAXBElement }{@code <}{@link TFunctionDefinition }{@code >}
     *     {@link JAXBElement }{@code <}{@link TDecisionTable }{@code >}
     *     {@link JAXBElement }{@code <}{@link TList }{@code >}
     *     {@link JAXBElement }{@code <}{@link TContext }{@code >}
     *     {@link JAXBElement }{@code <}{@link TLiteralExpression }{@code >}
     *     
     */
    public JAXBElement<? extends TExpression> getExpression() {
        return expression;
    }

    /**
     * Sets the value of the expression property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link TRelation }{@code >}
     *     {@link JAXBElement }{@code <}{@link TInvocation }{@code >}
     *     {@link JAXBElement }{@code <}{@link TExpression }{@code >}
     *     {@link JAXBElement }{@code <}{@link TFunctionDefinition }{@code >}
     *     {@link JAXBElement }{@code <}{@link TDecisionTable }{@code >}
     *     {@link JAXBElement }{@code <}{@link TList }{@code >}
     *     {@link JAXBElement }{@code <}{@link TContext }{@code >}
     *     {@link JAXBElement }{@code <}{@link TLiteralExpression }{@code >}
     *     
     */
    public void setExpression(JAXBElement<? extends TExpression> value) {
        this.expression = value;
    }

}
