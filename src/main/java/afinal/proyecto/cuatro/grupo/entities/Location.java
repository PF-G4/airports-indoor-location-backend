package afinal.proyecto.cuatro.grupo.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "location")
public class Location {
	
	@Id
	private Integer id;
	
	@NotNull
	private String name;
	
	@NotNull
	private String abreviature;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "destinationId")
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

	@Override
	public String toString() {
		return name + " (" + abreviature +")";
	}
	
}
