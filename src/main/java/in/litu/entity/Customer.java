package in.litu.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerId;
	private String customerName;
	private String customerEmail;
	private String password;
	private long phoneNumber;
	
	@OneToMany(mappedBy = "customer")
	private List<Address> addresses;
	
	@OneToMany(mappedBy = "customer")
	private List<Booking> bookings;
}