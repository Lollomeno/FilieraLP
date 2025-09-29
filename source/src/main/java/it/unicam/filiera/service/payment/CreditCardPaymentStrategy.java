
package it.unicam.filiera.service.payment;

import java.math.BigDecimal;
import java.util.UUID;


public class CreditCardPaymentStrategy implements PaymentStrategy {

    public static final String STRATEGY_NAME = "creditcard";

    @Override
    public PaymentResult pay(BigDecimal amount) {
        // --- LOGICA DI PAGAMENTO CON CARTA DI CREDITO SIMULATA ---
        System.out.println("Pagamento di " + amount + " EUR effettuato con Carta di Credito.");
        // Qui ci sarebbe la vera integrazione con un gateway di pagamento (es. Stripe)
        
        // Simuliamo un esito positivo
        String transactionId = "CC_" + UUID.randomUUID().toString();
        return new PaymentResult("SUCCESS", transactionId);
    }

    @Override
    public String getStrategyName() {
        return STRATEGY_NAME;
    }
}