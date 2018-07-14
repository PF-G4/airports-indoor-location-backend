package afinal.proyecto.cuatro.grupo.entities;
import afinal.proyecto.cuatro.grupo.entities.Node;
import afinal.proyecto.cuatro.grupo.entities.Edge;

import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;


public class Grafo {
	
	private long idGrafo;
	
	private Iterable<Edge> edgesGrafo;
	
	private Iterable<Node> nodesGrafo;
		
	public Grafo(){
		
		
	}
	
	
	
	public long getIdGrafo() {
		return idGrafo;
	}

	public void setIdGrafo(long idGrafo) {
		this.idGrafo = idGrafo;
	}

	public Iterable<Edge> getEdgesGrafo() {
		return edgesGrafo;
	}

	public void setEdgesGrafo(Iterable<Edge> edgesGrafo) {
		this.edgesGrafo = edgesGrafo;
	}

	public Iterable<Node> getNodesGrafo() {
		return nodesGrafo;
	}

	public void setNodesGrafo(Iterable<Node> nodesGrafo) {
		this.nodesGrafo = nodesGrafo;
	}
		
		
	
	public Node getNodeByValue(String val) {

		List<Node> listaNodo = new ArrayList<Node>();
		for (Node node : nodesGrafo) {
			listaNodo.add(node);
		}
		

		return listaNodo.stream().filter(n -> n.getValue().equals(val)).findFirst().get();
	     

	}
	
	public Node getNodeByPosition(double posX, double posY) {

		List<Node> listaNodo = new ArrayList<Node>();
		for (Node node : nodesGrafo) {
			listaNodo.add(node);
		}
		

		return listaNodo.stream().filter(n -> n.getPos_x()==posX && n.getPos_y()==posY).findFirst().get();
	     

	}

}
