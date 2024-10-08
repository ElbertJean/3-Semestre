import java.util.ArrayList;
import java.util.Collections;

public class Baralho {
    
    private ArrayList<Carta> cartas;
    private int fimBaralho;

    public Baralho(ArrayList<Carta> cartas) {
        this.cartas = cartas;
        this.fimBaralho = cartas.size();
    }

    public void imprimirBaralho() {
        for (Carta carta : cartas) {
            System.out.println(carta);
        }
    }

    public boolean hasCarta(Carta carta) {
        return cartas.contains(carta);
    }

    public Carta distribuirCartas() {
        if (fimBaralho > 0) {
            fimBaralho--;
            return cartas.get(fimBaralho);
        }
        return null;
    }

    public void embaralhar() {
        Collections.shuffle(cartas);
    }
}
