package afinal.proyecto.cuatro.grupo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class FlightDuplicateNumberException extends RuntimeException  {
	
	/*
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FlightDuplicateNumberException(String number) {
		super(String.format("Already exist Flight with number: %s", number));
	}
}
