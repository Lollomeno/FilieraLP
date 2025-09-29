
package it.unicam.filiera.factory;

import it.unicam.filiera.model.entity.User;
import it.unicam.filiera.model.enums.Role;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.util.Set;

@Component // Rende la classe un bean di Spring, così può essere iniettata con @Autowired
public class UserFactory {

    /**
     * Crea un'istanza di User a partire dai dati di base.
     * Centralizza la logica di creazione dell'oggetto.
     */
    public User createUser(Role ruolo, String nome, String cognome, String email, String password) {
        User user = new User();
        user.setNome(nome);
        user.setCognome(cognome);
        user.setEmail(email);
        user.setPassword(password); // La password verrà codificata dallo UserService
        user.setRoles(Set.of(ruolo));
        user.setCreatedAt(LocalDateTime.now());
        
        return user;
    }
}