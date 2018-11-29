package afinal.proyecto.cuatro.grupo.services;

import afinal.proyecto.cuatro.grupo.entities.BoardingGate;
import org.springframework.stereotype.Service;

@Service
public interface BoardingGateService {

    void saveOrUpdate(BoardingGate boardingGate);

    BoardingGate findById(Long id);

    Iterable<BoardingGate> findAll();

    void delete(Long id);

}
