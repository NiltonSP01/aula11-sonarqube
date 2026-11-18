package org.example;

import java.math.BigDecimal;
import java.util.Map;

public class FinanceUtils {

    private final Map<String, ImpostoStrategy> estrategias;

    public FinanceUtils() {
        this.estrategias = Map.of(
                "ICMS", new IcmsStrategy(),
                "IPI", new IpiStrategy(),
                "ISS", new IssStrategy(),
                "PIS", new PisStrategy(),
                "COFINS", new CofinsStrategy(),
                "IOF", new IofStrategy()
        );
    }

    public BigDecimal calcularImposto(BigDecimal valor, String tipo) {
        if (valor == null || tipo == null || !estrategias.containsKey(tipo)) {
            return BigDecimal.ZERO;
        }
        return estrategias.get(tipo).calcular(valor);
    }
}