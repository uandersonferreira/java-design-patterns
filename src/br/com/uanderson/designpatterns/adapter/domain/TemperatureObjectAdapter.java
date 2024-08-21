package br.com.uanderson.designpatterns.adapter.domain;

public class TemperatureObjectAdapter {
    private Temperature temperature;//Composição

    public TemperatureObjectAdapter(Temperature temperature) {
        this.temperature = temperature;
    }

    public double getValue() {
        return ((temperature.getValue() - 32) * 5 ) / 9;
        //Pega um value em Fahrenheit é convert para Celsius
        //Pois o client necessita/espera do/o valor em Celsius
    }

    public void setValue(double value) {//Valor em Celsius
       temperature.setValue( ( (value * 9) / 5 ) + 32);
        //Recebe um value em Celsius é convert para Fahrenheit
        //Pois por default Temperature é em Fahrenheit.
    }
}
