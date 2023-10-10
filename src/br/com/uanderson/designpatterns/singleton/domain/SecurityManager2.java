package br.com.uanderson.designpatterns.singleton.domain;

public class SecurityManager2 {
    /*
     Atributo de classe, compartilhado por todas as instâncias da class
     criada diretamente, ou seja, é criada independente se foi solicitado
     ou não. podendo impactar no desempenho, por isso dever-se analisar
     o seu caso de uso.
     E não permite o tratamento de Exceptions caso ocorra.
     ex: private static SecurityManager2 instance = new SecurityManager2();

    */
    private static SecurityManager2 instance;
    static {
        try{
            //CARREGAMENTO 'Eager' ansioso, impaciente
            instance = new SecurityManager2();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        /*
            Essa mudança, faz com que seja possível: captar/pegar e tratar alguma
            exception, que pode vim ocorrer durante a criação da instância de
            SecurityManager.
         */
    }
    private SecurityManager2(){}
    
    public static SecurityManager2 getInstance(){
        //CARREGAMENTO 'Eager' ansioso, impaciente
        return instance;//Simplesmente retornamos a instância já criada anteriormente
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