package in.litu.execption;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CustomerIdNotFoundException extends RuntimeException {

	private String message;
}
