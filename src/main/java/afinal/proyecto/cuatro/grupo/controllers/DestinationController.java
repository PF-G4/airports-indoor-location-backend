package afinal.proyecto.cuatro.grupo.controllers;
import afinal.proyecto.cuatro.grupo.entities.Destination;
import afinal.proyecto.cuatro.grupo.services.DestinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/destination")
public class DestinationController {

	@Autowired
	private DestinationService destinationService;

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	public void saveOrUpdate(@RequestBody Destination destination) {
		destinationService.saveOrUpdate(destination); }

	@RequestMapping(method = RequestMethod.GET, value = {"/{id}"})
	@ResponseStatus(value = HttpStatus.OK)
	public Destination findById(@PathVariable(value = "id") Long id) {
		return destinationService.findById(id);
	}

	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public Iterable<Destination> findAll() {
		return destinationService.findAll(); }

	@RequestMapping(method = RequestMethod.DELETE, value = {"/{id}"})
	@ResponseStatus(value = HttpStatus.OK)
	public void delete(@PathVariable(value = "id") Long id) {
		destinationService.delete(id); }

}
