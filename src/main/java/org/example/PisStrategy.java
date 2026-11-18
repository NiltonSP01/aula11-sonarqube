package org.example;

import java.math.BigDecimal;

public class PisStrategy implements ImpostoStrategy {
    private static final BigDecimal ALIQUOTA = new BigDecimal("0.0165");

    @Override
    public BigDecimal calcular(BigDecimal valor) {
        return valor.multiply(ALIQUOTA);
    }
}