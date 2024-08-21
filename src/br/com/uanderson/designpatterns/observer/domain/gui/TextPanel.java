package br.com.uanderson.designpatterns.observer.domain.gui;

import br.com.uanderson.designpatterns.observer.domain.TextObserver;
import br.com.uanderson.designpatterns.observer.domain.WeatherForecast;

import javax.swing.*;


public class TextPanel extends JPanel {

    public TextPanel() {
        JTextField txtTemperature = new JTextField(20);
        txtTemperature.setEnabled(false);
        add(txtTemperature);
        /*
            Criando o novo observer  e registrando o mesmo na lista do
            Subject.
         */
        TextObserver observer = new TextObserver(txtTemperature);
        WeatherForecast.getInstance().registerObserver(observer);
    }
}
