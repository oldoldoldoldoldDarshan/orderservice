package com.egen.orderservice.controller;

import java.util.List;
import java.util.UUID;

import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.egen.orderservice.dto.OrderRequest;
import com.egen.orderservice.model.OrderDetails;
import com.egen.orderservice.service.OrderServiceImpl;

@CrossOrigin()
@RestController()
public class OrderController {

	@Autowired
	private OrderServiceImpl orderService;

	@PostMapping("/order")
	public OrderDetails createOrder(@RequestBody OrderRequest orderRequest) {
		OrderDetails createdOrder = orderService.createOrder(orderRequest);
		return createdOrder;
	}

	@GetMapping(value = "/{orderID}")
	public OrderDetails getOrderByID(@PathVariable UUID orderID) {
		OrderDetails orderById = orderService.getOrderByID(orderID);
		return orderById;
	}

	@GetMapping(value = "/customer/{customerId}")
	public List<OrderDetails> getOrdersByCustomer(@PathVariable String customerId,
			@QueryParam("Date") String date, @QueryParam("pageNumber") Integer pageNumber, @QueryParam("Status") String status) {
		return orderService.getOrdersByCustomerID(customerId);

	}

}
