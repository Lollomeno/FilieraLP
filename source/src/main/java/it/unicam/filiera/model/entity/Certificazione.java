
package it.unicam.filiera.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import it.unicam.filiera.model.enums.StatoCert;

@Entity

@Data
public class Certificazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, unique = true)
    private String nome;
    
    private String enteRilascio;
    
    @Lob
    private String descrizione;
    
    private LocalDate validFrom;
    private LocalDate validTo;

      @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatoCert stato; 

   
    @ManyToMany(mappedBy = "certificazioni")
    private Set<Prodotto> prodotti = new HashSet<>();

    @ManyToMany(mappedBy = "certificazioni")
    private Set<Azienda> aziende = new HashSet<>();
}