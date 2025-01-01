package br.com.uanderson.designpatterns.behavioral_patterns.strategy.strategy_example_02;

import java.util.function.Consumer;

public class ModernStrategy {
    public static void main(String[] args) {
        String paymentMethod = "BOLETO";// "CREDIT_CARD", "BOLETO", "PIX"
        double amount = 3.0;
        PaymentType.valueOf(paymentMethod).pay(amount);
    }//main
}//class


class PaymentMethods {
    public static void creditCard(double amount) {
        System.out.println("Validing credi card...");
        System.out.println("Paid R$ " + amount + " with credit card.");
    }

    public static void boleto(double amount) {
        System.out.println("Generating barcode...");
        System.out.println("Paid R$ " + amount + " with Boleto.");
    }

    public static void pix(double amount) {
        System.out.println("Generating QR Code...");
        System.out.println("Paid R$ " + amount + " with  PIX.");
    }
}

enum PaymentType {
    CREDIT_CARD(PaymentMethods::creditCard),
    BOLETO(PaymentMethods::boleto),
    PIX(PaymentMethods::pix);

    private final Consumer<Double> paymentStrategy;

    PaymentType(Consumer<Double> paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void pay(double amount) {
        paymentStrategy.accept(amount);
    }

}


