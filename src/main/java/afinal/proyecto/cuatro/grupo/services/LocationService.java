package afinal.proyecto.cuatro.grupo.services;

import afinal.proyecto.cuatro.grupo.entities.Location;
import org.springframework.stereotype.Service;

@Service
public interface LocationService {
	
	void saveOrUpdate(Location location);
	
	Iterable<Location> findAll();

}
