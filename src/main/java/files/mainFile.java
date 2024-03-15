package files;

import com.github.javafaker.Faker;
import dano_fra.entities.Libri;
import dano_fra.entities.Riviste;
import dano_fra.entities.periodicita;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class mainFile {
    public static void main(String[] args) {
        Random random = new Random();
        Faker faker1 = new Faker();
        periodicita[] values = periodicita.values();
        // Limito gli autori per fai vedere che la ricerca per autore funzioni e dia come risultato più di un libro per autore
        List<String> autoriList = new ArrayList<>();
        autoriList.add(faker1.book().author());
        autoriList.add(faker1.book().author());
        autoriList.add(faker1.book().author());
        autoriList.add(faker1.book().author());
        Supplier<Libri> randomLibri = () -> new Libri(random.nextInt(1, 2000000000), faker1.book().title(), random.nextInt(1900, 2024), random.nextInt(50, 500), autoriList.get(random.nextInt(0, autoriList.size())), faker1.book().genre());
        Supplier<Riviste> randomRiviste = () -> new Riviste(random.nextInt(1, 2000000000), faker1.book().title(), random.nextInt(1900, 2024), random.nextInt(50, 500), values[random.nextInt(0, values.length)]);
        //LIBRI RANDOM
        List<Libri> libriList = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            libriList.add(randomLibri.get());
        }
        libriList.forEach(System.out::println);
        //RIVISTE RANDOM
        List<Riviste> rivisteList = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            rivisteList.add(randomRiviste.get());
        }
        rivisteList.forEach(System.out::println);
        File libri = new File("src/main/java/files/libri.txt");
        File riviste = new File("src/main/java/files/riviste.txt");
        System.out.println(libri.exists());
        System.out.println(riviste.exists());
        try {
            FileUtils.writeStringToFile(libri, libriList + System.lineSeparator(), StandardCharsets.UTF_8, true);
            FileUtils.writeStringToFile(riviste, rivisteList + System.lineSeparator(), StandardCharsets.UTF_8, true);
            System.out.println("Scritto!");
            String contenutoLibro = FileUtils.readFileToString(libri, StandardCharsets.UTF_8);
            String contenutoRiviste = FileUtils.readFileToString(libri, StandardCharsets.UTF_8);
            System.out.println("CONTENUTO FILE");
            System.out.println(contenutoLibro);
            System.out.println(contenutoRiviste);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}