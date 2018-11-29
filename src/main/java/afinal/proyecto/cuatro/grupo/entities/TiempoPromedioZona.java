package afinal.proyecto.cuatro.grupo.entities;

import javax.persistence.*;

@Entity
@Table(name = "tiempo_prom_zona")
public class TiempoPromedioZona {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
