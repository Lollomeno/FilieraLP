
package it.unicam.filiera.repository;

import it.unicam.filiera.model.entity.Prodotto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Prodotto, Long> {}