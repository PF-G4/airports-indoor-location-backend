package afinal.proyecto.cuatro.grupo.controllers;

import afinal.proyecto.cuatro.grupo.entities.EnvioPromo;
import afinal.proyecto.cuatro.grupo.services.EnvioPromoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/envioPromo")
public class EnvioPromoController {

	@Autowired
	private EnvioPromoService envioPromoService;

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	public void saveOrUpdate(@RequestBody EnvioPromo envioPromo) {
		envioPromoService.saveOrUpdate(envioPromo);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public Iterable<EnvioPromo> findAll() {
		return envioPromoService.findAll();
	}

		

}
