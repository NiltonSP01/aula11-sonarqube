package org.example;

import java.math.BigDecimal;

public class IofStrategy implements ImpostoStrategy {
    private static final BigDecimal ALIQUOTA = new BigDecimal("0.0038");

    @Override
    public BigDecimal calcular(BigDecimal valor) {
        return valor.multiply(ALIQUOTA);
    }
}