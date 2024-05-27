package in.litu.execption;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MedicineIdNotFoundException extends RuntimeException {

	private String message;
}
