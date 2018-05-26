package afinal.proyecto.cuatro.grupo.dao;

import afinal.proyecto.cuatro.grupo.entities.UserDestinationHistory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface DaoUserDestinationHistory extends CrudRepository<UserDestinationHistory, Long> {

    @Query("select udh from UserDestinationHistory udh where udh.user=:user")
    UserDestinationHistory findByUser(@Param("user") String user);

}
