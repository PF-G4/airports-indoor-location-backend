package afinal.proyecto.cuatro.grupo.services;

import java.io.IOException;

import afinal.proyecto.cuatro.grupo.api.FlightByUserDto;
import afinal.proyecto.cuatro.grupo.api.LoginResponse;
import org.springframework.stereotype.Service;

import afinal.proyecto.cuatro.grupo.entities.User;

@Service
public interface UserService {
	
	void saveOrUpdate(User user);
	
	User findById(Long id);
	
	Iterable<User> findAll();
	
	void delete(User user);

	LoginResponse login(User user) throws IOException;

	void flightByUser(FlightByUserDto request);
}
