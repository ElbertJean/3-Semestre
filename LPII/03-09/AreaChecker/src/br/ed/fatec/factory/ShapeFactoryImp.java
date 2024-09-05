package br.ed.fatec.factory;

public class ShapeFactoryImp implements ShapeFactory {

    Calculable result = null;

    @Override
    public Calculable getShape(ShapeType type, Double[] values) {
        switch (type) {
            case SQUARE:
                result = new Square(values[0]);
                break;
            case RECTANGLE:
                result = new Rectangle(values[0], values[1]);
                break;
            case CIRCLE:
                result = new Circle(values[0]);
                break;
            case TRIANGLE:
                result = new Triangle(values[0], values[1]);
                break;
            case PARALLELOGRAM:
                result = new Parallelogram(values[0], values[1]);
                break;
            case TRAPEZO:
                result = new Trapezo(values[0], values[1], values[2]);
                break;
            case HEXAGON:
                result = new Hexagon(values[0]);
                break;
            case DIAMOND:
                result = new Diamond(values[0], values[1]);
                break;
            case CUBE:
                result = new Cube(values[0]);
                break;
        }
        return result;
    }
}