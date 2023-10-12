# Design Patter Adapter
![Design Pattern Adapter](../../../../../../.github/img/adapter.png)

Esta implementação usa o princípio da composição do objeto: o adaptador implementa a interface de um objeto e envolve o outro. Pode ser implementado em todas as linguagens de programação populares.

![Design Pattern Adapter](../../../../../../.github/img/adapter-02.png)

O padrão de projeto Adapter é um padrão estrutural que permite que objetos 
com interfaces incompatíveis trabalhem juntos. Ele atua como um intermediário 
que conecta duas interfaces incompatíveis, permitindo que elas colaborem.

O padrão Adapter é útil em situações em que você tem duas classes com 
interfaces diferentes, mas deseja que elas possam interagir de maneira 
transparente. Isso é especialmente útil ao trabalhar com código legado 
ou bibliotecas de terceiros que não podem ser facilmente modificadas para
se adequar à interface desejada.

Aqui estão os principais elementos do padrão Adapter:

- Cliente: O cliente é a classe que deseja interagir com o objeto adaptado.
    Ele possui uma referência para a interface de destino.

- Alvo (Target): O alvo define a interface desejada que o cliente usa para
    interagir com o objeto adaptado. O alvo é geralmente uma interface ou classe abstrata.

-  Adaptador (Adapter): O adaptador é uma classe que implementa a interface de destino
    e mantém uma referência ao objeto que precisa ser adaptado. Ele atua como uma camada
    intermediária que traduz chamadas do cliente para o objeto adaptado.

- Adaptado (Adaptee): O adaptado é a classe existente com a interface incompatível.
    O adaptador é responsável por encapsular o adaptado e fornecer uma interface 
    compatível com o cliente

## Pós e Contras
- Princípio da responsabilidade única: Você pode separar a interface ou o código de conversão 
de dados da lógica de negócios principal do programa.

- Princípio aberto/com fundamento. Você pode introduzir novos tipos de adaptadores no programa
sem quebrar o código do cliente existente, desde que eles trabalhem com os adaptadores 
através da interface do cliente

- CONTRA: A complexidade geral do código aumenta porque você precisa introduzir um conjunto de
novas interfaces e classes. Por vezes, é mais simples apenas alterar a classe de 
serviço para que ela corresponda ao resto do seu código.