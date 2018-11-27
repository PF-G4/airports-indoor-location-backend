package afinal.proyecto.cuatro.grupo.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "duracion_estadia")
public class DuracionEstadia {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String zone;

    @NotNull
    private Double duracionEstadia;

    public DuracionEstadia() {

    }

    public DuracionEstadia(String zone, Double duracionEstadia) {
        this.zone = zone;
        this.duracionEstadia = duracionEstadia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public Double getDuracionEstadia() {
        return duracionEstadia;
    }

    public void setDuracionEstadia(Double duracionEstadia) {
        this.duracionEstadia = duracionEstadia;
    }
}
