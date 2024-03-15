package dano_fra.entities;

public class Riviste extends Catalogo {
    public periodicita periodicita;

    public Riviste(String titolo, int annoDiPubblicazione,int numeroPagine, periodicita periodicita){        super(titolo, annoDiPubblicazione, numeroPagine);
        this.periodicita=periodicita;
}
}
