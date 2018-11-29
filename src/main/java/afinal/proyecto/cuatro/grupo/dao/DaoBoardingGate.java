package afinal.proyecto.cuatro.grupo.dao;

import afinal.proyecto.cuatro.grupo.entities.BoardingGate;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DaoBoardingGate extends CrudRepository<BoardingGate, Long> {

    Optional<BoardingGate> findBoardingGateByNumber(Integer number);

}
