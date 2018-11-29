package afinal.proyecto.cuatro.grupo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class TiempoPromedioZonaNotFoundException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public TiempoPromedioZonaNotFoundException(String fieldName, String field) {
        super(String.format("TiempoPromedioZona not found with %s: %s", fieldName, field));
    }
}
