package br.com.uanderson.designpatterns.factormethod.domain.shape;

import java.awt.*;

public class Circle extends Shape{

    @Override
    public void draw(Graphics g) {
        g.setColor(getColor());
        g.fillOval(0, 0, 50, 50);
    }
}
