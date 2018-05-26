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
	public void saveOrUpdate(@RequestBody Beacon beacon) { beaconService.saveOrUpdate(beacon); }

	@GetMapping("/{id}")
	public Beacon findById(@PathVariable(value = "id") String id) { return beaconService.findBeaconById(id); }

	@RequestMapping(method = RequestMethod.GET)
	public Iterable<Beacon> findAll() { return beaconService.findAll(); }

	@RequestMapping(method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.OK)
	public void delete(@PathVariable(value = "id") String id) { beaconService.delete(id); }

}
