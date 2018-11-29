package afinal.proyecto.cuatro.grupo.entities;

import javax.persistence.*;

@Entity
@Table(name = "ultima_posicion")
public class Position {

	@Id
	@Column(name = "id")
	private Integer id;

	@Column(name = "id_usuario")
	private Long userID;

	@Column(name = "momento_posicion")
	private String momentoPosicion;

	@Column(name = "zone")
	private String zone;

	public Position() {
	}

	public Position(Long userID, String momentoPosicion, String zone) {
		this.userID = userID;
		this.momentoPosicion = momentoPosicion;
		this.zone = zone;
	}

	public Long getUserID() {
		return userID;
	}

	public void setUserID(Long userID) {
		this.userID = userID;
	}

	public String getMomentoPosicion() {
		return momentoPosicion;
	}

	public void setMomentoPosicion(String momentoPosicion) {
		this.momentoPosicion = momentoPosicion;
	}

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	@Override
	public String toString() {
		return String.format("[userID=%s, momentoPosicion=%s, zone=%s]",
				userID,
				momentoPosicion,
				zone);
	}
}