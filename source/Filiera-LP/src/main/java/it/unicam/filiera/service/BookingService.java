
package it.unicam.filiera.service;

import it.unicam.filiera.exception.IllegalStateException;
import it.unicam.filiera.exception.ResourceNotFoundException;
import it.unicam.filiera.model.entity.Evento;
import it.unicam.filiera.model.entity.Prenotazione;
import it.unicam.filiera.model.entity.User;
import it.unicam.filiera.repository.BookingRepository;
import it.unicam.filiera.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class BookingService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private BookingRepository bookingRepository;

    /**
     * Gestisce la logica di business per creare una prenotazione per un evento.
     * Questa operazione è transazionale: o tutti i passaggi hanno successo, o nessuno viene salvato.
     *
     * @param eventoId L'ID dell'evento da prenotare.
     * @param numeroPosti Il numero di posti richiesti.
     * @param acquirente L'utente che sta effettuando la prenotazione.
     * @return L'entità Prenotazione appena creata e salvata.
     * @throws ResourceNotFoundException se l'evento non viene trovato.
     * @throws IllegalStateException se i posti non sono disponibili.
     */
    @Transactional
    public Prenotazione creaPrenotazione(Long eventoId, int numeroPosti, User acquirente) {
        // 1. Recupera l'evento dal database
        Evento evento = eventRepository.findById(eventoId)
            .orElseThrow(() -> new ResourceNotFoundException("Evento non trovato con id: " + eventoId));
            
        // 2. Verifica la disponibilità e decrementa i posti.
        // La logica è incapsulata nell'entità Evento per rispettare l'Expert Pattern.
        // Il metodo decrementaPosti lancerà un'eccezione se i posti non sono sufficienti.
        try {
            evento.decrementaPosti(numeroPosti);
        } catch (IllegalArgumentException e) { 
            // Usiamo IllegalArgumentException come esempio di eccezione custom
            // lanciata da decrementaPosti.
            throw new IllegalStateException(e.getMessage());
        }

        // 3. Salva lo stato aggiornato dell'evento (con meno posti disponibili)
        eventRepository.save(evento);
        
        // 4. Crea la nuova entità Prenotazione
        Prenotazione prenotazione = new Prenotazione();
        prenotazione.setAcquirente(acquirente);
        prenotazione.setEvento(evento); // Associa l'evento alla prenotazione
        prenotazione.setPostiPrenotati(numeroPosti);
        prenotazione.setCreatedAt(LocalDateTime.now());
        
        // 5. Salva la nuova prenotazione nel database
        return bookingRepository.save(prenotazione);
    }
}