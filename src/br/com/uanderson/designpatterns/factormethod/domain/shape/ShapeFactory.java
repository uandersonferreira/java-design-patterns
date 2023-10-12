package br.com.uanderson.designpatterns.factormethod.domain.shape;

public class ShapeFactory {
    public static Shape newShape(){
        return new Circle();
    }

}//class
/*
Factory Method Estático (Static Factory Method):
Em vez de criar uma instância de uma classe Creator, você
pode ter um método estático na própria classe para criar objetos.
Isso é semelhante a um Factory Method simples, mas sem a necessidade
de instanciar a classe Creator.
 */