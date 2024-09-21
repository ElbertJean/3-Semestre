public class ListaEncadeada {
    
    private No topo;

    public ListaEncadeada() {
        this.topo = null;
    }

    public No getTopo() {
        return topo;
    }

    public void setTopo(No topo) {
        this.topo = topo;
    }

    public void empilhar(String valor) {
        No valorInserido = new No(valor);
        if (topo == null) {
            topo = valorInserido;
            return;
        }
        valorInserido.setProximo(topo);
        topo = valorInserido;
    }

    public No desempilhar() {
        if (topo.getProximo() == null) {
            System.out.println("A pilha está alone");
            return null;
        }
        No retirado = topo.getProximo();
        topo.setProximo(retirado.getProximo());
        return retirado;  
    }

    public void imprimir() {
        No no = topo;
        while (no != null) {
            System.out.println(no.getEstado());
            no = no.getProximo();
        }
    }
}
