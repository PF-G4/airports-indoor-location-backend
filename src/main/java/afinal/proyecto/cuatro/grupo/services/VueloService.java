package afinal.proyecto.cuatro.grupo.services;

import afinal.proyecto.cuatro.grupo.entities.Vuelo;
import org.springframework.stereotype.Service;

@Service
public interface VueloService {
	
	void saveOrUpdate(Vuelo vuelo);
	
	Vuelo findVueloById(String id);
	
	Iterable<Vuelo> findAll();

	void delete(String id);

}
