package afinal.proyecto.cuatro.grupo.dao;

import afinal.proyecto.cuatro.grupo.entities.DuracionEstadia;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DaoDuracionEstadia extends CrudRepository<DuracionEstadia, Long> {

    Optional<DuracionEstadia> getDuracionEstadiaByZone(String zone);

}
