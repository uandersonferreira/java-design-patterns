package br.com.uanderson.designpatterns.templatemethod.test;

import br.com.uanderson.designpatterns.strategy.domain.Person;
import br.com.uanderson.designpatterns.strategy.domain.RunMovement;
import br.com.uanderson.designpatterns.strategy.domain.WalkMovement;
import br.com.uanderson.designpatterns.templatemethod.domain.Cha;
import br.com.uanderson.designpatterns.templatemethod.domain.Suco;

public class App {
    public static void main(String[] args) {
        Suco suco = new Suco();
        suco.PREPARAR();

        System.out.println("==============================");

        Cha cha = new Cha();
        cha.PREPARAR();
    }
}
