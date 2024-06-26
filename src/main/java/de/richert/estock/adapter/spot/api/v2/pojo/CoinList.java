package de.richert.estock.adapter.spot.api.v2.pojo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class CoinList {

    private String currency;

    private List<Coin> coins;

    private String full_name;
}
