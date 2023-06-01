# Princípio de substituição de Lizkov

>Subclasses devem poder substituir suas superclasses

O Princípio de Substituição de Liskov é um princípio fundamental da programação orientada a objetos que estabelece que objetos de uma classe derivada devem ser substituíveis por objetos de sua classe base sem quebrar o comportamento esperado do programa.

Em outras palavras, uma subclasse deve poder ser usada no lugar de sua classe base sem causar efeitos colaterais ou comportamentos inesperados.

Vamo ver esse exemplo que ***viola o princípio***:

temos a classe retângulo:
```java
public class Retangulo {
    protected double largura;
    protected double altura;

    public Retangulo(double largura, double altura) {
        this.largura = largura;
        this.altura = altura;
    }

    public void setLargura(double largura) {
        this.largura = largura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double calcularArea() {
        return largura * altura;
    }
}
```

e a classe quadrado:

```java
public class Quadrado extends Retangulo {
    public Quadrado(double lado) {
        super(lado, lado);
    }

    @Override
    public void setLargura(double largura) {
        super.setLargura(largura);
        super.setAltura(largura);
    }

    @Override
    public void setAltura(double altura) {
        super.setAltura(altura);
        super.setLargura(altura);
    }
}
```

Sabemos que ***todo quadrado é um retângulo mas nem todo retângulo é um quadrado***.

Agora imagina que devemos implementar um método que redimensione um retangulo para valores exatos:

```java
public class Exemplo {
    public static void redimensionar(Retangulo retangulo) {
        retangulo.setLargura(5.0);
        retangulo.setAltura(4.0);
        System.out.prdoubleln("Nova área: " + retangulo.calcularArea());
    }

    public static void main(String[] args) {
        Retangulo retangulo = new Quadrado(3.0);
        redimensionar(retangulo);//<--- momento em que o princípio é violado
    }
}
```
Nesse exemplo, chamamos o método redimensionar() passando um objeto Quadrado como argumento, mas esperando um objeto Retangulo.
O resultado será uma área de 16, enquanto deveria ser 20. Isso ocorre porque as implementações de setLargura() e setAltura() em Quadrado modificam ambos os lados do quadrado, violando a semântica esperada de um retângulo.

## Corrigindo o código inicial

Uma possível solução seria remover a herança e utilizar uma composição entre Retangulo e Quadrado.
essa forma, as classes não estão mais relacionadas por herança, mas podem compartilhar uma mesma interface, como FiguraGeometrica, que define os métodos comuns a ambas.

- interface IFiguraGeometrica:

```java
public interface FiguraGeometrica {
    double calcularArea();
}
```

- Classe Retangulo:

```java
public class Retangulo implements FiguraGeometrica {
    protected double largura;
    protected double altura;

    public Retangulo(double largura, double altura) {
        this.largura = largura;
        this.altura = altura;
    }

    public void setLargura(double largura) {
        this.largura = largura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        return largura * altura;
    }
}
```

- Classe quadrado:

```java
public class Quadrado implements FiguraGeometrica {
    private Retangulo retangulo;

    public Quadrado(double lado) {
        retangulo = new Retangulo(lado, lado);
    }

    public void setLado(double lado) {
        retangulo.setLargura(lado);
        retangulo.setAltura(lado);
    }

    @Override
    public double calcularArea() {
        return retangulo.calcularArea();
    }
}
```

Nessa nova implementação, as classes Retangulo e Quadrado implementam a interface FiguraGeometrica.
O Quadrado agora contém uma instância de Retangulo e delega chamadas de método para ela.
Isso garante que um Quadrado seja substituível por um Retangulo em qualquer contexto, mantendo o comportamento esperado.

- Solução que ***não viola o princípio***:

```java
public class Exemplo {
    public static void redimensionar(FiguraGeometrica figura) {
        figura.setLargura(5.0);
        figura.setAltura(4.0);
        System.out.println("Nova área: " + figura.calcularArea());
    }

    public static void main(String[] args) {
        FiguraGeometrica figura = new Quadrado(3.0);
        redimensionar(figura);
    }
}

```