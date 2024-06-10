package de.richert.estock.spot.api.v3.pojo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TickerPrice {
    private String symbol;
    private String price;
}
