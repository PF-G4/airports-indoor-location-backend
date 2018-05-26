package afinal.proyecto.cuatro.grupo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
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

	@OneToMany(mappedBy = "user")
	private UserDestinationHistory userDestinationHistory;
	
	public User() {
		
	}
	
	public User(String name, String email, String password, UserDestinationHistory userDestinationHistory) {
		this.name = name;
		this.email = email;
		this.password = password;
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
	public UserDestinationHistory getUserDestinationHistory() {
		return userDestinationHistory;
	}
	public void setUserDestinationHistory(UserDestinationHistory userDestinationHistory) {
		this.userDestinationHistory = userDestinationHistory;
	}

}
