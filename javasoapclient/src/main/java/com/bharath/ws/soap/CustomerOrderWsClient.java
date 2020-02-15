package com.bharath.ws.soap;

import java.net.MalformedURLException;
import java.net.URL;

import com.bharath.ws.soap.CustomerOrdersWsImplService;

public class CustomerOrderWsClient {

	public static void main(String[] args) throws MalformedURLException {
		new CustomerOrdersWsImplService(new URL("http://localhost:8080/wsdlfirstws/customerordersservice?wsdl"));
	}

}
