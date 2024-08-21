package br.com.uanderson.designpatterns.behavioral_patterns.templatemethod.domain;

public abstract class Bebida {
    public final void PREPARAR(){
        adicionarAgua();

        adicionarSubstancias();

        if (colocarAcucar()){
            adicionarAcucar();
        }

        mexer();
    }//method

    protected abstract void adicionarAgua();
    protected abstract void adicionarSubstancias();
    protected abstract boolean colocarAcucar();
    protected abstract void adicionarAcucar();
    protected abstract void mexer();

    /*
    Métodos Abstratos (Abstract Methods): Esses são os métodos declarados na classe abstrata, mas
    sem implementação. Eles representam os pontos onde as subclasses devem fornecer sua própria
    implementação. Cada subclasse que herda da classe abstrata deve implementar esses métodos.

    protected:
    Significa que, ele pode ser acessado a partir de qualquer classe no mesmo pacote e também por
    classes que herdam da classe que contém o membro (ou seja, suas subclasses).
     */

}//class
