package in.litu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.litu.dto.BookingDto;
import in.litu.entity.Booking;
import in.litu.service.BookingService;
import in.litu.util.ResponseStructure;


@RequestMapping("/booking")
@RestController
public class BookingController {

	@Autowired
	private BookingService service;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Booking>> addBooking(@RequestParam int customerId,
			@RequestParam int[]medicineId, @RequestBody BookingDto bookingDto )
	{
		return service.addBooking(customerId,medicineId,bookingDto);
	}
	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Booking>> cancelBooking(@RequestParam int bookingId)
	{
		return service.cancelBooking(bookingId);
	}
			
}
