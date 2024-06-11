package de.richert.estock.adapter.rest.model;

import de.richert.estock.adapter.websocket.model.Geschaeftsart;
import lombok.Builder;

@Builder
public record OrderAnlage(
    double price,
    String symbol,
    double menge,
    int zeitfenster,
    Geschaeftsart geschaeftsart,
    Ordertyp ordertyp
) {

}
