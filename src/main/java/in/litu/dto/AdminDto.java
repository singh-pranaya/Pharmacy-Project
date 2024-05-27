package in.litu.dto;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class AdminDto {

	private int adminId;
	private String adminName;
	private String adminEmail;
}
