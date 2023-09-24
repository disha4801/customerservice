package com.dnb.customerservice.service;


import java.util.Optional;


import com.dnb.customerservice.dto.Customer;
import com.dnb.customerservice.exceptions.IdNotFoundException;
import com.dnb.customerservice.exceptions.InvalidAddressException;
import com.dnb.customerservice.exceptions.InvalidContactNumberException;
import com.dnb.customerservice.exceptions.InvalidCustomerIdException;
import com.dnb.customerservice.exceptions.InvalidGovtIdException;
import com.dnb.customerservice.exceptions.InvalidNameException;

public interface CustomerService{

	public Customer createCustomer(Customer customer)throws IdNotFoundException;
	public Iterable<Customer> getAllCustomers() throws InvalidNameException, InvalidCustomerIdException, InvalidContactNumberException, InvalidAddressException, InvalidGovtIdException;
	public boolean deleteCustomerById(int customerId) throws InvalidCustomerIdException, InvalidNameException,
			InvalidContactNumberException, InvalidAddressException, InvalidGovtIdException, IdNotFoundException;
	public Optional<Customer> getCustomerById(int customerId) throws IdNotFoundException;
	public boolean existsById(int customerId);

}
