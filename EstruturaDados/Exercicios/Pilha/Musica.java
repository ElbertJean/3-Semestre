public class Musica {
    private String musica;
    private Musica proximo;

    public Musica () {
        this.proximo = null;
    }

    public Musica (String musica) {
        this.musica = musica;
        this.proximo = null; 
    }

    public String getMusica() {
        return musica;
    }

    public void setMusica(String musica) {
        this.musica = musica;
    }

    public Musica getProximo() {
        return proximo;
    }

    public void setProximo(Musica proximo) {
        this.proximo = proximo;
    }

    @Override
    public String toString() {
        return "No [musica=" + musica + ", proximo=" + proximo + "]";
    }
}