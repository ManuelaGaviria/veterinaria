import java.util.Date;

public class AplicacionMedicamento {
    private Long id;
    private Mascota mascota;
    private Medicamento medicamento;
    private Empleado veterinario;
    private Date fechaAplicacion;
    private String comentario;

    public AplicacionMedicamento(Long id, Mascota mascota, Medicamento medicamento, Empleado veterinario, Date fechaAplicacion, String comentario) {
        this.id = id;
        this.mascota = mascota;
        this.medicamento = medicamento;
        this.veterinario = veterinario;
        this.fechaAplicacion = fechaAplicacion;
        this.comentario = comentario;
    }
}
