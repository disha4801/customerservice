package com.dnb.customerservice.payload.request;

import jakarta.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class CustomerRequest {
	
	@NotBlank(message = "customer name should not be blank")
	private String customerName;
	private String customerContactNumber;
	private String customerAddress;
	private String customerPAN;
	private String customerUUID;

}
