package br.com.uanderson.designpatterns.adapter.domain;

public class TemperatureClassAdapter extends Temperature{
    @Override
    public double getValue() {
        return ((super.getValue() - 32) * 5 ) / 9;
        //Pega um value em Fahrenheit é convert para Celsius
    }

    @Override
    public void setValue(double value) {
        super.setValue( ( (value * 9) / 5 ) + 32);
        //Recebe um value em Fahrenheit é convert para Celsius
    }

    public double getValueInFahrenheit(){
        return super.getValue();
    }
}
