package com.marcin.ws.trainings;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.2.1
 * 2020-02-20T19:10:32.129+01:00
 * Generated source version: 3.2.1
 * 
 */
@WebServiceClient(name = "CustomerCarsService", 
                  wsdlLocation = "classpath:wsdl/SthMine.wsdl",
                  targetNamespace = "http://trainings.ws.marcin.com/") 
public class CustomerCarsService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://trainings.ws.marcin.com/", "CustomerCarsService");
    public final static QName CustomerCarsPort = new QName("http://trainings.ws.marcin.com/", "CustomerCarsPort");
    static {
        URL url = CustomerCarsService.class.getClassLoader().getResource("wsdl/SthMine.wsdl");
        if (url == null) {
            java.util.logging.Logger.getLogger(CustomerCarsService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "classpath:wsdl/SthMine.wsdl");
        }       
        WSDL_LOCATION = url;   
    }

    public CustomerCarsService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public CustomerCarsService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CustomerCarsService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    public CustomerCarsService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public CustomerCarsService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public CustomerCarsService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }    




    /**
     *
     * @return
     *     returns CustomerCarsPortType
     */
    @WebEndpoint(name = "CustomerCarsPort")
    public CustomerCarsPortType getCustomerCarsPort() {
        return super.getPort(CustomerCarsPort, CustomerCarsPortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CustomerCarsPortType
     */
    @WebEndpoint(name = "CustomerCarsPort")
    public CustomerCarsPortType getCustomerCarsPort(WebServiceFeature... features) {
        return super.getPort(CustomerCarsPort, CustomerCarsPortType.class, features);
    }

}
