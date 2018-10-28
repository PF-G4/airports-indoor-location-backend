package afinal.proyecto.cuatro.grupo.services;

import afinal.proyecto.cuatro.grupo.entities.Node;

import java.util.List;

public interface WayFindingService {
	List<Node> getDestination(double pos_orig_x, double pos_orig_y, double pos_dest_x, double pos_dest_y);
}
