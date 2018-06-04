package afinal.proyecto.cuatro.grupo.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "beacons")
public class Beacon {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	private String name;

	@NotNull
	private String position;

	@NotNull
	private String zone;

	@OneToOne(mappedBy="beacon", cascade=CascadeType.ALL)
	private Promotion promotion;

	public Beacon() {
	}

	public Beacon(String name, String position, String zone, Promotion promotion) {
		this.name = name;
		this.position = position;
		this.zone = zone;
		this.promotion = promotion;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) { this.id = id; }
	public String getName() {
		return name;
	}
	public void setName(String name) { this.name = name; }
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
	public Promotion getPromotion() {
		return promotion;
	}
	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}

}
