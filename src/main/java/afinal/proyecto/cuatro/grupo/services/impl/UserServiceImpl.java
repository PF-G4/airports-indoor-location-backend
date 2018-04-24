package afinal.proyecto.cuatro.grupo.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import afinal.proyecto.cuatro.grupo.dao.DaoUser;
import afinal.proyecto.cuatro.grupo.entities.User;
import afinal.proyecto.cuatro.grupo.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private DaoUser daoUser;
	
	@Override
	public User saveOrUpdate(User user) {
		return daoUser.save(user);
	}

	@Override
	public User findById(Long id) {
		return daoUser.findById(id).get();
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
