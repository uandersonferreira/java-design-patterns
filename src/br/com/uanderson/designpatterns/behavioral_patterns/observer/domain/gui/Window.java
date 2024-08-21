package br.com.uanderson.designpatterns.behavioral_patterns.observer.domain.gui;


public class Window {
    private JFrame frame;

    // Construtor da classe Window, que recebe um título, largura e altura como parâmetros
    public Window(String title, int width, int height) {
        // Inicializa o objeto JFrame
        frame = new JFrame();

        // Define o tamanho da janela com base nos parâmetros de largura e altura
        frame.setSize(width, height);

        // Define a localização inicial da janela na tela (coordenadas x, y)
        frame.setLocation(600, 400);

        // Define o título da janela
        frame.setTitle(title);

        // Define a operação padrão a ser executada quando a janela é fechada (fechar o aplicativo)
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Define o layout da janela como BorderLayout, que organiza os componentes em regiões
        frame.setLayout(new BorderLayout());

        // Adiciona um componente ChangeTemperaturePanel no centro da janela (região CENTER)
        frame.add(new ChangeTemperaturePanel(), BorderLayout.CENTER);

        // Adiciona um componente TextPanel na parte inferior da janela (região SOUTH)
        frame.add(new TextPanel(), BorderLayout.SOUTH);
    }

    // Método para tornar a janela visível
    public void show() {
        frame.setVisible(true);
    }
}
