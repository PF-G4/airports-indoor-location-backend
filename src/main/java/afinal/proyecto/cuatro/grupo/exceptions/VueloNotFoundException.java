package afinal.proyecto.cuatro.grupo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class VueloNotFoundException extends RuntimeException {

	//
	private static final long serialVersionUID = 1L;

	public VueloNotFoundException(String fieldName, Object field) {
		super(String.format("Vuelo not found with %s: %s", fieldName, field));
	}
	
}
