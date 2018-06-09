package afinal.proyecto.cuatro.grupo.entities;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Edges")
public class Edge{
	
	@Id
	private long edgeId;
	
	@NotNull
    private double cost;
	
	@Transient //no persiste este campo
	private Node origin;
	
	@Size(max = 60)
	@NotNull
	private String origin_value;
	
	@Transient //no persiste este campo
	private Node target;
	
	@Size(max = 60)
	@NotNull
	private String target_value;

    public Edge(Node originNode,Node targetNode, double costVal){
            
    		origin = originNode;
    		target = targetNode;
            cost = costVal;
            origin_value = origin.getValue();
            target_value = target.getValue();
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

	public Node getOrigin() {
		return origin;
	}

	public void setOrigin(Node origin) {
		this.origin = origin;
		this.origin_value = origin.getValue();
	}

	public void setTarget(Node target) {
		this.target = target;
		this.target_value = target.getValue();
	}
	
	
	public String getOrigin_value() {
		return origin_value;
	}


	public String getTarget_value() {
		return target_value;
	}


}