package br.com.uanderson.designpatterns.creational_patterns.abstractfactory.domain.shape;

import java.awt.*;

public class NotFillCircle extends Shape {//5° - Concrete Product/SubType extends SuperType

    @Override
    public void draw(Graphics g) {
        g.setColor(getColor());
        g.drawOval(0, 0, 50, 50);
    }
}
