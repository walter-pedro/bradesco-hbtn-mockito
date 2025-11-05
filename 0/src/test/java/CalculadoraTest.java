import mockito.Calculadora;
import mockito.ServicoMatematico;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class CalculadoraTest {

    @Mock
    ServicoMatematico servicoMatematico;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void deveSomar() {
        when(servicoMatematico.somar(2, 3)).thenReturn(5);

        Calculadora calculadora = new Calculadora();
        int resultado = calculadora.somar(2, 3);

        assertEquals(5, resultado);
    }
}
