package in.litu.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.litu.entity.Address;
import in.litu.repo.AddressRepo;

@Repository
public class AddressDao {

	@Autowired
	private AddressRepo repo;

	public Address saveAddress(Address address) {
		
		return repo.save(address);
	}

	public Address updateAddress(int addressId, Address address) {
		Optional<Address> optional = repo.findById(addressId);
		if (optional.isPresent()) {
			address.setAddressId(addressId);
			return repo.save(address);
		}else {
			return null;
		}
		
	}

	public Address findAddress(int addressId) {
		Optional<Address> optional = repo.findById(addressId);
		if(optional.isPresent()) {
			return optional.get();
		}else {
			return null;
		}
	}

	public Address deleteAddress(int addressId) {
		Optional<Address> optional = repo.findById(addressId);
		if (optional.isPresent()) {
			Address address=optional.get();
			repo.delete(address);
			return address;
		}else {
			return null;
		}
	}
}
