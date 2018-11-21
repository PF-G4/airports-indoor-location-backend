
package afinal.proyecto.cuatro.grupo.controllers;

import afinal.proyecto.cuatro.grupo.api.ResponseDuracionEstadia;
import afinal.proyecto.cuatro.grupo.api.ResponsePeopleQuantity;
import afinal.proyecto.cuatro.grupo.entities.FlowAnalysis;
import afinal.proyecto.cuatro.grupo.services.FlowAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

@RestController
@RequestMapping("/flowAnalysis")
public class FlowAnalysisController {

	@Autowired
	private FlowAnalysisService flowAnalysisService;

	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;

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
												 @RequestParam(value = "until", defaultValue = "") String until) {
		return flowAnalysisService.peopleQuantity(zone, since, until);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/duracionEstadia")
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseDuracionEstadia duracionEstadia(@RequestParam(value = "zone", defaultValue = "") String zone) {
		String queryStr = "select duracion_estadia from demora_actual where zone = ?1";
		try {
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			Query query = entityManager.createNativeQuery(queryStr);
			query.setParameter(1, zone);

			return new ResponseDuracionEstadia(Double.parseDouble(query.getSingleResult().toString()));
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}
