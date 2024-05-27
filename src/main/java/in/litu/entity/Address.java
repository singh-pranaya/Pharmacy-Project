package in.litu.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int addressId;
	private String StreetName;
	private String city;
	private String state;
	private long pincode;
	
	@ManyToOne 
	@JoinColumn
	private Customer customer;
	
	//ONE CUSTOMER HAVING MANY ADDRESS
	
	@OneToOne
	@JoinColumn
	private MedicalStore medicalStore;
	
	//ONE MEDICINESTORE HAVING ONE ADDRESS
}
