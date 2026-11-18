package org.example;

import java.math.BigDecimal;

public class IcmsStrategy implements ImpostoStrategy {
    private static final BigDecimal ALIQUOTA = new BigDecimal("0.17");

    @Override
    public BigDecimal calcular(BigDecimal valor) {
        return valor.multiply(ALIQUOTA);
    }
}