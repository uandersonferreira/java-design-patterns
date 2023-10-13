package br.com.uanderson.designpatterns.composite.domain;

public class Rectangle implements SceneObject{
    //Representa um Leaf uma "Folha"
    private String name;

    public Rectangle(String name) {
        this.name = name;
    }

    @Override
    public void draw() {
        System.out.println("Drawing rectangle");
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
