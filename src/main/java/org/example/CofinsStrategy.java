package org.example;

import java.math.BigDecimal;

public class CofinsStrategy implements ImpostoStrategy {
    private static final BigDecimal ALIQUOTA = new BigDecimal("0.076");

    @Override
    public BigDecimal calcular(BigDecimal valor) {
        return valor.multiply(ALIQUOTA);
    }
}