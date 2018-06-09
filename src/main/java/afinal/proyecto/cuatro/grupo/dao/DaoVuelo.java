package afinal.proyecto.cuatro.grupo.dao;

import afinal.proyecto.cuatro.grupo.entities.Vuelo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface DaoVuelo extends CrudRepository<Vuelo, String> {

    @Query("select v from Vuelo v where v.id=:id")
    Vuelo findVueloById(@Param("id") String id);

}
