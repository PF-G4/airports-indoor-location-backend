package afinal.proyecto.cuatro.grupo.services.impl;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import afinal.proyecto.cuatro.grupo.dao.DaoStateFlight;
import afinal.proyecto.cuatro.grupo.dao.DaoVuelo;
import afinal.proyecto.cuatro.grupo.entities.StateFlightEnum;
import afinal.proyecto.cuatro.grupo.entities.Vuelo;
import afinal.proyecto.cuatro.grupo.exceptions.FlightDuplicateNumberException;
import afinal.proyecto.cuatro.grupo.exceptions.StateNotFoundException;
import afinal.proyecto.cuatro.grupo.services.VueloService;

@Service
public class VueloServiceImpl implements VueloService {
	
	@Autowired
	private DaoVuelo daoVuelo;
	
	@Autowired
	private DaoStateFlight daoStateFlight;
	
	@Override
	public void saveOrUpdate(Vuelo vuelo) {
		validateStateFlightId(vuelo);
		try {
			daoVuelo.save(vuelo);
		} catch (Exception e) {
			if (e.getCause() != null && e.getCause() instanceof ConstraintViolationException) {
				throw new FlightDuplicateNumberException(vuelo.getNumber());
			}
			//if (ServiceUtil.isConstraintName("unique_number", e)) throw new FlightDuplicateNumberException(vuelo.getNumber());
		}
	}

	@Override
	public Vuelo findVueloById(String id) {
		return daoVuelo.findVueloById(id);
	}

	@Override
	public Iterable<Vuelo> findAll() {
		return daoVuelo.findAll();
	}

	@Override
	public void delete(String id) {
		try{
			daoVuelo.delete(findVueloById(id));
		} catch (Exception e) {
			System.out.println("[ERROR] " + e);
		}
	}

	//PRIVATE METHODS
	
	private void validateStateFlightId(Vuelo vuelo) {
		if (vuelo.getStateFlightId() == null) {
			vuelo.setStateFlightId(StateFlightEnum.EN_HORARIO.getId());
		} else {
			daoStateFlight.findById(vuelo.getStateFlightId()).orElseThrow(() -> new StateNotFoundException("id", vuelo.getStateFlightId()));
		}
	}
	
}
	