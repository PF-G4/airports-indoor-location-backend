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

	@GetMapping("/{id}")
	public Vuelo findVueloById(@PathVariable(value = "id") String id) {
		return vueloService.findVueloById(id);
	}

	@RequestMapping(method = RequestMethod.GET)
	public Iterable<Vuelo> findAll() {
		return vueloService.findAll();
	}

	@RequestMapping(method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.OK)
	public void delete(@PathVariable(value = "id") String id) { vueloService.delete(id); }

}
