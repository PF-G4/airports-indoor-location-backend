package afinal.proyecto.cuatro.grupo.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import afinal.proyecto.cuatro.grupo.dao.DaoPromotion;
import afinal.proyecto.cuatro.grupo.entities.Promotion;
import afinal.proyecto.cuatro.grupo.exceptions.PromotionNotFoundException;
import afinal.proyecto.cuatro.grupo.services.PromotionService;

@Service
public class PromotionServiceImpl implements PromotionService {
	
	@Autowired
	private DaoPromotion daoPromotion;
	
	@Override
	public void saveOrUpdate(Promotion promotion) {
		try {
			daoPromotion.save(promotion);
		} catch (Exception e) {
			System.out.println("[ERROR] " + e);
		}
	}

	@Override
	public Promotion findById(Long id) {
		return daoPromotion.findById(id)
				.orElseThrow(() -> new PromotionNotFoundException("id", id));
	}

	@Override
	public Promotion findPromotionByBeaconId(String id) {
		return daoPromotion.findPromotionByBeaconId(id);
	}

	@Override
	public Iterable<Promotion> findAll() {
		return daoPromotion.findAll();
	}

	@Override
	public void delete(Long id) {
		try{
			daoPromotion.delete(findById(id));
		} catch (Exception e) {
			System.out.println("[ERROR] " + e);
		}
	}

}
