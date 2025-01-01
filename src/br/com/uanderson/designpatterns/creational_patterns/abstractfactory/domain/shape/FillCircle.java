package br.com.uanderson.designpatterns.creational_patterns.abstractfactory.domain.shape;

import java.awt.*;

public class FillCircle extends Shape { //5° - Concrete Product/SubType extends SuperType

    @Override
    public void draw(Graphics g) {
        g.setColor(getColor());
        g.fillOval(0, 0, 50, 50);
    }
}
