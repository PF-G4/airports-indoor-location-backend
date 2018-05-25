package afinal.proyecto.cuatro.grupo.dao;

import afinal.proyecto.cuatro.grupo.entities.Beacon;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface DaoBeacon extends CrudRepository<Beacon, String> {

    @Query("select b from Beacon b where b.id=:id")
    Beacon findBeaconById(@Param("id") String id);
}
