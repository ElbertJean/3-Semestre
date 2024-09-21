public class No {
    public String estado;
    public No proximo;

    public No() {
        this.proximo = null;
    }

    public No(String estado) {
        this.estado = estado;
        this.proximo = null;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public No getProximo() {
        return proximo;
    }

    public void setProximo(No proximo) {
        this.proximo = proximo;
    }

    @Override
    public String toString() {
        return "No [estado=" + estado + ", proximo=" + proximo + "]";
    }

    public Object getTopo() {
        throw new UnsupportedOperationException("Unimplemented method 'getTopo'");
    }

    
}