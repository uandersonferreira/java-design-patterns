package br.com.uanderson.designpatterns.creational_patterns.abstractfactory.test;

import br.com.uanderson.designpatterns.creational_patterns.abstractfactory.domain.gui.Window;
import br.com.uanderson.designpatterns.creational_patterns.abstractfactory.domain.shape.Shape;
import br.com.uanderson.designpatterns.creational_patterns.abstractfactory.domain.shape.ShapeAbstractFactory;
import br.com.uanderson.designpatterns.creational_patterns.abstractfactory.domain.shape.ShapeFactoryProducer;

public class Main {
    public static void main(String[] args) {
        Window w = new Window("Shapes", 300, 300);
        w.show();

        ShapeAbstractFactory factory = ShapeFactoryProducer.getFactory(false);

        Shape shape = factory.newShape("square");

        w.drawShape(shape);
        /*
            TEMOS DUAS FAMILIAS DE OBJETOS :
                - OS PREENCHIDOS(Fill)
                - NÃO PREENCHIDOS(NotFill)
                - ONDE CADA OBJECT HERDA DE SHAPE
                - E AMBAS DEVEM RETORNAR UM SHAPE

         */

    }
}
