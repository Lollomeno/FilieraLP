
package it.unicam.filiera.controller;

import it.unicam.filiera.dto.ProdottoDTO;
import it.unicam.filiera.model.entity.Prodotto;
import it.unicam.filiera.model.entity.User;
import it.unicam.filiera.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/prodotti")
public class ProductController {
    
    @Autowired
    private ProductService productService;
    
    // Endpoint per la modifica di un prodotto
    @PutMapping("/{id}")
    public ResponseEntity<Prodotto> modificaProdotto(
            @PathVariable Long id,
            @RequestBody ProdottoDTO nuoviDati) {
        
        // In un'app reale, l'utente verrebbe dal contesto di sicurezza di Spring Security
        User utenteCorrente = new User(); // ESEMPIO: DA SOSTITUIRE
        utenteCorrente.setId(1L); // ESEMPIO: DA SOSTITUIRE
        
        Prodotto prodottoAggiornato = productService.modificaProdotto(id, nuoviDati, utenteCorrente);
        return ResponseEntity.ok(prodottoAggiornato);
    }
    
    // Altri endpoint:
    // @PostMapping per la creazione
    // @DeleteMapping("/{id}") per l'eliminazione
    // @GetMapping("/{id}") per la lettura di un prodotto
    // @GetMapping per la lista di tutti i prodotti
}