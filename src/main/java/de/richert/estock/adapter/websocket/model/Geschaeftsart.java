package de.richert.estock.adapter.websocket.model;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Geschaeftsart {
  KAUF("BUY"),
  VERKAUF("SELL"),
  NIX(null);

  @Getter
  private final String apibegriff;
}
