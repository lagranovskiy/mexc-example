package de.richert.estock.adapter.spot.api.v3.marketdata;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import de.richert.estock.common.JsonUtil;
import de.richert.estock.common.MarketDataClient;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Ticker24hr {

  public static Ticker24hr ticker24hr(Map<String, String> params) {
    return MarketDataClient.get("/api/v3/ticker/24hr", params, new TypeReference<Ticker24hr>() {
    });
  }

  public static void main(String[] args) {
    HashMap<String, String> symbolParams = Maps.newHashMap(ImmutableMap.<String, String>builder()
        .put("symbol", "BTCUSDT")
        .build());
    //24hr ticker price change statistics
    log.info("=>>ticker24hr:{}", JsonUtil.toJson(ticker24hr(symbolParams)));
  }
}
