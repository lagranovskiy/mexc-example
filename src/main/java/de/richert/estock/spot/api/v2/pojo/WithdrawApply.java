package de.richert.estock.spot.api.v2.pojo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class WithdrawApply {

    private String currency;
    private String wallet_type;
    private String amount;
    private String chain;
    private String address;
    private String remark;
}
