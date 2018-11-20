package afinal.proyecto.cuatro.grupo.services.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import afinal.proyecto.cuatro.grupo.dao.DaoEnvioPromo;
import afinal.proyecto.cuatro.grupo.entities.EnvioPromo;
import afinal.proyecto.cuatro.grupo.services.EnvioPromoService;



@Service
public class EnvioPromoServiceImpl implements EnvioPromoService {

	@Autowired
	private DaoEnvioPromo daoEnvioPromo;
	
	@Override
	public void saveOrUpdate(EnvioPromo envioPromo) {
		try {
			daoEnvioPromo.save(envioPromo);
		} catch (Exception e) {
			System.out.println("[ERROR] " + e);
		}
	}
	
	@Override
	public Iterable<EnvioPromo> findAll() {
		Iterable<EnvioPromo> envioPromo = daoEnvioPromo.findAll();
		return envioPromo;
	}

}
