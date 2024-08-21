package br.com.uanderson.designpatterns.creational_patterns.factormethod.domain.shape;

public class Circle extends Shape{

    @Override
    public void draw(Graphics g) {
        g.setColor(getColor());
        g.fillOval(0, 0, 50, 50);
    }
}
