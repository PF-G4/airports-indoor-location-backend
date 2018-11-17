package afinal.proyecto.cuatro.grupo.entities;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "flow_analysis")
public class FlowAnalysis {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	private String id_usuario;

	@NotNull
	private String momento_posicion;

	@NotNull
	private String zone;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(String id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getMomento_posicion() {
		return momento_posicion;
	}

	public void setMomento_posicion(String momento_posicion) {
		this.momento_posicion = momento_posicion;
	}

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	public FlowAnalysis() {
	}

	public FlowAnalysis(String name, String position, String zone) {
		this.id_usuario = name;
		this.momento_posicion = position;
		this.zone = zone;
		
	}

}
