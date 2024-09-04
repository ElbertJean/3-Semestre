package br.ed.fatec.factory;

class Diamond implements Calculable {

    private double diagonalMaior;
    private double diagonalMenor;

    public Diamond(double diagonalMaior, double diagonalMenor) {
        this.diagonalMaior = diagonalMaior;
        this.diagonalMenor = diagonalMenor;
    }

    public double calcularArea() {
        return (diagonalMaior * diagonalMenor) / 2;
    }
}
