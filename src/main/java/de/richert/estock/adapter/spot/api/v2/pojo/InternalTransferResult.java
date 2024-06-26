package de.richert.estock.adapter.spot.api.v2.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class InternalTransferResult {

    @JsonProperty("transact_id")
    private String id;
    private String currency;
    private String amount;
    @JsonProperty("from")
    private String fromSys;
    @JsonProperty("to")
    private String toSys;
    @JsonProperty("transact_state")
    private String state;


}
