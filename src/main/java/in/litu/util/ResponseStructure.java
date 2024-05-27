package in.litu.util;

import lombok.Data;

@Data
public class ResponseStructure<T> {

	private String message;
	private int httpStatus;
	private Object data;
}
