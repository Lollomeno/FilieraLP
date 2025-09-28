
package it.unicam.filiera.repository;

import it.unicam.filiera.model.entity.Ordine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Ordine, Long> {}