// Um carro só dirige
public class Car implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Carro está dirigindo.");
    }

    @Override
    public void fly() {
        throw new UnsupportedOperationException("Carro não pode voar!");
    }
}


