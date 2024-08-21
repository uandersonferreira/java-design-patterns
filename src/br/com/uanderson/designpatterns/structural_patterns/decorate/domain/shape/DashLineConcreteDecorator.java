package br.com.uanderson.designpatterns.structural_patterns.decorate.domain.shape;

import java.awt.*;

public class DashLineConcreteDecorator extends ShapeComponentDecorator {
    /*
        CONCRETE DECORATOR - QUE HERDA/EXTENDER DO SUPER DECORATOR 'ShapeComponentDecorator'
        DESSA  FORMA SE TORNA TAMBÉM UM 'SHAPE' (SUPER TYPE OBJECT) E TAMBÉM PASSA NO TESTE:
        - É UM COMPONENTE(SHAPE) ?

        ALÉM DISSO TAMBÉM CONSEGUE SOBREESCREVER O METHOD DRAW() - ATRAVÉS DA CHAMADA
        VIA SUA SUPER CLASS  'ShapeComponentDecorator', QUE POSSUI UMA CHAMADA DE DRAW()
        VIA SUA SUPER CLASS QUE É 'ShapeComponent'.
     */
    public DashLineConcreteDecorator(ShapeComponent shapeComponent) {
        super(shapeComponent);
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D graphics2D = (Graphics2D) g.create();

        BasicStroke stroke = new BasicStroke(
                3,
                BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_BEVEL,
                0,
                new float[]{9},
                0);

        graphics2D.setStroke(stroke);

        super.draw(graphics2D);

        graphics2D.dispose();
    }
}
