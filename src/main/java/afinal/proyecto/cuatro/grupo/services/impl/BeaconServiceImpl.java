package afinal.proyecto.cuatro.grupo.services.impl;

import afinal.proyecto.cuatro.grupo.dao.DaoBeacon;
import afinal.proyecto.cuatro.grupo.entities.Beacon;
import afinal.proyecto.cuatro.grupo.services.BeaconService;
import afinal.proyecto.cuatro.grupo.services.util.ServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BeaconServiceImpl extends ServiceUtil implements BeaconService {
	
	@Autowired
	private DaoBeacon daoBeacon;
	
	@Override
	public void saveOrUpdate(Beacon beacon) {
		try {
			daoBeacon.save(beacon);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public Beacon findBeaconById(String id) {
		return daoBeacon.findBeaconById(id);
	}

	@Override
	public Iterable<Beacon> findAll() {
		return daoBeacon.findAll();
	}

	@Override
	public void delete(String id) {
		try{
			daoBeacon.delete(findBeaconById(id));
		} catch (Exception e) {
			System.out.println("[ERROR] " + e);
		}
	}

}
