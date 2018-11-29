package afinal.proyecto.cuatro.grupo.services.impl;

import afinal.proyecto.cuatro.grupo.dao.DaoBoardingGate;
import afinal.proyecto.cuatro.grupo.entities.*;
import afinal.proyecto.cuatro.grupo.exceptions.*;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import afinal.proyecto.cuatro.grupo.dao.DaoLocation;
import afinal.proyecto.cuatro.grupo.dao.DaoStateFlight;
import afinal.proyecto.cuatro.grupo.dao.DaoVuelo;
import afinal.proyecto.cuatro.grupo.services.VueloService;

@Service
public class VueloServiceImpl implements VueloService {

	@Autowired
	private DaoVuelo daoVuelo;

	@Autowired
	private DaoStateFlight daoStateFlight;

	@Autowired
	private DaoLocation daoLocation;

	@Autowired
	private DaoBoardingGate daoBoardingGate;

	@Override
	public void saveOrUpdate(Vuelo vuelo) {
		validateStateFlightId(vuelo);
		validateDestinationId(vuelo);
		validateBoardingGateNumber(vuelo);
		try {
			daoVuelo.save(vuelo);
		} catch (Exception e) {
			if (e.getCause() != null && e.getCause() instanceof ConstraintViolationException) {
				throw new FlightDuplicateNumberException(vuelo.getNumber());
			}
		}
	}

	@Override
	public Vuelo findVueloById(Long id) {
		return daoVuelo.findById(id).orElseThrow(() -> new FlightNotFoundException("id", id));
	}

	@Override
	public Iterable<Vuelo> findAll() {
		Iterable<Vuelo> vuelos = daoVuelo.findAll();
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
		StateFlight stateFlight = daoStateFlight.findById(
				vuelo.getStateFlightId() == null ? StateFlightEnum.EN_HORARIO.getId() : vuelo.getStateFlightId()
		).orElseThrow(() -> new StateNotFoundException("id", vuelo.getStateFlightId()));
		vuelo.setStateFlight(stateFlight);
	}


	private void validateDestinationId(Vuelo vuelo) {
		Location destination = daoLocation.findById(
				vuelo.getDestinationId()).orElseThrow(() -> new DestinationNotFoundException("id", vuelo.getDestinationId()));
		vuelo.setDestination(destination);
	}


	private void validateBoardingGateNumber(Vuelo vuelo) {
		BoardingGate boardingGate = daoBoardingGate.findBoardingGateByNumber(vuelo.getBoardingGateNumber())
				.orElseThrow(() -> new BoardingGateNotFoundException("number", vuelo.getBoardingGateNumber()));
		vuelo.setBoardingGate(boardingGate);
	}
}