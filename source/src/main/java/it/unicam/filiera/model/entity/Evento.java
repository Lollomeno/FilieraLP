
package it.unicam.filiera.model.entity;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.time.LocalDateTime;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Evento extends Contenuto {
    
    private LocalDateTime dataOra;
    private Integer postiTotali;
    private Integer postiDisponibili;
    private String location;
    
    public void decrementaPosti(int numeroPosti) {
        if (this.postiDisponibili < numeroPosti) {
            // throw new InsufficientSeatsException("Posti non disponibili");
        }
        this.postiDisponibili -= numeroPosti;
    }
}