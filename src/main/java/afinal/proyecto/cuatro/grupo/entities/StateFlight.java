package afinal.proyecto.cuatro.grupo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "vuelo_estado")
public class StateFlight {

    @Id
    @Column(name = "id")
    private Integer id;

    @NotNull
    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "stateFlight", cascade = CascadeType.ALL)
    private Set<Vuelo> vuelo;

    private StateFlight() {

    }

    private StateFlight(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @JsonIgnore
    public Set<Vuelo> getVuelo() {
        return vuelo;
    }

    public void setVuelo(Set<Vuelo> vuelo) {
        this.vuelo = vuelo;
    }

}