package br.com.uanderson.designpatterns.singleton.domain;

public class SecurityManager {
    private static SecurityManager instance;//Atributo de classe, compartilhado por todas as instâncias da class
    private SecurityManager(){}
    
    public static SecurityManager getInstance(){
        //CARREGAMENTO PREGUIÇOSO 'LAZY'
        if (instance == null){//se nula irá criar a instância
            instance = new SecurityManager();//associar ao nosso atributo
        }
        //Se não for nula irá só retornnar a instância já criada, assim
        //garante que estaremos nós referenciado a mesma instância
        //independenete de onde SecurityManager estiver sendo chamado.
        return instance;
    }
    public void login(){
        
    }

}
/*
    SecurityManager representara um Gerenciador de segurança
    que está disponivel para a aplicação inteira.
    - Enão decidimos que não é necessaŕio mais de uma instância
    do mesmo.
    
    Como garantir isso?
    
    1° - Definir o construct como private, somente a class terá
    acesso ao mesmo.
    
    2° - Criar um atributo de classe privado do tipo da classe que estamos
    aplicando o singleton, no nosso caso SecurityManger.
    ex: private static SecurityManager instance;

    3° - Criar um method de classe publico, que irá criar a instÂncia quando for solicitada
     e então armazenda em nosso atributo de class criado e então retorna o mesmo, que contêm uma instância
    de SecurityManager, ou da class que desejar aplicar o padrão.


 */