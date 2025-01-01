package br.com.uanderson.designpatterns.creational_patterns.factormethod.domain.shape;

import java.awt.*;

public class Square extends Shape{

    @Override
    public void draw(Graphics g) {
        g.setColor(getColor());
        g.fillRect(0, 0, 100, 100);
    }
}
