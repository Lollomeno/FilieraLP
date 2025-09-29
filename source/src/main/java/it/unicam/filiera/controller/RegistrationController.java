
package it.unicam.filiera.controller;

import it.unicam.filiera.dto.RegistrationRequestDTO;
import it.unicam.filiera.factory.UserFactory; 
import it.unicam.filiera.model.entity.User;
import it.unicam.filiera.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth") // Usiamo un URL base per l'autenticazione/registrazione
public class RegistrationController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserFactory userFactory;

    /**
     * Endpoint per la registrazione di un nuovo utente.
     * Riceve i dati di registrazione, li usa per creare un utente tramite la factory,
     * passa l'utente al service per la logica di business e il salvataggio,
     * e infine restituisce una risposta HTTP.
     *
     * @param requestDTO I dati di registrazione inviati dal client.
     * @return una ResponseEntity che indica il successo (HTTP 201 Created) o un errore.
     */
    @PostMapping("/register") // Risponde alle richieste POST a /api/auth/register
    public ResponseEntity<?> registerUser(@RequestBody RegistrationRequestDTO requestDTO) {
        
        try {
            // 1. Usa la UserFactory per creare l'oggetto User a partire dai dati della richiesta
            User newUser = userFactory.createUser(
                requestDTO.getRuolo(),
                requestDTO.getNome(),
                requestDTO.getCognome(),
                requestDTO.getEmail(),
                requestDTO.getPassword()
            );

            // 2. Passa l'utente appena creato allo UserService per la logica di registrazione
            User savedUser = userService.registerNewUser(newUser);

            // 3. Restituisce una risposta di successo (HTTP 201 Created)
            // Non restituiamo mai la password nella risposta! 
            // Potremmo creare un UserResponseDTO per questo.
            // Per semplicità, qui restituiamo l'utente salvato senza password.
            savedUser.setPassword(null); 
            return new ResponseEntity<>(savedUser, HttpStatus.CREATED);

        } catch (IllegalStateException e) {
            // Se lo UserService lancia un'eccezione (es. email già esistente),
            // il Controller la cattura e restituisce un errore HTTP 400 Bad Request.
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}