
package it.unicam.filiera.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Prodotto extends Contenuto {
    
    @Column(nullable = false)
    private BigDecimal prezzo;
    
    private Integer stock;
    private String categoria;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "prodotto_certificazione", // Nome della tabella di giunzione che JPA creerà
        joinColumns = @JoinColumn(name = "prodotto_id"), // Colonna con la FK di questa classe (Prodotto)
        inverseJoinColumns = @JoinColumn(name = "certificazione_id") // Colonna con la FK dell'altra classe (Certificazione)
    )
    private Set<Certificazione> certificazioni = new HashSet<>();
}