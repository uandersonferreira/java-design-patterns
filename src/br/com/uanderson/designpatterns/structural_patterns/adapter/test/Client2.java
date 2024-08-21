package br.com.uanderson.designpatterns.structural_patterns.adapter.test;

import br.com.uanderson.designpatterns.structural_patterns.adapter.domain.Temperature;
import br.com.uanderson.designpatterns.structural_patterns.adapter.domain.TemperatureObjectAdapter;

public class Client2 {//Client
    public static void main(String[] args) {
        Temperature temperature = new Temperature();
       // temperature.setValue(86);
        /*
            Aqui estamos atribuindo a temperatura diretamente no atributo
            da instância de Temperature, então devemos passar o valor em FAHRENHEIT
            que é o esperado por default.
         */

        TemperatureObjectAdapter adapterObject = new TemperatureObjectAdapter(temperature);
        adapterObject.setValue(30);
        /*
            Já aqui estamos atribuinto o valor da temperatura através da instância
            do adapter, então devemos passar o valor em Celsius, que ele se encarregarar
            de fazer a conversão para FAHRENHEIT e setar em Temperature.
         */
        System.out.println("CELSIUS: "+adapterObject.getValue());
        System.out.println("FAHRENHEIT: "+ temperature.getValue());//Pegar o valor real salvo em Temperature

        /*
            Dessa forma, implementamos o padrão adapter com sucesso,
            pois o client que só entende Celsius, consegue conversar com
            o service que só entende FAHRENHEIT.
            Mais ou menos essa lógica srsrsr.
         */

    }
}
