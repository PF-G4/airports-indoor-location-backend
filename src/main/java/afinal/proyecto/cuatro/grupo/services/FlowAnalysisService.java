package afinal.proyecto.cuatro.grupo.services;

import afinal.proyecto.cuatro.grupo.entities.FlowAnalysis;


import org.springframework.stereotype.Service;

@Service
public interface FlowAnalysisService {

	void saveOrUpdate(FlowAnalysis flowAnalysis);
	
	Iterable<FlowAnalysis> findAll();

}
