package afinal.proyecto.cuatro.grupo.controllers;

import afinal.proyecto.cuatro.grupo.entities.Vuelo;
import afinal.proyecto.cuatro.grupo.services.VueloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vuelo")
public class VueloController {

	@Autowired
	private VueloService vueloService;

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	public void saveOrUpdate(@RequestBody Vuelo vuelo) {
		vueloService.saveOrUpdate(vuelo);
	}

	@RequestMapping(method = RequestMethod.GET, value = {"/{id}"})
	@ResponseStatus(value = HttpStatus.OK)
	public Vuelo findVueloById(@PathVariable(value = "id") Long id) {
		return vueloService.findVueloById(id);
	}

	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public Iterable<Vuelo> findAll() {
		return vueloService.findAll();
	}

	@RequestMapping(method = RequestMethod.DELETE, value = {"/{id}"})
	@ResponseStatus(value = HttpStatus.OK)
	public void delete(@PathVariable(value = "id") Long id) {
		vueloService.delete(id);
	}

}