package in.litu.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Staff {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int staffId;
	private String staffName;
	private String staffEmail;
	private String staffPassword;
	private long phoneNumber;
	
	
	@ManyToOne
	private Admin admin;
	
	//MANY STAFF HAVING ONE ADMIN
	
	@OneToOne
	private MedicalStore medicalStore;
	
	
	//ONE STAFF HAVING ONE MEDICINESTORE
}
