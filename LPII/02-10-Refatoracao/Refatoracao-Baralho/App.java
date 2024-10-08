import java.util.ArrayList;

public class App {
    
    public static void main(String[] args) {
    
        String[] naipes = {"Ouros", "Espadas", "Copas", "Paus"};
        String[] nomes = {"Ás", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Valete", "Dama", "Rei"};
        
        ArrayList<Carta> cartas = new ArrayList<>();
        
        for (String naipe : naipes) {
            for (String nome : nomes) {
                cartas.add(new Carta(nome, naipe));
            }
        }

        Baralho baralho = new Baralho(cartas);
        System.out.println("\nCartas no baralho:");
        baralho.imprimirBaralho();
        
        baralho.embaralhar();

        System.out.println("\nCartas embaralhadas:\n");
        baralho.imprimirBaralho();

        System.out.println("\nDistribuindo cartas");
        System.out.println(baralho.distribuirCartas());
    }
}
