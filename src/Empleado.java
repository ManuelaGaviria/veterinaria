import java.util.ArrayList;
import java.util.List;

public class Empleado {
    private Integer id;
    private String nombre;
    private String puesto;
    private List<AplicacionMedicamento> aplicacionMedicamentos;
    private List<HistorialEstado> historialEstados;

    public Empleado(Integer id, String nombre, String puesto) {
        this.id = id;
        this.nombre = nombre;
        this.puesto = puesto;
        this.aplicacionMedicamentos = new ArrayList<>();
        this.historialEstados = new ArrayList<>();
    }

    public Empleado() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public List<AplicacionMedicamento> getAplicacionMedicamentos() {
        return aplicacionMedicamentos;
    }

    public void setAplicacionMedicamentos(List<AplicacionMedicamento> aplicacionMedicamentos) {
        this.aplicacionMedicamentos = aplicacionMedicamentos;
    }

    public List<HistorialEstado> getHistorialEstados() {
        return historialEstados;
    }

    public void setHistorialEstados(List<HistorialEstado> historialEstados) {
        this.historialEstados = historialEstados;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", puesto='" + puesto + '\'' +
                '}';
    }

    public boolean esVeterinario() {
        return "Veterinario".equalsIgnoreCase(puesto);
    }

    public boolean esAdmin() {
        return "Admin".equalsIgnoreCase(puesto);
    }
}
