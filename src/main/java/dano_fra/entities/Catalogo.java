package dano_fra.entities;

public abstract class Catalogo {
    public String titolo;
    public int annoDiPubblicazione;
    public int numeroPagine;

    public Catalogo(String titolo, int annoDiPubblicazione, int numeroPagine) {
        this.titolo=titolo;
        this.annoDiPubblicazione =annoDiPubblicazione;
        this.numeroPagine =numeroPagine;
}

}
