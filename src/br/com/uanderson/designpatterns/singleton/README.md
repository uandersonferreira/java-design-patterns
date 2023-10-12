# Design Patter Singleton
![Design Pattern Singleton](../../../../../../.github/img/singleton.png)

Tem como objetivo, garantir que uma classe tenha **apenas uma única instância  durante a execução da aplicação**
e forneça um ponto global de acesso para essa instância. Em outras palavras, o Singleton assegura
que uma determinada classe tenha uma única instância em toda a aplicação e fornece um meio
de acessar essa instância de forma global.

#### Principais características do Singleton:


-  Uma única instância: O Singleton garante que apenas uma única instância da classe seja
   criada durante o ciclo de vida da aplicação.

-  Acesso global: Ele oferece um método ou propriedade para acessar essa única instância a
   partir de qualquer lugar da aplicação.

-  Lazy initialization: Normalmente, a instância Singleton é criada sob demanda, ou seja,
   apenas quando é solicitada pela primeira vez. Isso ajuda a economizar recursos, pois a instância
   não é criada desnecessariamente.

-  Controle de acesso: O Singleton controla o acesso concorrente para garantir que apenas uma
   thread possa criar a instância e que todas as outras threads obtenham a referência para a
   instância já existente.

-  Globalmente visível: A instância Singleton é globalmente visível, o que significa que todos
   os objetos que precisam acessá-la podem fazer isso facilmente, sem a necessidade de criar
   novas instâncias.
