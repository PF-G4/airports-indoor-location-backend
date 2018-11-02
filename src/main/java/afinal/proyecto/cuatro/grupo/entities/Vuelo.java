package afinal.proyecto.cuatro.grupo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "vuelos")
public class Vuelo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	@Column(unique = true)
	private String number;

	@NotNull
	@Column(name = "boarding_date_time")
	private Date boardingDateTime;

	@NotNull
	@Column(name = "boarding_gate")
	private Integer boardingGate;

	@Transient
	@JsonIgnore
	private Integer stateFlightId;

	@Transient
	@JsonIgnore
	private Integer destinationId;

    @ManyToOne
    @JoinColumn(name = "state_flight_id")
	private StateFlight stateFlight;

    @ManyToOne
    @JoinColumn(name = "destination_id")
	private Location destination;

	@ManyToMany(fetch = FetchType.LAZY,
			cascade = {
					CascadeType.PERSIST,
					CascadeType.MERGE
			},
			mappedBy = "flights")
    private Set<User> users;

    public Vuelo() {
    }

	public Vuelo(String number, Date boardingDateTime, Integer boardingGate) {
		this.number = number;
		this.boardingDateTime = boardingDateTime;
		this.boardingGate = boardingGate;
		this.users = new HashSet<>();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getNumber() {
		return number; 
	}
	public void setNumber(String number) { 
		this.number = number; 
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

	@JsonIgnore
	public Integer getStateFlightId() {
		return stateFlightId;
	}

	@JsonProperty
	public void setStateFlightId(Integer stateFlightId) {
		this.stateFlightId = stateFlightId;
	}

	@JsonIgnore
	public Integer getDestinationId() {
		return destinationId;
	}

	@JsonProperty
	public void setDestinationId(Integer destinationId) {
		this.destinationId = destinationId;
	}

	public Location getDestination() {
	    return destination;
	}

	public void setDestination(Location destination) {this.destination = destination;}

	public void setStateFlight(StateFlight stateFlight) {
		this.stateFlight = stateFlight;
	}

	public StateFlight getStateFlight() {
		return stateFlight;
	}

	@JsonIgnore
	public Set<User> getUsers() {
		return users;
	}

	@JsonProperty
	public void setUsers(Set<User> users) {
		this.users = users;
	}
}
