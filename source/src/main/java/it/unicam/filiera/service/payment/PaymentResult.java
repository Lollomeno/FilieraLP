
package it.unicam.filiera.service.payment;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor // Costruttore con tutti gli argomenti
public class PaymentResult {
    private String status; // es. "SUCCESS", "FAILED"
    private String transactionId;
}