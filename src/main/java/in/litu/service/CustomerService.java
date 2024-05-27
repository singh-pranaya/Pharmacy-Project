package in.litu.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import in.litu.dao.AddressDao;
import in.litu.dao.CustomerDao;
import in.litu.dto.AddressDto;
import in.litu.dto.BookingDto;
import in.litu.dto.CustomerDto;
import in.litu.entity.Address;
import in.litu.entity.Booking;
import in.litu.entity.Customer;
import in.litu.execption.AddressIdNotFoundException;
import in.litu.execption.CustomerEmailNotfoundException;
import in.litu.execption.CustomerIdNotFoundException;
import in.litu.execption.CustomerPasswordnotfoundException;
import in.litu.util.ResponseStructure;

@Service
public class CustomerService {

	@Autowired
	private CustomerDao dao;
	
	@Autowired
	private AddressDao addressDao;
	
	@Autowired
	private ModelMapper mapper;

	public ResponseEntity<ResponseStructure<CustomerDto>> signupCustomer(int addressId, Customer customer) {
		Address dbAddress=addressDao.findAddress(addressId);
		if (dbAddress!=null) {
			List<Address> addresses=new ArrayList<Address>();
			addresses.add(dbAddress);
			customer.setAddresses(addresses);
			
			
			Customer dbCustomer=dao.saveCustomer(customer);
			CustomerDto dto=mapper.map(dbCustomer, CustomerDto.class);
			List<Address> list = dbCustomer.getAddresses();
			List<AddressDto> dtos=null;
			for (Address address : list) {
				AddressDto addressDto=this.mapper.map(address, AddressDto.class);
				dtos.add(addressDto);
			}
			
			List<Booking> bookings = dbCustomer.getBookings();
			List<BookingDto> bookingDtos=null;
			for (Booking b : bookings) {
				BookingDto bookingDto=this.mapper.map(b, BookingDto.class);
				bookingDtos.add(bookingDto);
			}
			
			dto.setAddressDtos(dtos);
			dto.setBookingDtos(bookingDtos);
			
			ResponseStructure<CustomerDto> structure=new ResponseStructure<>();
			structure.setMessage("customer saved succesfully");
			structure.setHttpStatus(HttpStatus.CREATED.value());
			structure.setData(dto);
			
			return new ResponseEntity<ResponseStructure<CustomerDto>>(structure,HttpStatus.CREATED);
		}else {
			throw new AddressIdNotFoundException("sorry failed to signup customer because address not present"); 
		}
	}

	public ResponseEntity<ResponseStructure<CustomerDto>> updateCustomer(int customerId, Customer customer) {
		Customer dbCustomer=dao.updateCustomer(customerId,customer);
		if (dbCustomer!=null) {
			CustomerDto dto=mapper.map(dbCustomer, CustomerDto.class);
			List<Address> list = dbCustomer.getAddresses();
			List<AddressDto> dtos=null;
			for (Address address : list) {
				AddressDto addressDto=this.mapper.map(address, AddressDto.class);
				dtos.add(addressDto);
			}
			
			List<Booking> bookings = dbCustomer.getBookings();
			List<BookingDto> bookingDtos=null;
			for (Booking b : bookings) {
				BookingDto bookingDto=this.mapper.map(b, BookingDto.class);
				bookingDtos.add(bookingDto);
			}
			
			dto.setAddressDtos(dtos);
			dto.setBookingDtos(bookingDtos);
			
			ResponseStructure<CustomerDto> structure=new ResponseStructure<>();
			structure.setMessage("customer updated succesfully");
			structure.setHttpStatus(HttpStatus.OK.value());
			structure.setData(dto);
			
			return new ResponseEntity<ResponseStructure<CustomerDto>>(structure,HttpStatus.OK);
		}else {
			throw new CustomerIdNotFoundException("unable to update customer as customer id not present");
		}
	}

	public ResponseEntity<ResponseStructure<CustomerDto>> findCustomer(int customerId) {
		Customer dbCustomer=dao.findCustomer(customerId);
		if (dbCustomer!=null) {
			CustomerDto dto=mapper.map(dbCustomer, CustomerDto.class);
			List<Address> list = dbCustomer.getAddresses();
			List<AddressDto> dtos=null;
			for (Address address : list) {
				AddressDto addressDto=this.mapper.map(address, AddressDto.class);
				dtos.add(addressDto);
			}
			
			List<Booking> bookings = dbCustomer.getBookings();
			List<BookingDto> bookingDtos=null;
			for (Booking b : bookings) {
				BookingDto bookingDto=this.mapper.map(b, BookingDto.class);
				bookingDtos.add(bookingDto);
			}
			
			dto.setAddressDtos(dtos);
			dto.setBookingDtos(bookingDtos);
			
			ResponseStructure<CustomerDto> structure=new ResponseStructure<>();
			structure.setMessage("customer fetched succesfully");
			structure.setHttpStatus(HttpStatus.FOUND.value());
			structure.setData(dto);
			
			return new ResponseEntity<ResponseStructure<CustomerDto>>(structure,HttpStatus.FOUND);
		}else {
			throw new CustomerIdNotFoundException("sorry failed to fetch the customr");
		}
	}

	public ResponseEntity<ResponseStructure<CustomerDto>> deleteCustomer(int customerId) {
		Customer dbCustomer=dao.deleteCustomer(customerId);
		if (dbCustomer!=null) {
			CustomerDto dto=mapper.map(dbCustomer, CustomerDto.class);
			List<Address> list = dbCustomer.getAddresses();
			List<AddressDto> dtos=null;
			for (Address address : list) {
				AddressDto addressDto=this.mapper.map(address, AddressDto.class);
				dtos.add(addressDto);
			}
			
			List<Booking> bookings = dbCustomer.getBookings();
			List<BookingDto> bookingDtos=null;
			for (Booking b : bookings) {
				BookingDto bookingDto=this.mapper.map(b, BookingDto.class);
				
				bookingDtos.add(bookingDto);
			}
			
			dto.setAddressDtos(dtos);
			dto.setBookingDtos(bookingDtos);
			
			ResponseStructure<CustomerDto> structure=new ResponseStructure<>();
			structure.setMessage("customer deleted succesfully");
			structure.setHttpStatus(HttpStatus.FOUND.value());
			structure.setData(dto);
			
			return new ResponseEntity<ResponseStructure<CustomerDto>>(structure,HttpStatus.FOUND);
		}else {
			throw new CustomerIdNotFoundException("sorryfailed to delete customer");
		}
	}

	public ResponseEntity<ResponseStructure<CustomerDto>> loginCustomer(String email, String password) {
		Customer dbCustomer=dao.findCustomerByEmail(email);
		if (dbCustomer!=null) {
			if (password.equals(dbCustomer.getPassword())) {
				CustomerDto dto = this.mapper.map(dbCustomer,CustomerDto.class);
				ResponseStructure<CustomerDto> structure=new ResponseStructure<>();
				structure.setMessage("customer login succesfully");
				structure.setHttpStatus(HttpStatus.FOUND.value());
				structure.setData(dto);
				
				return new ResponseEntity<ResponseStructure<CustomerDto>>(structure,HttpStatus.FOUND);
			}else {
				throw new CustomerPasswordnotfoundException("sorry failed to login");
			}
		}else {
			throw new CustomerEmailNotfoundException("sorry failed to login");
		}
	}
}
