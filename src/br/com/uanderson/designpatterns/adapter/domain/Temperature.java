package br.com.uanderson.designpatterns.adapter.domain;

public class Temperature {//Target
    private double value;

    public double getValue(){
        return this.value;
    }

    public void  setValue(double value){
        this.value = value;
    }

}
/*
TEMPERATURE POR DEFAULT E EM FAHRENHEIT

- Mas caso eu precise em Celsius ?


 */