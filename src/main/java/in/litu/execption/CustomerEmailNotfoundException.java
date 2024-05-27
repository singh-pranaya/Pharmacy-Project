package in.litu.execption;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CustomerEmailNotfoundException extends RuntimeException {

	private String message;
}
