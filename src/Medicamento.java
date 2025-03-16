import java.util.Date;

public class Medicamento {
    private Long id;
    private String nombre;
    private int cantidadStock;
    private double precio;
    private Date fechaVencimiento;

    public Medicamento(Long id, String nombre, int cantidadStock, double precio, Date fechaVencimiento) {
        this.id = id;
        this.nombre = nombre;
        this.cantidadStock = cantidadStock;
        this.precio = precio;
        this.fechaVencimiento = fechaVencimiento;
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
