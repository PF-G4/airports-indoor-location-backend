
package afinal.proyecto.cuatro.grupo.controllers;

import afinal.proyecto.cuatro.grupo.entities.FlowAnalysis;
import afinal.proyecto.cuatro.grupo.services.FlowAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/flowAnalysis")
public class FlowAnalysisController {

	@Autowired
	private FlowAnalysisService flowAnalysisService;

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	public void saveOrUpdate(@RequestBody FlowAnalysis flowAnalysis) {
		flowAnalysisService.saveOrUpdate(flowAnalysis);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public Iterable<FlowAnalysis> findAll() {
		return flowAnalysisService.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value="/peopleQuantity")
	@ResponseStatus(value = HttpStatus.OK)
	public int peopleQuantity(@RequestParam(value = "zone", defaultValue = "") String zone,
							  @RequestParam(value = "since", defaultValue = "") Date since,
							  @RequestParam(value = "until", defaultValue = "") Date until) {
		return flowAnalysisService.peopleQuantity(zone, since, until);
	}
		

}
