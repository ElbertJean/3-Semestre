package br.ed.fatec.main;

import br.ed.fatec.factory.Calculable;
import br.ed.fatec.factory.ShapeFactoryImp;
import br.ed.fatec.factory.ShapeType;

public class Main {
    
    public static void main(String[] args) {    
        ShapeFactoryImp shapeFactory = new ShapeFactoryImp();

        Calculable quadrado = shapeFactory.getShape(ShapeType.SQUARE, new Double[] { 5.0 } );
        System.out.println("Área do Quadrado: " + quadrado.calcularArea());

        Calculable retangulo = shapeFactory.getShape(ShapeType.RECTANGLE, new Double[] { 5.0, 10.0 });
        System.out.println("Área do Retangulo: " + retangulo.calcularArea());

        Calculable circulo = shapeFactory.getShape(ShapeType.CIRCLE, new Double[] { 5.0 });
        System.out.println("Área do Circulo: " + circulo.calcularArea());

        Calculable triangulo = shapeFactory.getShape(ShapeType.TRIANGLE, new Double[] { 5.0, 10.0 });
        System.out.println("Área do Triangulo: " + triangulo.calcularArea());

        Calculable paralelogramo = shapeFactory.getShape(ShapeType.PARALLELOGRAM, new Double[] { 5.0, 10.0 });
        System.out.println("Área do Paralelogramo: " + paralelogramo.calcularArea());

        Calculable trapezio = shapeFactory.getShape(ShapeType.TRAPEZO, new Double[] { 5.0, 10.0, 15.0 });
        System.out.println("Área do Trapezio: " + trapezio.calcularArea());

        Calculable hexagono = shapeFactory.getShape(ShapeType.HEXAGON, new Double[] { 5.0 });
        System.out.println("Área do Hexagono: " + hexagono.calcularArea());

        Calculable diamante = shapeFactory.getShape(ShapeType.DIAMOND, new Double[] { 5.0, 10.0 });
        System.out.println("Área do Diamante: " + diamante.calcularArea());

        Calculable cubo = shapeFactory.getShape(ShapeType.CUBE, new Double[] { 5.0 });
        System.out.println("Área do Cubo: " + cubo.calcularArea());

    }
}
