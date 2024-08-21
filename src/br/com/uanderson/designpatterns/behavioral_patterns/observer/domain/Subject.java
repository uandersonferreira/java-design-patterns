package br.com.uanderson.designpatterns.behavioral_patterns.observer.domain;

public interface Subject {//Estrutura/modelo generica a se seguida
    //TÊM QUE TER A CAPACIDADE DE REGISTRAR/DELETAR REGISTRO E NOTIFICAR
    // QUEM ESTÁ INTERESSADO EM SUAS MUDANÇAS

    public void registerObserver(Observer observer);
    public void unregisterObserver(Observer observer);
    public void notifyObservers();

}
