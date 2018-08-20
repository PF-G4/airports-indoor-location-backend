package afinal.proyecto.cuatro.grupo.entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

	@NotNull
	@Column(columnDefinition = "INT(11) default '1'")
	private Integer stateFlightId;

	@NotNull
    @Column(columnDefinition = "INT(11) default '1'")
	private Integer destinationId;

	@Transient
	private StateFlight stateFlight;

	@Transient
	private Location destination;

    public Vuelo() {
    }

	public Vuelo(String number, Date boardingDateTime, Integer boardingGate, Integer stateFlightId) {
		this.number = number;
		this.boardingDateTime = boardingDateTime;
		this.boardingGate = boardingGate;
		this.stateFlightId = stateFlightId;
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
	public void setStateFlightId(Integer stateFlightId) {
		this.stateFlightId = stateFlightId;
	}

	public StateFlight getStateFlight() {return stateFlight;}
	public void setStateFlight(StateFlight stateFlight) {this.stateFlight = stateFlight;}

    @JsonIgnore
	public Integer getDestinationId() {
		return destinationId;
	}
	public void setDestinationId(Integer destinationId) {
		this.destinationId = destinationId;
	}

	public Location getDestination() {return destination;}
	public void setDestination(Location destination) {this.destination = destination;}
}
