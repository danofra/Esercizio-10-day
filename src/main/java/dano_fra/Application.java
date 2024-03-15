package dano_fra;

import com.github.javafaker.Faker;
import dano_fra.entities.Libri;
import dano_fra.entities.Riviste;
import dano_fra.entities.periodicita;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Application {

    public static void main(String[] args) {
        Random random = new Random();
        //LIBRI
        List<Libri> libriList = new ArrayList<>();
        Faker faker = new Faker();
        Libri l1 = new Libri(1234567891, faker.book().title(), random.nextInt(1900, 2024), random.nextInt(50, 500), faker.book().author(), faker.book().genre());
        Libri l2 = new Libri(1234567892, faker.book().title(), random.nextInt(1900, 2024), random.nextInt(50, 500), faker.book().author(), faker.book().genre());
        Libri l3 = new Libri(1234567893, faker.book().title(), random.nextInt(1900, 2024), random.nextInt(50, 500), faker.book().author(), faker.book().genre());
        libriList.add(l1);
        libriList.add(l2);
        libriList.add(l3);
        libriList.forEach(System.out::println);
        //RIVISTE
        List<Riviste> rivisteList = new ArrayList<>();
        Riviste r1 = new Riviste(1234567894, faker.book().title(), random.nextInt(1900, 2024), random.nextInt(50, 500), periodicita.MENSILE);
        Riviste r2 = new Riviste(1234567895, faker.book().title(), random.nextInt(1900, 2024), random.nextInt(50, 500), periodicita.SEMESTRALE);
        Riviste r3 = new Riviste(1234567896, faker.book().title(), random.nextInt(1900, 2024), random.nextInt(50, 500), periodicita.SETTIMANALE);
        rivisteList.add(r1);
        rivisteList.add(r2);
        rivisteList.add(r3);
        rivisteList.forEach(System.out::println);
        // Scanner per la scelta dell'utente
        Scanner scanner = new Scanner(System.in);
        System.out.println("Benvenuti nel nostro store di libri e riviste!");
        System.out.println("-----------------------------------------");
        System.out.println("Scegliere la tua opzione: cosa vuoi visualizzare?");
        System.out.println("1. Libro");
        System.out.println("2. Rivista");
        System.out.println("3. Esci");
        int scelta = scanner.nextInt();
        switch (scelta) {
            case 1:
                System.out.println("1. Inserisci un nuovo libro");
                System.out.println("2. Visualizza un libro");
                System.out.println("3. Visualizza i libri per anno di pubblicazione");
                System.out.println("4. Visualizza i libri per autore");
                System.out.println("5. Esci");
                System.out.println("-----------------------------------------");
                int scelta1 = scanner.nextInt();
                switch (scelta1) {
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
                        System.out.println("Inserire l' ISBN del libro da visualizzare");
                        int ISBN3 = scanner.nextInt();
                        for (Libri libro1 : libriList) {
                            if ((libro1.getISBN()) == ISBN3) {
                                System.out.println(libro1);
                                break;
                            }
                        }
                        break;
                    case 3:
                        System.out.println("Inserire l'anno di pubblicazione dei libri da visualizzare");
                        int annoDiPubblicazione1 = scanner.nextInt();
                        List<Libri> libriList1 = libriList.stream()
                                .filter(libri -> libri.getAnnoDiPubblicazione() == annoDiPubblicazione1)
                                .toList();
                        libriList1.forEach(System.out::println);
                        break;
                    case 4:
                        System.out.println("Inserire l'autore dei libri da visualizzare");
                        Scanner scanner1 = new Scanner(System.in);
                        String autore1 = scanner1.nextLine();
                        List<Libri> libriList2 = libriList.stream().filter(libroS -> libroS.getAutore().equalsIgnoreCase(autore1)).collect(Collectors.toList());
                        libriList2.forEach(System.out::println);
                        break;
                    case 5:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Scelta non valida");
                        break;
                }
                break;
            case 2:
                System.out.println("1. Inserisci una nuova rivista");
                System.out.println("2. Visualizza una rivista");
                System.out.println("3. Visualizza le riviste per anno di pubblicazione");
                System.out.println("4. Esci");
                System.out.println("-----------------------------------------");
                int scelta2 = scanner.nextInt();
                switch (scelta2) {
                    case 1:
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
                    case 2:
                        System.out.println("Inserire l' ISBN della rivista da visualizzare");
                        int ISBN4 = scanner.nextInt();
                        for (Riviste rivista1 : rivisteList) {
                            if ((rivista1.getISBN()) == ISBN4) {
                                System.out.println(rivista1);
                                break;
                            }
                        }
                        break;
                    case 3:
                        System.out.println("Inserire l'anno di pubblicazione della rivista da visualizzare");
                        int annoDiPubblicazione3 = scanner.nextInt();
                        List<Riviste> rivisteList1 = rivisteList.stream().filter(riviste -> riviste.getAnnoDiPubblicazione() == annoDiPubblicazione3).toList();
                        rivisteList1.forEach(System.out::println);
                        break;
                    case 4:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Scelta non valida");
                        break;
                }
                break;
            case 3:
                System.exit(0);
        }
        System.out.println("Vuoi continuare? (s/n)");
        System.out.println("1. Si");
        System.out.println("2. No");
        int scelta3;
        do {
            scelta3 = scanner.nextInt();
            if (scelta3 == 1) {
                break;
            } else if (scelta3 == 2) {
                System.exit(0);
            } else {
                System.out.println("Scelta non valida, inserire 1 o 2.");
            }
        } while (true);

    }
}

