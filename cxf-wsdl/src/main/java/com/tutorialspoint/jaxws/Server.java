package com.tutorialspoint.jaxws;

import javax.xml.ws.Endpoint;

import com.tutorialspoint.pojo.HelloWorld;
import com.tutorialspoint.pojo.HelloWorldImpl;
import org.apache.cxf.ext.logging.LoggingFeature;


public class Server {
    public static void main(String[] args) throws Exception {
        HelloWorld impl = new HelloWorldImpl();
        Endpoint.publish("http://localhost:9090/HelloServerPort", impl, new LoggingFeature());
        System.out.println("Server ready...");
        Thread.sleep(5 * 60 * 1000);
        System.out.println("Server exiting ...");
        System.exit(0);
    }
}