package de.richert.estock.adapter.spot.api.v3.marketdata;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import de.richert.estock.adapter.spot.api.v3.pojo.ExchangeInfo;
import de.richert.estock.common.JsonUtil;
import de.richert.estock.common.MarketDataClient;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExchangeInformation {

  public static ExchangeInfo exchangeInfo(Map<String, String> params) {
    return MarketDataClient.get("/api/v3/exchangeInfo", params, new TypeReference<ExchangeInfo>() {
    });
  }

  public static void main(String[] args) {
    HashMap<String, String> symbolParams = Maps.newHashMap(ImmutableMap.<String, String>builder()
        .put("symbol", "BTCUSDT")
        .build());
    //exchange information
    log.info("=>>exchangeInfo:{}", JsonUtil.toJson(exchangeInfo(symbolParams)));
  }
}
