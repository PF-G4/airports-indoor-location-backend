package afinal.proyecto.cuatro.grupo.controllers;

import afinal.proyecto.cuatro.grupo.api.ResponseDuracionEstadia;
import afinal.proyecto.cuatro.grupo.services.DuracionEstadiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/duracionEstadia")
public class DuracionEstadiaController {

    @Autowired
    private DuracionEstadiaService duracionEstadiaService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseDuracionEstadia getDuracionEstadia(@RequestParam(value = "zone", defaultValue = "") String zone) {
        return new ResponseDuracionEstadia(duracionEstadiaService.duracionEstadia(zone).getDuracionEstadia());
    }

}
