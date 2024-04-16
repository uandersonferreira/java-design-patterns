package br.com.uanderson.designpatterns.abstractfactory.domain.shape;

public abstract class ShapeAbstractFactory {//2°-Abstract Factory
    public abstract Shape newShape(String type);

    /*
       - Poderia ser uma interface também

        - Retorna uma instância de Shape e recebe como parametro uma
        String que representa o Type do shape.

     */


}//class
