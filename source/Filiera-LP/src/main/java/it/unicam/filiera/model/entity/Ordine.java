
package it.unicam.filiera.model.entity;

import it.unicam.filiera.model.enums.StatoOrdine;
import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ordini") // 'Order' è una parola chiave SQL, meglio usare un nome diverso
@Data
public class Ordine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "acquirente_id", nullable = false)
    private User acquirente;
    
    @OneToMany(mappedBy = "ordine", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrdineRiga> righe = new ArrayList<>();
    
    @Enumerated(EnumType.STRING)
    private StatoOrdine stato;
    
    private BigDecimal totale;
    private String indirizzoSpedizione;
    private String datiPagamento; // Semplificato, in un'app reale sarebbe più complesso
    
    private LocalDateTime createdAt;
    
    public void addRiga(OrdineRiga riga) {
        righe.add(riga);
        riga.setOrdine(this);
    }
}