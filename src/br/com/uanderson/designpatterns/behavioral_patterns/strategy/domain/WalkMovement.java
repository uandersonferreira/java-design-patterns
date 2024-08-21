package br.com.uanderson.designpatterns.behavioral_patterns.strategy.domain;

public class WalkMovement implements Movement{
    //É UMA DAS ESTRATEGIAS CONCRETAS QUE IMPLEMENTA A INTERFACE SUPER QUE TEMOS

    @Override
    public void move(int distance) {
        int currentDistance = 0;

        while (currentDistance < distance){
            currentDistance++;

            try {
                Thread.sleep(300);

                if (currentDistance % 20 == 0){
                    Thread.sleep(300);
                    System.out.println("Parada para descanso...");
                }
                System.out.printf("Distância percorrida: %dm \n", currentDistance);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }//method move

}//class
