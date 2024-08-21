package br.com.uanderson.designpatterns.abstractfactory.domain.shape;

public abstract class ShapeAbstractFactory {//2°-Abstract Factory
    public abstract Shape newShape(String type);
}
