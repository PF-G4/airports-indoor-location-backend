package afinal.proyecto.cuatro.grupo.services.util;

import java.util.regex.Pattern;
import org.hibernate.exception.ConstraintViolationException;

public class ServiceUtil {
	
	private static final String PATTERN_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	public boolean isConstraintName(String constraintName, Exception e) {
		return e.getCause() != null && e.getCause() instanceof ConstraintViolationException && 
				((ConstraintViolationException ) e.getCause()).getConstraintName().equals(constraintName);
	}
	
	public boolean isValidEmail(String email) {
		return Pattern.compile(PATTERN_EMAIL).matcher(email).matches();
	}
	
	
}
