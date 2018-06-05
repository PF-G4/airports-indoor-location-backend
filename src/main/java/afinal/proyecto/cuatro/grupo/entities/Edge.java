package afinal.proyecto.cuatro.grupo.entities;

public class Edge{
    private double cost;
    private final Node target;

    public Edge(Node targetNode, double costVal){
            target = targetNode;
            cost = costVal;
    }

	public double getCost() {
		return cost;
	}
	
	public void setCost(double cost) {
		this.cost = cost;
	}

	public Node getTarget() {
		return target;
	}
}