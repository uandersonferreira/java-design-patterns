package br.com.uanderson.designpatterns.creational_patterns.abstractfactory.domain.shape;

public class ShapeFactoryProducer {//1°-FactoryProducer
    private static FillShapeFactory fillShapeFactory;
    private static NotFillShapeFactory notFillShapeFactory;
    public static  ShapeAbstractFactory getFactory(boolean fill){
        //Aplicando o padrão singleton para retornar sempre a mesma intância
        if (fill){
           if (fillShapeFactory == null){
               fillShapeFactory = new FillShapeFactory();
           }
           return fillShapeFactory;
        }else {
            if (notFillShapeFactory == null){
                notFillShapeFactory = new NotFillShapeFactory();
            }
            return notFillShapeFactory;
        }
    }//method

}//class
