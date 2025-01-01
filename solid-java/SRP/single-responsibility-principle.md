# Single Responsibility Principle

"A class should have one, and only one, reason to change."

Uma classe deve ter um, e somente um, motivo para mudar.

- A classe deve possuir **uma única responsabilidade** dentro do software. 

### O que é o Single Responsibility Principle (SRP)?

Vamos começar com o básico. O SRP, ou Princípio da Responsabilidade Única, é um dos pilares dos princípios S.O.L.I.D., que são um conjunto de boas práticas para o desenvolvimento de software orientado a objetos. Em termos simples, o SRP diz que **uma classe deve ter apenas uma responsabilidade**. Isso significa que cada classe ou componente do sistema deve ser responsável por uma única parte da funcionalidade do sistema.

**Por que isso é importante?**  
Imagine que você está construindo um prédio. Se você contratar um pedreiro para fazer todas as tarefas — desde levantar as paredes até pintar as portas — ele vai se sobrecarregar e você pode acabar com um prédio cheio de problemas. O mesmo vale para o código: se uma classe tiver muitas responsabilidades, ela vai se tornar difícil de entender, de modificar e de testar. Além disso, mudanças em uma parte do sistema podem acabar afetando outras áreas de forma indesejada. A ideia do SRP é evitar isso, criando classes mais simples e especializadas.

### SRP + PADRÕES DE PROJETOS

O **Princípio da Responsabilidade Única (SRP)** está diretamente relacionado a alguns **padrões de projeto** (design patterns), que visam separar e isolar responsabilidades para tornar o código mais modular, flexível e de fácil manutenção. Vamos explorar como o SRP se relaciona com alguns desses padrões.

### 1. **Padrão Strategy**
O padrão **Strategy** é um exemplo claro de como aplicar o SRP em um cenário de design de software. Ele permite que você defina uma família de algoritmos, encapsule cada um deles e os torne intercambiáveis. O objetivo é que a responsabilidade de cada algoritmo seja separada em diferentes classes, de modo que cada uma tenha uma única responsabilidade.

#### Exemplo de aplicação do SRP com Strategy:
Se tivermos uma classe `OrdemDeCompra` que realiza diferentes cálculos de desconto para uma ordem, ao invés de ter toda a lógica de cálculo dentro de `OrdemDeCompra`, podemos usar o padrão **Strategy** para delegar essa responsabilidade a diferentes classes que implementam uma interface comum.

```java
// Interface de cálculo de desconto
public interface Desconto {
    BigDecimal calcularDesconto(OrdemDeCompra ordemDeCompra);
}

// Estratégia de desconto para clientes VIP
public class DescontoVIP implements Desconto {
    @Override
    public BigDecimal calcularDesconto(OrdemDeCompra ordemDeCompra) {
        return ordemDeCompra.calcularTotal().multiply(new BigDecimal(0.2)); // 20% de desconto
    }
}

// Estratégia de desconto para clientes normais
public class DescontoNormal implements Desconto {
    @Override
    public BigDecimal calcularDesconto(OrdemDeCompra ordemDeCompra) {
        return ordemDeCompra.calcularTotal().multiply(new BigDecimal(0.05)); // 5% de desconto
    }
}

// Classe OrdemDeCompra agora delega o cálculo de desconto a uma estratégia
public class OrdemDeCompra {
    private List<Produto> produtos;
    private Desconto descontoStrategy;

    public OrdemDeCompra(Desconto descontoStrategy) {
        this.descontoStrategy = descontoStrategy;
    }

    public BigDecimal calcularTotal() {
        BigDecimal total = BigDecimal.ZERO;
        for (Produto produto : produtos) {
            total = total.add(produto.getPreco());
        }
        return total.subtract(descontoStrategy.calcularDesconto(this)); // Aplica o desconto
    }
}
```

Nesse exemplo, o cálculo do desconto foi delegado a classes separadas (`DescontoVIP`, `DescontoNormal`), cada uma com a responsabilidade de calcular o desconto de uma forma específica. A classe `OrdemDeCompra` agora tem uma única responsabilidade: **gerenciar os produtos e calcular o total**, enquanto o cálculo do desconto fica nas classes de estratégia.

