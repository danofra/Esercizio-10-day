package dano_fra;

import com.github.javafaker.Faker;
import dano_fra.entities.Libri;
import dano_fra.entities.Riviste;
import dano_fra.entities.periodicita;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Random random = new Random();
        //LIBRI
        List<Libri> libriList = new ArrayList<>();
        Faker faker = new Faker();
        Libri l1 = new Libri(1234567891, faker.book().title(), random.nextInt(2000, 2024), random.nextInt(50, 500), faker.book().author(), faker.book().genre());
        Libri l2 = new Libri(1234567892, faker.book().title(), random.nextInt(2000, 2024), random.nextInt(50, 500), faker.book().author(), faker.book().genre());
        Libri l3 = new Libri(1234567893, faker.book().title(), random.nextInt(2000, 2024), random.nextInt(50, 500), faker.book().author(), faker.book().genre());
        libriList.add(l1);
        libriList.add(l2);
        libriList.add(l3);
        //RIVISTE
        List<Riviste> rivisteList = new ArrayList<>();
        Riviste r1 = new Riviste(1234567891, faker.book().title(), random.nextInt(2000, 2024), random.nextInt(50, 500), periodicita.MENSILE);
        Riviste r2 = new Riviste(1234567892, faker.book().title(), random.nextInt(2000, 2024), random.nextInt(50, 500), periodicita.SEMESTRALE);
        Riviste r3 = new Riviste(1234567893, faker.book().title(), random.nextInt(2000, 2024), random.nextInt(50, 500), periodicita.SETTIMANALE);
        rivisteList.add(r1);
        rivisteList.add(r2);
        rivisteList.add(r3);
        // Scanner per la scelta dell'utente
        Scanner scanner = new Scanner(System.in);
        System.out.println("Benvenuti nel nostro store di libri e riviste!");
        System.out.println("-----------------------------------------");
        System.out.println("Scegliere la tua opzione:");
        System.out.println("1. Inserisci un nuovo libro");
        System.out.println("2. Inserisci una nuova rivista");
        System.out.println("3. Visualizza un libro");
        System.out.println("4. Visualizza una rivista");
        System.out.println("5. Visualizza tutti i libri");
        System.out.println("6. Visualizza tutte le riviste");
        System.out.println("7. Esci");
        System.out.println("-----------------------------------------");
        int scelta = scanner.nextInt();
        switch (scelta) {
            case 1:
                System.out.println("Inserire i dati del libro");
                Libri libro = new Libri(scanner.nextInt(), scanner.next(), scanner.nextInt(), scanner.nextInt(), scanner.next(), scanner.next());
                libriList.add(libro);
                System.out.println("Libro aggiunto correttamente");
                break;
            case 2:
                System.out.println("Inserire i dati della rivista");
                Riviste rivista = new Riviste(scanner.nextInt(), scanner.next(), scanner.nextInt(), scanner.nextInt(), periodicita.valueOf(scanner.next()));
                rivisteList.add(rivista);
                System.out.println("Rivista aggiunta correttamente");
                break;
            case 3:
                System.out.println("Inserire l' ISBN del libro da visualizzare");
                int ISBN = scanner.nextInt();
                if (ISBN == l1.getISBN()) {
                    System.out.println(l1);
                }
                break;
            default:
                System.out.println("Scelta non valida");
                break;
        }
    }
}

