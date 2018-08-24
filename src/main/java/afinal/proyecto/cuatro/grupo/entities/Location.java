package afinal.proyecto.cuatro.grupo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "location")
public class Location {

	@Id
	@Column(name = "id")
	private Integer id;

	@NotNull
	private String name;

	@NotNull
	private String abreviature;

	@OneToMany(mappedBy = "destination", cascade = CascadeType.ALL)
	private Set<Vuelo> vuelo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAbreviature() {
		return abreviature;
	}

	public void setAbreviature(String abreviature) {
		this.abreviature = abreviature;
	}

	@JsonIgnore
	public Set<Vuelo> getVuelo() {
		return vuelo;
	}

	public void setVuelo(Set<Vuelo> vuelo) {
		this.vuelo = vuelo;
	}

	@Override
	public String toString() {
		return name + " (" + abreviature +")";
	}

}