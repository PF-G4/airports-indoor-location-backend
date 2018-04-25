package afinal.proyecto.cuatro.grupo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class UserDuplicateEmailException extends RuntimeException  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserDuplicateEmailException(String email) {
		super(String.format("Already exist User with email: %s", email));
	}

}
