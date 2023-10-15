package br.com.uanderson.designpatterns.decorate.domain.shape;

import java.awt.*;

public class Square implements ShapeComponent {
    //CONCRETE COMPONENT QUE IMPLEMENTAM O COMPONENTE
    //OU SEJA PARA PASSAR NO TESTE: É UM COMPONENTE?
    @Override
    public void draw(Graphics g) {
        g.drawRect(0, 0, 100, 100);
    }
}
