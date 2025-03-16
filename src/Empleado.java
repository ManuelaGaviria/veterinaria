public class Empleado {
    private Long id;
    private String nombre;
    private String rol;
    private String horario;

    public Empleado(Long id, String nombre, String rol, String horario) {
        this.id = id;
        this.nombre = nombre;
        this.rol = rol;
        this.horario = horario;
    }

    public boolean esVeterinario() {
        return "Veterinario".equalsIgnoreCase(rol);
    }

    public boolean esAdmin() {
        return "Admin".equalsIgnoreCase(rol);
    }
}
