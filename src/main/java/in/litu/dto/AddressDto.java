package in.litu.dto;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class AddressDto {

	private int addressId;
	private String StreetName;
	private String city;
	private String state;
	private long pincode;
}
