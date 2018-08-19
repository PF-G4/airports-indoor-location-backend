package afinal.proyecto.cuatro.grupo.services.impl;

import afinal.proyecto.cuatro.grupo.entities.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import afinal.proyecto.cuatro.grupo.dao.DaoStateFlight;
import afinal.proyecto.cuatro.grupo.services.StateFlightService;

@Service
public class StateFlightServiceImpl implements StateFlightService {
	
	@Autowired
	private DaoStateFlight daoStateFlight;

	@Override
	public void saveOrUpdate(StateFlight stateFlight) {
		try {
			daoStateFlight.save(stateFlight);
		} catch (Exception e) {
			System.out.println("[ERROR] " + e);
		}
	}

	@Override
	public Iterable<StateFlight> findAll() {
		return daoStateFlight.findAll();
	}
}