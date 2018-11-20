package afinal.proyecto.cuatro.grupo.entities;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "flow_analysis")
public class FlowAnalysis {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	private Long idUsuario;

	@NotNull
	private Date momentoPosicion;

	@NotNull
	private String zone;

	public FlowAnalysis() {

	}

	public FlowAnalysis(Long idUsuario, Date momentoPosicion, String zone) {
		this.idUsuario = idUsuario;
		this.momentoPosicion = momentoPosicion;
		this.zone = zone;
	}

	public Date getMomentoPosicion() {
		return momentoPosicion;
	}

	public void setMomentoPosicion(Date momentoPosicion) {
		this.momentoPosicion = momentoPosicion;
	}

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
}
