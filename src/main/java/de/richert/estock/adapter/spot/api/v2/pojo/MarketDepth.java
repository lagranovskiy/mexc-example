package de.richert.estock.adapter.spot.api.v2.pojo;

import lombok.Data;

@Data
public class MarketDepth {

    private String price;

    private String quantity;
}
