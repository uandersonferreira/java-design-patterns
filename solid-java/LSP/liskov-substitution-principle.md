# Liskov Substitution Principle

"Derived classes must be substitutable for their base classes."

Classes derivadas devem ser substituíveis por suas classes base.

- O princípio da substituição de Liskov foi introduzido por Barbara Liskov em 1987:

"Se para cada objeto 01 do tipo S há um objeto 02 do tipo T de forma que, para todos os programas P, o comportamento de P é inalterado quando 01 é substituido por 02, então S é um subtipo de T."


### O que é o Liskov Substitution Principle?  

Em palavras simples, o LSP diz que **uma classe derivada deve ser capaz de substituir sua classe base sem quebrar o programa**. Isso significa que **qualquer comportamento esperado da classe base também deve funcionar com as classes filhas**.  

Pense em um plugue de tomada: ele funciona com diferentes aparelhos, desde que sigam o mesmo padrão. Se um aparelho foge desse padrão, ele simplesmente não funciona — o que seria equivalente a violar o LSP no código.  

A origem desse conceito remonta à cientista da computação Barbara Liskov, que definiu o princípio como:  

> "Se para cada objeto `O1` do tipo `S` (`S` é uma subclasse), há um objeto `O2` do tipo `T` (`T` é a superclasse) de forma que, para todos os programas `P` (programas Java), o comportamento de `P` é inalterado quando `O1` é substituído por `O2`, então `S` é um subtipo de `T`."

---

> "Se para cada instância `obj1` de uma classe `SubClass`, existe uma instância `obj2` de uma classe `SuperClass` de forma que, para qualquer método ou operação `P`, o comportamento de `P` permanece consistente ao substituir `obj1` por `obj2`, então `SubClass` é um subtipo válido de `SuperClass`."

### Explicação com Java

1. **Superclasse (T)**: Vamos considerar uma classe `Animal` como a superclasse.
   ```java
   public class Animal {
       public void fazerSom() {
           System.out.println("Animal faz som");
       }
   }
   ```

2. **Subclasse (S)**: Agora, vamos criar uma subclasse `Cachorro` que herda de `Animal`.
   ```java
   public class Cachorro extends Animal {
       @Override
       public void fazerSom() {
           System.out.println("Cachorro late");
       }
   }
   ```

3. **Objetos (O1 e O2)**: `O1` é um objeto do tipo `Cachorro` e `O2` é um objeto do tipo `Animal`.
   ```java
   Animal O2 = new Animal();
   Cachorro O1 = new Cachorro();
   ```

4. **Programa (P)**: Vamos criar um programa que usa a classe `Animal`.
   ```java
   public class Main {
       public static void main(String[] args) {
           Animal animal = new Animal();
           animal.fazerSom();
       }
   }
   ```

### Aplicação do Princípio

De acordo com o LSP, podemos substituir `O2` (objeto do tipo `Animal`) por `O1` (objeto do tipo `Cachorro`) sem alterar o comportamento do programa `P`.

```java
public class Main {
    public static void main(String[] args) {
        Animal animal = new Cachorro(); // Substituindo Animal por Cachorro
        animal.fazerSom(); // Saída: "Cachorro late"
    }
}
```

### Conclusão

O Princípio da Substituição de Liskov garante que uma subclasse (`Cachorro`) pode substituir sua superclasse (`Animal`) sem alterar o comportamento esperado do programa. Isso é fundamental para garantir a robustez e a flexibilidade do código orientado a objetos.

---

### Outro Exemplo Simples: Classes de Retângulos e Quadrados  

Imagine que estamos modelando um sistema geométrico e temos uma classe base chamada `Rectangle` e uma classe derivada chamada `Square`.  

```java
// Classe base
public class Rectangle {
    protected int width;
    protected int height;

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getArea() {
        return width * height;
    }
}

// Classe derivada
public class Square extends Rectangle {
    @Override
    public void setWidth(int width) {
        this.width = width;
        this.height = width; // Lados iguais
    }

    @Override
    public void setHeight(int height) {
        this.height = height;
        this.width = height; // Lados iguais
    }
}
```

Em teoria, tudo parece funcionar bem, mas observe o problema: um **quadrado** não se comporta da mesma forma que um **retângulo**.  

---

