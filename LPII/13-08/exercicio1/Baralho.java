public class Baralho {
    
    private Carta[] cartas = new Carta[52];
    private int fimBaralho;

    public Baralho(Carta[] cartas) {
        this.cartas = cartas;
        this.fimBaralho = cartas.length;
    }

    public void imprimirBaralho() {
        for (int i = 0; i < cartas.length; i++) {
            if (cartas[i] != null) {
                System.out.println(cartas[i]);
            }
        }
    }

    public boolean hasCarta(Carta carta) {
        for (int i = 0; i < cartas.length; i++) {
            if (cartas[i] !== null && cartas[i].equals(carta)) {
                return true;
            }
        }
        return false;
    }

    public Carta distribuirCartas() {
        this.fimBaralho--;
        return this.cartas[fimBaralho];
    }

    public void embaralhar() {
        for (int i = 0; i < cartas.length; i++) {
            int random = (int) (Math.random() * cartas.length);
            Carta temp = cartas[i];
            cartas[i] = cartas[random];
            cartas[random] = temp;
        }
    }
}
