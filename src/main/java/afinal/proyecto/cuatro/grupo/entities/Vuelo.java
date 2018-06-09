package afinal.proyecto.cuatro.grupo.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "vuelos")
public class Vuelo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	private String number;

	@NotNull
	private Date boardingDateTime;

	@NotNull
	private Integer boardingGate;

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "vuelo_user",
			joinColumns = { @JoinColumn(name = "vuelo_id") },
			inverseJoinColumns = { @JoinColumn(name = "user_id") })
	private Set<User> users;

	public Vuelo() {
	}

	public Vuelo(String number, Date boardingDateTime, Integer boardingGate, Set<User> users) {
		this.number = number;
		this.boardingDateTime = boardingDateTime;
		this.boardingGate = boardingGate;
		this.users = users;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNumber() { return number; }
	public void setNumber(String number) { this.number = number; }
	public Date getBoardingDateTime() { return boardingDateTime; }
	public void setBoardingDateTime(Date boardingDateTime) {
		this.boardingDateTime = boardingDateTime;
	}
	public Integer getBoardingGate() {
		return boardingGate;
	}
	public void setBoardingGate(Integer boardingGate) {
		this.boardingGate = boardingGate;
	}
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) { this.users = users; }
}
