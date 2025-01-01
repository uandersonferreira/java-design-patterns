# Open Closed Principle

"You should be able to extend a classes behavior, without modifying it."

Você deve poder estender um comportamento de classe, sem modificá-lo.

- Objetos devem estar abertos para extensão, mas fechados para modificações.

- Quando novos comportamentos precisam ser adicionados no siftware, devemos estender e não alterar
o código fonte original.


### O que significa o Open Closed Principle?

O Open Closed Principle (ou OCP para os íntimos) diz:

**“Você deve poder estender o comportamento de uma classe sem modificar seu código original.”**

Isso quer dizer que nossas classes devem ser:

- **Abertas para extensão**: Devemos conseguir adicionar novas funcionalidades quando o sistema precisar.
- **Fechadas para modificações**: O código original não deve ser alterado diretamente, para evitar efeitos colaterais e bugs inesperados.

Imagine um carro. Você pode instalar novos acessórios (como um som mais moderno ou um teto solar) sem precisar mexer no motor ou na estrutura original do veículo. Com classes, a ideia é a mesma: adicionar funcionalidades sem “mexer no motor”.

---

### Por que isso é importante?

No dia a dia de um desenvolvedor, você trabalha em equipe, muitas vezes mexendo em códigos que outros criaram. Quando você modifica diretamente uma classe, pode causar problemas em partes do sistema que dependem dela. O OCP nos protege desse caos, permitindo que o sistema evolua de forma organizada e segura.

---

### Implementando o Open Closed Principle na prática com Java

#### Problema com um sistema "rígido"
Suponha que você tenha uma classe que calcula o salário de diferentes tipos de funcionários:

```java
public class SalaryCalculator {
    public double calculateSalary(String employeeType, double baseSalary) {
        if (employeeType.equals("Manager")) {
            return baseSalary * 1.5;
        } else if (employeeType.equals("Developer")) {
            return baseSalary * 1.2;
        } else {
            return baseSalary;
        }
    }
}
```

A classe funciona bem – até que o cliente decide adicionar um novo tipo de funcionário, como "Estagiário". Agora você precisa abrir o código, adicionar mais um `else if`, e corre o risco de introduzir bugs ou quebrar algo.

#### Solução seguindo o OCP
A solução é tornar a classe **extensível**, usando polimorfismo. Veja como:

1. **Defina uma interface**:

```java
public interface SalaryRule {
    double calculate(double baseSalary);
}
```

2. **Implemente regras específicas para cada tipo de funcionário**:

```java
public class ManagerSalaryRule implements SalaryRule {
    @Override
    public double calculate(double baseSalary) {
        return baseSalary * 1.5;
    }
}

public class DeveloperSalaryRule implements SalaryRule {
    @Override
    public double calculate(double baseSalary) {
        return baseSalary * 1.2;
    }
}

public class InternSalaryRule implements SalaryRule {
    @Override
    public double calculate(double baseSalary) {
        return baseSalary * 0.8;
    }
}
```

3. **Refatore a classe principal para delegar o cálculo**:

```java
public class SalaryCalculator {
    private SalaryRule salaryRule;

    public SalaryCalculator(SalaryRule salaryRule) {
        this.salaryRule = salaryRule;
    }

    public double calculateSalary(double baseSalary) {
        return salaryRule.calculate(baseSalary);
    }
}
```

Agora, quando precisar adicionar um novo tipo de funcionário, basta criar uma nova classe que implemente `SalaryRule`. Nenhuma modificação é necessária no código existente.

#### Benefícios
- **Escalabilidade**: Adicionar novas funcionalidades não impacta o código existente.
- **Manutenção fácil**: O código está organizado e segue padrões claros.
- **Testabilidade**: Como as regras estão isoladas em classes separadas, é mais fácil testá-las individualmente.

---

### Relações com Padrões de Projeto
O Open Closed Principle está diretamente ligado a diversos padrões de projeto, como:

- **Strategy**: Permite escolher algoritmos em tempo de execução, como no exemplo acima.
- **Decorator**: Facilita a adção de novos comportamentos dinâmicos a objetos.
- **Factory Method**: Ajuda a criar instâncias de classes fechadas para modificações.

### Pontos de Atenção na Implementação
1. **Evite over-engineering**: Nem todo sistema precisa de extensibilidade extrema. Use OCP quando fizer sentido.
2. **Documente suas abstrações**: Novos desenvolvedores precisam entender como estender o sistema.
3. **Teste bem suas classes base**: Uma base sólida garante que as extensões funcionarão sem surpresas.

---

