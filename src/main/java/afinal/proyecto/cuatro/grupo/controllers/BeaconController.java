package afinal.proyecto.cuatro.grupo.controllers;

import afinal.proyecto.cuatro.grupo.entities.Beacon;
import afinal.proyecto.cuatro.grupo.services.BeaconService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/beacon")
public class BeaconController {

	@Autowired
	private BeaconService beaconService;

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	public void saveOrUpdate(@RequestBody Beacon beacon) {
		beaconService.saveOrUpdate(beacon);
	}

	@RequestMapping(method = RequestMethod.GET, value = {"/{id}"})
	@ResponseStatus(value = HttpStatus.OK)
	public Beacon findById(@PathVariable(value = "id") Long id) {
		return beaconService.findById(id);
	}

	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public Iterable<Beacon> findAll() {
		return beaconService.findAll();
	}

	@RequestMapping(method = RequestMethod.DELETE, value = {"/{id}"})
	@ResponseStatus(value = HttpStatus.OK)
	public void delete(@PathVariable(value = "id") Long id) {
		beaconService.delete(id);
	}

}
