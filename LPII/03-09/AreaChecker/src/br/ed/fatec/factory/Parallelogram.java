package br.ed.fatec.factory;

class Parallelogram implements Calculable {

    private double base;
    private double altura;

    public Parallelogram(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    public double calcularArea() {
        return base * altura;
    }
}
