package afinal.proyecto.cuatro.grupo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PromotionNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PromotionNotFoundException(String fieldName, Object field) {
		super(String.format("Promotion not found with %s: %s", fieldName, field));
	}
	
}
