package afinal.proyecto.cuatro.grupo.dao;

import afinal.proyecto.cuatro.grupo.entities.DuracionEstadia;
import org.springframework.data.repository.CrudRepository;

public interface DaoDuracionEstadia extends CrudRepository<DuracionEstadia, Long> {

    DuracionEstadia getDuracionEstadiaByZone(String zone);

}
