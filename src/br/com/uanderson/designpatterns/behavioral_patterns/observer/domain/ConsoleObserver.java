package br.com.uanderson.designpatterns.behavioral_patterns.observer.domain;

public class ConsoleObserver implements Observer {
    //CONCRETE OBSERVER
    @Override
    public void update(Subject subject) {
        WeatherForecast wf = (WeatherForecast) subject;
        System.out.println("Temperature: "+wf.getTemperature());
    }
    /*
        OBSERVADOR IMPLEMENTADO, AGORA BASTA REGISTRAR-SE EM
        WeatherForecast para poder receber as notifações, das mudanças da
        temperatura.
     */
}
