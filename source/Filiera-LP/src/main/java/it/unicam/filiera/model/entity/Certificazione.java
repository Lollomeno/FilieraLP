
package it.unicam.filiera.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

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
}