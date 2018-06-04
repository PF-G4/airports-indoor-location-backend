package afinal.proyecto.cuatro.grupo.services;
import afinal.proyecto.cuatro.grupo.entities.Destination;
import org.springframework.stereotype.Service;

@Service
public interface DestinationService {

	void saveOrUpdate(Destination destination);

	Destination findById(Long id);

	Iterable<Destination> findAll();
	
	void delete(Long id);

}
