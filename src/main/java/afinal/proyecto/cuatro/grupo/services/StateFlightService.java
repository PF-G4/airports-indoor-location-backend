package afinal.proyecto.cuatro.grupo.services;

import afinal.proyecto.cuatro.grupo.entities.StateFlight;
import org.springframework.stereotype.Service;

@Service
public interface StateFlightService {
	
	void saveOrUpdate(StateFlight stateFlight);
	
	Iterable<StateFlight> findAll();

}
