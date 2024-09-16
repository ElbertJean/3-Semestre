

public class Main {
  
  public static void main(String[] args) {

    ListaSemCabeca lista = new ListaSemCabeca();
    lista.adicionar("Elbert");
    lista.adicionar("João");
    System.out.println(lista.getPrimeiro().getValor());
    System.out.println(lista.getUltimo().getValor());

    for (int i = 0; i < lista.getTamanho(); i++){
      System.out.println("Nomes: " + lista.buscar(i).getValor());
    }

    System.out.println(lista.buscar(5).getValor());
  }

}
