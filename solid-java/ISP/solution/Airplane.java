// Um avião só voa
public class Airplane implements Flyable {
    @Override
    public void fly() {
        System.out.println("Avião está voando.");
    }
}