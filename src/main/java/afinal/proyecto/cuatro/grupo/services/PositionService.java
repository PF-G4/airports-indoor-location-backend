package afinal.proyecto.cuatro.grupo.services;

import afinal.proyecto.cuatro.grupo.entities.Position;
import org.springframework.stereotype.Service;

@Service
public interface PositionService {
	
	Position getLastPosition(Long userID);

}
