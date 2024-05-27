package in.litu.execption;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MedicinenameNotFoundException extends RuntimeException {

	private String message;
}
