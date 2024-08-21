package br.com.uanderson.designpatterns.structural_patterns.decorate.domain.gui;

import br.com.uanderson.designpatterns.structural_patterns.decorate.domain.shape.ShapeComponent;

import javax.swing.*;
import java.awt.*;

public class DrawPanel extends JPanel {
    private ShapeComponent shapeComponent;

    public void drawShape(ShapeComponent shapeComponent) {
        this.shapeComponent = shapeComponent;
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        if (shapeComponent != null) {
            shapeComponent.draw(g);
        }
    }
}
