// Aula 01 - Vetor de números

public class Main_01 {

  public static void main(String[] args) {
    int[] vetor = new int[10];
    vetor[0]  = 3;
    vetor[1]  = 4;
    vetor[2]  = 8;
    vetor[3]  = 13;
    vetor[4]  = 22;
    vetor[5]  = 51;
    vetor[6]  = 33;

    for (int i = 0; i < vetor.length ; i++) {
      if (vetor[i] != 0) {
        System.out.println(vetor[i]);
      }
    }

  }
}