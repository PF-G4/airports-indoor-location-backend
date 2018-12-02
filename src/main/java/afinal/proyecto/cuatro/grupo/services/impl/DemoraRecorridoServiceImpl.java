package afinal.proyecto.cuatro.grupo.services.impl;

import afinal.proyecto.cuatro.grupo.api.ResponseDemoraRecorrido;
import afinal.proyecto.cuatro.grupo.dao.DaoUser;
import afinal.proyecto.cuatro.grupo.entities.*;
import afinal.proyecto.cuatro.grupo.exceptions.UserNotFoundException;
import afinal.proyecto.cuatro.grupo.services.DemoraRecorridoService;
import afinal.proyecto.cuatro.grupo.services.PositionService;
import afinal.proyecto.cuatro.grupo.services.TiempoPromedioZonaService;
import afinal.proyecto.cuatro.grupo.services.WayFindingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DemoraRecorridoServiceImpl implements DemoraRecorridoService {

    private static Logger logger = LoggerFactory.getLogger(DemoraRecorridoServiceImpl.class);

    private static Map<String, String> positionWayFindingByBeaconTag = new HashMap<>();

    @Autowired
    private DaoUser daoUser;

    @Autowired
    private WayFindingService wayFindingService;

    @Autowired
    private TiempoPromedioZonaService tiempoPromedioZonaService;

    @Autowired
    private PositionService positionService;

    public DemoraRecorridoServiceImpl() {
        positionWayFindingByBeaconTag.put("le2", "1/1");
        positionWayFindingByBeaconTag.put("ca2", "3/3");
        positionWayFindingByBeaconTag.put("co1", "3/5");
        positionWayFindingByBeaconTag.put("co2", "4/5");
        positionWayFindingByBeaconTag.put("br1", "4/3");
        positionWayFindingByBeaconTag.put("ca1", "4/4");
        positionWayFindingByBeaconTag.put("br2", "2/1");
        positionWayFindingByBeaconTag.put("le1", "3/2");

        positionWayFindingByBeaconTag.put("lemon-2", "1/1");
        positionWayFindingByBeaconTag.put("candy-2", "3/3");
        positionWayFindingByBeaconTag.put("coconut-1", "3/5");
        positionWayFindingByBeaconTag.put("coconut-2", "4/5");
        positionWayFindingByBeaconTag.put("beetroot-1", "4/3");
        positionWayFindingByBeaconTag.put("candy-1", "4/4");
        positionWayFindingByBeaconTag.put("beetroot-2", "2/1");
        positionWayFindingByBeaconTag.put("lemon-1", "3/2");
    }

    @Override
    public ResponseDemoraRecorrido getDemoraRecorrido(Long idUser) {

        logger.info(String.format("[%s] Search DemoraRecorrido for idUser=%s", this.getClass().getSimpleName(), idUser));

        User user = daoUser.findById(idUser)
                .orElseThrow(() -> new UserNotFoundException("id", idUser));

        Position lastPosition = positionService.getLastPosition(user.getId());

        String positionOrigen = positionWayFindingByBeaconTag.get(lastPosition.getZone());
        String[] coordenadaOrigen = positionOrigen.split("/");

        Vuelo flight = getProximityFlight(user.getFlights());
        logger.info(String.format("[%s] LastPosition is %s. First flight to search destination is %s", this.getClass().getSimpleName(), lastPosition, flight));
        String beaconTagDestino = flight.getBoardingGate().getBeaconTag();

        String positionDestino = positionWayFindingByBeaconTag.get(beaconTagDestino);
        String[] coordenadaDestino = positionDestino.split("/");

        List<Node> nodesResult = wayFindingService.getDestination(
                Double.parseDouble(coordenadaOrigen[0]),
                Double.parseDouble(coordenadaOrigen[1]),
                Double.parseDouble(coordenadaDestino[0]),
                Double.parseDouble(coordenadaDestino[1])
        );

        logger.info(String.format("[%s] WayFound for %s to %s : %s", this.getClass().getSimpleName(), lastPosition.getZone(), beaconTagDestino, nodesResult));

        Double result = 0.0;
        for (Node node: nodesResult) {
            result += tiempoPromedioZonaService.tiempoPromedioZona(node.getValue()).getTiempoProm();
        }

        return new ResponseDemoraRecorrido(result, flight);
    }

    private Vuelo getProximityFlight(Set<Vuelo> flights) {
        if (flights.isEmpty())
            throw new RuntimeException("No flights associated for user");
        List<Vuelo> flightsInFuture = flights.stream().sorted(Comparator.comparing(Vuelo::getBoardingDateTime))
                .filter(flight -> flight.getBoardingDateTime().after(new Date())) //que el date sea mayor al dia de hoy (el vuelo no haya sido volado)
                .collect(Collectors.toList());
        if (flightsInFuture.isEmpty())
            throw new RuntimeException("No flights in the future for the user.");
        return flightsInFuture.get(0);

    }
}
