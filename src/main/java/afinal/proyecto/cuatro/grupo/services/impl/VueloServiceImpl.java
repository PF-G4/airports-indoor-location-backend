package afinal.proyecto.cuatro.grupo.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import afinal.proyecto.cuatro.grupo.dao.DaoVuelo;
import afinal.proyecto.cuatro.grupo.entities.Vuelo;
import afinal.proyecto.cuatro.grupo.services.VueloService;

@Service
public class VueloServiceImpl implements VueloService {
	
	@Autowired
	private DaoVuelo daoVuelo;
	
	@Override
	public void saveOrUpdate(Vuelo vuelo) {
		try {
			daoVuelo.save(vuelo);
		} catch (Exception e) {
			System.out.println("[ERROR] " + e);
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

}
