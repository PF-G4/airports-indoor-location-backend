package afinal.proyecto.cuatro.grupo.services.impl;

import afinal.proyecto.cuatro.grupo.dao.DaoTiempoPromedioZona;
import afinal.proyecto.cuatro.grupo.entities.TiempoPromedioZona;
import afinal.proyecto.cuatro.grupo.exceptions.TiempoPromedioZonaNotFoundException;
import afinal.proyecto.cuatro.grupo.services.TiempoPromedioZonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TiempoPromedioZonaServiceImpl implements TiempoPromedioZonaService {

    @Autowired
    private DaoTiempoPromedioZona daoTiempoPromedioZona;

    @Override
    public TiempoPromedioZona tiempoPromedioZona(String zone) {
        return daoTiempoPromedioZona.findByZona(zone)
                .orElseThrow(() -> new TiempoPromedioZonaNotFoundException("zona", zone));
                //.orElse(new TiempoPromedioZona(zone, 0.0)); //por default, el tiempoProm es 0
    }
}
