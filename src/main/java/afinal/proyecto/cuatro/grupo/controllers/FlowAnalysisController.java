
package afinal.proyecto.cuatro.grupo.controllers;

import afinal.proyecto.cuatro.grupo.entities.FlowAnalysis;
import afinal.proyecto.cuatro.grupo.services.FlowAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

		

}
