
package it.unicam.filiera.service;

import it.unicam.filiera.exception.ResourceNotFoundException;
import it.unicam.filiera.model.entity.Contenuto;
import it.unicam.filiera.model.entity.Moderazione;
import it.unicam.filiera.model.entity.User;
import it.unicam.filiera.model.enums.EsitoModerazione;
import it.unicam.filiera.model.enums.Pubblicazione;
import it.unicam.filiera.repository.ContenutoRepository;
import it.unicam.filiera.repository.ModerationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class ModerationService {
    
    @Autowired
    private ContenutoRepository contenutoRepository;
    
    @Autowired
    private ModerationRepository moderationRepository;
    
    @Transactional
    public void approvaContenuto(Long contenutoId, String note, User curatore) {
        Contenuto contenuto = contenutoRepository.findById(contenutoId)
            .orElseThrow(() -> new ResourceNotFoundException("Contenuto non trovato"));
            
        // Logica di business: non si può approvare un contenuto già pubblicato
        if(contenuto.getStatoPubblicazione() != Pubblicazione.IN_REVISIONE) {
             // throw new IllegalStateException("Il contenuto non è in stato di revisione");
        }
        
        contenuto.setStatoPubblicazione(Pubblicazione.PUBBLICATO);
        contenutoRepository.save(contenuto);
        
        Moderazione moderazione = new Moderazione();
        moderazione.setContenuto(contenuto);
        moderazione.setCuratore(curatore);
        moderazione.setEsito(EsitoModerazione.APPROVATO);
        moderazione.setNote(note);
        moderazione.setCreatedAt(LocalDateTime.now());
        
        moderationRepository.save(moderazione);
    }
    
    // Aggiungere metodo per rifiutareContenuto
}