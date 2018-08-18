package afinal.proyecto.cuatro.grupo.entities;

import java.util.ArrayList;
import java.util.List;


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
