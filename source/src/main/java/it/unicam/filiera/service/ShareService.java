package it.unicam.filiera.service;


import it.unicam.filiera.model.entity.Contenuto;
import it.unicam.filiera.repository.ContenutoRepository;
import it.unicam.filiera.service.social.ShareResult;
import it.unicam.filiera.service.social.ShareableData;
import it.unicam.filiera.service.social.SocialShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class ShareService {
    
    @Autowired
    private ContenutoRepository contenutoRepository;
    
    // Iniezione di tutte le implementazioni di SocialShareService
    private final Map<String, SocialShareService> shareServices;

    @Autowired
    public ShareService(Map<String, SocialShareService> shareServices) {
        this.shareServices = shareServices;
    }
    
    public ShareResult condividiContenuto(Long contenutoId, String socialTarget) {
        // 1. Recupera il contenuto
        Contenuto contenuto = contenutoRepository.findById(contenutoId)
            .orElseThrow();
            
        // 2. Seleziona il servizio di condivisione corretto
        SocialShareService service = Optional.ofNullable(shareServices.get(socialTarget))
            .orElseThrow(() -> new IllegalArgumentException("Piattaforma social non supportata: " + socialTarget));
            
        // 3. Prepara i dati
        // In un'app reale, l'URL sarebbe costruito dinamicamente
        ShareableData dataToShare = new ShareableData(
            contenuto.getTitolo(),
            contenuto.getDescrizione(),
            "http://miosito.com/contenuto/" + contenuto.getId(),
            null // URL immagine
        );
        
        // 4. Delega la condivisione al servizio specifico
        return service.share(dataToShare);
    }
}