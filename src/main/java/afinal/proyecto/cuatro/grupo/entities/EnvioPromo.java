package afinal.proyecto.cuatro.grupo.entities;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "envio_promocion")
public class EnvioPromo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	private Long idUsuario;

	@NotNull
	private Date momentoEnvio;

	@NotNull
	private String beacon;
	
	@NotNull
	private Integer flagPromo;
	
	//en este campo lo dejo por si queremos guardar algo que nos interese por ej algo relacionado con las alertas
	private String textoMultiuso;
	
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

	public Date getMomentoEnvio() {
		return momentoEnvio;
	}

	public void setMomentoEnvio(Date momentoEnvio) {
		this.momentoEnvio = momentoEnvio;
	}

	public String getBeacon() {
		return beacon;
	}

	public void setBeacon(String beacon) {
		this.beacon = beacon;
	}

	public Integer getFlagPromo() {
		return flagPromo;
	}

	public void setFlagPromo(Integer flagPromo) {
		this.flagPromo = flagPromo;
	}

	public String getTextoMultiuso() {
		return textoMultiuso;
	}

	public void setTextoMultiuso(String textoMultiuso) {
		this.textoMultiuso = textoMultiuso;
	}

	

	public EnvioPromo(Long idUsuario, Date momentoEnvio, String beacon, Integer flagPromo, String textoMultiuso) {
		this.idUsuario = idUsuario;
		this.momentoEnvio = momentoEnvio;
		this.beacon = beacon;
		this.flagPromo = flagPromo;
		this.textoMultiuso = textoMultiuso;
	}

}
