package in.litu.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Medicine {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int medicineId;
	private String medicineName;
	private Double cost;
	private LocalDate expiryDate;
	private int StockQuantity;
	private String manufacturer;
	private String description;
	
	@ManyToOne
	private MedicalStore medicalStore;
}
