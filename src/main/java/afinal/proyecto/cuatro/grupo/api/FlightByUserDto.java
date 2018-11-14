package afinal.proyecto.cuatro.grupo.api;

import afinal.proyecto.cuatro.grupo.entities.Vuelo;

import java.util.Set;

public class FlightByUserDto {

    private String email;
    private Set<Vuelo> flights;


    public FlightByUserDto() {

    }

    public FlightByUserDto(String email, Set<Vuelo> flights) {
        this.email = email;
        this.flights = flights;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Vuelo> getFlights() {
        return flights;
    }

    public void setFlights(Set<Vuelo> flights) {
        this.flights = flights;
    }
}
