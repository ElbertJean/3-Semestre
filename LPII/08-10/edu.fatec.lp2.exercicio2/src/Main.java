public class Main {
    public static void main(String[] args) throws Exception {
        
        Supermercado simpatia = new Supermercado("Supermercado");

        Produto p1 = new Produto(simpatia);
        p1.setNome("Arroz");
        p1.setUnidade("Kg");
        p1.setDescricao("Arroz Branco");
        p1.setPreco(10.00);
        p1.setDescontoMaximo(5.00);

        Produto p2 = new Produto(simpatia);
        p2.setNome("Feijão");
        p2.setUnidade("Kg");
        p2.setDescricao("Feijão Carioca");
        p2.setPreco(10.00);
        p2.setDescontoMaximo(5.00);

        ItemCompra ic1 = new ItemCompra(2, p1, 2.0);

        System.out.println(ic1.toString());
        System.out.println(ic1.calcularPreco());
        System.out.println(ic1.toString());

        ItemCompra ic2 = new ItemCompra(1, p2, 3.0);
        System.out.println(ic2.toString());
        System.out.println(ic2.calcularPreco());
        System.out.println(ic2.toString());

    }
}
