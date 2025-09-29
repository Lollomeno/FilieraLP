
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
public class Pacchetto extends Contenuto {
    
    private BigDecimal prezzoTotale;

    @OneToMany(mappedBy = "pacchetto", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<PacchettoItem> items = new HashSet<>();
    
    public void addItem(PacchettoItem item) {
        items.add(item);
        item.setPacchetto(this);
    }
}