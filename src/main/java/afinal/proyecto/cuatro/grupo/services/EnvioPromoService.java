package afinal.proyecto.cuatro.grupo.services;

import afinal.proyecto.cuatro.grupo.entities.EnvioPromo;


import org.springframework.stereotype.Service;

@Service
public interface EnvioPromoService {

	void saveOrUpdate(EnvioPromo envioPromo);
	
	Iterable<EnvioPromo> findAll();

}
