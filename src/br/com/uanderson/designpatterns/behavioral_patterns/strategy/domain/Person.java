package br.com.uanderson.designpatterns.behavioral_patterns.strategy.domain;

public class Person {
    //CONTEXT - QUEM IRÁ FAZER A CHAMADA DAS ESTRATEGIAS E AS EXECUTAR
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public void move(Movement movement, int distance){
        System.out.println(name + " iniciou o movimento...");

        movement.move(distance);

        System.out.println(name + " terminou o movimento...");

        /*
            o padrão Strategy será usado para lidar com as várias formas
            de movimentos que uma pessoa pode ter, como por exemplo:
            - Andar, correr, pular...

            Por isso passamos a Interface e não a estrategia em si (Movimento),
            abstraindo as coisas. Dessa forma, validamos o principio do
            aberto e fechado, pois ela não irá mudar, mas poderá de espandir
            ou seja receber novos movimentos.

         */
    }
}
