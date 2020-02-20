
package com.marcin.ws.trainings;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.marcin.ws.trainings package. 
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

    private final static QName _GetCarsRequest_QNAME = new QName("http://trainings.ws.marcin.com/", "getCarsRequest");
    private final static QName _GetCarsResponse_QNAME = new QName("http://trainings.ws.marcin.com/", "getCarsResponse");
    private final static QName _CreateCarsRequest_QNAME = new QName("http://trainings.ws.marcin.com/", "createCarsRequest");
    private final static QName _CreateCarsResponse_QNAME = new QName("http://trainings.ws.marcin.com/", "createCarsResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.marcin.ws.trainings
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetCarsRequest }
     * 
     */
    public GetCarsRequest createGetCarsRequest() {
        return new GetCarsRequest();
    }

    /**
     * Create an instance of {@link GetCarsResponse }
     * 
     */
    public GetCarsResponse createGetCarsResponse() {
        return new GetCarsResponse();
    }

    /**
     * Create an instance of {@link CreateCarsRequest }
     * 
     */
    public CreateCarsRequest createCreateCarsRequest() {
        return new CreateCarsRequest();
    }

    /**
     * Create an instance of {@link CreateCarsResponse }
     * 
     */
    public CreateCarsResponse createCreateCarsResponse() {
        return new CreateCarsResponse();
    }

    /**
     * Create an instance of {@link Car }
     * 
     */
    public Car createCar() {
        return new Car();
    }

    /**
     * Create an instance of {@link Model }
     * 
     */
    public Model createModel() {
        return new Model();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCarsRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://trainings.ws.marcin.com/", name = "getCarsRequest")
    public JAXBElement<GetCarsRequest> createGetCarsRequest(GetCarsRequest value) {
        return new JAXBElement<GetCarsRequest>(_GetCarsRequest_QNAME, GetCarsRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCarsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://trainings.ws.marcin.com/", name = "getCarsResponse")
    public JAXBElement<GetCarsResponse> createGetCarsResponse(GetCarsResponse value) {
        return new JAXBElement<GetCarsResponse>(_GetCarsResponse_QNAME, GetCarsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateCarsRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://trainings.ws.marcin.com/", name = "createCarsRequest")
    public JAXBElement<CreateCarsRequest> createCreateCarsRequest(CreateCarsRequest value) {
        return new JAXBElement<CreateCarsRequest>(_CreateCarsRequest_QNAME, CreateCarsRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateCarsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://trainings.ws.marcin.com/", name = "createCarsResponse")
    public JAXBElement<CreateCarsResponse> createCreateCarsResponse(CreateCarsResponse value) {
        return new JAXBElement<CreateCarsResponse>(_CreateCarsResponse_QNAME, CreateCarsResponse.class, null, value);
    }

}
