
package it.unicam.filiera.model.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@PrimaryKeyJoinColumn(name = "user_id") // Collega l'ID a quello della tabella User
public class Azienda extends User {
    
    @Column(nullable = false)
    private String nomeAzienda;

    @Lob
    private String descrizioneAzienda;

    private String partitaIva;

    private double latitudine;
    private double longitudine;

    // Relazione con le certificazioni (se un'azienda può averle direttamente)
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "azienda_certificazione",
        joinColumns = @JoinColumn(name = "azienda_id"),
        inverseJoinColumns = @JoinColumn(name = "certificazione_id")
    )
    private Set<Certificazione> certificazioni;
}