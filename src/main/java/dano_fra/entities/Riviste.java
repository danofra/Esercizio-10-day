package dano_fra.entities;

public class Riviste extends Catalogo {
    public periodicita periodicita;

    public Riviste(int ISBN, String titolo, int annoDiPubblicazione, int numeroPagine, periodicita periodicita) {
        super(ISBN, titolo, annoDiPubblicazione, numeroPagine);
        this.periodicita = periodicita;
    }

    public periodicita getPeriodicita() {
        return periodicita;
    }

    @Override
    public String toString() {
        return "\nISBN: " + getISBN() +
                "\nTitolo: " + getTitolo() +
                "\nAnno di pubblicazione: " + getAnnoDiPubblicazione() +
                "\nNumero di pagine: " + getNumeroPagine() +
                "\nPeriodicità: " + getPeriodicita().name() +
                "\n";
    }
}
