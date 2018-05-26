package afinal.proyecto.cuatro.grupo.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "userdestinationhistory")
public class UserDestinationHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@OneToMany(mappedBy = "userDestinationHistory")
	@PrimaryKeyJoinColumn
	private Set<User> users;

	@OneToMany(mappedBy = "userDestinationHistory")
	@PrimaryKeyJoinColumn
	private Set<Destination> destinations;

	@NotNull
	private Date date;

	public UserDestinationHistory() {
	}

	public UserDestinationHistory(Set<User> users, Set<Destination> destinations, Date date) {
		this.users = users;
		this.destinations = destinations;
		this.date = date;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Set<User> getUser() { return users; }
	public void setUser(Set<User> users) {
		this.users = users;
	}
	public Set<Destination> getDestination() {
		return destinations;
	}
	public void setDestination(Set<Destination> destinations) {
		this.destinations = destinations;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

}
