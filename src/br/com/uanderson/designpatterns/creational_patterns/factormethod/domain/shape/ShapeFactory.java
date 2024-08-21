package br.com.uanderson.designpatterns.creational_patterns.factormethod.domain.shape;

public class ShapeFactory {
    public static Shape newShape() {
        // Mudar o desenho mesmo após o código ser compilado através de um arquivo de configuração externo.

        try {
            // Obtém a classe da forma a ser criada a partir do arquivo de propriedades "shapeClass"
            String shapeClass = Props.getString("shapeClass");

            // Cria uma instância da classe da forma
            Shape shape = (Shape) Class.forName(shapeClass).newInstance();

            // Obtém as cores da forma a partir do arquivo de propriedades "color"
            String[] colors = Props.getString("color").split(",");
            //Separa por virgula então será gerado um array de 3 posições, pois temos a config de color (0,0,255)

            // Define as cores na forma
            shape.defineColor(Integer.parseInt(colors[0]), Integer.parseInt(colors[1]), Integer.parseInt(colors[2]));
            //Por ser String, temos que fazer o parse para um inteiro

            return shape;

        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            // Em caso de exceção, lançamos uma RuntimeException com a exceção original
            throw new RuntimeException(e);
        }
    }//method


    public static Shape newShape(int i){
        if (i == 1){
            return new Circle();
        }else if(i == 2){
            return new Square();
        }else {
            return null;
        }
        /*
            Outras variações de implementação, podem ocorrer
            passando como argumento uma String ou Enum do
            subType que queremos.
         */
    }

}//class
/*
Factory Method Estático (Static Factory Method):
Em vez de criar uma instância de uma classe Creator, você
pode ter um método estático na própria classe para criar objetos.
Isso é semelhante a um Factory Method simples, mas sem a necessidade
de instanciar a classe Creator.
 */