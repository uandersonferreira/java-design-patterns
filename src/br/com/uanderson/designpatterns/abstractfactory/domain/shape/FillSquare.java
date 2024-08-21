package br.com.uanderson.designpatterns.abstractfactory.domain.shape;

import java.awt.*;

public class FillSquare extends Shape {//5° - Concrete Product/SubType extends SuperType

    @Override
    public void draw(Graphics g) {
        g.setColor(getColor());
        g.fillRect(0, 0, 100, 100);
    }
}
