package afinal.proyecto.cuatro.grupo.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import afinal.proyecto.cuatro.grupo.services.WayFindingService;;


@RestController
@RequestMapping("/way-finding")
public class WayFindingController {

	@Autowired
	private WayFindingService wayFindingService;


	@GetMapping("/{posX}/{posY}")

    public void getDestination(@PathVariable(value = "posX") double posX,

							   @PathVariable(value = "posY") double posY) {

        /*return */ wayFindingService.getDestination(posX, posY);

    }



}