package afinal.proyecto.cuatro.grupo.entities;

public class Node{

    private final String value;
    private double g_scores;
    private double h_scores;
    private double f_scores = 0;
    private Edge[] adjacencies;
    private Node parent;

    public Node(String val, double hVal){
            value = val;
            h_scores = hVal;
    }

    public String toString(){
            return value;
    }

	public double getG_scores() {
		return g_scores;
	}

	public void setG_scores(double g_scores) {
		this.g_scores = g_scores;
	}

	public double getH_scores() {
		return h_scores;
	}
	
	public void setH_scores(double h_scores) {
		this.h_scores = h_scores;
	}

	public double getF_scores() {
		return f_scores;
	}

	public void setF_scores(double f_scores) {
		this.f_scores = f_scores;
	}

	public Edge[] getAdjacencies() {
		return adjacencies;
	}

	public void setAdjacencies(Edge[] adjacencies) {
		this.adjacencies = adjacencies;
	}
	
	public String getValue() {
		return value;
	}
	
	
	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

}
