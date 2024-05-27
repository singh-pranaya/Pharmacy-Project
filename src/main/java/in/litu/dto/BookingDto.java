package in.litu.dto;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import in.litu.enums.BookingStatus;
import lombok.Data;

@Data
@Component
public class BookingDto {

	private int bookingId;
	private LocalDate orderDate;
	private int quantity;
	private String paymentmode;
	private LocalDate expectedDate;
	private BookingStatus bookingStatus;
	
}
