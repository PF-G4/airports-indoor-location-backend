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
import java.util.stream.Collectors;


@RestController
@RequestMapping("/way-finding")
public class WayFindingController {

    private final WayFindingService wayFindingService;

    @Autowired
    public WayFindingController(WayFindingService wayFindingService) {
        this.wayFindingService = wayFindingService;
    }

    @GetMapping("/{oPosX}/{oPosY}/{dPosX}/{dPosY}")
    public List<String> getDestination(
            @PathVariable(value = "oPosX") double oPosX,
            @PathVariable(value = "oPosY") double oPosY,
            @PathVariable(value = "dPosX") double dPosX,
            @PathVariable(value = "dPosY") double dPosY) {

        List<Node> destination = wayFindingService.getDestination(oPosX, oPosY, dPosX, dPosY);

        System.out.printf("*** getDestination - road: %s%n", destination.toString());

        return createResponse(destination);
    }

    private List<String> createResponse(List<Node> destination) {
        return destination.stream().map(Node::toString).collect(Collectors.toList());
    }
}