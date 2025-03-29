import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Poblador {

    public static List<Cliente> getClientes() {
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente(1, "Ash Ketchum", "Pallet Town", "ash@pokemon.com", "123456789"));
        clientes.add(new Cliente(2, "Misty", "Cerulean City", "misty@pokemon.com", "987654321"));
        clientes.add(new Cliente(3, "Brock", "Pewter City", "brock@pokemon.com", "456789123"));
        clientes.add(new Cliente(4, "Jessie", "Team Rocket HQ", "jessie@pokemon.com", "789123456"));
        clientes.add(new Cliente(5, "James", "Team Rocket HQ", "james@pokemon.com", "321654987"));
        clientes.add(new Cliente(6, "Gary Oak", "Pallet Town", "gary@pokemon.com", "112233445"));
        clientes.add(new Cliente(7, "Tracey Sketchit", "Orange Islands", "tracey@pokemon.com", "556677889"));
        clientes.add(new Cliente(8, "Nurse Joy", "Pokémon Center", "joy@pokemon.com", "999888777"));
        clientes.add(new Cliente(9, "Officer Jenny", "Viridian City", "jenny@pokemon.com", "101010101"));
        clientes.add(new Cliente(10, "Professor Oak", "Pallet Town", "oak@pokemon.com", "202020202"));

        return clientes;
    }

    public static List<Mascota> getMascotas() {
        List<Mascota> mascotas = new ArrayList<>();

        mascotas.add(new Mascota(1, "Pikachu", "Electric", LocalDate.of(2020, 5, 15)));
        mascotas.add(new Mascota(2, "Charizard", "Fire/Flying", LocalDate.of(2019, 8, 20)));
        mascotas.add(new Mascota(3, "Bulbasaur", "Grass/Poison", LocalDate.of(2021, 3, 10)));
        mascotas.add(new Mascota(4, "Starmie", "Water/Psychic", LocalDate.of(2020, 7, 5)));
        mascotas.add(new Mascota(5, "Psyduck", "Water", LocalDate.of(2022, 1, 12)));
        mascotas.add(new Mascota(6, "Golduck", "Water", LocalDate.of(2021, 9, 30)));
        mascotas.add(new Mascota(7, "Onix", "Rock/Ground", LocalDate.of(2018, 11, 18)));
        mascotas.add(new Mascota(8, "Geodude", "Rock/Ground", LocalDate.of(2023, 4, 22)));
        mascotas.add(new Mascota(9, "Meowth", "Normal", LocalDate.of(2022, 6, 14)));
        mascotas.add(new Mascota(10, "Arbok", "Poison", LocalDate.of(2020, 12, 1)));
        mascotas.add(new Mascota(11, "Growlie", "Poison", LocalDate.of(2021, 2, 8)));
        mascotas.add(new Mascota(12, "Weezing", "Poison", LocalDate.of(2019, 5, 25)));
        mascotas.add(new Mascota(13, "Eevee", "Normal", LocalDate.of(2023, 8, 17)));
        mascotas.add(new Mascota(14, "Marill", "Water/Fairy", LocalDate.of(2022, 11, 3)));

        return mascotas;
    }


    public static void asociarMascotasAClientes(List<Cliente> clientes, List<Mascota> mascotas) {
        // Utilidad para buscar cliente por nombre
        Map<String, Cliente> clienteMap = clientes.stream()
                .collect(Collectors.toMap(Cliente::getNombre, c -> c));

        try {
            // Ash
            clienteMap.get("Ash Ketchum").registrarMascota(mascotas.get(0)); // Pikachu
            clienteMap.get("Ash Ketchum").registrarMascota(mascotas.get(1)); // Charizard
            clienteMap.get("Ash Ketchum").registrarMascota(mascotas.get(2)); // Bulbasaur

            // Misty
            clienteMap.get("Misty").registrarMascota(mascotas.get(3)); // Starmie
            clienteMap.get("Misty").registrarMascota(mascotas.get(4)); // Psyduck
            clienteMap.get("Misty").registrarMascota(mascotas.get(5)); // Golduck

            // Brock
            clienteMap.get("Brock").registrarMascota(mascotas.get(6)); // Onix
            clienteMap.get("Brock").registrarMascota(mascotas.get(7)); // Geodude

            // Jessie
            clienteMap.get("Jessie").registrarMascota(mascotas.get(8)); // Meowth
            clienteMap.get("Jessie").registrarMascota(mascotas.get(9)); // Arbok

            // James
            clienteMap.get("James").registrarMascota(mascotas.get(10)); // Growlie
            clienteMap.get("James").registrarMascota(mascotas.get(11)); // Weezing

            // Gary
            clienteMap.get("Gary Oak").registrarMascota(mascotas.get(12)); // Eevee

            // Tracey
            clienteMap.get("Tracey Sketchit").registrarMascota(mascotas.get(13)); // Marill

        } catch (IllegalStateException e) {
            System.err.println("Error al registrar mascota: " + e.getMessage());
        }
    }

    public static List<Medicamento> getMedicamentos() {
        List<Medicamento> medicamentos = new ArrayList<>();

        medicamentos.add(new Medicamento(1, "Antibiótico", 50, 12.5, LocalDate.of(2024, 5, 20)));
        medicamentos.add(new Medicamento(2, "Vacuna Rabia", 30, 25.0, LocalDate.of(2025, 3, 15)));
        medicamentos.add(new Medicamento(3, "Desparasitante", 100, 8.0, LocalDate.of(2023, 12, 31)));
        medicamentos.add(new Medicamento(4, "Antiinflamatorio", 45, 18.75, LocalDate.of(2024, 8, 10)));
        medicamentos.add(new Medicamento(5, "Analgesico", 70, 9.99, LocalDate.of(2024, 9, 5)));
        medicamentos.add(new Medicamento(6, "Vitaminas", 200, 4.50, LocalDate.of(2025, 1, 1)));
        medicamentos.add(new Medicamento(7, "Suero", 25, 30.0, LocalDate.of(2024, 7, 22)));
        medicamentos.add(new Medicamento(8, "Pomada Antifúngica", 60, 15.20, LocalDate.of(2024, 11, 30)));
        medicamentos.add(new Medicamento(9, "Antiparasitario", 80, 10.0, LocalDate.of(2024, 12, 15)));
        medicamentos.add(new Medicamento(10, "Sedante", 15, 45.0, LocalDate.of(2024, 10, 10)));

        return medicamentos;
    }

    public static List<Empleado> getEmpleados() {
        List<Empleado> empleados = new ArrayList<>();

        empleados.add(new Empleado(1, "Juan Pérez", "Veterinario"));
        empleados.add(new Empleado(2, "Ana Gómez", "Asistente"));
        empleados.add(new Empleado(3, "Carlos Ruiz", "Farmacéutico"));
        empleados.add(new Empleado(4, "María López", "Recepcionista"));
        empleados.add(new Empleado(5, "Luis Fernández", "Veterinario"));
        empleados.add(new Empleado(6, "Sofía Martínez", "Técnico de Laboratorio"));

        return empleados;
    }

    public static List<Estado> getEstados() {
        List<Estado> estados = new ArrayList<>();

        estados.add(new Estado(1, "En tratamiento"));
        estados.add(new Estado(2, "Recuperado"));
        estados.add(new Estado(3, "Pendiente"));
        estados.add(new Estado(4, "En observación"));
        estados.add(new Estado(5, "Crítico"));
        estados.add(new Estado(6, "Alta"));
        estados.add(new Estado(7, "Cirugía programada"));

        return estados;
    }

    public static List<AplicacionMedicamento> getAplicaciones() {
        List<AplicacionMedicamento> aplicaciones = new ArrayList<>();

        aplicaciones.add(new AplicacionMedicamento(1, "Primera dosis", LocalDate.of(2023, 10, 1)));
        aplicaciones.add(new AplicacionMedicamento(2, "Vacuna anual", LocalDate.of(2023, 11, 15)));
        aplicaciones.add(new AplicacionMedicamento(3, "Desparasitación mensual", LocalDate.of(2023, 12, 1)));
        aplicaciones.add(new AplicacionMedicamento(4, "Antiinflamatorio post-cirugía", LocalDate.of(2023, 9, 20)));
        aplicaciones.add(new AplicacionMedicamento(5, "Vitaminas para pelaje", LocalDate.of(2023, 10, 10)));
        aplicaciones.add(new AplicacionMedicamento(6, "Suero para deshidratación", LocalDate.of(2023, 11, 5)));
        aplicaciones.add(new AplicacionMedicamento(7, "Pomada para hongos", LocalDate.of(2023, 12, 10)));
        aplicaciones.add(new AplicacionMedicamento(8, "Antiparasitario mensual", LocalDate.of(2023, 9, 30)));
        aplicaciones.add(new AplicacionMedicamento(9, "Sedante para viaje", LocalDate.of(2023, 10, 15)));
        aplicaciones.add(new AplicacionMedicamento(10, "Vacuna anual", LocalDate.of(2023, 11, 30)));
        aplicaciones.add(new AplicacionMedicamento(11, "Vitaminas para pelaje", LocalDate.of(2023, 12, 5)));
        aplicaciones.add(new AplicacionMedicamento(12, "Suero para deshidratación", LocalDate.of(2023, 9, 25)));
        aplicaciones.add(new AplicacionMedicamento(13, "Pomada para hongos", LocalDate.of(2023, 10, 5)));
        aplicaciones.add(new AplicacionMedicamento(14, "Antiparasitario mensual", LocalDate.of(2023, 11, 10)));
        aplicaciones.add(new AplicacionMedicamento(15, "Sedante para viaje", LocalDate.of(2023, 12, 15)));
        aplicaciones.add(new AplicacionMedicamento(16, "Vacuna anual", LocalDate.of(2023, 9, 20)));
        aplicaciones.add(new AplicacionMedicamento(17, "Vitaminas para pelaje", LocalDate.of(2023, 10, 25)));
        aplicaciones.add(new AplicacionMedicamento(18, "Suero para deshidratación", LocalDate.of(2023, 11, 10)));
        aplicaciones.add(new AplicacionMedicamento(19, "Pomada para hongos", LocalDate.of(2023, 12, 15)));
        aplicaciones.add(new AplicacionMedicamento(20, "Antiparasitario mensual", LocalDate.of(2023, 9, 30)));
        aplicaciones.add(new AplicacionMedicamento(21, "Vacuna mensual", LocalDate.of(2025, 3, 28))); // NUEVA

        return aplicaciones;
    }

    public static void asociarAplicaciones(
            List<AplicacionMedicamento> aplicaciones,
            List<Mascota> mascotas,
            List<Medicamento> medicamentos,
            List<Empleado> empleados) {

        // Asignación directa por índice
        aplicaciones.get(0).setMedicamento(medicamentos.get(0));  // antibiotico
        aplicaciones.get(0).setMascota(mascotas.get(0));          // pikachu
        aplicaciones.get(0).setEmpleado(empleados.get(0));        // juan

        aplicaciones.get(1).setMedicamento(medicamentos.get(1));  // vacunaRabia
        aplicaciones.get(1).setMascota(mascotas.get(3));          // starmie
        aplicaciones.get(1).setEmpleado(empleados.get(1));        // ana

        aplicaciones.get(2).setMedicamento(medicamentos.get(2));  // desparasitante
        aplicaciones.get(2).setMascota(mascotas.get(2));          // bulbasaur
        aplicaciones.get(2).setEmpleado(empleados.get(4));        // luis

        aplicaciones.get(3).setMedicamento(medicamentos.get(3));  // antiinflamatorio
        aplicaciones.get(3).setMascota(mascotas.get(1));          // charizard
        aplicaciones.get(3).setEmpleado(empleados.get(0));        // juan

        aplicaciones.get(4).setMedicamento(medicamentos.get(5));  // vitaminas
        aplicaciones.get(4).setMascota(mascotas.get(4));          // psyduck
        aplicaciones.get(4).setEmpleado(empleados.get(1));        // ana

        aplicaciones.get(5).setMedicamento(medicamentos.get(6));  // suero
        aplicaciones.get(5).setMascota(mascotas.get(5));          // golduck
        aplicaciones.get(5).setEmpleado(empleados.get(4));        // luis

        aplicaciones.get(6).setMedicamento(medicamentos.get(7));  // pomada
        aplicaciones.get(6).setMascota(mascotas.get(6));          // onix
        aplicaciones.get(6).setEmpleado(empleados.get(1));        // ana

        aplicaciones.get(7).setMedicamento(medicamentos.get(8));  // antiparasitario
        aplicaciones.get(7).setMascota(mascotas.get(7));          // geodude
        aplicaciones.get(7).setEmpleado(empleados.get(0));        // juan

        aplicaciones.get(8).setMedicamento(medicamentos.get(9));  // sedante
        aplicaciones.get(8).setMascota(mascotas.get(8));          // meowth
        aplicaciones.get(8).setEmpleado(empleados.get(1));        // ana

        aplicaciones.get(9).setMedicamento(medicamentos.get(1));  // vacunaRabia
        aplicaciones.get(9).setMascota(mascotas.get(9));          // arbok
        aplicaciones.get(9).setEmpleado(empleados.get(4));        // luis

        aplicaciones.get(10).setMedicamento(medicamentos.get(5)); // vitaminas
        aplicaciones.get(10).setMascota(mascotas.get(10));        // growlie
        aplicaciones.get(10).setEmpleado(empleados.get(1));       // ana

        aplicaciones.get(11).setMedicamento(medicamentos.get(6)); // suero
        aplicaciones.get(11).setMascota(mascotas.get(11));        // weezing
        aplicaciones.get(11).setEmpleado(empleados.get(0));       // juan

        aplicaciones.get(12).setMedicamento(medicamentos.get(7)); // pomada
        aplicaciones.get(12).setMascota(mascotas.get(12));        // eevee
        aplicaciones.get(12).setEmpleado(empleados.get(1));       // ana

        aplicaciones.get(13).setMedicamento(medicamentos.get(8)); // antiparasitario
        aplicaciones.get(13).setMascota(mascotas.get(13));        // marill
        aplicaciones.get(13).setEmpleado(empleados.get(4));       // luis

        aplicaciones.get(14).setMedicamento(medicamentos.get(9)); // sedante
        aplicaciones.get(14).setMascota(mascotas.get(0));         // pikachu
        aplicaciones.get(14).setEmpleado(empleados.get(1));       // ana

        aplicaciones.get(15).setMedicamento(medicamentos.get(1)); // vacunaRabia
        aplicaciones.get(15).setMascota(mascotas.get(3));         // starmie
        aplicaciones.get(15).setEmpleado(empleados.get(4));       // luis

        aplicaciones.get(16).setMedicamento(medicamentos.get(5)); // vitaminas
        aplicaciones.get(16).setMascota(mascotas.get(4));         // psyduck
        aplicaciones.get(16).setEmpleado(empleados.get(1));       // ana

        aplicaciones.get(17).setMedicamento(medicamentos.get(6)); // suero
        aplicaciones.get(17).setMascota(mascotas.get(5));         // golduck
        aplicaciones.get(17).setEmpleado(empleados.get(0));       // juan

        aplicaciones.get(18).setMedicamento(medicamentos.get(7)); // pomada
        aplicaciones.get(18).setMascota(mascotas.get(6));         // onix
        aplicaciones.get(18).setEmpleado(empleados.get(1));       // ana

        aplicaciones.get(19).setMedicamento(medicamentos.get(8)); // antiparasitario
        aplicaciones.get(19).setMascota(mascotas.get(7));         // geodude
        aplicaciones.get(19).setEmpleado(empleados.get(4));       // luis

        aplicaciones.get(20).setMedicamento(medicamentos.get(1)); // Vacuna Rabia
        aplicaciones.get(20).setMascota(mascotas.get(4));         // Psyduck
        aplicaciones.get(20).setEmpleado(empleados.get(0));       // Juan

    }

    public static List<HistorialEstado> getHistorialEstados(
            List<Mascota> mascotas,
            List<Empleado> empleados,
            List<Estado> estados
    ) {
        // Deben estar en el mismo orden que fueron definidos
        Mascota pikachu = mascotas.get(0);
        Mascota starmie = mascotas.get(3);
        Mascota charizard = mascotas.get(1);
        Mascota bulbasaur = mascotas.get(2);
        Mascota psyduck = mascotas.get(4);
        Mascota golduck = mascotas.get(5);
        Mascota onix = mascotas.get(6);
        Mascota geodude = mascotas.get(7);
        Mascota meowth = mascotas.get(8);
        Mascota arbok = mascotas.get(9);
        Mascota growlie = mascotas.get(10);
        Mascota weezing = mascotas.get(11);
        Mascota eevee = mascotas.get(12);
        Mascota marill = mascotas.get(13);

        Empleado juan = empleados.get(0);
        Empleado ana = empleados.get(1);
        Empleado luis = empleados.get(4);

        Estado enTratamiento = estados.get(0);
        Estado recuperado = estados.get(1);
        Estado pendiente = estados.get(2);
        Estado enObservacion = estados.get(3);
        Estado critico = estados.get(4);
        Estado alta = estados.get(5);

        List<HistorialEstado> historialEstados = new ArrayList<>();
        historialEstados.add(new HistorialEstado(1, LocalDate.of(2023, 10, 2), pikachu, enTratamiento, juan));
        historialEstados.add(new HistorialEstado(2, LocalDate.of(2023, 11, 16), starmie, recuperado, ana));
        historialEstados.add(new HistorialEstado(3, LocalDate.of(2023, 12, 2), charizard, alta, luis));
        historialEstados.add(new HistorialEstado(4, LocalDate.of(2023, 9, 25), bulbasaur, enObservacion, juan));
        historialEstados.add(new HistorialEstado(5, LocalDate.of(2023, 10, 5), psyduck, pendiente, ana));
        historialEstados.add(new HistorialEstado(6, LocalDate.of(2023, 11, 20), golduck, enTratamiento, juan));
        historialEstados.add(new HistorialEstado(7, LocalDate.of(2023, 12, 5), onix, enTratamiento, ana));
        historialEstados.add(new HistorialEstado(8, LocalDate.of(2023, 9, 30), geodude, enTratamiento, luis));
        historialEstados.add(new HistorialEstado(9, LocalDate.of(2023, 10, 15), meowth, enTratamiento, juan));
        historialEstados.add(new HistorialEstado(10, LocalDate.of(2023, 11, 30), arbok, enTratamiento, ana));
        historialEstados.add(new HistorialEstado(11, LocalDate.of(2023, 12, 5), growlie, enTratamiento, luis));
        historialEstados.add(new HistorialEstado(12, LocalDate.of(2023, 9, 25), weezing, enTratamiento, juan));
        historialEstados.add(new HistorialEstado(13, LocalDate.of(2023, 10, 5), eevee, enTratamiento, ana));
        historialEstados.add(new HistorialEstado(14, LocalDate.of(2023, 11, 10), marill, enTratamiento, luis));
        historialEstados.add(new HistorialEstado(15, LocalDate.of(2023, 12, 15), pikachu, enTratamiento, juan));
        historialEstados.add(new HistorialEstado(16, LocalDate.of(2023, 11, 25), charizard, critico, juan));
        historialEstados.add(new HistorialEstado(17, LocalDate.of(2023, 12, 10), arbok, critico, ana));
        historialEstados.add(new HistorialEstado(18, LocalDate.of(2023, 12, 20), marill, critico, luis));

        return historialEstados;
    }

}
