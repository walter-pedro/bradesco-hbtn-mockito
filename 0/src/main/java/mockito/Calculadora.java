package mockito;

import mockito.ServicoMatematico;
import mockito.ServicoMatematicoImpl;

public class Calculadora {
    ServicoMatematico servicoMatematico = new ServicoMatematicoImpl();

    public int somar(int a, int b) {
        return servicoMatematico.somar(a, b);
    }
}
