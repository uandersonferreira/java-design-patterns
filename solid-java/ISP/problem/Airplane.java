// Um avião só voa
public class Airplane implements Vehicle {
    @Override
    public void drive() {
        throw new UnsupportedOperationException("Avião não pode dirigir!");
    }

    @Override
    public void fly() {
        System.out.println("Avião está voando.");
    }
}