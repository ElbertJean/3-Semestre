package ListaEncadeada;

public class Main {
  
  public static void main(String[] args) {
                        
    ListaEncadeada lista = new ListaEncadeada();
    lista.adicionar("AC");
    lista.adicionar("BA");
    lista.adicionar("CE");
    lista.adicionar("DF");
    System.out.println("Busca:" + lista.buscar(3).getValor());
    System.out.println("Tamanho: " + lista.getTamanho());
    System.out.println("Primeiro: " + lista.getPrimeiro().getValor());
    System.out.println("Último  : " + lista.getUltimo().getValor() + "\n\n");

    lista.remover("DF");
    lista.remover("AC");
    lista.remover("CE");
    lista.remover("BA");

    for (int i = 0; i < lista.getTamanho(); i++) {
      System.out.println("Posicao: " + i + " Valor: " + lista.buscar(i).getValor());
    }
  }
}
