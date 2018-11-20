package afinal.proyecto.cuatro.grupo.services.impl;

import afinal.proyecto.cuatro.grupo.api.ResponsePeopleQuantity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import afinal.proyecto.cuatro.grupo.dao.DaoFlowAnalysis;
import afinal.proyecto.cuatro.grupo.entities.FlowAnalysis;
import afinal.proyecto.cuatro.grupo.services.FlowAnalysisService;

import java.time.format.DateTimeFormatter;
import java.util.Date;


@Service
public class FlowAnalysisServiceImpl implements FlowAnalysisService {

	@Autowired
	private DaoFlowAnalysis daoFlowAnalysis;
	
	@Override
	public void saveOrUpdate(FlowAnalysis flowAnalysis) {
		try {
			daoFlowAnalysis.save(flowAnalysis);
		} catch (Exception e) {
			System.out.println("[ERROR] " + e);
		}
	}
	
	@Override
	public Iterable<FlowAnalysis> findAll() {
		Iterable<FlowAnalysis> flowAnalysis = daoFlowAnalysis.findAll();
		return flowAnalysis;
	}

	@Override
	public ResponsePeopleQuantity peopleQuantity(String zone, String since, String until) {
		int result;
		if (until != null && !until.equals("")) {
			 result = daoFlowAnalysis.peopleQuantity(zone, since, until);
		} else {
			result = daoFlowAnalysis.peopleQuantity(zone, since);
		}
		return new ResponsePeopleQuantity(result);
	}

}
