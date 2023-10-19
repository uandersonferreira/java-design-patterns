package br.com.uanderson.designpatterns.strategy.test;

import br.com.uanderson.designpatterns.strategy.domain.Person;
import br.com.uanderson.designpatterns.strategy.domain.RunMovement;
import br.com.uanderson.designpatterns.strategy.domain.WalkMovement;

public class App {
    public static void main(String[] args) {
        Person p = new Person("Uanderson");
        p.move(new RunMovement(), 50);
    }
}
