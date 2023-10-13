package br.com.uanderson.designpatterns.adapter.domain;

public class TemperatureClassAdapter extends Temperature{//Adapter de class - herança
    //Extend o que estamos adaptando  e sobrescrevemos os methods para se comunicar
    //com o client que irá chamar o Adapter.
    @Override
    public double getValue() {
        return ((super.getValue() - 32) * 5 ) / 9;
        //Pega um value em Fahrenheit é convert para Celsius
        //Pois o client necessita/espera do/o valor em Celsius
    }

    @Override
    public void setValue(double value) {//Valor em Celsius
        super.setValue( ( (value * 9) / 5 ) + 32);
        //Recebe um value em Celsius é convert para Fahrenheit
        //Pois por default Temperature é em Fahrenheit.

    }

    //Podemos ter outros methods, além  dos que devemos sobrescrever
    public double getValueInFahrenheit(){
        return super.getValue();
        //Retorna o valor de Temperature em Fahrenheit que foi convertido no setValue()
    }
}
