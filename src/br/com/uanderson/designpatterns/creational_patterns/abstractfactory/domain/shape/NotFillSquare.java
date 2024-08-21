package br.com.uanderson.designpatterns.creational_patterns.abstractfactory.domain.shape;

public class NotFillSquare extends Shape {//5° - Concrete Product/SubType extends SuperType

    @Override
    public void draw(Graphics g) {
        g.setColor(getColor());
        g.drawRect(0, 0, 100, 100);
    }
}
