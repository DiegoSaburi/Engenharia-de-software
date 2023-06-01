# Principio Aberto/Fechado

>Classes devem ser “abertas” para extensão e “fechadas” para modificação.

- Aberto para extensão
  - Quando requisitos mudam, somos capazes de ***alterar o
  sistema por meio da extensão de uma classe*** (ou de
  classes) com ***novos “comportamentos”*** que satisfazem
  as mudanças
- Fechado para modificação
  - ***Alterar*** o comportamento de ***um sistema não*** consiste
  em ***alterar seu código fonte*** de suas classes.

É importante salientar que ***nunca conseguiremos*** projetar um ***sistema extensível para todo tipo de mudança***.
Como não pode ser completo, o ***uso do princípio deve ser estratégico***

Vamos ver o seguinte exemplo:

Temos os códigos em codigoInicial, agora recebemos um requisito na qual existe mais de um tipo de empregado e de candidatoGenerico.
por exemplo, o empregado pode ser um gerente tal qual um candidatoGenerico tbm se candidata para a vaga de gerente.
Vamos criar um ***enum*** que vai lidar com os tipos de candidatoGenerico:

```java
package codigoInicial;

public enum TipoCandidato {
	GENERICO, GERENTE;
}
```

por default, vamos considerar que ***todo candidatoGenerico é genérico até q se diga o contrário***.

Com isso esse novo requisito, teríamos que modificar CriadorContas para criar uma conta de um empregado do tipo gerente, violando assim o princípio.

Solução que ***viola o princípio***:

```java
package codigoFinal;

public class CriadorContas {
  public Empregado criar(CandidatoGenerico candidatoGenerico) {
    Empregado empregado = new Empregado();

    empregado.setNome(candidatoGenerico.getNome());
    empregado.setSobrenome(candidatoGenerico.getSobrenome());

    if (candidatoGenerico.getTipoCandidato() == TipoCandidato.GENERICO) {
      empregado.setEmail(candidatoGenerico.getNome().charAt(0) + candidatoGenerico.getSobrenome() + "@xpto.com");
    }
    if (candidatoGenerico.getTipoCandidato() == TipoCandidato.GERENTE) {
      empregado.setEmail(candidatoGenerico.getNome() + candidatoGenerico.getSobrenome() + "@xpto.com");
      empregado.setGerente(true);
    }

    return empregado;
  }
}
```

e para cada novo candidatoGenerico ou empregado que criador conta tivesse que criar, teríamos que adicionar um if para cada um deles

## Corrigindo o código inicial

vamos implementar uma interface ***ICandidato*** que vai ser extendida por outras classes do tipo candidatoGenerico:

```java
package codigoFinal;

public interface ICandidato {
	String getNome();
	String getSobrenome();
}
```

Vamos deixar a classe candidato com um nome mais genérico (candidatoGenerico) e vamos criar ***uma classe nova para cada novo tipo de candidato***.
Além disso, criaremos ***uma classe CriadorConta para cada tipo de candidato*** e que vai extender de uma interface CriadorContas.
Dessa forma, ***cada classe irá sobrescrever o método criar com sua própria regra***.

- Interface CriadorConta:
```java
package codigoFinal;

public interface ICriadorConta {
	Empregado criar(ICandidato candidato);
}

```

Com isso, ***classes já criadas ficarão fechadas a modificação, porém o sistema ficará aberto a extensão***.
Os if's que iríamos criar para cada tipo de candidato, agora se tornará uma classe para cada tipo.
Voltando para o exemplo que viola o principio e substituindo por uma que não viola:

- Criador de contas para ***candidatos genéricos***

```java
package codigoFinal;

public class CriadorContasGenerico implements ICriadorConta{
    @Override
    public Empregado criar(ICandidato candidato)
    {
        Empregado empregado = new Empregado();

        empregado.setNome(candidato.getNome());
        empregado.setSobrenome(candidato.getSobrenome());
        empregado.setEmail(candidato.getNome().charAt(0) + candidato.getSobrenome() + "@xpto.com");
        
        return empregado;
    }
}
```

- Criador de contas para ***candidados gerente***

```java
package codigoFinal;

public class CriadorContasGerente implements ICriadorConta{

	@Override
	public Empregado criar(ICandidato candidato) {
		Empregado empregado = new Empregado();
		
		empregado.setEmail(candidato.getNome() + candidato.getSobrenome() + "@xpto.com");
		empregado.setGerente(true);

		return empregado;
	}
}

```

PORÉM CHEGAMOS A UM IMPASSE.

Dentro da main, depois dessas alterações, ficamos com o seguinte código:

```java
package codigoFinal;

import java.util.*;

public class Program {

	public static void main(String[] args) {
		List<ICandidato> candidatoGenericos = new ArrayList<ICandidato>();
	    candidatoGenericos.add(new CandidatoGenerico("Carlos", "Silva"));
	    candidatoGenericos.add(new CandidatoGerente("Maria", "Souza"));
	    candidatoGenericos.add(new CandidatoGenerico("Ana", "Lopes"));
	    List<Empregado> empregados = new ArrayList<Empregado>();
		
		
	    CriadorContas criadorContas = new CriadorContas();//<----
      
      

	    for (CandidatoGenerico candidatoGenerico : candidatoGenericos)
	    {
	        empregados.add(criadorContas.criar(candidatoGenerico));
	    }

	    for (Empregado empregado: empregados)
	    {
	        System.out.println(empregado.getNome() + " " + empregado.getSobrenome() + " " + empregado.getEmail());
	    }

	}

}

```

porém, ***não temos mais uma classe chamada criador contas***.
Essa responsabilidade ficou para cada classe, então como vamos chamar o criador contas correto de cada classe?

> criaremos um método na interface que devolva o criador contas correto!

fica a cargo de cada classe candidato designar qual o seu criador de contas.
No caso, a classe CandidatoGerente deve devolver um CriadorContasGerente e a classe CandidatoGenérico deve devolver um CriadorContasGenerico.

Agora na main, basta chamar o método que retorna tal criador de contas para uma variável do tipo da interface ICriadorContas.
Depois, por meio dessa variável, chamar o método criar.

- Solução que ***não viola o princípio***:
```java
package codigoFinal;

import java.util.*;

public class Program {

	public static void main(String[] args) {
		List<ICandidato> candidatos = new ArrayList<ICandidato>();
	    candidatos.add(new CandidatoGenerico("Carlos", "Silva"));
	    candidatos.add(new CandidatoGerente("Maria", "Souza"));
	    candidatos.add(new CandidatoGenerico("Ana", "Lopes"));

	    List<Empregado> empregados = new ArrayList<Empregado>();
		//CriadorContas criadorContas = new CriadorContas(); antes ficava aqui


	    for (ICandidato candidato : candidatos)
	    {
		    ICriadorConta criadorConta = candidato.obterCriadorConta();//agora fica aqui
	        empregados.add(criadorConta.criar(candidato));
	    }

	    for (Empregado empregado: empregados)
	    {
	        System.out.println(empregado.getNome() + " " + empregado.getSobrenome() + " " + empregado.getEmail());
	    }

	}

}

```



