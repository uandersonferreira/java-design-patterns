package br.com.uanderson.designpatterns.creational_patterns.abstractfactory.domain.shape;

public abstract class Shape {//4° - Type - Class model for subTypes
    private Color color;

    public abstract void draw(Graphics g);

    public void defineColor(int r, int g, int b) {
        this.color = new Color(r, g, b);
    }

    public Color getColor() {
        return color;
    }
}
