package afinal.proyecto.cuatro.grupo.controllers;

import afinal.proyecto.cuatro.grupo.entities.BoardingGate;
import afinal.proyecto.cuatro.grupo.services.BoardingGateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/boardingGate")
public class BoardingGateController {

    @Autowired
    private BoardingGateService boardingGateService;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public void saveOrUpdate(@RequestBody BoardingGate boardingGate) {
        boardingGateService.saveOrUpdate(boardingGate);
    }

    @RequestMapping(method = RequestMethod.GET, value = {"/{id}"})
    @ResponseStatus(value = HttpStatus.OK)
    public BoardingGate findById(@PathVariable(value = "id") Long id) {
        return boardingGateService.findById(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Iterable<BoardingGate> findAll() {
        return boardingGateService.findAll();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = {"/{id}"})
    @ResponseStatus(value = HttpStatus.OK)
    public void delete(@PathVariable(value = "id") Long id) {
        boardingGateService.delete(id);
    }
}
