
package it.unicam.filiera.repository;

import it.unicam.filiera.model.entity.Contenuto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContenutoRepository extends JpaRepository<Contenuto, Long> {}