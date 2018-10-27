package afinal.proyecto.cuatro.grupo.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import afinal.proyecto.cuatro.grupo.dao.DaoFlowAnalysis;
import afinal.proyecto.cuatro.grupo.entities.FlowAnalysis;
//import afinal.proyecto.cuatro.grupo.exceptions.FlowAnalysisNotFoundException;
import afinal.proyecto.cuatro.grupo.services.FlowAnalysisService;


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

}
