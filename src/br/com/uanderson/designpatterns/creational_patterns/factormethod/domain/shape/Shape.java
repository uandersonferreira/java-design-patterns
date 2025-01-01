package br.com.uanderson.designpatterns.creational_patterns.factormethod.domain.shape;

import java.awt.*;

public abstract class Shape {//Class modelo
    private Color color;

    public abstract void draw(Graphics g);

    public void defineColor(int r, int g, int b) {
        this.color = new Color(r, g, b);
    }

    public Color getColor() {
        return color;
    }
}
