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
                System.out.println("Inserire l' ISBN del libro");
                int ISBN = scanner.nextInt();
                System.out.println("Inserire il titolo del libro");
                String titolo = scanner.next();
                System.out.println("Inserire l'anno di pubblicazione del libro");
                int annoDiPubblicazione = scanner.nextInt();
                System.out.println("Inserire il numero di pagine del libro");
                int numeroPagine = scanner.nextInt();
                System.out.println("Inserire l'autore del libro");
                String autore = scanner.next();
                System.out.println("Inserire il genere del libro");
                String genere = scanner.next();
                Libri libro = new Libri(ISBN, titolo, annoDiPubblicazione, numeroPagine, autore, genere);
                libriList.add(libro);
                System.out.println("Libro aggiunto correttamente");
                break;
            case 2:
                System.out.println("Inserire i dati della rivista");
                System.out.println("Inserire l' ISBN della rivista");
                int ISBN2 = scanner.nextInt();
                System.out.println("Inserire il titolo della rivista");
                String titolo2 = scanner.next();
                System.out.println("Inserire l'anno di pubblicazione della rivista");
                int annoDiPubblicazione2 = scanner.nextInt();
                System.out.println("Inserire il numero di pagine della rivista");
                int numeroPagine2 = scanner.nextInt();
                System.out.println("Inserire la periodicità della rivista");
                System.out.println("1 - MENSILE");
                System.out.println("2 - SEMESTRALE");
                System.out.println("3 - SETTIMANALE");
                periodicita mensile;
                periodicita semestrale;
                periodicita settimanale;
                int sc = scanner.nextInt();
                Riviste rivista;
                switch (sc) {
                    case 1:
                        mensile = periodicita.MENSILE;
                        rivista = new Riviste(ISBN2, titolo2, annoDiPubblicazione2, numeroPagine2, mensile);
                        rivisteList.add(rivista);
                        break;
                    case 2:
                        semestrale = periodicita.SEMESTRALE;
                        rivista = new Riviste(ISBN2, titolo2, annoDiPubblicazione2, numeroPagine2, semestrale);
                        rivisteList.add(rivista);
                        break;
                    case 3:
                        settimanale = periodicita.SETTIMANALE;
                        rivista = new Riviste(ISBN2, titolo2, annoDiPubblicazione2, numeroPagine2, settimanale);
                        rivisteList.add(rivista);
                        break;
                    default:
                        System.out.println("Scelta non valida");
                        break;
                }
                System.out.println("Rivista aggiunta correttamente");
                break;
            case 3:
                System.out.println("Inserire l' ISBN del libro da visualizzare");
                int ISBN1 = scanner.nextInt();
                // Creando i libri in modo statico, il confronto è possibile solo con tre casi
                if (ISBN1 == l1.getISBN()) {
                    System.out.println(l1);
                }
                if (ISBN1 == l2.getISBN()) {
                    System.out.println(l2);
                }
                if (ISBN1 == l3.getISBN()) {
                    System.out.println(l3);
                }
                break;
            default:
                System.out.println("Scelta non valida");
                break;
        }
    }
}

