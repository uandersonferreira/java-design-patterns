package br.com.uanderson.designpatterns.templatemethod.domain;

public abstract class Bebida {
    public void preparar(){
        adicionarAgua();

        adicionarSubstancias();

        if (colocarAcucar()){
            adicionarAcucar();
        }

        mexer();
    }//method

    public abstract void adicionarAgua();
    protected abstract void adicionarSubstancias();
    protected abstract boolean colocarAcucar();
    protected abstract void adicionarAcucar();
    protected abstract void mexer();

}//class
