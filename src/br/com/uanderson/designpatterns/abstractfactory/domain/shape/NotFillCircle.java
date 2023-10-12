package br.com.uanderson.designpatterns.abstractfactory.domain.shape;

import java.awt.*;

public class NotFillCircle extends Shape {

    @Override
    public void draw(Graphics g) {
        g.setColor(getColor());
        g.drawOval(0, 0, 50, 50);
    }
}
