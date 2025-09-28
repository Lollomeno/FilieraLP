
package it.unicam.filiera.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.math.BigDecimal;
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
        name = "prodotto_certificazione",
        joinColumns = @JoinColumn(name = "prodotto_id"),
        inverseJoinColumns = @JoinColumn(name = "certificazione_id")
    )
    private Set<Certificazione> certificazioni;
}