package com.dnb.customerservice.Controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dnb.customerservice.dto.Customer;
import com.dnb.customerservice.exceptions.IdNotFoundException;
import com.dnb.customerservice.exceptions.InvalidAddressException;
import com.dnb.customerservice.exceptions.InvalidContactNumberException;
import com.dnb.customerservice.exceptions.InvalidCustomerIdException;
import com.dnb.customerservice.exceptions.InvalidGovtIdException;
import com.dnb.customerservice.exceptions.InvalidNameException;
import com.dnb.customerservice.payload.request.CustomerRequest;
import com.dnb.customerservice.service.CustomerService;
import com.dnb.customerservice.utils.RequestToEntityMapper;

import jakarta.validation.Valid;

//@CrossOrigin("*")
@RestController
@RequestMapping("/api/customer")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	@Autowired
	RequestToEntityMapper mapper;
	
    @PostMapping("/create") //comb of @RequestMapping + post method==>spring v4.3.x
	
	public ResponseEntity<?> createCustomer(@Valid @RequestBody CustomerRequest customerRequest) 
	 {
		Customer customer2 = mapper.getCustomerEntityObject(customerRequest);
		// return ResponseEntity.ok(mapper.getAccountEntityObject(accountRequest));

		try {
			Customer customer3 = customerService.createCustomer(customer2);

			return new ResponseEntity(customer3, HttpStatus.CREATED);
		} catch (IdNotFoundException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
//    {
//		
//		return ResponseEntity.ok(mapper.getCustomerEntityObject(customerRequest));
//		
//}

	@GetMapping("/{customerId}")
	public ResponseEntity<?> getCustomerById(@PathVariable("customerId")int customerId)throws IdNotFoundException{
		
		Optional<Customer>optional = customerService.getCustomerById(customerId);
		if(optional.isPresent()) {
			return ResponseEntity.ok(optional.get());
		}
		else {
			throw new IdNotFoundException("customer id is not valid");
		}
	}
	@DeleteMapping("/{customerId}")
	public ResponseEntity<?> deleteCustomerById(@PathVariable("customerId") int customerId) throws  IdNotFoundException, InvalidCustomerIdException{
		if (customerService.existsById(customerId)) {
			try {
				customerService.deleteCustomerById(customerId);
			} catch (InvalidCustomerIdException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvalidNameException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvalidContactNumberException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvalidAddressException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvalidGovtIdException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IdNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//return (ResponseEntity<?>) ResponseEntity.noContent().build();
		     return ResponseEntity.ok("customer deleted");
		}
		else {
			throw new IdNotFoundException("Customer id not found");
		}
	}

}
