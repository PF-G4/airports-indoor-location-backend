package afinal.proyecto.cuatro.grupo.dao;

import afinal.proyecto.cuatro.grupo.entities.TiempoPromedioZona;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DaoTiempoPromedioZona extends CrudRepository<TiempoPromedioZona, Long> {

    Optional<TiempoPromedioZona> findByZona(String zone);

}
