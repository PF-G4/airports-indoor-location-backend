package afinal.proyecto.cuatro.grupo.controllers;

import afinal.proyecto.cuatro.grupo.entities.Position;
import afinal.proyecto.cuatro.grupo.services.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lastposition")
public class LastPositionController {

	private final PositionService positionService;

	@Autowired
	public LastPositionController(PositionService positionService) {
		this.positionService = positionService;
	}

	@GetMapping("/{userID}")
	public Position getLastPosition(@PathVariable(value = "userID") Long userID) {

		return positionService.getLastPosition(userID);
	}

}
