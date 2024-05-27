package in.litu.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.litu.entity.Booking;
import in.litu.repo.BookingRepo;

@Repository
public class BookingDao {

	@Autowired
	private BookingRepo repo;

	public Booking saveBooking(Booking booking) {
		
		return repo.save(booking);
	}

	public Booking findBooking(int bookingId) {
		Optional<Booking> optional = repo.findById(bookingId);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	public Booking cancelBooking(int bookingId) {
		Optional<Booking> optional = repo.findById(bookingId);
		if (optional.isPresent()) {
			repo.deleteById(bookingId);
			return optional.get();
		}
		return null;
	}
}
