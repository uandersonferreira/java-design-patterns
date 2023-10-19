package br.com.uanderson.designpatterns.templatemethod.domain;

public class Suco extends Bebida{
    @Override
    public void adicionarAgua() {
        System.out.println("Adicionando água ao suco");
    }

    @Override
    protected void adicionarSubstancias() {
        System.out.println("Adicionando suco");
    }

    @Override
    protected boolean colocarAcucar() {
        return true;
    }

    @Override
    protected void adicionarAcucar() {
        if (colocarAcucar())
            System.out.println("Adicionando açúcar ao suco");
    }

    @Override
    protected void mexer() {
        System.out.println("Mexendo o suco");
    }
}
