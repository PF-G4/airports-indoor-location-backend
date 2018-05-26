package afinal.proyecto.cuatro.grupo.controllers;

import afinal.proyecto.cuatro.grupo.entities.UserDestinationHistory;
import afinal.proyecto.cuatro.grupo.services.UserDestinationHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/destination/history")
public class UserDestinationHistoryController {

	@Autowired
	private UserDestinationHistoryService userDestinationHistoryService;

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	public void saveOrUpdate(@RequestBody UserDestinationHistory userDestinationHistory) {
		userDestinationHistoryService.saveOrUpdate(userDestinationHistory);
	}

	@GetMapping("/{user}")
	public UserDestinationHistory findById(@PathVariable(value = "user") String user) {
		return userDestinationHistoryService.findByUser(user);
	}

	@RequestMapping(method = RequestMethod.GET)
	public Iterable<UserDestinationHistory> findAll() {
		return userDestinationHistoryService.findAll();
	}

}
