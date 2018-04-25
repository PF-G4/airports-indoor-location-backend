package afinal.proyecto.cuatro.grupo.services;

import org.springframework.stereotype.Service;

import afinal.proyecto.cuatro.grupo.entities.User;

@Service
public interface UserService {
	
	void saveOrUpdate(User user);
	
	User findById(Long id);
	
	Iterable<User> findAll();
	
	void delete(User user);

}
