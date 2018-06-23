package afinal.proyecto.cuatro.grupo.services.impl;

import afinal.proyecto.cuatro.grupo.dao.DaoPromotion;
import afinal.proyecto.cuatro.grupo.entities.Promotion;
import afinal.proyecto.cuatro.grupo.exceptions.PromotionNotFoundException;
import afinal.proyecto.cuatro.grupo.services.PromotionService;
import afinal.proyecto.cuatro.grupo.services.util.ServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import afinal.proyecto.cuatro.grupo.services.BeaconService;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
public class PromotionServiceImpl extends ServiceUtil implements PromotionService {
	
	@Autowired
	private DaoPromotion daoPromotion;

	@Autowired
	private BeaconService beaconService;
	
	@Override
	public void saveOrUpdate(Promotion promotion) {

		try {
			daoPromotion.save(promotion);
		} catch (Exception e) {
			System.out.println("[ERROR] " + e);
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Promotion saveOrUpdateWithBeacon(Promotion promotion, Long beaconId) {
		promotion.setBeacon(beaconService.findById(beaconId));
		return daoPromotion.save(promotion);
	}

	@Override
	public Promotion findById(Long id) {
		return daoPromotion.findById(id)
				.orElseThrow(() -> new PromotionNotFoundException("id", id));
	}

	@Override
	public Promotion findPromotionByBeaconId(Long id) {
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
