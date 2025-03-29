import java.util.ArrayList;
import java.util.List;

public class Estado {
    private Integer id;
    private String nombre;
    private List<HistorialEstado> historialEstados;

    public Estado() {
    }

    public Estado(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.historialEstados = new ArrayList<>();
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

    public List<HistorialEstado> getHistorialEstados() {
        return historialEstados;
    }

    public void setHistorialEstados(List<HistorialEstado> historialEstados) {
        this.historialEstados = historialEstados;
    }

    @Override
    public String toString() {
        return "Estado{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
