package br.com.uanderson.designpatterns.structural_patterns.adapter.test;

import br.com.uanderson.designpatterns.structural_patterns.adapter.domain.TemperatureClassAdapter;

public class Client {//Client
    public static void main(String[] args) {
        TemperatureClassAdapter adapter = new TemperatureClassAdapter();
        adapter.setValue(30);//Passando um valor em Celsius que será convertido em Fahrenheit para o Temperature.

        System.out.println("CELSIUS: "+adapter.getValue());
        System.out.println("FAHRENHEIT: "+adapter.getValueInFahrenheit());

    }
}
