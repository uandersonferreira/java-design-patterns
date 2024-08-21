package br.com.uanderson.designpatterns.structural_patterns.decorate.domain.shape;

import java.awt.*;

public abstract class ShapeComponentDecorator implements ShapeComponent {//Decorator
    //REPRESENTA O DECORATOR QUE IMPLEMENTA O COMPONENT - O SUPER DOS DECORATORS
    //E POSSUI UMA INTÂNCIA DO COMPONENTE
    private ShapeComponent shapeComponent;//OBJETO COMPONENT
    //Objeto a se influênciado, alterado o comportamente

    public ShapeComponentDecorator(ShapeComponent shapeComponent) {
        this.shapeComponent = shapeComponent;
    }

    @Override
    public void draw(Graphics g) {
        shapeComponent.draw(g);//chama o draw do shapeComponent
    }
}
