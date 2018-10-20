package afinal.proyecto.cuatro.grupo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull
	private String name;
	
	@NotNull
	@Column(unique = true)
	private String email;
	
	@NotNull
	private String password;

	@ManyToMany(fetch = FetchType.LAZY,
			cascade = {
					CascadeType.PERSIST,
					CascadeType.MERGE
			})
	@JoinTable(name = "user_vuelos",
			joinColumns = { @JoinColumn(name = "user_id") },
			inverseJoinColumns = { @JoinColumn(name = "vuelo_id") })
	private Set<Vuelo> flights;

	public User() {

	}
	
	public User(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.flights = new HashSet<>();
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@JsonProperty
	public Set<Vuelo> getFlights() {
		return flights;
	}

	@JsonProperty
	public void setFlights(Set<Vuelo> flights) {
		this.flights = flights;
	}
}
