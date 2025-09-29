
package it.unicam.filiera.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Entity
@Data
public class OrdineRiga {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ordine_id", nullable = false)
    private Ordine ordine;
    
    // Polimorfismo: una riga può riferirsi a un Prodotto o a un Pacchetto
    // Qui usiamo un approccio semplice. Potrebbe essere migliorato con @Any o @MappedSuperclass
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prodotto_id")
    private Prodotto prodotto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pacchetto_id")
    private Pacchetto pacchetto;
    
    private int quantita;
    private BigDecimal prezzoUnitario;
    private BigDecimal subtotale;
}