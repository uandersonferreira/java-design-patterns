package br.com.uanderson.designpatterns.decorate.domain.shape;

import java.awt.*;

public class Circle implements ShapeComponent {
    //O CONCRETE COMPONENT QUE IMPLEMENTAM O COMPONENTE
    //OU SEJA PARA PASSAR NO TESTE: É UM COMPONENTE?

    @Override
    public void draw(Graphics g) {
        g.drawOval(0, 0, 50, 50);
    }
}
