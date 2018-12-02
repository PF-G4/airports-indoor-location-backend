package afinal.proyecto.cuatro.grupo.api;

import afinal.proyecto.cuatro.grupo.entities.Vuelo;

public class ResponseDemoraRecorrido {

    private Double demoraRecorrido;
    private Vuelo flight;

    public ResponseDemoraRecorrido() {

    }

    public ResponseDemoraRecorrido(Double demoraRecorrido, Vuelo flight) {
        this.demoraRecorrido = demoraRecorrido;
        this.flight = flight;
    }

    public Double getDemoraRecorrido() {
        return demoraRecorrido;
    }

    public void setDemoraRecorrido(Double demoraRecorrido) {
        this.demoraRecorrido = demoraRecorrido;
    }

    public Vuelo getFlight() {
        return flight;
    }

    public void setFlight(Vuelo flight) {
        this.flight = flight;
    }
}
