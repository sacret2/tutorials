package com.tutorialspoint.pojo;

import org.apache.cxf.frontend.ServerFactoryBean;

public class HelloServer {

    protected HelloServer() throws Exception{
        ServerFactoryBean factory = new ServerFactoryBean();
        factory.setServiceClass(HelloWorld.class); // interface
        factory.setAddress("http://localhost:5000/Hello");
        factory.setServiceBean(HelloWorldImpl.class);
        factory.create();   // używając refleksji obiekt factory przerabia klasę HelloServer
        // na server z endpointem  wywołanie new HelloServer() tworzy nowy serwer na porcie
        // określonym w factory
        // metody określone w ServiceClass są dostępne ich impl w ServiceBean
    }

    public static void main(String[] args) throws Exception {
        new HelloServer();
        System.out.println("Listening on port 5000");
        Thread.sleep(5*60*1000);
        System.out.println("Server exiting");
        System.exit(0);
    }
}
