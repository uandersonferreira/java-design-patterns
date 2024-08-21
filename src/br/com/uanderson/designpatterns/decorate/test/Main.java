package br.com.uanderson.designpatterns.decorate.test;

import br.com.uanderson.designpatterns.decorate.domain.gui.Window;
import br.com.uanderson.designpatterns.decorate.domain.shape.*;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Window w = new Window("Shapes", 300, 300);
        w.show();

        ShapeComponent shape = new DashLineConcreteDecorator(
                new ColorShapeConcreteDecoratorComponent(new Square(), Color.YELLOW));
//        ShapeComponent shape = new DashLineConcreteDecorator(new Circle());

        w.drawShape(shape);

    }
}
/*
Cenário com os seguintes comportamentos
- figura colorida de azul
- figura pontilhada ou não

        ShapeComponent shape = new ColorShapeConcreteDecoratorComponent(new Circle(), Color.BLUE);
        ShapeComponent shape2 = new ColorShapeConcreteDecoratorComponent(new Square(), Color.GREEN);

    Aqui temos duas figuras/objetos com comportamentos diferentes(cores).
    Dessa forma com o Decorator, é possivel atrelas/atribuir comportamentos
    a uma instância especifica o contrário de quando se usa herença, que atribui
    o comportamento a todas as intâncias da classe.

    - Comportamento por intância

       ShapeComponent shape = new DashLineConcreteDecorator(
                new ColorShapeConcreteDecoratorComponent(new Square(), Color.YELLOW));

        - Estamos criando um DashLine Shape que irá criar um ColorShape
        de um square com a cor amarela.
        ou seja, criamos linhas tracejadas para um quadrado na cor amarela.

        Isso é possível, pois o padrão permite a combinação de cada class
        de decorator, para que seja possível adicionar camadas de comportamento
        ao objeto final, na ordem que preferimos e assim obter o resultado desejado.
 */