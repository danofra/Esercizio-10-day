package dano_fra.entities;

public abstract class Catalogo {
    private int ISBN;
    private String titolo;
    private int annoDiPubblicazione;
    private int numeroPagine;

    public Catalogo(int ISBN, String titolo, int annoDiPubblicazione, int numeroPagine) {
        this.ISBN = ISBN;
        this.titolo = titolo;
        this.annoDiPubblicazione = annoDiPubblicazione;
        this.numeroPagine = numeroPagine;
    }

    public int getISBN() {
        return this.ISBN;
    }

    public String getTitolo() {
        return this.titolo;
    }

    public int getAnnoDiPubblicazione() {
        return this.annoDiPubblicazione;
    }

    public int getNumeroPagine() {
        return this.numeroPagine;
    }


}
