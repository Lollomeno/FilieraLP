package it.unicam.filiera;

import it.unicam.filiera.model.entity.User;
import it.unicam.filiera.model.enums.Role;
import it.unicam.filiera.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@SpringBootApplication
public class FilieraLpApplication {

    public static void main(String[] args) {
        SpringApplication.run(FilieraLpApplication.class, args);
    }

    
    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            // Controlla se l'utente esiste già per non crearlo ogni volta
            if (userRepository.findByEmail("venditore@test.com").isEmpty()) {
                User venditore = new User();
                venditore.setEmail("venditore@test.com");
                // Codifica la password prima di salvarla!
                venditore.setPassword(passwordEncoder.encode("password"));
                venditore.setNome("Mario");
                venditore.setCognome("Rossi");
                venditore.setRoles(Set.of(Role.PRODUTTORE));
                userRepository.save(venditore);
                System.out.println("Utente di test 'venditore@test.com' creato con ID: " + venditore.getId());
            } else {
                System.out.println("Utente di test 'venditore@test.com' già esistente.");
            }
        };
    }

    /**
     * Definisce un Bean per il PasswordEncoder.
     * Spring userà questo metodo per creare un oggetto PasswordEncoder
     * ogni volta che un'altra classe lo richiede con @Autowired.
     * Usiamo BCrypt, l'algoritmo di hashing standard e sicuro.
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}