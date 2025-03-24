import java.util.Date;

public class AplicacionMedicamento {
    private Long id;
    private Date fechaAplicacion;
    private String comentario;

    public AplicacionMedicamento(Long id, Date fechaAplicacion, String comentario) {
        this.id = id;
        this.fechaAplicacion = fechaAplicacion;
        this.comentario = comentario;
    }
}
