
package it.unicam.filiera.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Eccezione usata quando un'operazione viene tentata su un'entità
 * che non si trova nello stato corretto (es. approvare un prodotto già pubblicato).
 */
@ResponseStatus(HttpStatus.BAD_REQUEST) // Dice a Spring di restituire un errore HTTP 400
public class IllegalStateException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IllegalStateException(String message) {
        super(message);
    }
}