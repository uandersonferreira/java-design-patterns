package br.com.uanderson.designpatterns.behavioral_patterns.strategy.test;

import br.com.uanderson.designpatterns.behavioral_patterns.strategy.domain.Person;
import br.com.uanderson.designpatterns.behavioral_patterns.strategy.domain.RunMovement;

public class App {
    public static void main(String[] args) {
        Person p = new Person("Uanderson");
        p.move(new RunMovement(), 50);
    }
}
