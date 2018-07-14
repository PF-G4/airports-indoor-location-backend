package afinal.proyecto.cuatro.grupo.entities;
import java.lang.Math ;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "Nodes")
//@JsonIgnoreProperties(ignoreUnknown = true)
public class Node{
	
	@Id
	@Size(max = 60)
	private String value;
    
	private double g_scores;
    private double h_scores;
    private double f_scores = 0;
    
    @Transient //no persiste este campo
    private Edge[] adjacencies;
    
    @Transient //no persiste este campo
    private Node parent;
    
    @NotNull
    private double pos_x;
    
    @NotNull
    private double pos_y;
    
    ;
    
    public Node() {
    	
    }

    public Node(String val,double posX,double posY, double pos_dest_x,double pos_dest_y){
            value = val;
            pos_x = posX;
            pos_y = posY;
            h_scores = Math.hypot(pos_x-pos_dest_x, pos_y-pos_dest_y);
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

	public double getPos_x() {
		return pos_x;
	}

	public void setPos_x(double pos_x) {
		this.pos_x = pos_x;
	}

	public double getPos_y() {
		return pos_y;
	}

	public void setPos_y(double pos_y) {
		this.pos_y = pos_y;
	}
	
	

}
