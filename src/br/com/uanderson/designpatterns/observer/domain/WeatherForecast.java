package br.com.uanderson.designpatterns.observer.domain;

import java.util.LinkedHashSet;
import java.util.Set;

public class WeatherForecast implements Subject {
    //CONCRETE SUBJECT - Generico e desacoplado
    private static WeatherForecast instance;
    private Set<Observer> observers = new LinkedHashSet<>();
    private int temperature;

    private WeatherForecast() {
    }

    public static WeatherForecast getInstance() {
        //Aplicando o padrão singleton

        if (instance == null) {
            instance = new WeatherForecast();
        }
        return instance;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        notifyObservers();
        /*
        QUANDO QUEREMOS QUE O 'notifyObservers' SEJA CHAMADO?
        - Neste contexto queremos, que seja chamado, quando temperature
        sofre alguma mudança/alteração. Então logo após o method setTemperature()
        se executado.
         */
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unregisterObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    /*
     QUANDO QUEREMOS QUE O 'notifyObservers' SEJA CHAMADO?
        - Neste contexto queremos, que seja chamado, quando temperature
        sofre alguma mudança/alteração. Então logo após o method setTemperature()
        se executado.


     Uso de this no Código:

    O método notifyObservers faz parte da classe que atua como Subject (Sujeito).
    No loop for, a variável observer é um objeto Observer (Observador) na lista de Observers (Observadores).

    Quando o método notifyObservers é chamado, ele percorre a lista de Observers e, para
    cada Observer na lista, chama o método update(this). O this passado como argumento para
    o método update é uma referência ao próprio objeto Subject que está notificando os Observers.

    O this no contexto de observer.update(this) significa que o Subject (este objeto) está
    informando o Observer de que ele (o Subject) mudou de estado. O this se refere ao
    objeto Subject que está chamando o método notifyObservers. Isso permite que o Observer
    saiba qual Subject está notificando-o, caso haja vários objetos Subject e o mesmo
    Observer esteja observando todos eles.

      private Set<Observer> observers = new LinkedHashSet<>();

      Permite um desacoplamento, pois não importa qual observer se têm registrado
      ou que queremos cadastrar ou remover ou registrar, todos são vistos como um
      Observer que possui interesse no Subject e essa implementação de Lista permite isso,
      pois basicamente armazerna uma lista de observers não repetidos é na ordem em que foram
      registrados.
     */
    }
}
