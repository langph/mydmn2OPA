
package org.svb.dmn11;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.svb.dmn11 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Context_QNAME = new QName("http://www.omg.org/spec/DMN/20151101/dmn.xsd", "context");
    private final static QName _DMNElement_QNAME = new QName("http://www.omg.org/spec/DMN/20151101/dmn.xsd", "DMNElement");
    private final static QName _BusinessKnowledgeModel_QNAME = new QName("http://www.omg.org/spec/DMN/20151101/dmn.xsd", "businessKnowledgeModel");
    private final static QName _Definitions_QNAME = new QName("http://www.omg.org/spec/DMN/20151101/dmn.xsd", "definitions");
    private final static QName _Artifact_QNAME = new QName("http://www.omg.org/spec/DMN/20151101/dmn.xsd", "artifact");
    private final static QName _BusinessContextElement_QNAME = new QName("http://www.omg.org/spec/DMN/20151101/dmn.xsd", "businessContextElement");
    private final static QName _NamedElement_QNAME = new QName("http://www.omg.org/spec/DMN/20151101/dmn.xsd", "namedElement");
    private final static QName _DecisionTable_QNAME = new QName("http://www.omg.org/spec/DMN/20151101/dmn.xsd", "decisionTable");
    private final static QName _PerformanceIndicator_QNAME = new QName("http://www.omg.org/spec/DMN/20151101/dmn.xsd", "performanceIndicator");
    private final static QName _Association_QNAME = new QName("http://www.omg.org/spec/DMN/20151101/dmn.xsd", "association");
    private final static QName _Relation_QNAME = new QName("http://www.omg.org/spec/DMN/20151101/dmn.xsd", "relation");
    private final static QName _KnowledgeSource_QNAME = new QName("http://www.omg.org/spec/DMN/20151101/dmn.xsd", "knowledgeSource");
    private final static QName _ElementCollection_QNAME = new QName("http://www.omg.org/spec/DMN/20151101/dmn.xsd", "elementCollection");
    private final static QName _Import_QNAME = new QName("http://www.omg.org/spec/DMN/20151101/dmn.xsd", "import");
    private final static QName _TextAnnotation_QNAME = new QName("http://www.omg.org/spec/DMN/20151101/dmn.xsd", "textAnnotation");
    private final static QName _DecisionService_QNAME = new QName("http://www.omg.org/spec/DMN/20151101/dmn.xsd", "decisionService");
    private final static QName _LiteralExpression_QNAME = new QName("http://www.omg.org/spec/DMN/20151101/dmn.xsd", "literalExpression");
    private final static QName _DrgElement_QNAME = new QName("http://www.omg.org/spec/DMN/20151101/dmn.xsd", "drgElement");
    private final static QName _InformationItem_QNAME = new QName("http://www.omg.org/spec/DMN/20151101/dmn.xsd", "informationItem");
    private final static QName _Invocation_QNAME = new QName("http://www.omg.org/spec/DMN/20151101/dmn.xsd", "invocation");
    private final static QName _OrganizationUnit_QNAME = new QName("http://www.omg.org/spec/DMN/20151101/dmn.xsd", "organizationUnit");
    private final static QName _ItemDefinition_QNAME = new QName("http://www.omg.org/spec/DMN/20151101/dmn.xsd", "itemDefinition");
    private final static QName _List_QNAME = new QName("http://www.omg.org/spec/DMN/20151101/dmn.xsd", "list");
    private final static QName _InputData_QNAME = new QName("http://www.omg.org/spec/DMN/20151101/dmn.xsd", "inputData");
    private final static QName _Expression_QNAME = new QName("http://www.omg.org/spec/DMN/20151101/dmn.xsd", "expression");
    private final static QName _FunctionDefinition_QNAME = new QName("http://www.omg.org/spec/DMN/20151101/dmn.xsd", "functionDefinition");
    private final static QName _Decision_QNAME = new QName("http://www.omg.org/spec/DMN/20151101/dmn.xsd", "decision");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.svb.dmn11
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TDMNElement }
     * 
     */
    public TDMNElement createTDMNElement() {
        return new TDMNElement();
    }

    /**
     * Create an instance of {@link TKnowledgeSource }
     * 
     */
    public TKnowledgeSource createTKnowledgeSource() {
        return new TKnowledgeSource();
    }

    /**
     * Create an instance of {@link TDRGElement }
     * 
     */
    public TDRGElement createTDRGElement() {
        return new TDRGElement();
    }

    /**
     * Create an instance of {@link TNamedElement }
     * 
     */
    public TNamedElement createTNamedElement() {
        return new TNamedElement();
    }

    /**
     * Create an instance of {@link TImport }
     * 
     */
    public TImport createTImport() {
        return new TImport();
    }

    /**
     * Create an instance of {@link TTextAnnotation }
     * 
     */
    public TTextAnnotation createTTextAnnotation() {
        return new TTextAnnotation();
    }

    /**
     * Create an instance of {@link TArtifact }
     * 
     */
    public TArtifact createTArtifact() {
        return new TArtifact();
    }

    /**
     * Create an instance of {@link TElementCollection }
     * 
     */
    public TElementCollection createTElementCollection() {
        return new TElementCollection();
    }

    /**
     * Create an instance of {@link TPerformanceIndicator }
     * 
     */
    public TPerformanceIndicator createTPerformanceIndicator() {
        return new TPerformanceIndicator();
    }

    /**
     * Create an instance of {@link TBusinessContextElement }
     * 
     */
    public TBusinessContextElement createTBusinessContextElement() {
        return new TBusinessContextElement();
    }

    /**
     * Create an instance of {@link TAssociation }
     * 
     */
    public TAssociation createTAssociation() {
        return new TAssociation();
    }

    /**
     * Create an instance of {@link TRelation }
     * 
     */
    public TRelation createTRelation() {
        return new TRelation();
    }

    /**
     * Create an instance of {@link TExpression }
     * 
     */
    public TExpression createTExpression() {
        return new TExpression();
    }

    /**
     * Create an instance of {@link TDecisionTable }
     * 
     */
    public TDecisionTable createTDecisionTable() {
        return new TDecisionTable();
    }

    /**
     * Create an instance of {@link TContext }
     * 
     */
    public TContext createTContext() {
        return new TContext();
    }

    /**
     * Create an instance of {@link TDefinitions }
     * 
     */
    public TDefinitions createTDefinitions() {
        return new TDefinitions();
    }

    /**
     * Create an instance of {@link TBusinessKnowledgeModel }
     * 
     */
    public TBusinessKnowledgeModel createTBusinessKnowledgeModel() {
        return new TBusinessKnowledgeModel();
    }

    /**
     * Create an instance of {@link TInputData }
     * 
     */
    public TInputData createTInputData() {
        return new TInputData();
    }

    /**
     * Create an instance of {@link TDecision }
     * 
     */
    public TDecision createTDecision() {
        return new TDecision();
    }

    /**
     * Create an instance of {@link TFunctionDefinition }
     * 
     */
    public TFunctionDefinition createTFunctionDefinition() {
        return new TFunctionDefinition();
    }

    /**
     * Create an instance of {@link TOrganizationUnit }
     * 
     */
    public TOrganizationUnit createTOrganizationUnit() {
        return new TOrganizationUnit();
    }

    /**
     * Create an instance of {@link TList }
     * 
     */
    public TList createTList() {
        return new TList();
    }

    /**
     * Create an instance of {@link TItemDefinition }
     * 
     */
    public TItemDefinition createTItemDefinition() {
        return new TItemDefinition();
    }

    /**
     * Create an instance of {@link TInvocation }
     * 
     */
    public TInvocation createTInvocation() {
        return new TInvocation();
    }

    /**
     * Create an instance of {@link TDecisionService }
     * 
     */
    public TDecisionService createTDecisionService() {
        return new TDecisionService();
    }

    /**
     * Create an instance of {@link TLiteralExpression }
     * 
     */
    public TLiteralExpression createTLiteralExpression() {
        return new TLiteralExpression();
    }

    /**
     * Create an instance of {@link TInformationItem }
     * 
     */
    public TInformationItem createTInformationItem() {
        return new TInformationItem();
    }

    /**
     * Create an instance of {@link TImportedValues }
     * 
     */
    public TImportedValues createTImportedValues() {
        return new TImportedValues();
    }

    /**
     * Create an instance of {@link TUnaryTests }
     * 
     */
    public TUnaryTests createTUnaryTests() {
        return new TUnaryTests();
    }

    /**
     * Create an instance of {@link TInformationRequirement }
     * 
     */
    public TInformationRequirement createTInformationRequirement() {
        return new TInformationRequirement();
    }

    /**
     * Create an instance of {@link TDMNElementReference }
     * 
     */
    public TDMNElementReference createTDMNElementReference() {
        return new TDMNElementReference();
    }

    /**
     * Create an instance of {@link TContextEntry }
     * 
     */
    public TContextEntry createTContextEntry() {
        return new TContextEntry();
    }

    /**
     * Create an instance of {@link TInputClause }
     * 
     */
    public TInputClause createTInputClause() {
        return new TInputClause();
    }

    /**
     * Create an instance of {@link TAuthorityRequirement }
     * 
     */
    public TAuthorityRequirement createTAuthorityRequirement() {
        return new TAuthorityRequirement();
    }

    /**
     * Create an instance of {@link TKnowledgeRequirement }
     * 
     */
    public TKnowledgeRequirement createTKnowledgeRequirement() {
        return new TKnowledgeRequirement();
    }

    /**
     * Create an instance of {@link TDecisionRule }
     * 
     */
    public TDecisionRule createTDecisionRule() {
        return new TDecisionRule();
    }

    /**
     * Create an instance of {@link TOutputClause }
     * 
     */
    public TOutputClause createTOutputClause() {
        return new TOutputClause();
    }

    /**
     * Create an instance of {@link TBinding }
     * 
     */
    public TBinding createTBinding() {
        return new TBinding();
    }

    /**
     * Create an instance of {@link TDMNElement.ExtensionElements }
     * 
     */
    public TDMNElement.ExtensionElements createTDMNElementExtensionElements() {
        return new TDMNElement.ExtensionElements();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TContext }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.omg.org/spec/DMN/20151101/dmn.xsd", name = "context", substitutionHeadNamespace = "http://www.omg.org/spec/DMN/20151101/dmn.xsd", substitutionHeadName = "expression")
    public JAXBElement<TContext> createContext(TContext value) {
        return new JAXBElement<TContext>(_Context_QNAME, TContext.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TDMNElement }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.omg.org/spec/DMN/20151101/dmn.xsd", name = "DMNElement")
    public JAXBElement<TDMNElement> createDMNElement(TDMNElement value) {
        return new JAXBElement<TDMNElement>(_DMNElement_QNAME, TDMNElement.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TBusinessKnowledgeModel }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.omg.org/spec/DMN/20151101/dmn.xsd", name = "businessKnowledgeModel", substitutionHeadNamespace = "http://www.omg.org/spec/DMN/20151101/dmn.xsd", substitutionHeadName = "drgElement")
    public JAXBElement<TBusinessKnowledgeModel> createBusinessKnowledgeModel(TBusinessKnowledgeModel value) {
        return new JAXBElement<TBusinessKnowledgeModel>(_BusinessKnowledgeModel_QNAME, TBusinessKnowledgeModel.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TDefinitions }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.omg.org/spec/DMN/20151101/dmn.xsd", name = "definitions", substitutionHeadNamespace = "http://www.omg.org/spec/DMN/20151101/dmn.xsd", substitutionHeadName = "namedElement")
    public JAXBElement<TDefinitions> createDefinitions(TDefinitions value) {
        return new JAXBElement<TDefinitions>(_Definitions_QNAME, TDefinitions.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TArtifact }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.omg.org/spec/DMN/20151101/dmn.xsd", name = "artifact", substitutionHeadNamespace = "http://www.omg.org/spec/DMN/20151101/dmn.xsd", substitutionHeadName = "DMNElement")
    public JAXBElement<TArtifact> createArtifact(TArtifact value) {
        return new JAXBElement<TArtifact>(_Artifact_QNAME, TArtifact.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TBusinessContextElement }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.omg.org/spec/DMN/20151101/dmn.xsd", name = "businessContextElement")
    public JAXBElement<TBusinessContextElement> createBusinessContextElement(TBusinessContextElement value) {
        return new JAXBElement<TBusinessContextElement>(_BusinessContextElement_QNAME, TBusinessContextElement.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TNamedElement }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.omg.org/spec/DMN/20151101/dmn.xsd", name = "namedElement", substitutionHeadNamespace = "http://www.omg.org/spec/DMN/20151101/dmn.xsd", substitutionHeadName = "DMNElement")
    public JAXBElement<TNamedElement> createNamedElement(TNamedElement value) {
        return new JAXBElement<TNamedElement>(_NamedElement_QNAME, TNamedElement.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TDecisionTable }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.omg.org/spec/DMN/20151101/dmn.xsd", name = "decisionTable", substitutionHeadNamespace = "http://www.omg.org/spec/DMN/20151101/dmn.xsd", substitutionHeadName = "expression")
    public JAXBElement<TDecisionTable> createDecisionTable(TDecisionTable value) {
        return new JAXBElement<TDecisionTable>(_DecisionTable_QNAME, TDecisionTable.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TPerformanceIndicator }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.omg.org/spec/DMN/20151101/dmn.xsd", name = "performanceIndicator", substitutionHeadNamespace = "http://www.omg.org/spec/DMN/20151101/dmn.xsd", substitutionHeadName = "businessContextElement")
    public JAXBElement<TPerformanceIndicator> createPerformanceIndicator(TPerformanceIndicator value) {
        return new JAXBElement<TPerformanceIndicator>(_PerformanceIndicator_QNAME, TPerformanceIndicator.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TAssociation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.omg.org/spec/DMN/20151101/dmn.xsd", name = "association", substitutionHeadNamespace = "http://www.omg.org/spec/DMN/20151101/dmn.xsd", substitutionHeadName = "artifact")
    public JAXBElement<TAssociation> createAssociation(TAssociation value) {
        return new JAXBElement<TAssociation>(_Association_QNAME, TAssociation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TRelation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.omg.org/spec/DMN/20151101/dmn.xsd", name = "relation", substitutionHeadNamespace = "http://www.omg.org/spec/DMN/20151101/dmn.xsd", substitutionHeadName = "expression")
    public JAXBElement<TRelation> createRelation(TRelation value) {
        return new JAXBElement<TRelation>(_Relation_QNAME, TRelation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TKnowledgeSource }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.omg.org/spec/DMN/20151101/dmn.xsd", name = "knowledgeSource", substitutionHeadNamespace = "http://www.omg.org/spec/DMN/20151101/dmn.xsd", substitutionHeadName = "drgElement")
    public JAXBElement<TKnowledgeSource> createKnowledgeSource(TKnowledgeSource value) {
        return new JAXBElement<TKnowledgeSource>(_KnowledgeSource_QNAME, TKnowledgeSource.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TElementCollection }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.omg.org/spec/DMN/20151101/dmn.xsd", name = "elementCollection", substitutionHeadNamespace = "http://www.omg.org/spec/DMN/20151101/dmn.xsd", substitutionHeadName = "namedElement")
    public JAXBElement<TElementCollection> createElementCollection(TElementCollection value) {
        return new JAXBElement<TElementCollection>(_ElementCollection_QNAME, TElementCollection.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TImport }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.omg.org/spec/DMN/20151101/dmn.xsd", name = "import")
    public JAXBElement<TImport> createImport(TImport value) {
        return new JAXBElement<TImport>(_Import_QNAME, TImport.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TTextAnnotation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.omg.org/spec/DMN/20151101/dmn.xsd", name = "textAnnotation", substitutionHeadNamespace = "http://www.omg.org/spec/DMN/20151101/dmn.xsd", substitutionHeadName = "artifact")
    public JAXBElement<TTextAnnotation> createTextAnnotation(TTextAnnotation value) {
        return new JAXBElement<TTextAnnotation>(_TextAnnotation_QNAME, TTextAnnotation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TDecisionService }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.omg.org/spec/DMN/20151101/dmn.xsd", name = "decisionService", substitutionHeadNamespace = "http://www.omg.org/spec/DMN/20151101/dmn.xsd", substitutionHeadName = "namedElement")
    public JAXBElement<TDecisionService> createDecisionService(TDecisionService value) {
        return new JAXBElement<TDecisionService>(_DecisionService_QNAME, TDecisionService.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TLiteralExpression }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.omg.org/spec/DMN/20151101/dmn.xsd", name = "literalExpression", substitutionHeadNamespace = "http://www.omg.org/spec/DMN/20151101/dmn.xsd", substitutionHeadName = "expression")
    public JAXBElement<TLiteralExpression> createLiteralExpression(TLiteralExpression value) {
        return new JAXBElement<TLiteralExpression>(_LiteralExpression_QNAME, TLiteralExpression.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TDRGElement }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.omg.org/spec/DMN/20151101/dmn.xsd", name = "drgElement", substitutionHeadNamespace = "http://www.omg.org/spec/DMN/20151101/dmn.xsd", substitutionHeadName = "namedElement")
    public JAXBElement<TDRGElement> createDrgElement(TDRGElement value) {
        return new JAXBElement<TDRGElement>(_DrgElement_QNAME, TDRGElement.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TInformationItem }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.omg.org/spec/DMN/20151101/dmn.xsd", name = "informationItem", substitutionHeadNamespace = "http://www.omg.org/spec/DMN/20151101/dmn.xsd", substitutionHeadName = "namedElement")
    public JAXBElement<TInformationItem> createInformationItem(TInformationItem value) {
        return new JAXBElement<TInformationItem>(_InformationItem_QNAME, TInformationItem.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TInvocation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.omg.org/spec/DMN/20151101/dmn.xsd", name = "invocation", substitutionHeadNamespace = "http://www.omg.org/spec/DMN/20151101/dmn.xsd", substitutionHeadName = "expression")
    public JAXBElement<TInvocation> createInvocation(TInvocation value) {
        return new JAXBElement<TInvocation>(_Invocation_QNAME, TInvocation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TOrganizationUnit }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.omg.org/spec/DMN/20151101/dmn.xsd", name = "organizationUnit", substitutionHeadNamespace = "http://www.omg.org/spec/DMN/20151101/dmn.xsd", substitutionHeadName = "businessContextElement")
    public JAXBElement<TOrganizationUnit> createOrganizationUnit(TOrganizationUnit value) {
        return new JAXBElement<TOrganizationUnit>(_OrganizationUnit_QNAME, TOrganizationUnit.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TItemDefinition }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.omg.org/spec/DMN/20151101/dmn.xsd", name = "itemDefinition", substitutionHeadNamespace = "http://www.omg.org/spec/DMN/20151101/dmn.xsd", substitutionHeadName = "namedElement")
    public JAXBElement<TItemDefinition> createItemDefinition(TItemDefinition value) {
        return new JAXBElement<TItemDefinition>(_ItemDefinition_QNAME, TItemDefinition.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.omg.org/spec/DMN/20151101/dmn.xsd", name = "list", substitutionHeadNamespace = "http://www.omg.org/spec/DMN/20151101/dmn.xsd", substitutionHeadName = "expression")
    public JAXBElement<TList> createList(TList value) {
        return new JAXBElement<TList>(_List_QNAME, TList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TInputData }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.omg.org/spec/DMN/20151101/dmn.xsd", name = "inputData", substitutionHeadNamespace = "http://www.omg.org/spec/DMN/20151101/dmn.xsd", substitutionHeadName = "drgElement")
    public JAXBElement<TInputData> createInputData(TInputData value) {
        return new JAXBElement<TInputData>(_InputData_QNAME, TInputData.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TExpression }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.omg.org/spec/DMN/20151101/dmn.xsd", name = "expression")
    public JAXBElement<TExpression> createExpression(TExpression value) {
        return new JAXBElement<TExpression>(_Expression_QNAME, TExpression.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TFunctionDefinition }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.omg.org/spec/DMN/20151101/dmn.xsd", name = "functionDefinition", substitutionHeadNamespace = "http://www.omg.org/spec/DMN/20151101/dmn.xsd", substitutionHeadName = "expression")
    public JAXBElement<TFunctionDefinition> createFunctionDefinition(TFunctionDefinition value) {
        return new JAXBElement<TFunctionDefinition>(_FunctionDefinition_QNAME, TFunctionDefinition.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TDecision }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.omg.org/spec/DMN/20151101/dmn.xsd", name = "decision", substitutionHeadNamespace = "http://www.omg.org/spec/DMN/20151101/dmn.xsd", substitutionHeadName = "drgElement")
    public JAXBElement<TDecision> createDecision(TDecision value) {
        return new JAXBElement<TDecision>(_Decision_QNAME, TDecision.class, null, value);
    }

}
