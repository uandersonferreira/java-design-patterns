package br.com.uanderson.designpatterns.adapter.domain;

public class Temperature {//Target (alvo/service)
    //TEMPERATURE POR DEFAULT E EM FAHRENHEIT
    private double value;

    public double getValue(){
        return this.value;//Sempre deve ser expresso em FAHRENHEIT
    }

    public void  setValue(double value){
        this.value = value;
        //Receber um value em FAHRENHEIT
    }

}
