
package afinal.proyecto.cuatro.grupo.controllers;

import afinal.proyecto.cuatro.grupo.api.ResponsePeopleQuantity;
import afinal.proyecto.cuatro.grupo.entities.FlowAnalysis;
import afinal.proyecto.cuatro.grupo.services.FlowAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

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
	public ResponsePeopleQuantity peopleQuantity(@RequestParam(value = "zone", defaultValue = "") String zone,
												 @RequestParam(value = "since", defaultValue = "")  String since,
												 @RequestParam(value = "until", defaultValue = "") String until) throws ParseException {
		return flowAnalysisService.peopleQuantity(zone, since, until);
	}
}
