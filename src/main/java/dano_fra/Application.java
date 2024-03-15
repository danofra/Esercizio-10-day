package dano_fra;

import com.github.javafaker.Faker;
import dano_fra.entities.Libri;
import dano_fra.entities.Riviste;
import dano_fra.entities.periodicita;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Application {

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

        // Scanner per la scelta dell'utente
        Scanner scanner = new Scanner(System.in);
        System.out.println("Benvenuti nel nostro store di libri e riviste!");
        System.out.println("-----------------------------------------");
        territoriality:
        while (true) {

            System.out.println("Scegliere la tua opzione: cosa vuoi visualizzare?");
            System.out.println("1. Libro");
            System.out.println("2. Rivista");
            System.out.println("3. Esci");
            int scelta = scanner.nextInt();

            switch (scelta) {
                case 1:
                    System.out.println("1. Inserisci un nuovo libro");
                    System.out.println("2. Visualizza un libro tramite ISBN");
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
                    System.out.println("2. Visualizza una rivista tramite ISBN");
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
            scelta3 = scanner.nextInt();
            switch (scelta3) {
                case 1:
                    break;
                case 2:
                    break territoriality;
                default:
                    System.out.println("Scelta non valida");
                    break;
            }

        }
    }
}

