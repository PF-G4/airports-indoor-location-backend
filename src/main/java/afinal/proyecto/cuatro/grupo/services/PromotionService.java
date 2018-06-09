package afinal.proyecto.cuatro.grupo.services;

import afinal.proyecto.cuatro.grupo.entities.Promotion;
import org.springframework.stereotype.Service;

@Service
public interface PromotionService {

	void saveOrUpdate(Promotion promotion);

	Promotion findPromotionByBeaconId(String id);

	Promotion findById(Long id);

	Iterable<Promotion> findAll();
	
	void delete(Long id);

}
