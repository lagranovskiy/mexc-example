package de.richert.estock.adapter.spot.api.v3.spottrade;

import com.fasterxml.jackson.core.type.TypeReference;
import de.richert.estock.adapter.spot.api.v3.pojo.Order;
import de.richert.estock.common.UserDataClient;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AllOrders {

  public static List<Order> allOrders(Map<String, String> params) {
    return UserDataClient.get("/api/v3/allOrders", params, new TypeReference<List<Order>>() {
    });
  }

}
