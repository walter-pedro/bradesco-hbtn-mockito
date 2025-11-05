package mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import mockito.ContaRepository;

public class BancoServiceTest {

    @Mock
    ContaRepository contaRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testConsultarSaldo() {
        // Criando conta simulada
        Conta conta = new Conta("0001", 100d);

        // Definindo comportamento do mock
        when(contaRepository.buscarConta("0001")).thenReturn(conta);    

        // Criando serviço com o mock
        BancoService bancoService = new BancoService(contaRepository);

        // Testando consulta de saldo
        double saldo = bancoService.consultarSaldo("0001");

        // Verificando se o saldo está correto
        assertEquals(saldo, conta.getSaldo());

        // Verificando se o método buscarConta foi chamado
        verify(contaRepository).buscarConta("0001");
    }


    @Test
    public void testDepositar() {
        // Criando conta simulada
        Conta conta = new Conta("0001", 100d);

        // Definindo comportamento do mock
        when(contaRepository.buscarConta("0001")).thenReturn(conta);    
        
        // Criando serviço com o mock
        BancoService bancoService = new BancoService(contaRepository);

        // Executando depósito
        bancoService.depositar("0001", 150d);

        // Verificando se o saldo foi atualizado
        

        // Verificando se os métodos foram chamados corretamente
        verify(contaRepository).buscarConta("0001");
        verify(contaRepository).salvar(conta);
    }
}
