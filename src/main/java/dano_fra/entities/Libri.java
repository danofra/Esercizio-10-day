package dano_fra.entities;

public class Libri extends Catalogo {
    public String autore;
    public String genere;

    public Libri(String titolo, int annoDiPubblicazione, int numeroPagine, String autore, String genere){
        super(titolo,annoDiPubblicazione, numeroPagine);
        this.autore=autore;
        this.genere=genere;
    }
}
