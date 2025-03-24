import java.util.ArrayList;
import java.util.List;

public class Empleado {
    private Long id;
    private String nombre;
    private String rol;
    private String horario;
    private String especialidad;

    private List<AplicacionMedicamento> aplicacionMedicamentos;

    public Empleado(Long id, String nombre, String rol, String horario, String especialidad) {
        this.id = id;
        this.nombre = nombre;
        this.rol = rol;
        this.horario = horario;
        this.especialidad = especialidad;
        this.aplicacionMedicamentos = new ArrayList<>();
    }

    public boolean esVeterinario() {
        return "Veterinario".equalsIgnoreCase(rol);
    }

    public boolean esAdmin() {
        return "Admin".equalsIgnoreCase(rol);
    }
}
