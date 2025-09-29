
package it.unicam.filiera.service;


import it.unicam.filiera.model.entity.User;
import it.unicam.filiera.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder; 
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder; 

    /**
     * Gestisce la logica di business per registrare un nuovo utente.
     *
     * @param user L'oggetto User creato dalla UserFactory.
     * @return L'utente salvato con un ID e password codificata.
     * @throws IllegalStateException se l'email è già in uso.
     */
    public User registerNewUser(User user) {
        // 1. Controllo di business: verifica se l'email esiste già
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new IllegalStateException("Errore: l'email '" + user.getEmail() + "' è già registrata.");
        }

        // 2. Logica di sicurezza: codifica la password prima di salvarla
        
        String hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);

        // 3. Persistenza: salva il nuovo utente nel database
        return userRepository.save(user);
    }
}

    