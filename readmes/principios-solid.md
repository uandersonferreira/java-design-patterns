# Principios do S.O.L.I.D 

> Note: Explicação gerada por IA

[S]ingle Responsibility Principle (Princípio da Responsabilidade Única)

[O]pen/Closed Principle (Princípio do Aberto/Fechado)

[L]iskov Substitution Principle (Princípio da Substituição de Liskov)

[I]nterface Segregation Principle (Princípio da Segregação de Interfaces)

[D]ependency Inversion Principle (Princípio da Inversão de Dependências)



### [S]ingle Responsibility Principle (Princípio da Responsabilidade Única)
**Definição:** Uma classe deve ter uma única responsabilidade, ou seja, ela deve lidar apenas com uma parte específica da funcionalidade do sistema. Se precisar mudar, será por uma única razão.

**Analogia:** Pense em um chef de cozinha que é responsável apenas pela preparação dos pratos. Se o chef também for encarregado de atender as mesas e lavar os pratos, ele estará sobrecarregado, o que pode causar erros. Separando as responsabilidades, cada pessoa tem um foco claro.

**Comparação com sistema real:** Imagine que você está desenvolvendo um sistema de pedidos de uma loja online. Você tem uma classe `Pedido`. Se essa classe gerencia o processamento do pedido, a atualização do estoque e o envio de notificações ao cliente, ela está sobrecarregada. O SRP sugere que essas responsabilidades sejam separadas em classes diferentes. Por exemplo, você pode ter uma classe `GerenciadorDePedidos` que cuida do processamento do pedido, uma `GerenciadorDeEstoque` que ajusta os níveis de estoque, e uma `Notificador` que envia notificações.

**Exemplo em Java:**
```java
// Violação do SRP: Uma classe que faz muitas coisas.
class Pedido {
    void processar() { /* lógica de processamento */ }
    void atualizarEstoque() { /* lógica de atualização do estoque */ }
    void enviarNotificacao() { /* lógica de envio de notificações */ }
}


// Correção: Cada classe tem uma responsabilidade clara.
class GerenciadorDePedidos {
    void processarPedido() { /* lógica de processamento */ }
}

class GerenciadorDeEstoque {
    void atualizarEstoque() { /* lógica de atualização de estoque */ }
}

class Notificador {
    void enviarNotificacao() { /* lógica de envio de notificações */ }
}
```

---

### [O]pen/Closed Principle (Princípio do Aberto/Fechado)
**Definição:** O código deve estar aberto para extensão (novas funcionalidades), mas fechado para modificação (não precisa alterar o código existente).

**Analogia:** Imagine que sua casa precisa de uma reforma. Em vez de destruir a estrutura para expandir um cômodo, você pode adicionar uma nova sala sem afetar o que já existe. Assim, a casa cresce sem ser destruída.

**Comparação com sistema real:** Suponha que você tenha um sistema de pagamentos que atualmente aceita apenas cartões de crédito. Se você precisar adicionar pagamentos via PayPal ou criptomoeda, o OCP sugere que você estenda o sistema sem modificar o código existente. Para isso, você pode criar uma interface `MeioDePagamento` e implementar diferentes classes para cada tipo de pagamento, sem alterar a lógica principal do sistema.

**Exemplo em Java:**
```java
// Correção: Adicionamos novos tipos de pagamento sem modificar a lógica de pagamento existente.
interface MeioDePagamento {
    void processarPagamento();
}

class CartaoDeCredito implements MeioDePagamento {
    public void processarPagamento() { /* lógica de pagamento com cartão de crédito */ }
}

class PayPal implements MeioDePagamento {
    public void processarPagamento() { /* lógica de pagamento com PayPal */ }
}
```

---

### [L]iskov Substitution Principle (Princípio da Substituição de Liskov)
**Definição:** Se uma classe filha é substituída pela classe mãe, o comportamento esperado do sistema não deve mudar. O subtipo deve ser substituível pela classe base sem problemas.

