package br.ed.fatec.factory;

class Square implements Calculable {
    
    private double lado;

    public Square(double lado){
        this.lado = lado;
    }
    
    @Override
    public double calcularArea() {
        return lado * lado;
    }
}