### Violação do LSP  

Vamos testar:  

```java
public class Main {
    public static void main(String[] args) {
        Rectangle rect = new Square();
        rect.setWidth(5);
        rect.setHeight(10);

        System.out.println("Área: " + rect.getArea()); // Esperado: 50, mas obtém 100
    }
}
```

O comportamento esperado do `Rectangle` foi quebrado porque o `Square` redefiniu a lógica para ajustar os lados. Isso viola o LSP.  

---

### Corrigindo o Problema  

A solução é repensar o design. Em vez de forçar o `Square` a ser um subtipo de `Rectangle`, devemos tratá-los como entidades separadas que compartilham uma interface comum:  

```java
// Interface comum
public interface Shape {
    int getArea();
}

// Retângulo
public class Rectangle implements Shape {
    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public int getArea() {
        return width * height;
    }
}

// Quadrado
public class Square implements Shape {
    private int side;

    public Square(int side) {
        this.side = side;
    }

    @Override
    public int getArea() {
        return side * side;
    }
}
```

Agora, ambos `Rectangle` e `Square` seguem o LSP, pois podem ser tratados como formas (`Shape`) sem impactar o comportamento do programa.

---

### Relações com Padrões de Projeto  

O LSP tem uma forte conexão com padrões de projeto, especialmente aqueles voltados para a criação e extensibilidade. Vamos ver como ele se relaciona com alguns padrões:  

#### **Factory Method**  
O padrão Factory Method cria objetos de maneira flexível, garantindo que as classes derivadas possam ser substituídas sem quebrar o sistema.  

**Exemplo**:  

```java
public interface Shape {
    int getArea();
}

public class Rectangle implements Shape {
    private int width, height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public int getArea() {
        return width * height;
    }
}

public class ShapeFactory {
    public static Shape createRectangle(int width, int height) {
        return new Rectangle(width, height);
    }
}
```

---

#### **Adapter**  
O padrão Adapter permite que diferentes classes sejam usadas de forma intercambiável, promovendo a substituição conforme o LSP.  

**Exemplo**:  

```java
public interface NewLogger {
    void log(String message);
}

// Classe legada
public class OldLogger {
    public void write(String text) {
        System.out.println("Old Logger: " + text);
    }
}

// Adapter
public class LoggerAdapter implements NewLogger {
    private OldLogger oldLogger;

    public LoggerAdapter(OldLogger oldLogger) {
        this.oldLogger = oldLogger;
    }

    @Override
    public void log(String message) {
        oldLogger.write(message);
    }
}

// Uso
public class Main {
    public static void main(String[] args) {
        NewLogger logger = new LoggerAdapter(new OldLogger());
        logger.log("Usando o Adapter");
    }
}
```

---

#### **Bridge**  
O padrão Bridge ajuda a separar abstrações de suas implementações, tornando substituições de classes muito mais seguras.  

**Exemplo**:  

```java
// Implementação
public interface Renderer {
    void render(String shape);
}

public class VectorRenderer implements Renderer {
    @Override
    public void render(String shape) {
        System.out.println("Renderizando " + shape + " como vetor.");
    }
}

// Abstração
public abstract class Shape {
    protected Renderer renderer;

    public Shape(Renderer renderer) {
        this.renderer = renderer;
    }

    public abstract void draw();
}

public class Circle extends Shape {
    public Circle(Renderer renderer) {
        super(renderer);
    }

    @Override
    public void draw() {
        renderer.render("Círculo");
    }
}

// Uso
public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle(new VectorRenderer());
        circle.draw();
    }
}
```

---

### Pontos de Atenção ao Implementar o LSP  

- **Teste Substituições**: Sempre substitua a classe base pela derivada nos testes para garantir que o comportamento permanece o mesmo.  
- **Evite Herança Inadequada**: Use herança apenas quando as classes têm uma verdadeira relação "é um". Caso contrário, considere a composição.  
- **Interfaces Bem Definidas**: Separe responsabilidades em interfaces específicas para que as classes derivadas não precisem sobrescrever métodos desnecessários.  

Com o LSP, você garante que seu código seja robusto, flexível e fácil de manter, especialmente em equipes maiores. A prática leva à perfeição, então teste bastante e observe como os padrões e princípios começam a se encaixar!