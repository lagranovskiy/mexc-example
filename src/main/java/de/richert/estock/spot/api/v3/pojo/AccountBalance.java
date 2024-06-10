package de.richert.estock.spot.api.v3.pojo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AccountBalance {
    private String asset;
    private String free;
    private String locked;
}
