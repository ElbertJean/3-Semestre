package br.ed.fatec.factory;

class Hexagon implements Calculable {

    private double lado;

    public Hexagon(double lado) {
        this.lado = lado;
    }

    public double calcularArea() {
        return ((3 * Math.sqrt(3)) / 2) * lado * lado;
    }
}
