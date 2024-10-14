public class ItemCompra implements Calculavel {
    
    private int quantidade;
    private Produto produto;
    private double desconto;

    public ItemCompra(int quantidade, Produto produto, double desconto) {
        this.quantidade = quantidade;
        this.produto = produto;
        this.desconto = desconto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    @Override
    public double calcularPreco() {
        return (quantidade * produto.getPreco()) - desconto;
    }

    @Override
    public String toString() {
        return "ItemCompra{" +
                "quantidade=" + quantidade +
                ", produto=" + produto +
                ", desconto=" + desconto +
                '}';
    }
}
