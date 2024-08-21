package br.com.uanderson.designpatterns.structural_patterns.decorate.domain.shape;

import java.awt.*;

public class ColorShapeConcreteDecoratorComponent extends ShapeComponentDecorator {
    /*
        CONCRETE DECORATOR - QUE HERDA/EXTENDER DO SUPER DECORATOR 'ShapeComponentDecorator'
        DESSA  FORMA SE TORNA TAMBÉM UM 'SHAPE' (SUPER TYPE OBJECT) E TAMBÉM PASSA NO TESTE:
        - É UM COMPONENTE(SHAPE) ?

        ALÉM DISSO TAMBÉM CONSEGUE SOBREESCREVER O METHOD DRAW() - ATRAVÉS DA CHAMADA
        VIA SUA SUPER CLASS  'ShapeComponentDecorator', QUE POSSUI UMA CHAMADA DE DRAW()
        VIA SUA SUPER CLASS QUE É 'ShapeComponent'.
     */
    private Color color;

    public ColorShapeConcreteDecoratorComponent(ShapeComponent shapeComponent, Color color) {
        super(shapeComponent);
        this.color = color;
    }

    @Override
    public void draw(Graphics g) {
        Graphics graphicsCopy = g.create();//Criando um copia para que não influência outras figuras

        graphicsCopy.setColor(color);//sendo assim setamos a color somente na copia e não no objeto original
        super.draw(graphicsCopy);//chamo o method draw da super class no caso 'ShapeComponentDecorator'

        graphicsCopy.dispose();//nós livramos da copia que foi criada (deletamos) após ser desenhada
    }

}
