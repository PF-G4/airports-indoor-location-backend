package afinal.proyecto.cuatro.grupo.services.impl;

import afinal.proyecto.cuatro.grupo.dao.DaoLocation;
import afinal.proyecto.cuatro.grupo.entities.Location;
import afinal.proyecto.cuatro.grupo.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationServiceImpl implements LocationService {
	
	@Autowired
	private DaoLocation daoLocation;

	@Override
	public void saveOrUpdate(Location location) {
		try {
			daoLocation.save(location);
		} catch (Exception e) {
			System.out.println("[ERROR] " + e);
		}
	}

	@Override
	public Iterable<Location> findAll() {
		return daoLocation.findAll();
	}
}