**Analogia:** Se você substitui um carro por outro, ambos devem ser capazes de dirigir. Um carro novo não deve perder funcionalidades básicas, como frear ou acelerar.
**Comparação com sistema real:** Imagine um sistema de gerenciamento de veículos para uma frota. Se você tem uma classe `Veiculo`, e subtipos como `Carro` e `Caminhao`, o princípio de Liskov diz que, ao substituir um veículo por outro (seja um carro ou caminhão), o sistema deve continuar funcionando conforme o esperado. Ou seja, ambos os subtipos devem implementar a funcionalidade de maneira consistente.

**Exemplo em Java:**
```java
// Violação do LSP: Um subtipo altera o comportamento esperado.


// Correção: Todos os subtipos devem cumprir o comportamento (method) esperado.
abstract class Veiculo {
    abstract void acelerar();
}

class Carro extends Veiculo {
    void acelerar() { System.out.println("Carro acelerando"); }
}

class Caminhao extends Veiculo {
    void acelerar() { System.out.println("Caminhão acelerando"); }
}
```

---

### [I]nterface Segregation Principle (Princípio da Segregação de Interfaces)
**Definição:** Uma classe não deve ser forçada a implementar interfaces que não utiliza. Interfaces menores e mais específicas são melhores do que interfaces grandes e genéricas.

**Analogia:** Imagine que você é um mecânico. Se você também fosse obrigado a trabalhar como eletricista e encanador, estaria sobrecarregado com funções irrelevantes para o seu trabalho principal.

**Comparação com sistema real:** Suponha que você tenha um sistema de gerenciamento de usuários com diferentes tipos de contas: `ContaBancaria` e `ContaInvestimento`. Se ambas as classes implementam uma interface `Conta` que contém métodos como `depositar`, `sacar` e `investir`, mas `ContaBancaria` não utiliza o método `investir`, ela estaria sendo forçada a implementar algo que não precisa. Seguindo o ISP, você pode separar as interfaces em `TransacoesBasicas` (com métodos `depositar` e `sacar`) e `Investimentos` (com o método `investir`).

**Exemplo em Java:**
```java
// Violação do ISP: Interface grande com métodos irrelevantes para algumas classes.


// Correção: Interfaces menores e mais específicas.
interface TransacoesBasicas {
    void depositar();
    void sacar();
}

interface Investimentos {
    void investir();
}

class ContaBancaria implements TransacoesBasicas {
    public void depositar() { /* lógica de depósito */ }
    public void sacar() { /* lógica de saque */ }
}

class ContaInvestimento implements TransacoesBasicas, Investimentos {
    public void depositar() { /* lógica de depósito */ }
    public void sacar() { /* lógica de saque */ }
    public void investir() { /* lógica de investimento */ }
}
```

---

### [D]ependency Inversion Principle (Princípio da Inversão de Dependências)
**Definição:** Dependa de abstrações (interfaces), não de implementações concretas. Isso permite que as classes de alto nível e baixo nível não fiquem acopladas diretamente.

**Analogia:** Pense em um carro. Você não precisa saber como cada peça funciona internamente (bateria, motor). Você só precisa saber que o carro funciona com essas abstrações (combustível, energia), independente da marca ou modelo.

**Comparação com sistema real:** Em um sistema de envio de e-mails, em vez de uma classe `ServicoEmail` depender diretamente de uma implementação concreta como `GmailService`, ela deve depender de uma interface abstrata `EmailService`. Dessa forma, a implementação concreta (como `GmailService` ou `YahooMailService`) pode ser trocada sem afetar o código que depende dela.

**Exemplo em Java:**
```java
// Violação do DIP: Depende de classes concretas.
class SistemaDeNotificacao {
    private GmailService gmailService = new GmailService();

    void notificar() {
        gmailService.enviarEmail();
    }
}


// Correção: Depender de uma abstração.
interface EmailService {
    void enviarEmail(String destinatario, String mensagem);
}

class GmailService implements EmailService {
    public void enviarEmail(String destinatario, String mensagem) {
        // Lógica para enviar email via Gmail
    }
}

class Notificador {
    private EmailService emailService;

    public Notificador(EmailService emailService) {
        this.emailService = emailService;
    }

    void notificarUsuario(String mensagem) {
        emailService.enviarEmail("usuario@dominio.com", mensagem);
    }
}
```

