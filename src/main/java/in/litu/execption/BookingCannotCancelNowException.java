package in.litu.execption;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class BookingCannotCancelNowException extends RuntimeException {

	private String message;
}
