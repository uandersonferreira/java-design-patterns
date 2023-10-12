package br.com.uanderson.designpatterns.adapter.test;

import br.com.uanderson.designpatterns.adapter.domain.TemperatureClassAdapter;

public class Client {//Client
    public static void main(String[] args) {
        TemperatureClassAdapter adapter = new TemperatureClassAdapter();
        adapter.setValue(30);

        System.out.println("CELSIUS: "+adapter.getValue());
        System.out.println("FAHRENHEIT: "+adapter.getValueInFahrenheit());

    }
}
