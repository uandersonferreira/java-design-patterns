package br.com.uanderson.designpatterns.abstractfactory.domain.shape;

public class ShapeFactoryProducer {//1°-FactoryProducer
    private static FillShapeFactory fillShapeFactory;
    private static NotFillShapeFactory notFillShapeFactory;
    public static  ShapeAbstractFactory getFactory(boolean fill){
        if (fill){//true
            //Aplicando o padrão singleton para retornar sempre a mesma intância
            if (fillShapeFactory == null){
               fillShapeFactory = new FillShapeFactory();
           }
           return fillShapeFactory;
        }else {//false
            //Aplicando o padrão singleton para retornar sempre a mesma intância
            if (notFillShapeFactory == null){
                notFillShapeFactory = new NotFillShapeFactory();
            }
            return notFillShapeFactory;
        }
    }//method

    /*
      Esse method retorno a AbstractFactory, dessa forma não importa qual
      ConcreteFactory é passado é sempre irá retornar a Factory Abstrata.
       - aqui temos um parametro de controle/tomada de decisão (boolean fill ) que
       nos dirar qual ConcreteFactory iremos instanciar/chamar.

     */

}//class
