package afinal.proyecto.cuatro.grupo.services;

import afinal.proyecto.cuatro.grupo.entities.UserDestinationHistory;
import org.springframework.stereotype.Service;

@Service
public interface UserDestinationHistoryService {
	
	void saveOrUpdate(UserDestinationHistory userDestinationHistory);
	
	UserDestinationHistory findByUser(String user);
	
	Iterable<UserDestinationHistory> findAll();

}
