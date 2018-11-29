package afinal.proyecto.cuatro.grupo.services.impl;

import afinal.proyecto.cuatro.grupo.dao.DaoPosition;
import afinal.proyecto.cuatro.grupo.entities.Position;
import afinal.proyecto.cuatro.grupo.exceptions.LastPositionNotFoundException;
import afinal.proyecto.cuatro.grupo.services.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PositionServiceImpl implements PositionService {

	@Autowired
	private DaoPosition daoPosition;

	@Override
	public Position getLastPosition(Long userID) {

		return daoPosition.findPositionByUserID(userID)
				.orElseThrow(() -> new LastPositionNotFoundException("userID", userID));
	};
}