### 2. **Padrão Observer**
O padrão **Observer** também pode ser visto como uma forma de aplicar o SRP. O objetivo do padrão Observer é permitir que um objeto (chamado de *subject*) notifique automaticamente outros objetos (chamados de *observers*) sobre mudanças no seu estado. Assim, a responsabilidade de notificar os observadores é separada da lógica do objeto principal, aderindo ao SRP.

#### Exemplo de aplicação do SRP com Observer:
No caso da `OrdemDeCompra`, se quisermos enviar e-mails ou atualizar uma interface do usuário sempre que o status de uma ordem mudar, podemos usar o padrão **Observer** para separar essa responsabilidade de outros processos.

```java
// Interface do Observer
public interface Observer {
    void atualizar(OrdemDeCompra ordemDeCompra);
}

// Classe que envia e-mail
public class NotificadorEmail implements Observer {
    @Override
    public void atualizar(OrdemDeCompra ordemDeCompra) {
        // Lógica para enviar e-mail
        System.out.println("Enviando e-mail para " + ordemDeCompra.getCliente().getEmail());
    }
}

// Classe OrdemDeCompra agora notifica seus observers
public class OrdemDeCompra {
    private List<Observer> observers = new ArrayList<>();
    private Status status;

    public void adicionarObserver(Observer observer) {
        observers.add(observer);
    }

    public void removerObserver(Observer observer) {
        observers.remove(observer);
    }

    public void mudarStatus(Status novoStatus) {
        this.status = novoStatus;
        notificarObservers();
    }

    private void notificarObservers() {
        for (Observer observer : observers) {
            observer.atualizar(this);
        }
    }
}
```

Neste caso, a `OrdemDeCompra` não precisa mais se preocupar com o envio de e-mails ou outras ações associadas ao status da ordem. A responsabilidade de notificar sobre mudanças de estado foi delegada para os objetos que implementam a interface `Observer`.

### 3. **Padrão Factory**
O padrão **Factory** também se relaciona com o SRP, pois ele centraliza a criação de objetos em um único lugar, permitindo que a classe principal se concentre em sua funcionalidade específica sem se preocupar com o processo de criação de instâncias.

#### Exemplo de aplicação do SRP com Factory:
Vamos supor que você precise criar diferentes tipos de ordens de compra com diferentes comportamentos (por exemplo, ordens com diferentes formas de pagamento). Você poderia usar um **Factory** para criar essas ordens, centralizando a criação dos objetos e permitindo que a classe `OrdemDeCompra` se concentre apenas em suas responsabilidades de manipulação de produtos e cálculos.

```java
// Interface para diferentes tipos de ordens de compra
public interface TipoOrdemDeCompra {
    void aplicarDesconto(OrdemDeCompra ordemDeCompra);
}

// Implementação do tipo de ordem com pagamento à vista
public class OrdemAVista implements TipoOrdemDeCompra {
    @Override
    public void aplicarDesconto(OrdemDeCompra ordemDeCompra) {
        // Aplica desconto específico para pagamento à vista
        ordemDeCompra.calcularTotal().multiply(new BigDecimal(0.1)); // 10% de desconto
    }
}

// Fábrica que cria diferentes tipos de ordens de compra
public class OrdemDeCompraFactory {
    public static OrdemDeCompra criarOrdemDeCompra(TipoOrdemDeCompra tipo) {
        OrdemDeCompra ordemDeCompra = new OrdemDeCompra();
        // Aplica o tipo de desconto conforme o tipo de pagamento
        tipo.aplicarDesconto(ordemDeCompra);
        return ordemDeCompra;
    }
}
```

Com a **Factory**, a classe `OrdemDeCompra` não precisa mais se preocupar com a criação do tipo específico de ordem ou com o cálculo de descontos baseados no tipo de pagamento. Isso torna o código mais limpo e aderente ao SRP.

### Conclusão

Embora o **Princípio da Responsabilidade Única (SRP)** não seja um padrão de design por si só, ele está profundamente relacionado a vários padrões de projeto. A ideia central do SRP é **delegar responsabilidades específicas** a diferentes partes do sistema, o que é uma característica comum em padrões como **Strategy**, **Observer** e **Factory**. Esses padrões ajudam a organizar o código de forma que cada classe ou componente tenha uma única responsabilidade, tornando o sistema mais modular, flexível e fácil de manter.