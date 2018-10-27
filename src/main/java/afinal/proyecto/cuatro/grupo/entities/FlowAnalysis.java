package afinal.proyecto.cuatro.grupo.entities;
import java.sql.Timestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "flowAnalysis")
public class FlowAnalysis {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	private String id_usuario;

	@NotNull
	private Timestamp momento_posicion;

	@NotNull
	private String zone;

	
	public FlowAnalysis() {
	}

	public FlowAnalysis(String name, Timestamp position, String zone) {
		this.id_usuario = name;
		this.momento_posicion = position;
		this.zone = zone;
		
	}

}
