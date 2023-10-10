package br.com.uanderson.designpatterns.singleton.test;

import br.com.uanderson.designpatterns.singleton.domain.SecurityManager;

public class Main {
    public static void main(String[] args) {
        SecurityManager sm1 = SecurityManager.getInstance();
        sm1.login();

        //Poderia ser em outro local da aplicação
        SecurityManager sm2 = SecurityManager.getInstance();
        sm2.login();

    }//main
}//class
