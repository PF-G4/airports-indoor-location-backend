package afinal.proyecto.cuatro.grupo.services;

import afinal.proyecto.cuatro.grupo.entities.DuracionEstadia;
import org.springframework.stereotype.Service;

@Service
public interface DuracionEstadiaService {

    DuracionEstadia duracionEstadia(String zone);

}
