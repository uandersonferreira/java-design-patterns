package br.com.uanderson.designpatterns.behavioral_patterns.observer.domain;

import javax.swing.*;

public class TextObserver  implements Observer {
    //CONCRETE OBSERVER
    private JTextField txtTemperature;

    public TextObserver(JTextField txtTemperature) {
        this.txtTemperature = txtTemperature;
    }

    @Override
    public void update(Subject subject) {
        WeatherForecast wf = (WeatherForecast) subject;
        txtTemperature.setText(String.valueOf(wf.getTemperature()));
    }
}
/*
    NÃO ADIANTA SÓ CRIAR UM OBSERVER, DEVEMOS REGISTRA-LO
    PARA QUE O SUBJECT SAIBA QUE ELE EXISTA E QUE DEVE
    SE NOTIFICADO QUANDO O MESMO SOFRER MUDANÇAS.
 */