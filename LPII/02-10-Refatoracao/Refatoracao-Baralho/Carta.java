public class Carta {

    private String nome;
    private String naipe;

    public Carta(String nome, String naipe) {
        this.nome = nome;
        this.naipe = naipe;
    }

    public String getNome() {
        return nome;
    }   

    public String getNaipe() {
        return naipe;
    }

    public String toString() {
        return nome + " de " + naipe;
    }

    public boolean equals(Carta obj) {
        return obj.nome == this.nome && obj.naipe == this.naipe;
    }
}