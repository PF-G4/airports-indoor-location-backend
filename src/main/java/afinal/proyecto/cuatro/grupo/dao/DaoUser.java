package afinal.proyecto.cuatro.grupo.dao;

import org.springframework.data.repository.CrudRepository;

import afinal.proyecto.cuatro.grupo.entities.User;

public interface DaoUser extends CrudRepository<User, Long> {

}
