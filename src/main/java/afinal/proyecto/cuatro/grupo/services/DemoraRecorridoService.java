package afinal.proyecto.cuatro.grupo.services;

import afinal.proyecto.cuatro.grupo.api.ResponseDemoraRecorrido;
import org.springframework.stereotype.Service;

@Service
public interface DemoraRecorridoService {

    ResponseDemoraRecorrido getDemoraRecorrido(Long idUser);

}
