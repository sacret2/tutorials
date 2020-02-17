package com.bharath.ws.soap;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import com.bharath.ws.soap.dto.PaymentProcessorRequest;
import com.bharath.ws.soap.dto.PaymentProcessorResponse;

@WebService
public interface PaymentProcessor {

	public @WebResult(name="response") PaymentProcessorResponse processPayment(@WebParam(name="paymentProcessorRequest") PaymentProcessorRequest paymentProcessorRequest);
}
