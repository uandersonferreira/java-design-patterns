package br.com.uanderson.designpatterns.templatemethod.domain;

public class Cha extends Bebida{
    /*
        Class concreta que herda da class abstrata(modelo) e
        assim modifica/sobreescrev o comportamento dos methods
        definidos com abstratos na super class.

     */
    @Override
    public void adicionarAgua() {
        System.out.println("Adicionando água ao Chá");
    }

    @Override
    protected void adicionarSubstancias() {
        System.out.println("Adicionando Chá");
    }

    @Override
    protected boolean colocarAcucar() {
        return false;
    }

    @Override
    protected void adicionarAcucar() {
        if (colocarAcucar())
            System.out.println("Adicionando açúcar ao Chá");
    }

    @Override
    protected void mexer() {
        System.out.println("Mexendo o Chá");
    }
}
