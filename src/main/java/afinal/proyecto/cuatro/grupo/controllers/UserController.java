package afinal.proyecto.cuatro.grupo.controllers;

import java.io.IOException;

import afinal.proyecto.cuatro.grupo.api.FlightByUserDto;
import afinal.proyecto.cuatro.grupo.api.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

	@RequestMapping(method = RequestMethod.GET, value = {"/{id}"})
	@ResponseStatus(value = HttpStatus.OK)
	public User findById(@PathVariable(value = "id") Long id) {
		return userService.findById(id);
	}

	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public Iterable<User> findAll() {
		return userService.findAll();
	}

	@RequestMapping(method = RequestMethod.DELETE, value = {"/{id}"})
	@ResponseStatus(value = HttpStatus.OK)
	public void delete(@PathVariable(value = "id") Long id) {
		userService.delete(findById(id));
	}
	
	@RequestMapping(value = "/login" ,method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public LoginResponse login(@RequestBody User user) throws IOException {
		return userService.login(user);
	}

	@RequestMapping(value = "/vuelo", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	public void saveFlightByUser(@RequestBody  FlightByUserDto request) {
		userService.flightByUser(request);
	}

}
