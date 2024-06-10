package de.richert.estock.spot.api.v3.marketdata;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import de.richert.estock.common.JsonUtil;
import de.richert.estock.common.MarketDataClient;
import de.richert.estock.spot.api.v3.pojo.Depth;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OrderBook {

  public static Depth depth(Map<String, String> params) {
    return MarketDataClient.get("/api/v3/depth", params, new TypeReference<Depth>() {
    });
  }

  public static void main(String[] args) {
    HashMap<String, String> symbolParams = Maps.newHashMap(ImmutableMap.<String, String>builder()
        .put("symbol", "BTCUSDT")
        .build());
    //order book
    log.info("=>>depth:{}", JsonUtil.toJson(depth(symbolParams)));
  }
}
