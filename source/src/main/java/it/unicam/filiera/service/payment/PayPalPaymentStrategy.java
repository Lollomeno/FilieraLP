
package it.unicam.filiera.service.payment;

import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.util.UUID;

@Component("paypal") // Nome del bean
public class PayPalPaymentStrategy implements PaymentStrategy {
    
    public static final String STRATEGY_NAME = "paypal";
    
    @Override
    public PaymentResult pay(BigDecimal amount) {
        // --- LOGICA DI PAGAMENTO CON PAYPAL SIMULATA ---
        System.out.println("Pagamento di " + amount + " EUR effettuato con PayPal.");
        // Qui ci sarebbe la vera integrazione con le API di PayPal
        
        // Simuliamo un esito positivo
        String transactionId = "PP_" + UUID.randomUUID().toString();
        return new PaymentResult("SUCCESS", transactionId);
    }
    
    @Override
    public String getStrategyName() {
        return STRATEGY_NAME;
    }
}