package in.litu.execption;

import lombok.AllArgsConstructor;
import lombok.Getter;
@Getter
public class StaffidNotFoundException extends RuntimeException {

	
	private String message;
	
	public StaffidNotFoundException(String message) {
		super();
		this.message=message;
	}

	
}
