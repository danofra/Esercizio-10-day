package dano_fra.entities;

public class Libri extends Catalogo {
    public String autore;
    public String genere;

    public Libri(int ISBN, String titolo, int annoDiPubblicazione, int numeroPagine, String autore, String genere) {
        super(ISBN, titolo, annoDiPubblicazione, numeroPagine);
        this.autore = autore;
        this.genere = genere;
    }

    public String getAutore() {
        return autore;
    }

    public String getGenere() {
        return genere;
    }

    @Override
    public String toString() {
        return "\nISBN: " + getISBN() +
                "\nTitolo: " + getTitolo() +
                "\nAnno di pubblicazione: " + getAnnoDiPubblicazione() +
                "\nNumero di pagine: " + getNumeroPagine() +
                "\nAutore: " + getAutore() +
                "\nGenere: " + getGenere() +
                "\n";
    }

}
