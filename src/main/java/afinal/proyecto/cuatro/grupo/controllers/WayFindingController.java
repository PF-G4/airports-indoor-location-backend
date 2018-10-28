package afinal.proyecto.cuatro.grupo.controllers;

import afinal.proyecto.cuatro.grupo.entities.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import afinal.proyecto.cuatro.grupo.services.WayFindingService;;import java.util.List;


@RestController
@RequestMapping("/way-finding")
public class WayFindingController {

    @Autowired
    private WayFindingService wayFindingService;

    @GetMapping("/{oPosX}/{oPosY}/{dPosX}/{dPosY}")
    public String getDestination(
            @PathVariable(value = "oPosX") double oPosX,
            @PathVariable(value = "oPosY") double oPosY,
            @PathVariable(value = "dPosX") double dPosX,
            @PathVariable(value = "dPosY") double dPosY) {

        List<Node> destination = wayFindingService.getDestination(oPosX, oPosY, dPosX, dPosY);

        return destination.toString();
    }
}