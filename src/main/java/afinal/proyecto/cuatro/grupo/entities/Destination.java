package afinal.proyecto.cuatro.grupo.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "destination")
public class Destination {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	@Column(unique = true)
	private String name;

	@NotNull
	private String zone;

	@OneToMany(mappedBy = "destination")
	private UserDestinationHistory userDestinationHistory;

	public Destination() {
	}

	public Destination(String name, String zone, UserDestinationHistory userDestinationHistory) {
		this.name = name;
		this.zone = zone;
		this.userDestinationHistory = userDestinationHistory;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getZone() {
		return zone;
	}
	public void setZone(String zone) {
		this.zone = zone;
	}
	public UserDestinationHistory getUserDestinationHistory() {
		return userDestinationHistory;
	}
	public void setUserDestinationHistory(UserDestinationHistory userDestinationHistory) {
		this.userDestinationHistory = userDestinationHistory;
	}

}
