package afinal.proyecto.cuatro.grupo.controllers;

import afinal.proyecto.cuatro.grupo.api.ResponseTiempoPromedioZona;
import afinal.proyecto.cuatro.grupo.services.TiempoPromedioZonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tiempoPromZona")
public class TiempoPromedioZonaController {

    @Autowired
    private TiempoPromedioZonaService tiempoPromedioZonaService;

    @RequestMapping(method = RequestMethod.GET, value = {"/{zone}"})
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseTiempoPromedioZona getTiempoPromedioZona(@PathVariable(value = "zone") String zone) {
        return new ResponseTiempoPromedioZona(tiempoPromedioZonaService.tiempoPromedioZona(zone).getTiempoProm());
    }

}
