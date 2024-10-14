public class Produto {

    private String nome;
    private String unidade;
    private String descricao;
    private double preco;
    private double descontoMaximo;
    private Supermercado supermercado;

    public Produto(Supermercado supermercado) {
        this.supermercado = supermercado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getDescontoMaximo() {
        return descontoMaximo;
    }

    public void setDescontoMaximo(double descontoMaximo) {
        this.descontoMaximo = descontoMaximo;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", unidade='" + unidade + '\'' +
                ", descricao='" + descricao + '\'' +
                ", preco=" + preco +
                ", descontoMaximo=" + descontoMaximo +
                ", supermercado=" + supermercado.getNome() +
                '}';
    }
}