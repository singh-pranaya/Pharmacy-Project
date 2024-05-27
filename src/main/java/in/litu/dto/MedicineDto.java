package in.litu.dto;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class MedicineDto {

	private int medicineId;
	private String medicineName;
	private Double cost;
	private LocalDate expiryDate;
	private int StockQuantity;
	private String manufacturer;
	private String description;
}
