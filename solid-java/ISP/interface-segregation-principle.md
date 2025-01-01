# Interface Segregation Principle

"Make fine grained interfaces that are client specific. "

Faça interfaces refinadas que são especificas do cliente.

- Uma classe não deve ser forçada a implementar interfaces e métodos que não serão utilizados.

- É melhor criar interfaces mais específicas ao invés de termos uma única interface genérica.


### O que é o Interface Segregation Principle?  

O **ISP** diz que **uma classe não deve ser forçada a implementar métodos de uma interface que ela não utiliza**. Em outras palavras, devemos criar interfaces menores, específicas para cada tipo de cliente, em vez de uma interface gigante que tenta fazer tudo.  

Imagine que você pediu um cardápio no restaurante e veio uma lista de todos os pratos possíveis, incluindo comidas que você nunca pediria. É confuso, não? O ISP sugere entregar um cardápio específico para o cliente — com apenas o que ele realmente precisa.  

No código, isso significa que **devemos evitar interfaces infladas (inchadas)**, pois elas causam dependências desnecessárias.  

---

### Exemplo de Violação do ISP  

Vamos começar com um exemplo de como NÃO aplicar o ISP. Imagine que estamos desenvolvendo um sistema para veículos e temos uma interface genérica:  

```java
public interface Vehicle {
    void drive();
    void fly();
}
```

Agora, todas as classes que implementam `Vehicle` serão forçadas a implementar os métodos `drive()` e `fly()`, mesmo que isso não faça sentido.  

```java
// Um carro só dirige
public class Car implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Carro está dirigindo.");
    }

    @Override
    public void fly() {
        throw new UnsupportedOperationException("Carro não pode voar!");
    }
}

// Um avião só voa
public class Airplane implements Vehicle {
    @Override
    public void drive() {
        throw new UnsupportedOperationException("Avião não pode dirigir!");
    }

    @Override
    public void fly() {
        System.out.println("Avião está voando.");
    }
}
```

Aqui está o problema: tanto `Car` quanto `Airplane` precisam implementar métodos que não fazem sentido para eles, violando o ISP.  

---

### Aplicando o ISP  

Para corrigir isso, podemos dividir a interface `Vehicle` em duas interfaces menores e mais específicas:  

```java
public interface Drivable {
    void drive();
}

public interface Flyable {
    void fly();
}
```

Agora, cada classe implementa apenas a interface que faz sentido para ela:  

```java
// Um carro só dirige
public class Car implements Drivable {
    @Override
    public void drive() {
        System.out.println("Carro está dirigindo.");
    }
}

// Um avião só voa
public class Airplane implements Flyable {
    @Override
    public void fly() {
        System.out.println("Avião está voando.");
    }
}
```

Com isso, eliminamos métodos desnecessários e respeitamos o princípio de que cada classe deve usar apenas o que realmente precisa.  

---

### Relações com Padrões de Projeto  

O **Interface Segregation Principle** se conecta com alguns padrões de projeto que ajudam a organizar interfaces de forma mais limpa e eficaz. Aqui estão três exemplos básicos:  

#### **Adapter**  

O Adapter permite que classes com interfaces incompatíveis trabalhem juntas, especialmente quando queremos adaptar uma interface antiga para atender a uma nova especificação mais refinada.  

**Exemplo**:  

```java
// Interface refinada
public interface ModernPayment {
    void makePayment(double amount);
}

// Classe legada
public class OldPaymentSystem {
    public void pay(double value) {
        System.out.println("Pagando: " + value);
    }
}

// Adapter
public class PaymentAdapter implements ModernPayment {
    private OldPaymentSystem oldPaymentSystem;

    public PaymentAdapter(OldPaymentSystem oldPaymentSystem) {
        this.oldPaymentSystem = oldPaymentSystem;
    }

    @Override
    public void makePayment(double amount) {
        oldPaymentSystem.pay(amount);
    }
}

// Uso
public class Main {
    public static void main(String[] args) {
        ModernPayment payment = new PaymentAdapter(new OldPaymentSystem());
        payment.makePayment(100.00);
    }
}
```

---

#### **Bridge**  

O Bridge separa abstrações de suas implementações, ajudando a criar interfaces específicas sem gerar dependências desnecessárias.  

**Exemplo**:  

```java
// Implementação
public interface NotificationSender {
    void send(String message);
}

public class EmailSender implements NotificationSender {
    @Override
    public void send(String message) {
        System.out.println("Enviando e-mail: " + message);
    }
}

public class SmsSender implements NotificationSender {
    @Override
    public void send(String message) {
        System.out.println("Enviando SMS: " + message);
    }
}

// Abstração
public abstract class Notification {
    protected NotificationSender sender;

    public Notification(NotificationSender sender) {
        this.sender = sender;
    }

    public abstract void notify(String message);
}

public class UserNotification extends Notification {
    public UserNotification(NotificationSender sender) {
        super(sender);
    }

    @Override
    public void notify(String message) {
        sender.send(message);
    }
}

// Uso
public class Main {
    public static void main(String[] args) {
        Notification notification = new UserNotification(new EmailSender());
        notification.notify("Bem-vindo!");

        notification = new UserNotification(new SmsSender());
        notification.notify("Sua conta foi criada.");
    }
}
```

---

#### **Facade**  

O Facade fornece uma interface simplificada para um conjunto de interfaces mais complexas, promovendo o uso de interfaces específicas para o cliente.  

**Exemplo**:  

```java
public interface AuthService {
    boolean authenticate(String username, String password);
}

public class BasicAuthService implements AuthService {
    @Override
    public boolean authenticate(String username, String password) {
        return "user".equals(username) && "password".equals(password);
    }
}

// Facade
public class LoginFacade {
    private AuthService authService;

    public LoginFacade(AuthService authService) {
        this.authService = authService;
    }

    public void login(String username, String password) {
        if (authService.authenticate(username, password)) {
            System.out.println("Login bem-sucedido.");
        } else {
            System.out.println("Credenciais inválidas.");
        }
    }
}

// Uso
public class Main {
    public static void main(String[] args) {
        LoginFacade login = new LoginFacade(new BasicAuthService());
        login.login("user", "password");
    }
}
```

---

### Pontos de Atenção ao Implementar o ISP  

1. **Evite Interfaces Infladas**: Divida interfaces grandes em menores e mais específicas para evitar dependências desnecessárias.  
2. **Conheça as Necessidades do Cliente**: Entenda exatamente quais métodos uma classe precisa implementar antes de criar a interface.  
3. **Refatore Sempre que Necessário**: Se uma interface começar a crescer ou perder foco, divida-a em partes menores.  

