package org.example;

import java.math.BigDecimal;

public class IpiStrategy implements ImpostoStrategy {
    private static final BigDecimal LIMITE = new BigDecimal("10000");
    private static final BigDecimal ALIQUOTA_ALTA = new BigDecimal("0.10");
    private static final BigDecimal ALIQUOTA_BAIXA = new BigDecimal("0.05");

    @Override
    public BigDecimal calcular(BigDecimal valor) {
        BigDecimal aliquota = valor.compareTo(LIMITE) > 0 ? ALIQUOTA_ALTA : ALIQUOTA_BAIXA;
        return valor.multiply(aliquota);
    }
}