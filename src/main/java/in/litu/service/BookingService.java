package in.litu.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import in.litu.dao.BookingDao;
import in.litu.dao.CustomerDao;
import in.litu.dao.MedicineDao;
import in.litu.dto.BookingDto;
import in.litu.entity.Booking;
import in.litu.entity.Customer;
import in.litu.entity.Medicine;
import in.litu.enums.BookingStatus;
import in.litu.execption.BookingAlreadyCancelledException;
import in.litu.execption.BookingAlredyDeliveredException;
import in.litu.execption.BookingCannotCancelNowException;
import in.litu.execption.BookingIdNotFoundException;
import in.litu.execption.CustomerIdNotFoundException;
import in.litu.execption.MedicineIdNotFoundException;
import in.litu.util.ResponseStructure;

@Service
public class BookingService {

	@Autowired
	private BookingDao dao;
	
	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private MedicineDao medicineDao;

	public ResponseEntity<ResponseStructure<Booking>> addBooking(int customerId, int[] medicineId,
			BookingDto bookingDto) {
		Customer dbcustomer = customerDao.findCustomer(customerId);
		if (dbcustomer!=null) {
			Booking booking = this.mapper.map(bookingDto, Booking.class);
			booking.setCustomer(dbcustomer);
			
			List<Medicine> list=new ArrayList<Medicine>();
			
			for (int medId : medicineId) {
				Medicine dbmedicine = medicineDao.findMedicine(medId);
				if (dbmedicine!=null) {
					list.add(dbmedicine);
					//UPDATE THE STOCK QUANTITY OF MEDICINE
					dbmedicine.setStockQuantity(dbmedicine.getStockQuantity()-bookingDto.getQuantity());
				}else {
					throw new MedicineIdNotFoundException("sorry failed to add booking");
				}
			}
			//SET THE LIST OF MEDICINE TO YOUR BOOKING
			booking.setMedicines(list);
			
			//UPDATE CUSTOMER WITH RESPECT TO BOOKINGS
			List<Booking> bookings2=new ArrayList<Booking>();
			bookings2.add(booking);
			dbcustomer.setBookings(bookings2);
			customerDao.updateCustomer(customerId, dbcustomer);
			
			booking.setBookingStatus(BookingStatus.ACTIVE);
			
			
			Booking dbBooking=dao.saveBooking(booking);
			
			ResponseStructure<Booking>structure=new ResponseStructure<>();
			structure.setMessage("booking saved succesfully");
			structure.setHttpStatus(HttpStatus.CREATED.value());
			structure.setData(dbBooking);
			return new ResponseEntity<ResponseStructure<Booking>>(structure,HttpStatus.CREATED);
				
			
			
		}else {
			throw new CustomerIdNotFoundException("sorry failed to add bookings");
		}
		
	}

	public ResponseEntity<ResponseStructure<Booking>> cancelBooking(int bookingId) {
			Booking dbBooking=dao.findBooking(bookingId);
			if (dbBooking!=null) {
				LocalDate cannotcancelDate=dbBooking.getExpectedDate().minusDays(2);
				
				if (dbBooking.getBookingStatus().equals(BookingStatus.CANCELLED)) {
					throw new BookingAlreadyCancelledException("sorry booking already cancelled");
				}else if (dbBooking.getBookingStatus().equals(BookingStatus.DELIVERED)) {
					throw new BookingAlredyDeliveredException("sorry booking already delivered");
				}else if (LocalDate.now().equals(cannotcancelDate) || LocalDate.now().isAfter(cannotcancelDate)) {
					throw new BookingCannotCancelNowException("sorry can't cancel the booking now");
					
				}else {
					Booking dbbBooking = dao.cancelBooking(bookingId);
					ResponseStructure<Booking> structure=new ResponseStructure<>();
					structure.setMessage("Booking cancelledsuccesfully");
					structure.setHttpStatus(HttpStatus.FOUND.value());
					structure.setData(dbbBooking);
					
					return new ResponseEntity<ResponseStructure<Booking>>(structure,HttpStatus.FOUND);
				}
			}else {
				throw new BookingIdNotFoundException("sorry failed to cancel the booking");
			}
		
	}
}
