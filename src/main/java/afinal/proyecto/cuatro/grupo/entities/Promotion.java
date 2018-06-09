package afinal.proyecto.cuatro.grupo.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "promotions")
public class Promotion {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	private String promotion;

	@OneToOne
	@PrimaryKeyJoinColumn
	private Beacon beacon;

	public Promotion() {
	}

	public Promotion(String promotion, Beacon beacon) {
		this.promotion = promotion;
		this.beacon = beacon;
	}

	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }
	public String getPromotion() {
		return promotion;
	}
	public void setPromotion(String promotion) {
		this.promotion = promotion;
	}
	public Beacon getBeacon() {
		return beacon;
	}
	public void setBeacon(Beacon beacon) {
		this.beacon = beacon;
	}

}
