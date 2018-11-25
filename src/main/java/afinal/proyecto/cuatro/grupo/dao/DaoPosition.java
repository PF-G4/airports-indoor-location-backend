package afinal.proyecto.cuatro.grupo.dao;

import afinal.proyecto.cuatro.grupo.entities.Position;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface DaoPosition extends CrudRepository<Position, Integer> {

    @Query("select p from Position p where p.userID=:userID")
    Position findUserById(@Param("userID") Long userID);

}
