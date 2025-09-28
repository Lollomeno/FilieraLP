
package it.unicam.filiera.repository;

import it.unicam.filiera.model.entity.Moderazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModerationRepository extends JpaRepository<Moderazione, Long> {}