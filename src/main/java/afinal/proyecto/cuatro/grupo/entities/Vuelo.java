package afinal.proyecto.cuatro.grupo.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "vuelo")
public class Vuelo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;

	@ManyToMany(mappedBy = "vuelos")
	@PrimaryKeyJoinColumn
	private Set<User> users;

	@NotNull
	private Date boardingDateTime;

	@NotNull
	private Integer boardingGate;

	public Vuelo() {
	}

	public Vuelo(Set<User> users, Date boardingDateTime, Integer boardingGate) {
		this.users = users;
		this.boardingDateTime = boardingDateTime;
		this.boardingGate = boardingGate;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	public Date getBoardingDateTime() {
		return boardingDateTime;
	}
	public void setBoardingDateTime(Date boardingDateTime) {
		this.boardingDateTime = boardingDateTime;
	}
	public Integer getBoardingGate() {
		return boardingGate;
	}
	public void setBoardingGate(Integer boardingGate) {
		this.boardingGate = boardingGate;
	}

}
