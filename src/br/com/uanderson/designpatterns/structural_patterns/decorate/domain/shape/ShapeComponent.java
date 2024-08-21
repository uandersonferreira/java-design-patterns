package br.com.uanderson.designpatterns.structural_patterns.decorate.domain.shape;

import java.awt.*;

public interface ShapeComponent {//Class modelo
    //SUPER CLASS OU INTERFACE - MODELO SUPER TYPE DO OBJETO
    //É O COMPONENT NA ESTRUTURA
    void draw(Graphics g);

}
