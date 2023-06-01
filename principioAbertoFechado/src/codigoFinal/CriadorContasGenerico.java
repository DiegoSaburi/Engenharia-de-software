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
