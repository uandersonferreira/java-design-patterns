# Dependency Inversion Principle

"Depend on abstractions, not on concretions."

Dependa de abstrações e não de implementações.

- Um módulo de alto nível deve depender de módulos de baixo nível e ambos devem depender da abstração.

- PS: Inversão de Dependência não é igual a Injeção de Dependência.

---

### O que é o Princípio da Inversão de Dependência?  

O DIP nos diz que **"devemos depender de abstrações e não de implementações concretas"**. Em outras palavras, módulos de **alto nível** (ex.: regras de negócio) não devem depender diretamente de módulos de **baixo nível** (ex.: acessos a banco de dados). Ambos devem depender de uma **abstração** (ex.: interface ou classe abstrata).  

A inversão de dependência promove um design mais flexível. Pense em um **plug de tomada**: ele aceita qualquer aparelho desde que tenha o formato do plug, independentemente de ser uma TV, um ventilador ou um carregador de celular.  

---

### Exemplo de Violação do DIP  

Imagine que você está criando um sistema para processar pagamentos e tem uma classe `ProcessadorPagamento` que depende diretamente da classe `PagamentoCartao`.  

```java
// Implementação concreta
public class PagamentoCartao {
    public void processar() {
        System.out.println("Processando pagamento com cartão.");
    }
}

// Módulo de alto nível
public class ProcessadorPagamento {
    private PagamentoCartao pagamentoCartao;

    public ProcessadorPagamento() {
        this.pagamentoCartao = new PagamentoCartao();
    }

    public void executar() {
        pagamentoCartao.processar();
    }
}
```

O problema aqui é que `ProcessadorPagamento` depende diretamente da implementação concreta `PagamentoCartao`. Se amanhã você quiser adicionar um novo método de pagamento, como Pix ou boleto, terá que modificar o código original, o que quebra o **Open Closed Principle** e dificulta a manutenção.  

---

### Corrigindo com DIP  

Para aplicar o DIP, criamos uma **abstração** que define o comportamento esperado (interface ou classe abstrata) e fazemos com que as classes concretas implementem essa abstração.  

```java
// Abstração
public interface MetodoPagamento {
    void processar();
}

// Implementações concretas
public class PagamentoCartao implements MetodoPagamento {
    @Override
    public void processar() {
        System.out.println("Processando pagamento com cartão.");
    }
}

public class PagamentoPix implements MetodoPagamento {
    @Override
    public void processar() {
        System.out.println("Processando pagamento com Pix.");
    }
}

// Módulo de alto nível
public class ProcessadorPagamento {
    private MetodoPagamento metodoPagamento;

    // Injeção de dependência via construtor
    public ProcessadorPagamento(MetodoPagamento metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    public void executar() {
        metodoPagamento.processar();
    }
}

// Uso
public class Main {
    public static void main(String[] args) {
        MetodoPagamento pagamento = new PagamentoCartao();
        ProcessadorPagamento processador = new ProcessadorPagamento(pagamento);
        processador.executar();

        pagamento = new PagamentoPix();
        processador = new ProcessadorPagamento(pagamento);
        processador.executar();
    }
}
```

Com essa abordagem:  
- `ProcessadorPagamento` não depende mais de implementações concretas como `PagamentoCartao` ou `PagamentoPix`. Ele depende de `MetodoPagamento`, uma abstração.  
- Adicionar novos métodos de pagamento não exige alteração no código do `ProcessadorPagamento`, apenas uma nova classe que implemente `MetodoPagamento`.  

---

### Relações com Padrões de Projeto  

O DIP está fortemente ligado a vários padrões de projeto. Aqui estão alguns padrões e exemplos de como eles ajudam a aplicar o princípio:  

#### **Factory Method**  

Esse padrão cria objetos sem expor a lógica de criação ao cliente.  

**Exemplo**:  

```java
public abstract class FabricaPagamento {
    public abstract MetodoPagamento criarPagamento();
}

public class FabricaPagamentoCartao extends FabricaPagamento {
    @Override
    public MetodoPagamento criarPagamento() {
        return new PagamentoCartao();
    }
}

public class FabricaPagamentoPix extends FabricaPagamento {
    @Override
    public MetodoPagamento criarPagamento() {
        return new PagamentoPix();
    }
}

// Uso
public class Main {
    public static void main(String[] args) {
        FabricaPagamento fabrica = new FabricaPagamentoCartao();
        MetodoPagamento pagamento = fabrica.criarPagamento();
        pagamento.processar();

        fabrica = new FabricaPagamentoPix();
        pagamento = fabrica.criarPagamento();
        pagamento.processar();
    }
}
```

---

#### **Dependency Injection**  

Esse padrão facilita a injeção de dependências (ex.: interfaces) em vez de criar dependências concretas dentro da classe.  

**Exemplo** com framework Spring:  

```java
@Component
public class PagamentoCartao implements MetodoPagamento {
    @Override
    public void processar() {
        System.out.println("Processando pagamento com cartão.");
    }
}

@Component
public class ProcessadorPagamento {
    private final MetodoPagamento metodoPagamento;

    @Autowired
    public ProcessadorPagamento(MetodoPagamento metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    public void executar() {
        metodoPagamento.processar();
    }
}

// Configuração e uso
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Main.class, args);
        ProcessadorPagamento processador = context.getBean(ProcessadorPagamento.class);
        processador.executar();
    }
}
```

---

#### **Strategy**  

Esse padrão define uma família de algoritmos, encapsula cada um e os torna intercambiáveis.  

**Exemplo**:  

```java
public interface CalculoImposto {
    double calcular(double valor);
}

public class CalculoImpostoSimples implements CalculoImposto {
    @Override
    public double calcular(double valor) {
        return valor * 0.1;
    }
}

public class CalculoImpostoComplexo implements CalculoImposto {
    @Override
    public double calcular(double valor) {
        return valor * 0.2;
    }
}

public class SistemaFiscal {
    private CalculoImposto estrategia;

    public SistemaFiscal(CalculoImposto estrategia) {
        this.estrategia = estrategia;
    }

    public double aplicarImposto(double valor) {
        return estrategia.calcular(valor);
    }
}

// Uso
public class Main {
    public static void main(String[] args) {
        CalculoImposto simples = new CalculoImpostoSimples();
        SistemaFiscal sistema = new SistemaFiscal(simples);
        System.out.println("Imposto: " + sistema.aplicarImposto(1000));

        CalculoImposto complexo = new CalculoImpostoComplexo();
        sistema = new SistemaFiscal(complexo);
        System.out.println("Imposto: " + sistema.aplicarImposto(1000));
    }
}
```

---

### Pontos de Atenção ao Implementar o DIP  

1. **Evite Dependências Concretas**: Sempre prefira interfaces ou classes abstratas para definir comportamentos.  
2. **Use Injeção de Dependência**: Facilita o fornecimento de implementações concretas sem acoplar o código.  
3. **Teste Separadamente**: Como o DIP reduz acoplamento, fica mais fácil testar módulos de forma isolada.  


