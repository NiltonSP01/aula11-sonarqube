package org.example;

import java.math.BigDecimal;

public interface ImpostoStrategy {
    BigDecimal calcular(BigDecimal valor);
}