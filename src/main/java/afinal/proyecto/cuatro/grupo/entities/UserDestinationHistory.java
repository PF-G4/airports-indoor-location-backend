package afinal.proyecto.cuatro.grupo.entities;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "userdestinationhistory")
public class UserDestinationHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	@PrimaryKeyJoinColumn
	private User user;

	@ManyToOne
	@PrimaryKeyJoinColumn
	private Destination destination;

	public UserDestinationHistory() {
	}

	public UserDestinationHistory(User user, Destination destination) {
		this.user = user;
		this.destination = destination;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Destination getDestination() {
		return destination;
	}
	public void setDestination(Destination destination) {
		this.destination = destination;
	}

}
