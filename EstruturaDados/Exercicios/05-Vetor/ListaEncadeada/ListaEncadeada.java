package ListaEncadeada;

public class ListaEncadeada {

  private No primeiro;
  private No ultimo;
  private int tamanho;

  public ListaEncadeada() {
    this.tamanho = 0;
  }

  public No getPrimeiro() {
    return primeiro;
  }

  public void setPrimeiro(No primeiro) {
    this.primeiro = primeiro;
  }

  public No getUltimo() {
    return ultimo;
  }

  public void setUltimo(No ultimo) {
    this.ultimo = ultimo;
  }

  public int getTamanho() {
    return tamanho;
  }

  public void setTamanho(int tamanho) {
    this.tamanho = tamanho;
  }

  public void adicionar(String novoValor) {
    No novoElemento = new No(novoValor);

    if (this.primeiro == null && this.ultimo == null) {
      this.primeiro = novoElemento;
      this.ultimo = novoElemento;
    } else {
      this.ultimo.setProximo(novoElemento);
      this.ultimo = novoElemento;
    }
    this.tamanho++;
  }

  public void remover(String valorProcurado) {
    No anterior = null;
    No atual = this.primeiro;
    for (int i = 0; i < this.getTamanho(); i++) {
      if (atual.getValor().equalsIgnoreCase(valorProcurado)) {
        if (this.tamanho == 1) {
          this.primeiro = null;
          this.ultimo = null;
        } else if (atual == primeiro){
          this.primeiro = atual.getProximo();
          atual.setProximo(null);
        } else if (atual == ultimo) {
          this.ultimo = anterior;
          anterior.setProximo(null);
        } else {
          anterior.setProximo(atual.getProximo());
          atual = null;
        }
        this.tamanho--; 
        break;
      } 
      anterior = atual;
      atual = atual.getProximo();
    }
  }

  public No buscar(int posicao) {
    No atual = this.primeiro;
    for (int i = 0; i < posicao; i++) {
      if (atual.getProximo() != null) {
        atual = atual.getProximo();
      }
    }
    return atual;
  }
}
