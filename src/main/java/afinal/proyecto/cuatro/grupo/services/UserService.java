package afinal.proyecto.cuatro.grupo.services;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;

import afinal.proyecto.cuatro.grupo.entities.User;

@Service
public interface UserService {
	
	void saveOrUpdate(User user);
	
	User findById(Long id);
	
	Iterable<User> findAll();
	
	void delete(User user);

	User login(User user) throws IOException;

}
