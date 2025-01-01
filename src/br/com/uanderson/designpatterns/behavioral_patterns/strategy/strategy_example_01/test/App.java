package br.com.uanderson.designpatterns.behavioral_patterns.strategy.strategy_example_01.test;

import br.com.uanderson.designpatterns.behavioral_patterns.strategy.strategy_example_01.domain.Person;
import br.com.uanderson.designpatterns.behavioral_patterns.strategy.strategy_example_01.domain.RunMovement;

public class App {
    public static void main(String[] args) {
        Person p = new Person("Uanderson");
        p.move(new RunMovement(), 50);
    }
}
