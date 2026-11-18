package org.example;

import java.math.BigDecimal;

public class FinanceUtils {

    // Complexidade ciclomatica alta
    public BigDecimal calcularImposto(BigDecimal valor, String tipo) {
        if (valor == null) return BigDecimal.ZERO;

        if (tipo.equals("ICMS")) {
            return valor.multiply(new BigDecimal("0.17"));
        } else if (tipo.equals("IPI")) {
            if (valor.compareTo(new BigDecimal("10000")) > 0) {
                return valor.multiply(new BigDecimal("0.10"));
            } else {
                return valor.multiply(new BigDecimal("0.05"));
            }
        } else if (tipo.equals("ISS")) {
            return valor.multiply(new BigDecimal("0.05"));
        } else if (tipo.equals("PIS")) {
            return valor.multiply(new BigDecimal("0.0165"));
        } else if (tipo.equals("COFINS")) {
            return valor.multiply(new BigDecimal("0.076"));
        } else if (tipo.equals("IOF")) {
            return valor.multiply(new BigDecimal("0.0038"));
        }
        return BigDecimal.ZERO;
    }
}