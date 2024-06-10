package de.richert.estock.spot.api.v3.marketdata;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import de.richert.estock.common.JsonUtil;
import de.richert.estock.common.MarketDataClient;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Kline {

  public static List<Object[]> klines(Map<String, String> params) {
    return MarketDataClient.get("/api/v3/klines", params, new TypeReference<List<Object[]>>() {
    });
  }

  public static void main(String[] args) {
    HashMap<String, String> symbolParams = Maps.newHashMap(ImmutableMap.<String, String>builder()
        .put("symbol", "BTCUSDT")
        .build());
    //kline/candlestick data
    symbolParams.put("interval", "1m");
    log.info("=>>klines:{}", JsonUtil.toJson(klines(symbolParams)));
  }
}
