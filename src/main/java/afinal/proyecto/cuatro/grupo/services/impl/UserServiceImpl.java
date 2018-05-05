package afinal.proyecto.cuatro.grupo.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import afinal.proyecto.cuatro.grupo.dao.DaoUser;
import afinal.proyecto.cuatro.grupo.entities.User;
import afinal.proyecto.cuatro.grupo.exceptions.UserDuplicateEmailException;
import afinal.proyecto.cuatro.grupo.exceptions.UserNotFoundException;
import afinal.proyecto.cuatro.grupo.services.UserService;
import afinal.proyecto.cuatro.grupo.services.util.ServiceUtil;

@Service
public class UserServiceImpl extends ServiceUtil implements UserService {
	
	@Autowired
	private DaoUser daoUser;
	
	@Override
	public void saveOrUpdate(User user) {
		try {
			daoUser.save(user);
		} catch (Exception e) {
			if (isConstraintName("unique_email", e)) throw new UserDuplicateEmailException(user.getEmail());
		}
	}

	@Override
	public User findById(Long id) {
		return daoUser.findById(id)
				.orElseThrow(() -> new UserNotFoundException("id", id));
	}

	@Override
	public Iterable<User> findAll() {
		return daoUser.findAll();
	}

	@Override
	public void delete(User user) {
		daoUser.delete(user);
	}

}
