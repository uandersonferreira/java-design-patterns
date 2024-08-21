package br.com.uanderson.designpatterns.behavioral_patterns.strategy.domain;

public interface Movement {
    // STRATEGY - INTERFACE SUPER QUE SERVIRÁ COMO MODELO PARA OS OBJECTS CONCRETES
    public void move(int distance);
}
