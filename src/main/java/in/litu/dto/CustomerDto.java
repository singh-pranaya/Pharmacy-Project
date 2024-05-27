package in.litu.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Component
public class CustomerDto {

	private int customerId;
	private String customerName;
	private String customerEmail;
	
	@OneToMany
	private List<AddressDto> addressDtos;
	
	@OneToMany
	private List<BookingDto> bookingDtos;
}
