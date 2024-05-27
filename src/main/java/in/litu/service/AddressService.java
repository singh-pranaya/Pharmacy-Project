package in.litu.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import in.litu.dao.AddressDao;
import in.litu.dto.AddressDto;
import in.litu.entity.Address;
import in.litu.execption.AddressIdNotFoundException;
import in.litu.util.ResponseStructure;

@Service
public class AddressService {

	@Autowired
	private AddressDao dao;
	
	@Autowired
	private AddressDto dto;
	
	@Autowired
	private ModelMapper mapper;

	
	public ResponseEntity<ResponseStructure<AddressDto>> saveAddress(Address address) {
		Address dbAddress=dao.saveAddress(address);
		AddressDto addressDto =this.mapper.map(dbAddress, AddressDto.class);
		ResponseStructure<AddressDto> structure=new ResponseStructure<>();
		structure.setMessage("Address saved succesfully");
		structure.setHttpStatus(HttpStatus.CREATED.value());
		structure.setData(addressDto);
		
		return new ResponseEntity<ResponseStructure<AddressDto>>(structure,HttpStatus.CREATED);
		
	}


	public ResponseEntity<ResponseStructure<AddressDto>> updateADdress(int addressId, Address address) {
		Address dbAddress=dao.updateAddress(addressId,address);
		if (dbAddress!=null) {
			AddressDto addressDto =this.mapper.map(dbAddress, AddressDto.class);
			ResponseStructure<AddressDto> structure=new ResponseStructure<>();
			structure.setMessage("Address updated succesfully");
			structure.setHttpStatus(HttpStatus.OK.value());
			structure.setData(addressDto);
			
			return new ResponseEntity<ResponseStructure<AddressDto>>(structure,HttpStatus.OK);
		}else {
			throw new AddressIdNotFoundException("sorry failed to update address");
		}
	}


	public ResponseEntity<ResponseStructure<AddressDto>> findAddress(int addressId) {
		Address dbAddress=dao.findAddress(addressId);
		if (dbAddress!=null) {
			AddressDto addressDto =this.mapper.map(dbAddress, AddressDto.class);
			ResponseStructure<AddressDto> structure=new ResponseStructure<>();
			structure.setMessage("Address Fetch succesfully");
			structure.setHttpStatus(HttpStatus.FOUND.value());
			structure.setData(addressDto);
			
			return new ResponseEntity<ResponseStructure<AddressDto>>(structure,HttpStatus.FOUND);
		}else {
			throw new AddressIdNotFoundException("sorry address is not present");
		}
	}


	public ResponseEntity<ResponseStructure<AddressDto>> deleteAddress(int addressId) {
		Address dbAddress=dao.deleteAddress(addressId);
		if (dbAddress!=null) {
			AddressDto addressDto =this.mapper.map(dbAddress, AddressDto.class);
			ResponseStructure<AddressDto> structure=new ResponseStructure<>();
			structure.setMessage("Address deleted succesfully");
			structure.setHttpStatus(HttpStatus.FOUND.value());
			structure.setData(addressDto);
			
			return new ResponseEntity<ResponseStructure<AddressDto>>(structure,HttpStatus.FOUND);
		}else {
			throw new AddressIdNotFoundException("sorry unable to delete address as it is not present");
		}
	}
	
}
