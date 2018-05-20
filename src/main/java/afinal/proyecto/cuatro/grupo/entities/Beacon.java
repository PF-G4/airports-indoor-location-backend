package afinal.proyecto.cuatro.grupo.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "beacons")
public class Beacon {

	@Id
	@Size(max = 60)
	private String id;

	@NotNull
	private String type;

	@NotNull
	private String position;

	@NotNull
	private String zone;

	public Beacon() {
	}

	public Beacon(String id, String type, String position, String zone) {
		this.id = id;
		this.type = type;
		this.position = position;
		this.zone = zone;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) { this.id = id; }
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getZone() {
		return zone;
	}
	public void setZone(String zone) {
		this.zone = zone;
	}

}
