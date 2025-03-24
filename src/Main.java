import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Alt+Intro with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        Cliente Ash = new Cliente(1L, "Ash", "562526", "ash@gmail.com", "calle 10");
        Mascota Pikachu = new Mascota(1L, "Pikachu", "Electrico", LocalDate.of(2025,03,18));
        Mascota Bulbasaur = new Mascota(1L, "Bulbasaur", "Planta", LocalDate.of(2025,03,18));

        Ash.setMascotas(Pikachu);
        Ash.setMascotas(Bulbasaur);

        /*
        List<Mascota> listaMascotas = new ArrayList<>();
        listaMascotas.add(Pikachu);
        */

        System.out.println(Pikachu);
        /*
        System.out.println(Ash.getNombre() + " tiene las siguientes mascotitas: ");

        for (Mascota mascota : Ash.getMascotas()) {
            System.out.println(mascota.getNombre() + " " + mascota.getEspecie());
        }

         */

    }
}