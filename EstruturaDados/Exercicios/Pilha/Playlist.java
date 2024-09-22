public class Playlist {
    
    private Musica topo;

    public Playlist() {
        this.topo = null;
    }

    public Musica getTopo() {
        return topo;
    }

    public void setTopo(Musica topo) {
        this.topo = topo;
    }

    public void empilhar(String musica) {
        Musica musicaRecebida = new Musica(musica);
        if(topo == null){
            topo = musicaRecebida;
            return;
        }
        musicaRecebida.setProximo(topo);
        topo = musicaRecebida;
    }

    public Musica desempilhar() {
        if (topo.getProximo() == null) {
            System.out.println("A pilha está alone");
            return null;
        }
        Musica retirado = topo.getProximo();
        topo.setProximo(retirado.getProximo());
        return retirado; 
    }

    public void imprimir() {
        Musica atual = topo;     // Fazendo desse jeito eu gero uma cópia do topo, não alterando o estado dele em si
        if(atual == null) {
            System.out.println("Não existe música na playlist");
        }
        while (atual != null) {
            System.out.println(atual.getMusica());
            atual = atual.getProximo();
        }
        System.out.println("\n");
    }
}
