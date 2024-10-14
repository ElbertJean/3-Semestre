import java.util.List;

public class ListaCompra {
 
    private List<ItemCompra> itensCompra;
    private int qtdeMax;

    public ListaCompra(int qtdeMax) {
        this.qtdeMax = qtdeMax;
    }

    public int getQtdeMax() {
        return qtdeMax;
    }

    public void setQtdeMax(int qtdeMax) {
        this.qtdeMax = qtdeMax;
    }

    public List<ItemCompra> getItensCompra() {
        return itensCompra;
    }

    public void setItensCompra(List<ItemCompra> itensCompra) {
        this.itensCompra = itensCompra;
    }

    public void addItem(ItemCompra item) {
        if (itensCompra.size() < qtdeMax) {
            itensCompra.add(item);
        }
    }

    public double calcularTotal() {
        double total = 0.0;
        for (ItemCompra item : itensCompra) {
            total += item.calcularPreco();
        }
        return total;
    }

}
