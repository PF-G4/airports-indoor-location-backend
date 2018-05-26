package afinal.proyecto.cuatro.grupo.services.impl;

import afinal.proyecto.cuatro.grupo.dao.DaoPromotion;
import afinal.proyecto.cuatro.grupo.entities.Promotion;
import afinal.proyecto.cuatro.grupo.exceptions.PromotionNotFoundException;
import afinal.proyecto.cuatro.grupo.services.PromotionService;
import afinal.proyecto.cuatro.grupo.services.util.ServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PromotionServiceImpl extends ServiceUtil implements PromotionService {
	
	@Autowired
	private DaoPromotion daoPromotion;
	
	@Override
	public void saveOrUpdate(Promotion promotion) {
		try {
			daoPromotion.save(promotion);
		} catch (Exception e) {
			System.out.println(e);
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
