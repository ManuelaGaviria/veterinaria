import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Medicamento {
    private Long id;
    private String nombre;
    private int cantidadStock;
    private double precio;
    private Date fechaVencimiento;

    private List<AplicacionMedicamento> aplicacionMedicamentos;

    public Medicamento(Long id, String nombre, int cantidadStock, double precio, Date fechaVencimiento) {
        this.id = id;
        this.nombre = nombre;
        this.cantidadStock = cantidadStock;
        this.precio = precio;
        this.fechaVencimiento = fechaVencimiento;
        this.aplicacionMedicamentos = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(int cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public List<AplicacionMedicamento> getAplicacionMedicamentos() {
        return aplicacionMedicamentos;
    }

    public void setAplicacionMedicamentos(List<AplicacionMedicamento> aplicacionMedicamentos) {
        this.aplicacionMedicamentos = aplicacionMedicamentos;
    }

    public boolean estaVencido() {
        return new Date().after(fechaVencimiento);
    }

    public void reducirStock(int cantidad) {
        if (cantidadStock < cantidad) {
            throw new IllegalStateException("No hay suficiente stock disponible.");
        }
        cantidadStock -= cantidad;
    }
}
