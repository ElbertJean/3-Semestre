package br.ed.fatec.factory;

class Circle implements Calculable {

    private double raio;

    public Circle(double raio) {
        this.raio = raio;
    }

    public double calcularArea() {
        return 3.14 * raio * raio;
    }
}
