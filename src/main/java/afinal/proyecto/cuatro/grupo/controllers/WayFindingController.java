package afinal.proyecto.cuatro.grupo.controllers;

import afinal.proyecto.cuatro.grupo.entities.Node;
import afinal.proyecto.cuatro.grupo.entities.Road;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import afinal.proyecto.cuatro.grupo.services.WayFindingService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("/way-finding")
public class WayFindingController {

    private final WayFindingService wayFindingService;

    @Autowired
    public WayFindingController(WayFindingService wayFindingService) {
        this.wayFindingService = wayFindingService;
    }

    @GetMapping("/{oPosX}/{oPosY}/{dPosX}/{dPosY}")
    public Road getDestination(
            @PathVariable(value = "oPosX") double oPosX,
            @PathVariable(value = "oPosY") double oPosY,
            @PathVariable(value = "dPosX") double dPosX,
            @PathVariable(value = "dPosY") double dPosY) {

        List<Node> destination = wayFindingService.getDestination(oPosX, oPosY, dPosX, dPosY);

        Road road = convertToRoad(destination);

        System.out.printf("*** getDestination - road: %s%n", road.toString());

        return road;
    }

    private Road convertToRoad(List<Node> destination) {

        String aux = destination.toString();

        aux = aux.substring(1, aux.length() - 1);

        List<String> myList = new ArrayList<>(Arrays.asList(aux.split(",")));

        return new Road(myList);
    }
}