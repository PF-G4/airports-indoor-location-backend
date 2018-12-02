package afinal.proyecto.cuatro.grupo.dao;

import afinal.proyecto.cuatro.grupo.entities.FlowAnalysis;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;

public interface DaoFlowAnalysis extends CrudRepository<FlowAnalysis, Long> {

    @Query("select count(distinct f.idUsuario) from FlowAnalysis f where f.zone = :zone and f.momentoPosicion >= :since and f.momentoPosicion < :until")
    int peopleQuantity(@Param("zone") String zone, @Param("since") Date since, @Param("until") Date until);

    @Query("select count(distinct f.idUsuario) from FlowAnalysis f where f.zone = :zone and f.momentoPosicion >= :since")
    int peopleQuantity(@Param("zone") String zone, @Param("since") Date since);

}
