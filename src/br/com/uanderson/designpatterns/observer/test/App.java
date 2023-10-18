package br.com.uanderson.designpatterns.observer.test;

import br.com.uanderson.designpatterns.observer.domain.ConsoleObserver;
import br.com.uanderson.designpatterns.observer.domain.WeatherForecast;
import br.com.uanderson.designpatterns.observer.domain.gui.Window;

public class App {
    public static void main(String[] args) {
        ConsoleObserver observer = new ConsoleObserver();//Criando uma instância do Observador(interessado)
        WeatherForecast.getInstance().registerObserver(observer);
        /*
            Pegando a instância do Observado(sujeito por quem se têm interesses)
            e chamando o method de registro para registrar o interessado criado.
        */

        Window window = new Window("Temperatura", 300, 150);
        window.show();
    }
}
