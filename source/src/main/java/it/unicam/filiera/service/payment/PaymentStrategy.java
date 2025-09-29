
package it.unicam.filiera.service.payment;

import java.math.BigDecimal;

/**
 * Interfaccia che definisce il contratto per una strategia di pagamento.
 * Questo è il cuore dello Strategy Pattern.
 */
public interface PaymentStrategy {

    /**
     * Esegue il pagamento per un dato importo.
     *
     * @param amount L'importo da pagare.
     * @return Un oggetto PaymentResult che incapsula l'esito della transazione.
     */
    PaymentResult pay(BigDecimal amount);

    /**
     * Restituisce il nome univoco della strategia (es. "creditcard", "paypal").
     * Utile per la selezione dinamica della strategia.
     * @return una stringa che identifica la strategia.
     */
    String getStrategyName();
}