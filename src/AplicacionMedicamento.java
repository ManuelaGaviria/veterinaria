import java.time.LocalDate;
import java.util.Date;

public class AplicacionMedicamento {
    private Integer id;
    private String comentario;
    private LocalDate fechaAplicacion;
    private Medicamento medicamento;
    private Mascota mascota;
    private Empleado empleado;

    public AplicacionMedicamento(Integer id, String comentario, LocalDate fechaAplicacion) {
        this.id = id;
        this.comentario = comentario;
        this.fechaAplicacion = fechaAplicacion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public LocalDate getFechaAplicacion() {
        return fechaAplicacion;
    }

    public void setFechaAplicacion(LocalDate fechaAplicacion) {
        this.fechaAplicacion = fechaAplicacion;
    }

    public Medicamento getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    @Override
    public String toString() {
        return "AplicacionMedicamento{" +
                "id=" + id +
                ", comentario='" + comentario + '\'' +
                ", fechaAplicacion=" + fechaAplicacion +
                '}';
    }
}
