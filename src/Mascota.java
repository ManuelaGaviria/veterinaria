import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Mascota {
    private Long id;
    private String nombre;
    private String especie;
    private int edad;
    private String historialMedico;
    private Cliente dueno;
    private List<HistorialEstado> historialEstados;

    public Mascota(Long id, String nombre, String especie, int edad, Cliente dueno) {
        this.id = id;
        this.nombre = nombre;
        this.especie = especie;
        this.edad = edad;
        this.dueno = dueno;
        this.historialEstados = new ArrayList<>();
    }

    public void actualizarEstado(Estado nuevoEstado, Empleado veterinario) {
        historialEstados.add(new HistorialEstado(this, nuevoEstado, new Date(), "Cambio de estado", veterinario));
    }

    public List<HistorialEstado> obtenerHistorial() {
        return historialEstados;
    }
}
