package afinal.proyecto.cuatro.grupo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "boarding_gate")
public class BoardingGate {

    @Id
    @Column(name = "id")
    private Long id;

    @NotNull
    private Integer number;

    @NotNull
    @Column(unique = true) //solo un beacon por puerta de embarque
    private String beaconTag;

    @OneToMany(mappedBy = "boardingGate", cascade = CascadeType.ALL)
    private Set<Vuelo> vuelo;

    public BoardingGate(Long id, String beaconTag, Integer number) {
        this.id = id;
        this.beaconTag = beaconTag;
        this.number = number;
    }

    public BoardingGate() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBeaconTag() {
        return beaconTag;
    }

    public void setBeaconTag(String beaconTag) {
        this.beaconTag = beaconTag;
    }

    @JsonIgnore
    public Set<Vuelo> getVuelo() {
        return vuelo;
    }

    public void setVuelo(Set<Vuelo> vuelo) {
        this.vuelo = vuelo;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
