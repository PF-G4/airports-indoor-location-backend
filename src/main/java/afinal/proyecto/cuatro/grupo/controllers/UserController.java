package afinal.proyecto.cuatro.grupo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import afinal.proyecto.cuatro.grupo.entities.User;
import afinal.proyecto.cuatro.grupo.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	public void saveOrUpdate(@RequestBody User user) {
		userService.saveOrUpdate(user);
	}

	@GetMapping("/{id}")
	public User findById(@PathVariable(value = "id") Long id) {
		return userService.findById(id);
	}

	@RequestMapping(method = RequestMethod.GET)
	public Iterable<User> findAll() {
		return userService.findAll();
	}

}
