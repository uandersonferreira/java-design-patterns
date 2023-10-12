package br.com.uanderson.designpatterns.adapter.domain;

public class TemperatureObjectAdapter {
    private Temperature temperature;//Composição

    public TemperatureObjectAdapter(Temperature temperature) {
        this.temperature = temperature;
    }

    public double getValue() {
        return ((temperature.getValue() - 32) * 5 ) / 9;
    }

    public void setValue(double value) {
       temperature.setValue( ( (value * 9) / 5 ) + 32);
    }
}
