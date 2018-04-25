package afinal.proyecto.cuatro.grupo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class UserInvalidEmailException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UserInvalidEmailException(String email) {
		super(String.format("The User email not is valid: %s", email));
	}

}
