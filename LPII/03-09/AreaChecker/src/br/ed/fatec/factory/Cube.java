package br.ed.fatec.factory;

class Cube implements Calculable {

    private double lado;

    public Cube(double lado) {
        this.lado = lado;
    }

    public double calcularArea() {
        return 6 * (lado * lado);
    }
}
