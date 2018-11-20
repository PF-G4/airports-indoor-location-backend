package afinal.proyecto.cuatro.grupo.dao;

import afinal.proyecto.cuatro.grupo.entities.FlowAnalysis;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;

public interface DaoFlowAnalysis extends CrudRepository<FlowAnalysis, Long> {

    //@Query("")
    //int peopleQuantity(@Param("zone") String zone, @Param("since") Date since, @Param("until") Date until);
}
