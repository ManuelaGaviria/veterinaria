import java.time.LocalDate;
import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(Main.class.getName());

        List<Cliente> clientes = Poblador.getClientes();
        List<Mascota> mascotas = Poblador.getMascotas();
        List<Medicamento> medicamentos = Poblador.getMedicamentos();
        List<Empleado> empleados = Poblador.getEmpleados();
        List<Estado> estados = Poblador.getEstados();
        List<HistorialEstado> historial = Poblador.getHistorialEstados(mascotas, empleados, estados);

        // Asociamos las mascotas a los clientes antes de imprimir
        Poblador.asociarMascotasAClientes(clientes, mascotas);

        List<AplicacionMedicamento> aplicaciones = Poblador.getAplicaciones();
        Poblador.asociarAplicaciones(aplicaciones, mascotas, medicamentos, empleados);




        // =====================================================
        // EJERCICIO 1
        /*
        Muestra cada cliente junto con el número de mascotas que posee,
        o incluso los nombres de sus mascotas. Basico
         */
        System.out.println("=====================================================");
        System.out.println("EJERCICIO 1");
        System.out.println("=====================================================");
        // Forma 1: Mostrar solo la cantidad de mascotas
        System.out.println("Clientes y número de mascotas:");
        clientes.stream().forEach(cliente -> {
            System.out.println(cliente.getNombre() + " tiene " +
                cliente.getMascotas().size() + " mascota(s).");
        });
        System.out.println("=====================================================");
        // Forma 2: Mostrar también los nombres de las mascotas
        System.out.println("\nClientes y nombres de sus mascotas:");
        clientes.stream().forEach(cliente -> {
            String nombresMascotas = cliente.getMascotas().stream()
                .map(Mascota::getNombre)
                .collect(Collectors.joining(", "));

            System.out.println(cliente.getNombre() + " tiene " +
                cliente.getMascotas().size() + " mascota(s): " + nombresMascotas);
        });

        // =====================================================
        // EJERCICIO 2
        /*
        Muestra todos los medicamentos, su cantidad en stock y destaca aquellos
        con stock bajo. Basico
         */
        System.out.println("=====================================================");
        System.out.println("EJERCICIO 2");
        System.out.println("=====================================================");

        System.out.println("Listado de medicamentos y su stock:\n");
        medicamentos.stream().forEach(med -> {
            String estadoStock = med.getCantidadStock() <= 20 ? "STOCK BAJO" : "";
            System.out.printf("• %s - %d unidades %s%n",
                med.getNombre(),
                med.getCantidadStock(),
                estadoStock);
        });

        // =====================================================
        // EJERCICIO 3
        /*
        Resume cuántas mascotas hay de cada especie (por ejemplo, “Eléctrico”, “Planta”,
        “Fuego”, “Agua”, etc.). Basico
         */
        System.out.println("=====================================================");
        System.out.println("EJERCICIO 3");
        System.out.println("=====================================================");
        System.out.println("Cantidad de mascotas por especie:\n");

        Map<String, Long> resumenPorEspecie = mascotas.stream()
            .collect(Collectors.groupingBy(
                Mascota::getEspecie,
                Collectors.counting()
            ));

        resumenPorEspecie.forEach((especie, cantidad) -> {
            System.out.println("• " + especie + ": " + cantidad);
        });

        // =====================================================
        // EJERCICIO 4
        /*
        Listar mascotas en estado "Crítico" ordenadas por fecha de registro. Basico
         */
        System.out.println("=====================================================");
        System.out.println("EJERCICIO 4");
        System.out.println("=====================================================");
        System.out.println("Mascotas en estado CRÍTICO ordenadas por fecha de cambio:\n");

        historial.stream()
            .filter(h -> h.getEstado().getNombre().equalsIgnoreCase("Crítico"))
            .sorted(Comparator.comparing(HistorialEstado::getFechaCambio)) // ascendente
            .forEach(h -> {
                System.out.printf("• %s (%s) - Fecha: %s%n",
                    h.getMascota().getNombre(),
                    h.getMascota().getEspecie(),
                    h.getFechaCambio());
            });

        // =====================================================
        // EJERCICIO 5
        /*
        Detalla cuántas aplicaciones de medicamentos ha realizado cada
        veterinario durante un período determinado. Esencial
         */
        System.out.println("=====================================================");
        System.out.println("EJERCICIO 5");
        System.out.println("=====================================================");
        // Rango de fechas
        LocalDate inicio = LocalDate.of(2023, 10, 1);
        LocalDate fin = LocalDate.of(2023, 12, 31);

        System.out.println("Aplicaciones realizadas por veterinarios entre "
                + inicio + " y " + fin + ":\n");
        Map<String, Long> aplicacionesPorVeterinario = aplicaciones.stream()
            .filter(app -> {
                Empleado emp = app.getEmpleado();
                return emp.getPuesto().equalsIgnoreCase("Veterinario")
                    && !app.getFechaAplicacion().isBefore(inicio)
                    && !app.getFechaAplicacion().isAfter(fin);
            })
            .collect(Collectors.groupingBy(
                app -> app.getEmpleado().getNombre(),
                Collectors.counting()
            ));

        aplicacionesPorVeterinario.forEach((nombre, cantidad) -> {
            System.out.println("• " + nombre + ": " + cantidad + " aplicación(es)");
        });

        // =====================================================
        // EJERCICIO 6
        /*
        Para una mascota seleccionada, muestra la evolución de sus estados. Esencial
         */
        System.out.println("=====================================================");
        System.out.println("EJERCICIO 6");
        System.out.println("=====================================================");
        // Paso 1: Mostrar lista de mascotas para elegir
        System.out.println("Mascotas disponibles:");
        mascotas.forEach(m -> System.out.println("• ID: " + m.getId() + " - " + m.getNombre()));

        // Paso 2: Pedir al usuario que seleccione una
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nIngrese el ID de la mascota para ver su historial de estados: ");
        long idSeleccionado = scanner.nextLong();

        // Paso 3: Buscar la mascota
        Mascota mascota = mascotas.stream()
            .filter(m -> m.getId() == idSeleccionado)
            .findFirst()
            .orElse(null);

        if (mascota == null) {
            System.out.println("Mascota no encontrada.");
            return;
        }

        // Paso 4: Filtrar y ordenar el historial de esa mascota
        List<HistorialEstado> historialMascota = historial.stream()
            .filter(h -> h.getMascota().equals(mascota))
            .sorted(Comparator.comparing(HistorialEstado::getFechaCambio))
            .collect(Collectors.toList());

        // Paso 5: Mostrar la evolución
        System.out.println("\nHistorial de estados para " + mascota.getNombre() + ":\n");
        historialMascota.forEach(h -> {
            System.out.printf("• %s - %s (Atendido por %s)%n",
                h.getFechaCambio(),
                h.getEstado().getNombre(),
                h.getVeterinario().getNombre());
        });

        // =====================================================
        // EJERCICIO 7
        /*
        Clientes con mas visitas medicas en el ultimo semestre. Esencial
         */
        System.out.println("=====================================================");
        System.out.println("EJERCICIO 7");
        System.out.println("=====================================================");
        // Paso 1: Calcular la fecha del semestre pasado
        LocalDate hoy = LocalDate.of(2023, 12, 31);
        LocalDate hace6Meses = hoy.minusMonths(6);

        // Paso 2: Mapa para buscar cliente por mascota
        Map<Mascota, Cliente> mapaMascotaCliente = new HashMap<>();
        for (Cliente cliente : clientes) {
            for (Mascota mascota2 : cliente.getMascotas()) {
                mapaMascotaCliente.put(mascota2, cliente);
            }
        }

        // Paso 3: Filtrar aplicaciones en el último semestre
        Map<String, Long> visitasPorCliente = aplicaciones.stream()
            .filter(app -> !app.getFechaAplicacion().isBefore(hace6Meses)) // después de hace 6 meses
            .map(app -> mapaMascotaCliente.get(app.getMascota()))         // obtener el cliente dueño de la mascota
            .filter(Objects::nonNull)
            .collect(Collectors.groupingBy(
                Cliente::getNombre,
                Collectors.counting()
            ));

        // Paso 4: Mostrar clientes con más visitas
        System.out.println("Clientes con más visitas médicas en los últimos 6 meses:\n");

        visitasPorCliente.entrySet().stream()
            .sorted(Map.Entry.<String, Long>comparingByValue().reversed()) // más visitas primero
            .forEach(entry -> {
                System.out.println("• " + entry.getKey() + ": " + entry.getValue() + " visita(s)");
            });

        // =====================================================
        // EJERCICIO 8
        /*
        Mascotas que requieren vacuna en el mes actual. Esencial
         */
        System.out.println("=====================================================");
        System.out.println("EJERCICIO 8");
        System.out.println("=====================================================");
        LocalDate hoy2 = LocalDate.now();
        int mesActual = hoy2.getMonthValue();
        int anioActual = hoy2.getYear();

        System.out.println("Mascotas que deben recibir vacunas este mes (" + hoy2.getMonth() + " " + anioActual + "):\n");

        aplicaciones.stream()
            .filter(app -> {
                Medicamento med = app.getMedicamento();
                LocalDate fecha = app.getFechaAplicacion();

                boolean esEsteMes = fecha.getMonthValue() == mesActual && fecha.getYear() == anioActual;
                boolean esVacuna = med.getNombre().toLowerCase().contains("vacuna");

                return esEsteMes && esVacuna;
            })
            .forEach(app -> {
                System.out.printf("• %s debe recibir %s el %s (Veterinario: %s)%n",
                    app.getMascota().getNombre(),
                    app.getMedicamento().getNombre(),
                    app.getFechaAplicacion(),
                    app.getEmpleado().getNombre());
            });

        // =====================================================
        // EJERCICIO 9
        /*
        Resumen del uso de cada medicamento, mostrando la cantidad de aplicaciones
        realizadas y, opcionalmente, el total de stock utilizado. Esencial
         */
        System.out.println("=====================================================");
        System.out.println("EJERCICIO 9");
        System.out.println("=====================================================");
        System.out.println("Resumen de uso de medicamentos:\n");

        Map<Medicamento, Long> usoPorMedicamento = aplicaciones.stream()
            .map(AplicacionMedicamento::getMedicamento)
            .filter(Objects::nonNull)
            .collect(Collectors.groupingBy(
                med -> med,
                Collectors.counting()
            ));

        usoPorMedicamento.entrySet().stream()
            .sorted(Map.Entry.<Medicamento, Long>comparingByValue().reversed())
            .forEach(entry -> {
                Medicamento med = entry.getKey();
                Long cantidadAplicaciones = entry.getValue();
                int stockEstimadoUsado = cantidadAplicaciones.intValue(); // 1 unidad por aplicación

                System.out.printf("• %s: %d aplicación(es), %d unidad(es) usadas (stock inicial: %d)%n",
                    med.getNombre(),
                    cantidadAplicaciones,
                    stockEstimadoUsado,
                    med.getCantidadStock());
            });

        // =====================================================
        // EJERCICIO 10
        /*
        Calcular el total de ventas diarias de medicamentos. Esencial
         */
        System.out.println("=====================================================");
        System.out.println("EJERCICIO 10");
        System.out.println("=====================================================");
        System.out.println("Total de ventas diarias de medicamentos:\n");

        // Agrupar por fecha y sumar los precios de los medicamentos aplicados ese día
        Map<LocalDate, Double> ventasPorDia = aplicaciones.stream()
            .filter(app -> app.getMedicamento() != null)
            .collect(Collectors.groupingBy(
                AplicacionMedicamento::getFechaAplicacion,  // agrupamos por fecha
                Collectors.summingDouble(app -> app.getMedicamento().getPrecio()) // sumamos precio por aplicación
            ));

        // Ordenar por fecha ascendente
        ventasPorDia.entrySet().stream()
            .sorted(Map.Entry.comparingByKey())
            .forEach(entry -> {
                LocalDate fecha = entry.getKey();
                Double total = entry.getValue();
                System.out.printf("• %s: $%.2f%n", fecha, total);
            });
    }
}