
package it.unicam.filiera.repository;

import it.unicam.filiera.model.entity.Pacchetto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PackageRepository extends JpaRepository<Pacchetto, Long> {}