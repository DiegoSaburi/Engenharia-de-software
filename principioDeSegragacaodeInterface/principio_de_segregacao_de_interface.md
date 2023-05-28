# Princípio de Segregação de Interfaces

> Clientes não devem ser forçados a depender de métodos q eles n usam

- Esse princípio trata dos problemas de termos ***interfaces gordas***
  - O que é uma interface gorda?
    - é um interface que possui ***baixa coesão*** e poderia ser ***quebrada em outras interfaces***

vamos pegar um exemplo que ***viola o princípio***:

```java
interface Funcionario {
    double getSalario();
    double getFGTS();
    int getSIAPE();
}
```

Nesse caso temos a interface funcionário, existem vários tipos de funcionários (CLT, PJ, funcionário público).
Com isso vemos que essa interface possui ***vários métodos que não são dependentes entre si*** e que possui uma ***altissima generalização***.

Agora vamos pra um exemplo que ***não viola o princípio***: 

```java
interface Funcionario { 
	double getSalario();
}
interface FuncionarioCLT extends Funcionario {
    double getFGTS();
}
interface FuncionarioPublico extends Funcionario {
    int getSIAPE();
}
```
vemos que todos os métodos são independentes entre si e que eles compartilham um único método (o de salário, visto que independentemente do tipo de funcionário todos recebem um salário).
Com isso melhoramos a coesão e acoplamento da interface.

## Exemplo

agora vamos pegar o código da interface IItemBilioteca que se encontra em codigoInicial:

```java
package codigoInicial;

import java.time.LocalDateTime;

public interface IItemBiblioteca {
    void emprestar(String usuarioEmprestimo);
    void devolver();
    LocalDateTime getDataDevolver();
    
    String getIdItemBiblioteca();
    void setIdItemBiblioteca(String idItemBiblioteca);
  
    String getTitulo();
    void setTitulo(String titulo);
  
    String getAutor();
    void setAutor(String autor);
  
    int getNumeroPaginas();
    void setNumeroPaginas(int numeroPaginas);
  
    int getDuracaoEmprestimoEmDias();
    void setDuracaoEmprestimoEmDias(int duracaoEmprestimoEmDias);
  
    String getUsuarioEmprestimo();
    void setUsuarioEmprestimo(String usuarioEmprestimo);
  
    LocalDateTime getDataEmprestimo();
    void setDataEmprestimo(LocalDateTime dataEmprestimo);
}
```

agora se pegarmos o código que temos em LivroConsulta, veremos alguns ***métodos sem implementação*** como emprestar, devolver:

```java
package br.ufba.isp;

import java.time.LocalDateTime;

public class LivroConsulta implements IItemBiblioteca {
  public String idItemBiblioteca;
  public String titulo;
  public String autor;
  public int numeroPaginas;

  public void emprestar(String usuarioEmprestimo) {

  }

  public void devolver() {

  }

  public LocalDateTime getDataDevolver() {
    return LocalDateTime.of(1900, 1, 1, 0, 0);
  }

  public String getIdItemBiblioteca() {
    return idItemBiblioteca;
  }

  public void setIdItemBiblioteca(String idItemBiblioteca) {
    this.idItemBiblioteca = idItemBiblioteca;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public String getAutor() {
    return autor;
  }

  public void setAutor(String autor) {
    this.autor = autor;
  }

  public int getNumeroPaginas() {
    return numeroPaginas;
  }

  public void setNumeroPaginas(int numeroPaginas) {
    this.numeroPaginas = numeroPaginas;
  }

  public int getDuracaoEmprestimoEmDias() {
    return 0;
  }

  public void setDuracaoEmprestimoEmDias(int duracaoEmprestimoEmDias) {

  }

  public String getUsuarioEmprestimo() {
    return "";
  }

  public void setUsuarioEmprestimo(String usuarioEmprestimo) {

  }

  public LocalDateTime getDataEmprestimo() {
    return LocalDateTime.of(1900, 1, 1, 0, 0);
  }

  public void setDataEmprestimo(LocalDateTime dataEmprestimo) {

  }
}
```

Isso está acontecendo pq ***IItemBiblioteca*** está agindo como uma ***interface gorda***.
a classe ***LivroConsulta não é emprestável*** com isso vemos que ***não existe uma implementação para tais métodos dentro dessa classe***.
os métodos que fazem sentido para a classe estão dependendo de outros métodos que não são implementáveis para esse contexto.

## Corrigindo o codigo inicial

Para corrigir os códigos, primeiro temos que entender o seguinte:
- Um livro comum ***não possui uma duração em minutos***
- Um livro de áudio e um filme ***não possui páginas***
- Um filme ***não possui apenas autores*** 
- Um livro de consulta ***não pode ser emprestado***
- todos eles ***são itens de biblioteca***

Com isso em mente, podemos subdividir a interface por outras menores.
Para atender os pontos levantados, vamo levar em conta as seguintes interfaces:

- ***Emprestavel:*** aql item que pode ser emprestado
- ***TempoDeDuracao:*** aql item que pode ser executado e tem um tempo de duração
- ***LivroTradicional:*** aql item do tipo livro (sem ser  consulta, audio etc)
- ***Autoral:*** aql item que possui um autor
- ***Filme:*** aql item que possui caracteristicas de um filme

Agora podemos implementar as interfaces nas classes devidas:

- Todos implementam IItemBiblioteca
- Livro implementa ILivroTradicional, IAutoral e IEmprestavel
- LivroAudio implementa IAutoral, IEmprestavel e ITempoDeDuracao
- LivroConsulta implementa ILivroTradicional e IAutoral
- Filme implementa ITempodeDuracao e IFilme
