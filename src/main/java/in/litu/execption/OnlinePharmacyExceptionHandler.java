package in.litu.execption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import in.litu.util.ResponseStructure;

@RestControllerAdvice
public class OnlinePharmacyExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> adminIdnotfoundexception(AdminIdNotFoundExecption execption)
	{
		ResponseStructure<String> structure=new ResponseStructure<>();
		structure.setMessage("admin id not present");
		structure.setHttpStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(execption.getMessage());
		
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> addressnotfoundexception(AddressIdNotFoundException execption)
	{
		ResponseStructure<String> structure=new ResponseStructure<>();
		structure.setMessage("address id not present");
		structure.setHttpStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(execption.getMessage());
		
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> storeIdnotfoundException(MedicalidNotFoundException execption)
	{
		ResponseStructure<String> structure=new ResponseStructure<>();
		structure.setMessage("Store id not present");
		structure.setHttpStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(execption.getMessage());
		
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> staffIdnotfoundException(StaffidNotFoundException execption)
	{
		ResponseStructure<String> structure=new ResponseStructure<>();
		structure.setMessage("Staff id not present");
		structure.setHttpStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(execption.getMessage());
		
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> medicineIdnotfoundException(MedicineIdNotFoundException execption)
	{
		ResponseStructure<String> structure=new ResponseStructure<>();
		structure.setMessage("medicine id not present");
		structure.setHttpStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(execption.getMessage());
		
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> customerIdnotfoundException(CustomerIdNotFoundException execption)
	{
		ResponseStructure<String> structure=new ResponseStructure<>();
		structure.setMessage("Customer id not present");
		structure.setHttpStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(execption.getMessage());
		
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> medicinenamenotfoundException(MedicinenameNotFoundException execption)
	{
		ResponseStructure<String> structure=new ResponseStructure<>();
		structure.setMessage("Medicine name not present");
		structure.setHttpStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(execption.getMessage());
		
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> customeremailnotfoundException(CustomerEmailNotfoundException execption)
	{
		ResponseStructure<String> structure=new ResponseStructure<>();
		structure.setMessage("Customer email not present");
		structure.setHttpStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(execption.getMessage());
		
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> customerpasswordnotfoundException(CustomerPasswordnotfoundException execption)
	{
		ResponseStructure<String> structure=new ResponseStructure<>();
		structure.setMessage("Customer password not present");
		structure.setHttpStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(execption.getMessage());
		
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> bookingidnotfoundexception(BookingIdNotFoundException execption)
	{
		ResponseStructure<String> structure=new ResponseStructure<>();
		structure.setMessage("Booking id not present");
		structure.setHttpStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(execption.getMessage());
		
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> bookingalreadycancelledexception(BookingAlreadyCancelledException execption)
	{
		ResponseStructure<String> structure=new ResponseStructure<>();
		structure.setMessage("Booking already cancelled");
		structure.setHttpStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(execption.getMessage());
		
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> bookingalreadydeliveredexception(BookingAlredyDeliveredException execption)
	{
		ResponseStructure<String> structure=new ResponseStructure<>();
		structure.setMessage("Booking already delivered");
		structure.setHttpStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(execption.getMessage());
		
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> bookingcannotcancelnowexception(BookingCannotCancelNowException execption)
	{
		ResponseStructure<String> structure=new ResponseStructure<>();
		structure.setMessage("Booking Can't cancel now");
		structure.setHttpStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(execption.getMessage());
		
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
}
