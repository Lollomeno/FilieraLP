
package it.unicam.filiera.service.social;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ShareableData {
    private String title;
    private String description;
    private String url;
    private String imageUrl; // URL dell'immagine da mostrare nel post
}