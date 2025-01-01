package br.com.uanderson.designpatterns.behavioral_patterns.strategy.strategy_example_01.domain;

public interface Movement {
    // STRATEGY - INTERFACE SUPER QUE SERVIRÁ COMO MODELO PARA OS OBJECTS CONCRETES
    public void move(int distance);
}
