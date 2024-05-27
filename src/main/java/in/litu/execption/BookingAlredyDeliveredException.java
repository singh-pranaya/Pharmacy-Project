package in.litu.execption;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class BookingAlredyDeliveredException extends RuntimeException {

	private String messgae;
}
