package it.unicam.filiera;

import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import it.unicam.filiera.model.entity.User;
import it.unicam.filiera.model.enums.Role;
import it.unicam.filiera.repository.UserRepository;

@SpringBootApplication
public class FilieraLpApplication {

	public static void main(String[] args) {
		SpringApplication.run(FilieraLpApplication.class, args);
	}



@Bean
CommandLineRunner initDatabase(UserRepository userRepository) {
 return args -> {
     User venditore = new User();
     venditore.setEmail("venditore@test.com");
     venditore.setPassword("password");
     venditore.setNome("Mario");
     venditore.setCognome("Rossi");
     venditore.setRoles(Set.of(Role.PRODUTTORE)); // Assumendo che Role sia un enum
     userRepository.save(venditore);
     System.out.println("Utente di test creato con ID: " + venditore.getId());
  };
  
 }

}
