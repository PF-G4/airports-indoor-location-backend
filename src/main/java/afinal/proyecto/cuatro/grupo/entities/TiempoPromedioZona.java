package afinal.proyecto.cuatro.grupo.entities;

import javax.persistence.*;

@Entity
@Table(name = "tiempo_prom_zona")
public class TiempoPromedioZona {

    @Id
    @Column
    private String zona;

    @Column
    private Double tiempoProm;

    public TiempoPromedioZona() {

    }

    public TiempoPromedioZona(String zona, Double tiempoProm) {
        this.zona = zona;
        this.tiempoProm = tiempoProm;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public Double getTiempoProm() {
        return tiempoProm;
    }

    public void setTiempoProm(Double tiempoProm) {
        this.tiempoProm = tiempoProm;
    }
}
