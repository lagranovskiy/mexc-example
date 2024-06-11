package de.richert.estock.adapter.websocket.model;

import lombok.Getter;

public record BookTickerDataDto(
    double A,
    double B,
    double a,
    double b
) {

}
