package com.tutorialspoint.helloworld;

import com.tutorialspoint.pojo.HelloWorld;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;

public final class Client {
    private static final QName SERVICE_NAME = new QName("http://helloworld.jaxws.cxf.tutorial.com/", "HelloWorld");
    private static final QName PORT_NAME = new QName("http://helloworld.jaxws.cxf.tutorial.com/", "HelloWorldPort");

    private Client() {
    }

    public static void main(String[] args) throws Exception {
        Service service = Service.create(SERVICE_NAME);
        System.out.println("service created");
        String endpointAddress = "http://localhost:9090/HelloServerPort";
        service.addPort(PORT_NAME, SOAPBinding.SOAP11HTTP_BINDING, endpointAddress);
        HelloWorld hw = service.getPort(HelloWorld.class);
        System.out.println(hw.greetings("World"));
    }
}
