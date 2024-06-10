package de.richert.estock;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import de.richert.estock.spot.api.v3.pojo.Order;
import de.richert.estock.spot.api.v3.pojo.TransferRec;
import de.richert.estock.spot.api.v3.spottrade.AllOrders;
import de.richert.estock.spot.api.v3.wallet.TransferHistory;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class TestService {

  @GetMapping("/listorders")
  public List<Order> listOrders() {
    return AllOrders.allOrders(Maps.newHashMap(ImmutableMap.<String, String>builder()
        .put("symbol", "BTCUSDT")
        .build()));
  }

  @GetMapping("/transferhistory")
  public TransferRec liefereBisschenDaten() {
    log.warn("Hey");

    //get transfer record
    return TransferHistory.getTransferRec(Maps.newHashMap(ImmutableMap.<String, String>builder()
        .put("fromAccountType", "SPOT")
        .put("toAccountType", "SPOT")
        .build()));
  }
}
