package afinal.proyecto.cuatro.grupo.services.impl;

import afinal.proyecto.cuatro.grupo.dao.DaoDuracionEstadia;
import afinal.proyecto.cuatro.grupo.entities.DuracionEstadia;
import afinal.proyecto.cuatro.grupo.exceptions.DuracionEstadiaNotFoundException;
import afinal.proyecto.cuatro.grupo.services.DuracionEstadiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DuracionEstadiaServiceImpl implements DuracionEstadiaService {

    @Autowired
    private DaoDuracionEstadia daoDuracionEstadia;

    @Override
    public DuracionEstadia duracionEstadia(String zone) {
        return daoDuracionEstadia.getDuracionEstadiaByZone(zone)
                .orElseThrow(() -> new DuracionEstadiaNotFoundException("zone", zone));
    }
}
