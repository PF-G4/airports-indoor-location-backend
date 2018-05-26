package afinal.proyecto.cuatro.grupo.services.impl;

import afinal.proyecto.cuatro.grupo.dao.DaoUserDestinationHistory;
import afinal.proyecto.cuatro.grupo.entities.UserDestinationHistory;
import afinal.proyecto.cuatro.grupo.services.UserDestinationHistoryService;
import afinal.proyecto.cuatro.grupo.services.util.ServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDestinationHistoryServiceImpl extends ServiceUtil implements UserDestinationHistoryService {
	
	@Autowired
	private DaoUserDestinationHistory daoUserDestinationHistory;
	
	@Override
	public void saveOrUpdate(UserDestinationHistory userDestinationHistory) {
		try {
			daoUserDestinationHistory.save(userDestinationHistory);
		} catch (Exception e) {
			System.out.println("[ERROR] " + e);
		}
	}

	@Override
	public UserDestinationHistory findByUser(String user) {
		return daoUserDestinationHistory.findByUser(user);
	}

	@Override
	public Iterable<UserDestinationHistory> findAll() {
		return daoUserDestinationHistory.findAll();
	}

}
