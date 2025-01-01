// Um carro só dirige
public class Car implements Drivable {
    @Override
    public void drive() {
        System.out.println("Carro está dirigindo.");
    }
}
