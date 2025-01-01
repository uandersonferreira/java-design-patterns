package br.com.uanderson.designpatterns.behavioral_patterns.strategy.strategy_example_02;

public class NoStrategy {
    public static void main(String[] args) {
        int paymentMethod = 1; // 1- Credit card, 2 - Boleto, 3 - Pix
        double amount = 3.0;

        if (paymentMethod == 1) {
            System.out.println("Validing credi card...");
            System.out.println("Paid R$ " + amount + " with credit card.");
        } else if (paymentMethod == 2) {
            System.out.println("Generating barcode...");
            System.out.println("Paid R$ " + amount + " with Boleto.");
        } else if (paymentMethod == 3) {
            System.out.println("Generating QR Code...");
            System.out.println("Paid R$ " + amount + " with  PIX.");
        } else {
            throw new IllegalStateException("Payment method not supported.");
        }
        
    }//main
}//class