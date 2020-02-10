
package com.tutorialspoint.helloworld;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.tutorialspoint.helloworld package. 
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

    private final static QName _Greetings_QNAME = new QName("http://helloworld.tutorialspoint.com/", "greetings");
    private final static QName _GreetingsResponse_QNAME = new QName("http://helloworld.tutorialspoint.com/", "greetingsResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.tutorialspoint.helloworld
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Greetings }
     * 
     */
    public Greetings createGreetings() {
        return new Greetings();
    }

    /**
     * Create an instance of {@link GreetingsResponse }
     * 
     */
    public GreetingsResponse createGreetingsResponse() {
        return new GreetingsResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Greetings }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Greetings }{@code >}
     */
    @XmlElementDecl(namespace = "http://helloworld.tutorialspoint.com/", name = "greetings")
    public JAXBElement<Greetings> createGreetings(Greetings value) {
        return new JAXBElement<Greetings>(_Greetings_QNAME, Greetings.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GreetingsResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GreetingsResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://helloworld.tutorialspoint.com/", name = "greetingsResponse")
    public JAXBElement<GreetingsResponse> createGreetingsResponse(GreetingsResponse value) {
        return new JAXBElement<GreetingsResponse>(_GreetingsResponse_QNAME, GreetingsResponse.class, null, value);
    }

}
