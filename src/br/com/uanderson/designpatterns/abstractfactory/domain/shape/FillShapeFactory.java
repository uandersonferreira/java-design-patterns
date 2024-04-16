package br.com.uanderson.designpatterns.abstractfactory.domain.shape;

public class FillShapeFactory extends ShapeAbstractFactory{//3°-Concrete Factory
    @Override
    public Shape newShape(String type) {
        if (type.equals("circle")){
            return new FillCircle();
        } else if (type.equals("square")) {
            return new FillSquare();
        }
        return null;
    }

}//class
