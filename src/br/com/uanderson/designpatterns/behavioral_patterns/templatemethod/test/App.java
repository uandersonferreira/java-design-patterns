package br.com.uanderson.designpatterns.behavioral_patterns.templatemethod.test;

import br.com.uanderson.designpatterns.behavioral_patterns.templatemethod.domain.Cha;
import br.com.uanderson.designpatterns.behavioral_patterns.templatemethod.domain.Suco;

public class App {
    public static void main(String[] args) {
        Suco suco = new Suco();
        suco.PREPARAR();

        System.out.println("==============================");

        Cha cha = new Cha();
        cha.PREPARAR();
    }
}
