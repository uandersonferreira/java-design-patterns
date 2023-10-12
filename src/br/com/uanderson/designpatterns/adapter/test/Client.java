package br.com.uanderson.designpatterns.adapter.test;

import br.com.uanderson.designpatterns.adapter.domain.Temperature;
import br.com.uanderson.designpatterns.adapter.domain.TemperatureClassAdapter;
import br.com.uanderson.designpatterns.adapter.domain.TemperatureObjectAdapter;

public class Client {//Client
    public static void main(String[] args) {
        TemperatureClassAdapter adapter = new TemperatureClassAdapter();
        adapter.setValue(30);

        System.out.println("CELSIUS: "+adapter.getValue());
        System.out.println("FAHRENHEIT: "+adapter.getValueInFahrenheit());
        System.out.println("---------------- OBJECT ------------");

        Temperature temperature = new Temperature();
        temperature.setValue(86);
        TemperatureObjectAdapter adapterObject = new TemperatureObjectAdapter(temperature);

        System.out.println("CELSIUS: "+adapterObject.getValue());
        System.out.println("FAHRENHEIT: "+ temperature.getValue());

    }
}
