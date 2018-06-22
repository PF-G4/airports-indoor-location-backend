package afinal.proyecto.cuatro.grupo.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import afinal.proyecto.cuatro.grupo.dao.DaoDestination;
import afinal.proyecto.cuatro.grupo.entities.Destination;
import afinal.proyecto.cuatro.grupo.exceptions.DestinationNotFoundException;
import afinal.proyecto.cuatro.grupo.services.DestinationService;

@Service
public class DestinationServiceImpl implements DestinationService {
	
	@Autowired
	private DaoDestination daoDestination;
	
	@Override
	public void saveOrUpdate(Destination destination) {
		try {
			daoDestination.save(destination);
		} catch (Exception e) {
			System.out.println("[ERROR] " + e);
		}
	}

	@Override
	public Destination findById(Long id) {
		return daoDestination.findById(id)
				.orElseThrow(() -> new DestinationNotFoundException("id", id));
	}

	@Override
	public Iterable<Destination> findAll() {
		return daoDestination.findAll();
	}

	@Override
	public void delete(Long id) {
		try{
			daoDestination.delete(findById(id));
		} catch (Exception e) {
			System.out.println("[ERROR] " + e);
		}
	}

}
