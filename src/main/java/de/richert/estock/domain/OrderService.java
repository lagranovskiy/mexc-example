package de.richert.estock.domain;

import de.richert.estock.adapter.rest.OrderRestAdapter;
import de.richert.estock.adapter.rest.model.OrderAnlage;
import de.richert.estock.adapter.rest.model.Ordertyp;
import de.richert.estock.adapter.websocket.model.BookTickerDto;
import de.richert.estock.adapter.websocket.model.Geschaeftsart;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderService {

  public static final double MENGE = 0.0001;
  public static final int ZEITFENSTER = 5000;

  private final OrderRestAdapter orderRestAdapter;

  public void pruefeObKaufNoetig(BookTickerDto bookTickerDto) {
    var gescaeftsart = bookTickerDto.ermittleGeschaeftsart();

    if (gescaeftsart == Geschaeftsart.NIX) {
      return;
    }

    orderRestAdapter.platziereOrder(OrderAnlage.builder()
        .geschaeftsart(gescaeftsart)
        .menge(MENGE)
        .price(bookTickerDto.ermittlePreis(gescaeftsart))
        .ordertyp(Ordertyp.LIMIT)
        .symbol(bookTickerDto.s())
        .zeitfenster(ZEITFENSTER)
        .build());
  }
}
