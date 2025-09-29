
package it.unicam.filiera.dto;

import it.unicam.filiera.model.enums.Role;
import lombok.Data;

// Questa classe modella i dati che ci aspettiamo di ricevere in formato JSON
// quando un utente si registra.
@Data
public class RegistrationRequestDTO {
    
    private String email;
    private String password;
    private String nome;
    private String cognome;
    private Role ruolo; // Specifica il ruolo con cui l'utente si sta registrando
    
    // Aggiungi qui le validazioni se usi spring-boot-starter-validation
    // Esempio:
    // @NotBlank(message = "L'email non può essere vuota")
    // @Email(message = "Formato email non valido")
    // private String email;
}