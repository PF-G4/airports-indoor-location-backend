package afinal.proyecto.cuatro.grupo.services.impl;

import afinal.proyecto.cuatro.grupo.dao.DaoBoardingGate;
import afinal.proyecto.cuatro.grupo.entities.BoardingGate;
import afinal.proyecto.cuatro.grupo.exceptions.BoardingGateNotFoundException;
import afinal.proyecto.cuatro.grupo.services.BoardingGateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardingGateServiceImpl implements BoardingGateService {

    @Autowired
    private DaoBoardingGate daoBoardingGate;

    @Override
    public void saveOrUpdate(BoardingGate boardingGate) {
        try {
            daoBoardingGate.save(boardingGate);
        } catch (Exception e) {
            System.out.println("[ERROR] " + e);
        }
    }

    @Override
    public BoardingGate findById(Long id) {
        return daoBoardingGate.findById(id)
                .orElseThrow(() -> new BoardingGateNotFoundException("id", id));
    }

    @Override
    public Iterable<BoardingGate> findAll() {
        return daoBoardingGate.findAll();
    }

    @Override
    public void delete(Long id) {
        try{
            daoBoardingGate.delete(findById(id));
        } catch (Exception e) {
            System.out.println("[ERROR] " + e);
        }
    }

}
