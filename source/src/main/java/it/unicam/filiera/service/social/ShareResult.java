
package it.unicam.filiera.service.social;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ShareResult {
    private String status; // "SUCCESS" o "FAILED"
    private String postUrl; // L'URL del post creato sul social network
    private String errorMessage;
}