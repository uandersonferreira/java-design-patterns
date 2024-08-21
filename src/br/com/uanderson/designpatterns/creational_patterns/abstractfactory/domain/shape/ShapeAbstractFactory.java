package br.com.uanderson.designpatterns.creational_patterns.abstractfactory.domain.shape;

public abstract class ShapeAbstractFactory {//2°-Abstract Factory
    public abstract Shape newShape(String type);
}
