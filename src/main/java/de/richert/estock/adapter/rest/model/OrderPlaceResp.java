package de.richert.estock.adapter.rest.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class OrderPlaceResp {
    private String symbol;
    private String orderId;
    private Long orderListId;
    private String clientOrderId;
    private Long transactTime;
}
