package afinal.proyecto.cuatro.grupo.services;

import afinal.proyecto.cuatro.grupo.api.ResponsePeopleQuantity;
import afinal.proyecto.cuatro.grupo.entities.FlowAnalysis;
import org.springframework.stereotype.Service;

import java.text.ParseException;

@Service
public interface FlowAnalysisService {

	void saveOrUpdate(FlowAnalysis flowAnalysis);
	
	Iterable<FlowAnalysis> findAll();

	ResponsePeopleQuantity peopleQuantity(String zone, String since, String until) throws ParseException;

}
