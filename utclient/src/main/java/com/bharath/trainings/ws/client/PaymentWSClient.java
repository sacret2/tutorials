package com.bharath.trainings.ws.client;

import java.net.MalformedURLException;
import java.net.URL;

import com.bharath.ws.soap.PaymentProcessor;
import com.bharath.ws.soap.PaymentProcessorImplService;
import com.bharath.ws.soap.PaymentProcessorRequest;
import com.bharath.ws.soap.PaymentProcessorResponse;

public class PaymentWSClient {

	public static void main(String[] args) {
		try {
			PaymentProcessorImplService service = new PaymentProcessorImplService(new URL("http://localhost:8080/javafirstws/paymentProcessor?wsdl"));
			PaymentProcessor port = service.getPaymentProcessorImplPort();
			
			PaymentProcessorResponse response = port.processPayment(new PaymentProcessorRequest());
			
			System.out.println(response.isResult());
		}
		catch(MalformedURLException e) {
			e.printStackTrace();
		}
	}

}
