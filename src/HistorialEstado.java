import java.util.Date;

public class HistorialEstado {
    private Mascota mascota;
    private Estado estado;
    private Date fechaHora;
    private String comentario;
    private Empleado veterinario;

    public HistorialEstado(Mascota mascota, Estado estado, Date fechaHora, String comentario, Empleado veterinario) {
        this.mascota = mascota;
        this.estado = estado;
        this.fechaHora = fechaHora;
        this.comentario = comentario;
        this.veterinario = veterinario;
    }
}
