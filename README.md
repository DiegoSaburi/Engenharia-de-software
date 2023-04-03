
# Engenharia de software

Esse Read me é baseado nos estudos da matéria de engenharia de software I da UFBA e no livro "Engenharia de Software Moderna" de Marco Tulio Valente

# Table of Contents

- [Introducao](#introducao)
  * [O que se estuda em engenharia de software?](#o-que-se-estuda-em-engenharia-de-software-)
  * [Engenharia de Requisitos](#engenharia-de-requisitos)
    + [Requisitos funcionais:](#requisitos-funcionais-)
    + [Requisitos nao funcionais:](#requisitos-nao-funcionais-)
  * [Projeto de Software](#projeto-de-software)
    + [Interfaces Providas:](#interfaces-providas-)
    + [Interfaces Requeridas:](#interfaces-requeridas-)
    + [Exemplo](#exemplo)
  * [Construção de Software](#constru--o-de-software)
  * [Testes de Software](#testes-de-software)

<small><i><a href='http://ecotrust-canada.github.io/markdown-toc/'>Table of contents generated with markdown-toc</a></i></small>

# Introducao
## O que se estuda em engenharia de software?

Para responder essa pergunta, vamos nos basear no [SWEBOK](https://www.computer.org/education/bodies-of-knowledge/software-engineering) que é um documento que visa documentar todos os princípios de engenharia de software.

O [SWEBOK](https://www.computer.org/education/bodies-of-knowledge/software-engineering) define 12 áreas de conhecimento em Engenharia de software:

1. Engenharia de Requisitos;
2. Projeto de Software;
3. Construção de Software;
4. Testes de Software;
5. Manutenção de Software;
6. Gerência de Configuração;
7. Gerência de Projetos;
8. Processos de Software;
9. Modelos de Software;
10. Qualidade de Software;
11. Prática Profissional;
12. Aspectos Econômicos.

## Engenharia de Requisitos

Os requisitos de um sistema definem o que ele deve fazer e como ele deve operar. Portanto, a Engenharia de Requisitos inclui o conjunto de atividades realizadas com o objetivo de definir, analisar, documentar e validar os requisito de um sistema. Tais requisitos podem ser definidos de duas maneiras:

### Requisitos funcionais:

Funcionalidades ou serviços que devem ser realizados pelo sistema (abordagem mais clara para o cliente ou usuário sobre o que o sistema faz)

### Requisitos nao funcionais:

Como o sistema deve operar para realizar tais serviçoes (são requisitos técnicos que geralmente não possuem uma abordagem muito clara para um leigo em tecnologia)

## Projeto de Software

Durante um projeto de software, são definidas suas principais unidades , porém, apenas a nível de **interface**

Ou seja, definiremos apenas as **assinaturas** das classes, métodos e atributos dessas unidades **sem implementar sua lógica de funcionamento**

Tais **interfaces** podem ser definidas em 2 tipos:

### Interfaces Providas:

Aqueles serviços que uma unidade de código torna **público para uso do sistema**

### Interfaces Requeridas:

São interfaces que são **Requeridas por outras interfaces**, ou seja, que são utilizadas por outras interfaces

### Exemplo

Considere as seguintes interfaces para um sistema de banco:

```java
class ContaBancaria{
    private Cliente cliente;
    private double saldo;
    public double getSaldo();{...}
    public String getNomeCliente(){...}
    public String getExtrato(Date inicio){...}
}
```
A classe **ContaBancaria** oferece uma interface para as demais classes do sistema por meio de 3 métodos (getSaldo, getNomeCliente e getExtrato). Ou seja, esses 3 métodos são as **interfaces Providas pela classe ContaBancaria**.

Por outro lado, podemos ver que ContaBancaria possui um atributo cujo tipo é **Cliente**, criando assim uma **dependência** da classe **ContaBancaria** para a classe **Cliente** (contaBancaria depende de Cliente). Portanto, a interface de Cliente é uma **interface requerida por ContaBancaria**

Além disso, se pensarmos em um projeto em um nível mais alto cujas unidades de código possuem mais *granularidade* ele é classificado como um projeto arquitetural. Isso significa que a **Arquitetura de software** trata da organização de um sistema em um nível de abstração mais alto do que aquele que envolve classes ou construções semelhantes (organização de pastas, microserviços etc)

## Construção de Software

Trata-se da *implementação* do sistema, isto é, criar o *código do sistema*. É nesse momento que implementamos o que não foi implementado na etapa de [Projeto de Software](#projeto-de-software). Pensamos nos algoritmos, estruturas de dados, quais frameworks utilizar, padrões de código e etc

## Testes de Software

Consiste na execução de um programa com um conjunto finito de casos com o objetivo de verificar a integridade e o comportamento do mesmo.