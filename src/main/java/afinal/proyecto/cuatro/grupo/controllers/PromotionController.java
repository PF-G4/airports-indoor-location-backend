package afinal.proyecto.cuatro.grupo.controllers;

import afinal.proyecto.cuatro.grupo.entities.Promotion;
import afinal.proyecto.cuatro.grupo.services.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/promotion")
public class PromotionController {

	@Autowired
	private PromotionService promotionService;

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	public void saveOrUpdate(@RequestBody Promotion promotion) {
		promotionService.saveOrUpdate(promotion);
	}

	@RequestMapping(method = RequestMethod.POST, value = {"/beacon/{beaconId}"})
	@ResponseStatus(value = HttpStatus.CREATED)
	public Promotion saveOrUpdateWithBeacon(@RequestBody Promotion promotion, @PathVariable(value = "beaconId") Long beaconId) {
		return promotionService.saveOrUpdateWithBeacon(promotion,beaconId);
	}

	@RequestMapping(method = RequestMethod.GET, value = {"/{id}"})
	@ResponseStatus(value = HttpStatus.OK)
	public Promotion findById(@PathVariable(value = "id") Long id) {
		return promotionService.findById(id);
	}


	@RequestMapping(method = RequestMethod.GET, value = {"/beacon/{beaconId}"})
	@ResponseStatus(value = HttpStatus.OK)
	public Promotion findPromotionByBeaconId(@PathVariable(value = "beaconId") Long beaconId) {
		return promotionService.findPromotionByBeaconId(beaconId);
	}

	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public Iterable<Promotion> findAll() {
		return promotionService.findAll();
	}

	@RequestMapping(method = RequestMethod.DELETE, value = {"/{id}"})
	@ResponseStatus(value = HttpStatus.OK)
	public void delete(@PathVariable(value = "id") Long id) {
		promotionService.delete(id);
	}

}
