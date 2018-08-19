package afinal.proyecto.cuatro.grupo.services.impl;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import afinal.proyecto.cuatro.grupo.dao.DaoLocation;
import afinal.proyecto.cuatro.grupo.dao.DaoStateFlight;
import afinal.proyecto.cuatro.grupo.dao.DaoVuelo;
import afinal.proyecto.cuatro.grupo.entities.Location;
import afinal.proyecto.cuatro.grupo.entities.StateFlight;
import afinal.proyecto.cuatro.grupo.entities.StateFlightEnum;
import afinal.proyecto.cuatro.grupo.entities.Vuelo;
import afinal.proyecto.cuatro.grupo.exceptions.FlightDuplicateNumberException;
import afinal.proyecto.cuatro.grupo.exceptions.FlightNotFoundException;
import afinal.proyecto.cuatro.grupo.exceptions.LocationNotFoundException;
import afinal.proyecto.cuatro.grupo.exceptions.StateNotFoundException;
import afinal.proyecto.cuatro.grupo.services.VueloService;

@Service
public class VueloServiceImpl implements VueloService {

	@Autowired
	private DaoVuelo daoVuelo;

	@Autowired
	private DaoStateFlight daoStateFlight;

	@Autowired
	private DaoLocation daoLocation;

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
	public Vuelo findVueloById(Long id) {
		Vuelo vuelo = daoVuelo.findById(id).orElseThrow(() -> new FlightNotFoundException("id", id));
		setStateFlightResponse(vuelo);
		setLocationResponse(vuelo);
		return vuelo;
	}

	@Override
	public Iterable<Vuelo> findAll() {
		Iterable<Vuelo> vuelos = daoVuelo.findAll();
		for (Vuelo vuelo : vuelos) {
			setStateFlightResponse(vuelo);
			setLocationResponse(vuelo);
		}
		return vuelos;
	}

	@Override
	public void delete(Long id) {
		try{
			daoVuelo.delete(daoVuelo.findById(id).orElseThrow(() -> new FlightNotFoundException("id", id)));
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

	private void setStateFlightResponse(Vuelo response) {
		StateFlight stateFlight = daoStateFlight.findById(response.getStateFlightId())
				.orElseThrow(() -> new StateNotFoundException("id", response.getStateFlightId()));
		response.setStateFlight(stateFlight);
	}

	private void setLocationResponse(Vuelo response) {
		Location location = daoLocation.findById(response.getDestinationId()).
				orElseThrow(() -> new LocationNotFoundException("id", response.getDestinationId()));
		response.setDestination(location);
	}

}