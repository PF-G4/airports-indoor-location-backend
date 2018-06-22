package afinal.proyecto.cuatro.grupo.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import afinal.proyecto.cuatro.grupo.dao.DaoBeacon;
import afinal.proyecto.cuatro.grupo.entities.Beacon;
import afinal.proyecto.cuatro.grupo.exceptions.BeaconNotFoundException;
import afinal.proyecto.cuatro.grupo.services.BeaconService;

@Service
public class BeaconServiceImpl implements BeaconService {
	
	@Autowired
	private DaoBeacon daoBeacon;
	
	@Override
	public void saveOrUpdate(Beacon beacon) {
		try {
			daoBeacon.save(beacon);
		} catch (Exception e) {
			System.out.println("[ERROR] " + e);
		}
	}

	@Override
	public Beacon findById(Long id) {
		return daoBeacon.findById(id)
				.orElseThrow(() -> new BeaconNotFoundException("id", id));
	}

	@Override
	public Iterable<Beacon> findAll() {
		return daoBeacon.findAll();
	}

	@Override
	public void delete(Long id) {
		try{
			daoBeacon.delete(findById(id));
		} catch (Exception e) {
			System.out.println("[ERROR] " + e);
		}
	}

}
