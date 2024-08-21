package br.com.uanderson.designpatterns.creational_patterns.abstractfactory.domain.shape;

public class NotFillShapeFactory extends ShapeAbstractFactory{//3°-Concrete Factory
    private NotFillCircle notFillCircle;
    private NotFillSquare notFillSquare;
    @Override
    public Shape newShape(String type) {
        //Aplicando o padrão singleton para retornar sempre a mesma intância

        if (type.equals("circle")){
            if (notFillCircle == null){
                notFillCircle =  new NotFillCircle();
            }
            return notFillCircle;
        } else if (type.equals("square")) {
            if (notFillSquare == null){
                notFillSquare = new NotFillSquare();
            }
            return notFillSquare;
        }
        return null;
    }

}//class
