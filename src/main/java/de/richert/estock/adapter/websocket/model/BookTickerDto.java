package de.richert.estock.adapter.websocket.model;

public record BookTickerDto(
    String c,
    String s,
    BookTickerDataDto d,
    Long t) {

  public double ermittlePreis(Geschaeftsart geschaeftsart) {
    return switch (geschaeftsart) {
      case KAUF -> d.a();
      case VERKAUF -> d.b();
      case NIX -> 0.0;
    };
  }

  public Geschaeftsart ermittleGeschaeftsart() {
    if (d().A() < 5 || d().B() < 5) {
      return Geschaeftsart.NIX;
    }

    if (d().A() > d().B()) {
      return Geschaeftsart.VERKAUF;
    } else if (d().A() < d().B()) {
      return Geschaeftsart.KAUF;
    }

    return Geschaeftsart.NIX;
  }
}
