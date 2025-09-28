
package it.unicam.filiera.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class ProdottoDTO {
    private String titolo;
    private String descrizione;
    private BigDecimal prezzo;
    private Integer stock;
    private String categoria;
}