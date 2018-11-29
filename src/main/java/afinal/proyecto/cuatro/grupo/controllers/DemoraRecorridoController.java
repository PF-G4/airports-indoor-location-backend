package afinal.proyecto.cuatro.grupo.controllers;

import afinal.proyecto.cuatro.grupo.api.ResponseDemoraRecorrido;
import afinal.proyecto.cuatro.grupo.services.DemoraRecorridoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/demoraRecorrido")
public class DemoraRecorridoController {

    @Autowired
    private DemoraRecorridoService demoraRecorridoService;

    @RequestMapping(method = RequestMethod.GET, value = {"/{idUser}"})
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseDemoraRecorrido getDemoraRecorrido(@PathVariable(value = "idUser") Long idUser) {
        return new ResponseDemoraRecorrido(demoraRecorridoService.getDemoraRecorrido(idUser));
    }

}
