package br.com.uanderson.designpatterns.composite.domain;

public class Triangle implements SceneObject{
    //Representa um Leaf uma "Folha"
    private String name;

    public Triangle(String name) {
        this.name = name;
    }

    @Override
    public void draw() {
        System.out.println("Drawing triangle");
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
