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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(Mascota mascota) {
        this.mascotas.add(mascota);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + this.id +
                ", nombre='" + this.nombre + '\'' +
                ", telefono='" + this.telefono + '\'' +
                ", email='" + this.email + '\'' +
                ", direccion='" + this.direccion + '\'' +
                ", mascotas=" + this.mascotas +
                '}';
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
