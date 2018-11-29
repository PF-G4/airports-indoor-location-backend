package afinal.proyecto.cuatro.grupo.services;

import afinal.proyecto.cuatro.grupo.entities.TiempoPromedioZona;
import org.springframework.stereotype.Service;

@Service
public interface TiempoPromedioZonaService {

    TiempoPromedioZona tiempoPromedioZona(String zone);

}
