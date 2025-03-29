import java.time.LocalDate;
import java.util.Date;

public class HistorialEstado {

    private Integer id;
    private LocalDate fechaCambio;
    private Mascota mascota;
    private Estado estado;
    private Empleado veterinario;

    public HistorialEstado() {
    }

    public HistorialEstado(Integer id, LocalDate fechaCambio, Mascota mascota, Estado estado, Empleado veterinario) {
        this.id = id;
        this.fechaCambio = fechaCambio;
        this.mascota = mascota;
        this.estado = estado;
        this.veterinario = veterinario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getFechaCambio() {
        return fechaCambio;
    }

    public void setFechaCambio(LocalDate fechaCambio) {
        this.fechaCambio = fechaCambio;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Empleado getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(Empleado veterinario) {
        this.veterinario = veterinario;
    }

    @Override
    public String toString() {
        return "HistorialEstado{" +
                "id=" + id +
                ", fechaCambio=" + fechaCambio +
                ", estado=" + estado +
                '}';
    }
}
