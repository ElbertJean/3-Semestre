public class Main {
    
    public static void main(String[] args) {

        ListaEncadeada lista = new ListaEncadeada();

        lista.empilhar("AC");
        lista.empilhar("DF");
        lista.empilhar("ES");
        lista.empilhar("RJ");
        lista.empilhar("SP");
    
        lista.imprimir();

        System.out.println(lista.desempilhar());
        lista.desempilhar();

        System.out.println("\n");
        lista.imprimir();
    

    }

}
