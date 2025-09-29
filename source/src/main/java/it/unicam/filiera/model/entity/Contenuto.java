
package it.unicam.filiera.model.entity;

import it.unicam.filiera.model.enums.Pubblicazione;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data
public abstract class Contenuto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String titolo;
    
    @Lob // Per testi lunghi
    private String descrizione;
    
    @Enumerated(EnumType.STRING)
    private Pubblicazione statoPubblicazione;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "creatore_id", nullable = false)
    private User creatore;
    
    private LocalDateTime createdAt;
}