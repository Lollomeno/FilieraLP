
package it.unicam.filiera.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
public class FaseFiliera {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prodotto_id", nullable = false)
    private Prodotto prodotto;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "azienda_id", nullable = false)
    private Azienda azienda;
    
    private String tipoFase; // es. PRODUZIONE, TRASFORMAZIONE, DISTRIBUZIONE
    private LocalDateTime data;
    
    @Lob
    private String note;
}