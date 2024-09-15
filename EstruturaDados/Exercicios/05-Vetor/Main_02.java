// Aula 02 - Vetor de Strings

import java.util.Scanner;

public class Main_02 {
  
  public static void main(String[] args) {
    String[] vetorEstados = new String[10];
    vetorEstados[0] = "SP";
    vetorEstados[1] = "MG";
    vetorEstados[2] = "RJ";
    vetorEstados[3] = "ES";
    vetorEstados[4] = "PR";
    vetorEstados[5] = "RS";
    vetorEstados[6] = "SC";
    
    for (int i = 0; i < vetorEstados.length ; i++) {
      if (vetorEstados[i] != null) {
        System.out.println(vetorEstados[i]);
      }
    }

    Scanner leitor = new Scanner(System.in);
    System.out.println("Qual sigla de estado você quer buscar?");
    String siglaBusca = leitor.nextLine();

    boolean encontrou = false;
    for (int j = 0; j < vetorEstados.length ; j++) {
      String elemento = vetorEstados[j];
      if (elemento.equals(siglaBusca)) {
        encontrou = true;
        break;
      }
    }
    if (encontrou) {
      System.out.println("Encontrado");
    } else {
      System.out.println("Não encontrado");
    }

    leitor.close();

  }
}
