package org.example;

import java.math.BigDecimal;

public class IssStrategy implements ImpostoStrategy {
    private static final BigDecimal ALIQUOTA = new BigDecimal("0.05");

    @Override
    public BigDecimal calcular(BigDecimal valor) {
        return valor.multiply(ALIQUOTA);
    }
}