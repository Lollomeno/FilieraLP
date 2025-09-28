
package it.unicam.filiera.repository;

import it.unicam.filiera.model.entity.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Prenotazione, Long> {}