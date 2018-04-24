package afinal.proyecto.cuatro.grupo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import afinal.proyecto.cuatro.grupo.entities.User;
import afinal.proyecto.cuatro.grupo.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(method = RequestMethod.POST)
	public void insertUser(@RequestBody User user) {
		userService.saveOrUpdate(user);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public User findById(@RequestParam Long id) {
		return userService.findById(id);
	}

}
