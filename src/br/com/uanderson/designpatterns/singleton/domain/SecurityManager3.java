package br.com.uanderson.designpatterns.singleton.domain;

public class SecurityManager3 {
    private static SecurityManager3 instance;//Atributo de classe, compartilhado por todas as instâncias da class
    private SecurityManager3(){}
    
    public static SecurityManager3 getInstance(){
        //CARREGAMENTO PREGUIÇOSO 'LAZY' - Para trabalhar com multiplas threads
        if (instance == null){//Se nulo irá criar uma seção crítica sincronizada
            synchronized (SecurityManager3.class){//Passando o objeto SecurityManager3.class como monitor de bloqueio
                if (instance == null){//Faz uma segunda verificação da instância, para ver se é nula
                    instance = new SecurityManager3();//se nula irá criar
                }
            }
        }
        return instance;

        /*
            Quando quemos aplicar o singleton em um cenário de
            multiplas threads, basta utilizar o 'synchronized' no
            method que já resolve, pois somente uma thread por vez irá ter acesso
            ao method. Mas issó pode acarretar em questões de desempenho, pois
            estamos sincronizando todo o method, e nesta implementação podemos utilizar uma
            outra abordagem, pois a questão do acesso simultanêo é somente na criação da
            instância, então iremos sincronizar apenas na criação da instância e realizar uma
            nova verificação, pois pode ocorrer de mais de uma thread ler a primeira verificação.
         */
    }

    public synchronized static SecurityManager3 getInstance2(){
        //CARREGAMENTO PREGUIÇOSO 'LAZY' - Para trabalhar com multiplas threads
        if (instance == null){//se nula irá criar a instância
            instance = new SecurityManager3();//associar ao nosso atributo
        }
        //Se não for nula irá só retornnar a instância já criada, assim
        //garante que estaremos nós referenciado a mesma instância
        //independenete de onde SecurityManager estiver sendo chamado.
        return instance;

        /*
            Quando quemos aplicar o singleton em um cenário de
            multiplas threads, basta utilizar o 'synchronized' no
            method que já resolve, pois somente uma thread por vez irá ter acesso
            ao method.
         */
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

EXPLICAÇÃO GERADA PELO CHAT DO NOSSO METHOD:

    public static SecurityManager3 getInstance():
    - Este é um método estático que fornece acesso à
      única instância da classe SecurityManager3.

    if (instance == null):
    - A primeira verificação verifica se a instância já foi criada.
     Se a instância já existir, o método retorna essa instância.

    synchronized (SecurityManager3.class):
    - Se a instância ainda não foi criada (ou seja, instance == null),
     o código entra em uma seção crítica sincronizada usando SecurityManager3.class
     como o monitor de bloqueio. Isso garante que apenas um thread por vez possa
     prosseguir para criar a instância.

    if (instance == null):
    - Dentro da seção crítica, uma segunda verificação é feita para
     garantir que nenhuma outra thread tenha criado a instância enquanto
     esperava pelo bloqueio. Se a instância ainda for nula, uma nova
     instância de SecurityManager3 é criada.

    return instance:
     - A instância (seja a recém-criada ou a já existente)
      é retornada para o chamador.

 */