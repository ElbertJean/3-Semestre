package br.ed.fatec.factory;

public interface ShapeFactory {
    Calculable getShape(ShapeType type, Double[] values);
}