### Relações com Padrões de Projeto (Com Exemplos Práticos)

---

#### **Strategy**  
O padrão Strategy permite alternar algoritmos ou comportamentos de maneira flexível em tempo de execução, respeitando o OCP.  

**Exemplo**: Suponha que você tenha um sistema de cálculo de frete. Dependendo da localização, o algoritmo de cálculo pode variar.  

```java
// Interface do comportamento
public interface FreightCalculator {
    double calculate(double weight);
}

// Implementações específicas
public class LocalFreightCalculator implements FreightCalculator {
    @Override
    public double calculate(double weight) {
        return weight * 5; // Cálculo para fretes locais
    }
}

public class InternationalFreightCalculator implements FreightCalculator {
    @Override
    public double calculate(double weight) {
        return weight * 10; // Cálculo para fretes internacionais
    }
}

// Classe que usa o comportamento
public class FreightService {
    private FreightCalculator calculator;

    public FreightService(FreightCalculator calculator) {
        this.calculator = calculator;
    }

    public double calculateFreight(double weight) {
        return calculator.calculate(weight);
    }
}

// Uso
public class Main {
    public static void main(String[] args) {
        FreightService localService = new FreightService(new LocalFreightCalculator());
        System.out.println("Frete Local: " + localService.calculateFreight(10));

        FreightService internationalService = new FreightService(new InternationalFreightCalculator());
        System.out.println("Frete Internacional: " + internationalService.calculateFreight(10));
    }
}
```

Aqui, se você precisar adicionar um novo cálculo, como **Frete Expresso**, basta criar uma nova classe que implemente a interface `FreightCalculator`, sem alterar os códigos existentes.

---

#### **Decorator**  
O padrão Decorator adiciona comportamentos ou responsabilidades dinamicamente a objetos, promovendo a extensibilidade.

**Exemplo**: Imagine um sistema de personalização de bebidas, onde os clientes podem adicionar complementos como leite ou chocolate.

```java
// Interface base
public interface Beverage {
    String getDescription();
    double cost();
}

// Implementação concreta
public class Coffee implements Beverage {
    @Override
    public String getDescription() {
        return "Coffee";
    }

    @Override
    public double cost() {
        return 2.00;
    }
}

// Classe Decoradora Abstrata
public abstract class BeverageDecorator implements Beverage {
    protected Beverage beverage;

    public BeverageDecorator(Beverage beverage) {
        this.beverage = beverage;
    }
}

// Implementação de Decorators
public class MilkDecorator extends BeverageDecorator {
    public MilkDecorator(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Milk";
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.50;
    }
}

public class ChocolateDecorator extends BeverageDecorator {
    public ChocolateDecorator(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Chocolate";
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.70;
    }
}

// Uso
public class Main {
    public static void main(String[] args) {
        Beverage coffee = new Coffee();
        coffee = new MilkDecorator(coffee);
        coffee = new ChocolateDecorator(coffee);

        System.out.println(coffee.getDescription() + " $" + coffee.cost());
    }
}
```

Aqui, novos complementos podem ser adicionados facilmente como novos decoradores, sem tocar nas classes existentes.

---

#### **Factory Method**  
O Factory Method é usado para criar objetos enquanto mantém o código para criação encapsulado, seguindo o OCP.

**Exemplo**: Suponha que você tenha um sistema que cria diferentes tipos de notificações (e-mail, SMS, push).

```java
// Produto
public interface Notification {
    void notifyUser();
}

// Implementações concretas
public class EmailNotification implements Notification {
    @Override
    public void notifyUser() {
        System.out.println("Enviando notificação por e-mail...");
    }
}

public class SmsNotification implements Notification {
    @Override
    public void notifyUser() {
        System.out.println("Enviando notificação por SMS...");
    }
}

// Fábrica
public abstract class NotificationFactory {
    public abstract Notification createNotification();
}

public class EmailNotificationFactory extends NotificationFactory {
    @Override
    public Notification createNotification() {
        return new EmailNotification();
    }
}

public class SmsNotificationFactory extends NotificationFactory {
    @Override
    public Notification createNotification() {
        return new SmsNotification();
    }
}

// Uso
public class Main {
    public static void main(String[] args) {
        NotificationFactory factory = new EmailNotificationFactory();
        Notification notification = factory.createNotification();
        notification.notifyUser();

        factory = new SmsNotificationFactory();
        notification = factory.createNotification();
        notification.notifyUser();
    }
}
```

Se precisar adicionar um novo tipo de notificação, como **PushNotification**, basta criar uma nova classe e uma nova fábrica correspondente, sem alterar as implementações existentes.

---


