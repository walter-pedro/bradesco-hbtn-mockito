package mockito;

public interface ContaRepository{

    public Conta buscarConta(String numero);
    public void salvar(Conta conta); 
}
