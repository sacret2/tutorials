package com.tutorialspoint.pojo;

import org.apache.cxf.frontend.ClientProxyFactoryBean;

public class HelloClient {
    public static void main(String[] args) throws Exception {
        ClientProxyFactoryBean clientFactory = new ClientProxyFactoryBean();
        clientFactory.setAddress("http://localhost:5000/Hello");
        HelloWorld helloServer = clientFactory.create(HelloWorld.class); // access to server
        // creates a proxy client for the specified server on port - here HelloWord
        try {
            System.out.println((String)helloServer.greetings((String) "Marcin"));
        }
        catch (Exception e){
            e.printStackTrace();
        }
        // greetings invocation
    }
}
