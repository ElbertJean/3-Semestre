public class ListaSemCabeca {

  private No primeiro;
  private No ultimo;
  private int tamanho;

  public ListaSemCabeca() {
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

  public void adicionar(String valor) {
    No novoElemento = new No(valor);
    if (this.primeiro == null && this.ultimo == null) {
      this.primeiro = novoElemento;
      this.ultimo = novoElemento;
    } else {
      this.ultimo.setProximo(novoElemento);
      this.ultimo = novoElemento;
    }
    tamanho++;
  }

  // Esse primeiro buscar está errado, porque:
  // Ao colocar -1, ele retorna o primeiro elemento da lista
  // Ao colocar um tamanho maior da lista, ele sempre retorna o último

  // public No buscar (int posicao) {
  //   No atual = this.primeiro;
  //   for (int i = 0; i < posicao; i++) {
  //     if (atual.getProximo() != null) {
  //       atual = atual.getProximo();
  //     }
  //   }
  //   return atual;
  // }

  public No buscar (int posicao) {
    No atual = this.primeiro;
    int contador = 0;
    while (atual != null && contador < posicao) {
      atual = atual.getProximo();
      contador++;
    }
    return atual;
  }


}