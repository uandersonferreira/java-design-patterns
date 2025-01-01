package br.com.uanderson.designpatterns.behavioral_patterns.strategy.strategy_example_02;

public class CommonStrategy {
    public static void main(String[] args) {
        int paymentMethodCode = 3; // 1- Credit card, 2 - Boleto, 3 - Pix
        double amount = 3.0;

        var paymentMethod = switch (paymentMethodCode) {
            case 1 -> new CreditCardPayment();
            case 2 -> new BoletoPayment();
            case 3 -> new PixPayment();
            default -> throw new IllegalStateException("Payment method not supported.");
        };
        var processor = new PaymentProcessor(paymentMethod);
        processor.pay(amount);
    }
}

class PaymentProcessor {
    private PaymentMethod paymentMethod;
    public PaymentProcessor(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void pay(double amount) {
        if (paymentMethod == null)
            throw new IllegalArgumentException("Payment method not specified.");
        paymentMethod.pay(amount);
    }
}

interface PaymentMethod {
    void pay(double amount);
}

class CreditCardPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Validing credi card...");
        System.out.println("Paid R$ " + amount + " with credit card.");
    }
}

class BoletoPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Generating barcode...");
        System.out.println("Paid R$ " + amount + " with Boleto.");
    }
}

class PixPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Generating QR Code...");
        System.out.println("Paid R$ " + amount + " with  PIX.");
    }
}

