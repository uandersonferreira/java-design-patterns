package br.com.uanderson.designpatterns.observer.domain;

public interface Observer {//Estrutura/modelo generica a se seguido
    //TÊM QUE TER A CAPACIDADE DE NOTIFICAR QUEM ESTÁ INTERESSADO NAS MUDANÇAS
    public void update(Subject subject);
    /*
        Quando chamado devemos passar um Subject, que é quem irá
        fazer a chamada ao update() como parametro, ou seja o Subject
        irá se passar como parametro.

     */
}
