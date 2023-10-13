package br.com.uanderson.designpatterns.composite.domain;

public class Triangle implements SceneObject{
    //Representa um Leaf uma "Folha"
    @Override
    public void draw() {
        System.out.println("Drawing triangle");
    }
}
