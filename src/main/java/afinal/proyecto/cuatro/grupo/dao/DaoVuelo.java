package afinal.proyecto.cuatro.grupo.dao;

import org.springframework.data.repository.CrudRepository;

import afinal.proyecto.cuatro.grupo.entities.Vuelo;

public interface DaoVuelo extends CrudRepository<Vuelo, Long> {

//    @Query("select v from Vuelo v where v.id=:id")
//    Vuelo findVueloById(@Param("id") String id);

}
