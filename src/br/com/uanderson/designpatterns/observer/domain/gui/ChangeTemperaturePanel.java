package br.com.uanderson.designpatterns.observer.domain.gui;


import br.com.uanderson.designpatterns.observer.domain.WeatherForecast;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangeTemperaturePanel extends JPanel implements ActionListener {

    private JComboBox<Integer> temperatureCbo;

    // Construtor da classe ChangeTemperaturePanel
    public ChangeTemperaturePanel() {
        // Valores disponíveis para seleção na caixa de combinação
        Integer[] values = { 0, 5, 10, 15, 20, 25, 30 };

        // Inicializa o JComboBox com os valores
        temperatureCbo = new JComboBox<>(values);

        // Registra esta classe como ouvinte para eventos de ação do JComboBox
        temperatureCbo.addActionListener(this);

        // Adiciona um rótulo "Temperatura:" ao painel
        add(new JLabel("Temperatura:"));

        // Adiciona o JComboBox ao painel
        add(temperatureCbo);
    }

    // Método chamado quando um evento de ação ocorre no JComboBox
    //Toda vez a temperatura é mudada
    @Override
    public void actionPerformed(ActionEvent event) {
        // Obtém a temperatura selecionada do JComboBox
        Integer temperature = (Integer) temperatureCbo.getSelectedItem();

        // Define a temperatura no objeto WeatherForecast usando um Singleton
        WeatherForecast.getInstance().setTemperature(temperature);
    }
}
