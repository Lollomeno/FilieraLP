
package it.unicam.filiera.model.entity;

import it.unicam.filiera.model.enums.EsitoModerazione;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
public class Moderazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contenuto_id", nullable = false)
    private Contenuto contenuto;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curatore_id", nullable = false)
    private User curatore;
    
    @Enumerated(EnumType.STRING)
    private EsitoModerazione esito;
    
    private String note;
    private LocalDateTime createdAt;
}
