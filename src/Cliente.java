import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private Long id;
    private String nombre;
    private String telefono;
    private String email;
    private String direccion;
    private List<Mascota> mascotas;

    public Cliente(Long id, String nombre, String telefono, String email, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
        this.mascotas = new ArrayList<>();
    }

    public void registrarMascota(Mascota mascota) {
        if (mascotas.size() >= 5) {
            throw new IllegalStateException("Un cliente no puede tener más de 5 mascotas.");
        }
        mascotas.add(mascota);
    }

    public List<Mascota> obtenerMascotas() {
        return mascotas;
    }
}
