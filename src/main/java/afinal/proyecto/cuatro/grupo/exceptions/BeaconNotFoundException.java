package afinal.proyecto.cuatro.grupo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class BeaconNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BeaconNotFoundException(String fieldName, Object field) {
		super(String.format("Beacon not found with %s: %s", fieldName, field));
	}
	
}
