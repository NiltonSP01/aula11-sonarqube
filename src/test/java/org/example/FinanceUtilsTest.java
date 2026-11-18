package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

class FinanceUtilsTest {

    private final FinanceUtils utils = new FinanceUtils();

    private void assertImposto(String esperado, String valor, String tipo) {
        BigDecimal resultado = utils.calcularImposto(new BigDecimal(valor), tipo);
        assertEquals(0, new BigDecimal(esperado).compareTo(resultado),
                "tipo " + tipo + " valor " + valor + " retornou " + resultado);
    }

    @Test
    void icmsAplicaDezesseteporcento() {
        assertImposto("170", "1000", "ICMS");
    }

    @Test
    void ipiAcimaDoLimiteAplicaDezPorCento() {
        assertImposto("1000.001", "10000.01", "IPI");
    }

    @Test
    void ipiNoLimiteAplicaCincoPorCento() {
        assertImposto("500", "10000", "IPI");
    }

    @Test
    void ipiAbaixoDoLimiteAplicaCincoPorCento() {
        assertImposto("50", "1000", "IPI");
    }

    @Test
    void issAplicaCincoPorCento() {
        assertImposto("50", "1000", "ISS");
    }

    @Test
    void pisAplicaAliquotaCorreta() {
        assertImposto("16.5", "1000", "PIS");
    }

    @Test
    void cofinsAplicaAliquotaCorreta() {
        assertImposto("76", "1000", "COFINS");
    }

    @Test
    void iofAplicaAliquotaCorreta() {
        assertImposto("3.8", "1000", "IOF");
    }

    @Test
    void valorNuloRetornaZero() {
        assertEquals(BigDecimal.ZERO, utils.calcularImposto(null, "ICMS"));
    }

    @Test
    void tipoDesconhecidoRetornaZero() {
        assertEquals(BigDecimal.ZERO, utils.calcularImposto(new BigDecimal("1000"), "XYZ"));
    }

    @Test
    void tipoNuloRetornaZero() {
        assertEquals(BigDecimal.ZERO, utils.calcularImposto(new BigDecimal("1000"), null));
    }
}