package br.com.uanderson.designpatterns.adapter.domain;

public class Temperature {//Target (alvo/service)
    //TEMPERATURE POR DEFAULT E EM FAHRENHEIT
    private double value;

    public double getValue(){
        return this.value;
    }

    public void  setValue(double value){
        this.value = value;
    }

}
