
package it.unicam.filiera.service.social;

/**
 * Interfaccia che definisce il contratto per un servizio di condivisione su social network.
 * Funge da <<boundary>> per isolare il nostro sistema dalle API esterne.
 */
public interface SocialShareService {

    /**
     * Condivide un contenuto su una specifica piattaforma social.
     *
     * @param shareableData L'oggetto contenente i dati da condividere (titolo, url, etc.).
     * @return Un oggetto ShareResult che incapsula l'esito della condivisione.
     * @throws ShareFailedException se la condivisione fallisce.
     */
    ShareResult share(ShareableData shareableData);

    /**
     * Restituisce il nome della piattaforma gestita da questa implementazione (es. "facebook").
     * @return una stringa che identifica la piattaforma.
     */
    String getPlatformName();
}