package com.bharath.ws.soap;

import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import com.bharath.ws.soap.CustomerOrdersWsImplService;
import com.bharath.ws.trainings.CreateOrdersRequest;
import com.bharath.ws.trainings.CreateOrdersResponse;
import com.bharath.ws.trainings.CustomerOrdersPortType;
import com.bharath.ws.trainings.DeleteOrdersRequest;
import com.bharath.ws.trainings.DeleteOrdersResponse;
import com.bharath.ws.trainings.GetOrdersRequest;
import com.bharath.ws.trainings.GetOrdersResponse;
import com.bharath.ws.trainings.Order;
import com.bharath.ws.trainings.Product;

public class CustomerOrderWsClient {

	public static void main(String[] args) throws MalformedURLException {
		CustomerOrdersWsImplService service = new CustomerOrdersWsImplService(
				new URL("http://localhost:8080/wsdlfirstws/customerordersservice?wsdl"));
		
		CustomerOrdersPortType customerOrdersWsImplPort = service.getCustomerOrdersWsImplPort();
		
		
		CreateOrdersRequest crequest = new CreateOrdersRequest();
		crequest.setCustomerId(BigInteger.valueOf(1));
		
		Product product = new Product();
		product.setId(BigInteger.valueOf(3).toString());
		product.setQuantity(BigInteger.valueOf(4));
		product.setDescription("Blend-a-med 3d white");
		Order order = new Order();
		order.setId(BigInteger.valueOf(2));
		order.getProduct().add(product);

		crequest.setOrder(order);
		
		CreateOrdersResponse cresponse = customerOrdersWsImplPort.createOrders(crequest);
		
		System.out.println("Order created: " + cresponse.isResult());
		
		
		GetOrdersRequest request = new GetOrdersRequest();
		request.setCustomerId(BigInteger.valueOf(1));
		
		GetOrdersResponse response = customerOrdersWsImplPort.getOrders(request);
		
		List<Order> orders = response.getOrder();
		
		System.out.println("Number of orders for customer are:" + orders.size());
		
		
		DeleteOrdersRequest drequest = new DeleteOrdersRequest();
		drequest.setCustomerId(BigInteger.valueOf(1));
		drequest.setOrder(order);
		DeleteOrdersResponse dresponse = customerOrdersWsImplPort.deleteOrders(drequest);
		
		System.out.println("delete successful: " + dresponse.isResult());
	
	}

}



