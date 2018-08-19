package afinal.proyecto.cuatro.grupo.controllers;

import afinal.proyecto.cuatro.grupo.entities.StateFlight;
import afinal.proyecto.cuatro.grupo.services.StateFlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stateflight")
public class StateFlightController {

	@Autowired
	private StateFlightService stateFlightService;

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	public void saveOrUpdate(@RequestBody StateFlight stateFlight) {
		stateFlightService.saveOrUpdate(stateFlight);
	}

	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public Iterable<StateFlight> findAll() {
		return stateFlightService.findAll();
	}

}
