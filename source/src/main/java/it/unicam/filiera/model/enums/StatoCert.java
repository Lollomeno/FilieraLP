
package it.unicam.filiera.model.enums;

/**
 * Rappresenta i possibili stati del ciclo di vita di una Certificazione.
 */
public enum StatoCert {
    
    /**
     * La certificazione è stata caricata ma è in attesa di approvazione.
     */
    IN_REVISIONE,
    
    /**
     * La certificazione è stata approvata ed è valida.
     */
    APPROVATO,
    
    /**
     * La certificazione è stata revisionata e rifiutata.
     */
    RIFIUTATO,
    
    /**
     * La certificazione è scaduta (la sua data di validità è passata).
     */
    SCADUTO
}