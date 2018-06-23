package afinal.proyecto.cuatro.grupo.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


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

	@ManyToMany(mappedBy = "users")
	private Set<Vuelo> vuelos;

	public User() {

	}
	
	public User(String name, String email, String password, Set<Vuelo> vuelos) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.vuelos = vuelos;
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
	public Set<Vuelo> getVuelos() { return vuelos; }
	public void setVuelos(Set<Vuelo> vuelos) {
		this.vuelos = vuelos;
	}

}
