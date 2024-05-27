package in.litu.execption;

import lombok.Getter;

@Getter
public class AdminIdNotFoundExecption extends RuntimeException{

	private String message;

	public AdminIdNotFoundExecption(String message) {
		super();
		this.message = message;
	}
	
	
}
