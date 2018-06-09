package afinal.proyecto.cuatro.grupo.services;
import afinal.proyecto.cuatro.grupo.entities.Beacon;
import org.springframework.stereotype.Service;

@Service
public interface BeaconService {

	void saveOrUpdate(Beacon beacon);

	Beacon findById(Long id);

	Iterable<Beacon> findAll();
	
	void delete(Long id);

}
