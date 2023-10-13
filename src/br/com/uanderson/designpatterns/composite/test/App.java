package br.com.uanderson.designpatterns.composite.test;

import br.com.uanderson.designpatterns.composite.domain.Rectangle;
import br.com.uanderson.designpatterns.composite.domain.SceneGroup;
import br.com.uanderson.designpatterns.composite.domain.Triangle;

public class App {
    public static void main(String[] args) {
        SceneGroup group1 = new SceneGroup("group1");

        Triangle t1 = new Triangle("Equilátero");
        SceneGroup group2 = new SceneGroup("group2");


        group1.add(t1);
        group1.add(group2);

        Triangle t2 = new Triangle("Escaleno");
        Rectangle r1 = new Rectangle("Trapézio Retângulo");

        group2.add(t2);
        group2.add(r1);

        SceneGroup group3 = new SceneGroup("group3");

        Rectangle r2 = new Rectangle("Retângulo Áureo");
        Rectangle r3 = new Rectangle("Retângulo");

        group3.add(r2);
        group3.add(r3);

        group2.add(group3);

        SceneGroup.printSceneTree(group1, "", true);

    }


}
