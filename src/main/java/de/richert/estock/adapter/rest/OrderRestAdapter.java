package de.richert.estock.adapter.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import de.richert.estock.adapter.rest.model.OrderAnlage;
import de.richert.estock.adapter.rest.model.OrderPlaceResp;
import de.richert.estock.common.UserDataClient;
import java.util.HashMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderRestAdapter {

  public static final String PATH = "/api/v3/order";

  /**
   * Platziert den Order auf der Börse
   *
   * @param orderAnlage Anlage Informationen
   * @return erhaltene Quittung
   */
  public OrderPlaceResp platziereOrder(OrderAnlage orderAnlage) {
    try {
      var params = new HashMap<String, String>();
      //symbol=AEUSDT&side=SELL&type=LIMIT&timeInForce=GTC&quantity=1&price=20
      params.put("symbol", orderAnlage.symbol());
      params.put("side", orderAnlage.geschaeftsart().getApibegriff());
      params.put("type", orderAnlage.ordertyp().name());
      params.put("quantity", String.valueOf(orderAnlage.menge()));
      params.put("price", String.valueOf(orderAnlage.price()));
      params.put("recvWindow", String.valueOf(orderAnlage.zeitfenster()));

      log.info("Wir senden folgende Anfrage {}", params);
      //place order
      var placeResp = UserDataClient.post(PATH, params, new TypeReference<OrderPlaceResp>() {
      });

      log.info("==>>Order wurde platziert:{}", placeResp);

      return placeResp;
    } catch (RuntimeException e) {
      log.info("Kann nicht mit Order API sprechen", e);
      return null;
    }
  }
}
