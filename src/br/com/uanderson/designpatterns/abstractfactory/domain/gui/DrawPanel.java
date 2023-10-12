package br.com.uanderson.designpatterns.abstractfactory.domain.gui;

import br.com.uanderson.designpatterns.abstractfactory.domain.shape.Shape;

import javax.swing.*;
import java.awt.*;

public class DrawPanel extends JPanel {
    private Shape shape;

    public void drawShape(Shape shape) {
        this.shape = shape;
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        if (shape != null) {
            shape.draw(g);
        }
    }
}
