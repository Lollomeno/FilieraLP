
package it.unicam.filiera.service;

import it.unicam.filiera.dto.ProdottoDTO;
import it.unicam.filiera.exception.ForbiddenException;
import it.unicam.filiera.exception.ResourceNotFoundException;
import it.unicam.filiera.model.entity.Prodotto;
import it.unicam.filiera.model.entity.User;
import it.unicam.filiera.model.enums.Pubblicazione;
import it.unicam.filiera.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    
    // Assumiamo esista un ProductValidator, qui semplificato
    // @Autowired
    // private ProductValidator productValidator;

    @Transactional
    public Prodotto modificaProdotto(Long prodottoId, ProdottoDTO nuoviDati, User utenteCorrente) {
        // 1. Validazione (omessa per brevità, ma sarebbe qui)
        // productValidator.validate(nuoviDati);

        // 2. Recupero
        Prodotto prodotto = productRepository.findById(prodottoId)
                .orElseThrow(() -> new ResourceNotFoundException("Prodotto non trovato con id: " + prodottoId));

        // 3. Controllo Autorizzazione (Fondamentale!)
        if (!prodotto.getCreatore().getId().equals(utenteCorrente.getId())) {
            throw new ForbiddenException("Non hai i permessi per modificare questo prodotto.");
        }

        // 4. Aggiornamento
        prodotto.setTitolo(nuoviDati.getTitolo());
        prodotto.setDescrizione(nuoviDati.getDescrizione());
        prodotto.setPrezzo(nuoviDati.getPrezzo());
        prodotto.setStock(nuoviDati.getStock());
        prodotto.setStatoPubblicazione(Pubblicazione.IN_REVISIONE);

        // 5. Salvataggio
        return productRepository.save(prodotto);
    }
    
    // Metodo per creare prodotto
    // Metodo per eliminare prodotto (con controlli di sicurezza)
}