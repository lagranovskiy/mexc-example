package de.richert.estock.adapter.spot.api.v3.marketdata;

import com.fasterxml.jackson.core.type.TypeReference;
import de.richert.estock.adapter.spot.api.v3.pojo.Symbols;
import de.richert.estock.common.JsonUtil;
import de.richert.estock.common.MarketDataClient;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ApiDefaultSymbol {

  public static Symbols defaultSymbols(Map<String, String> params) {
    return MarketDataClient.get("/api/v3/defaultSymbols", params, new TypeReference<Symbols>() {
    });
  }

  public static void main(String[] args) {
    //api default symbols
    log.info("=>>defaultSymbols:{}", JsonUtil.toJson(defaultSymbols(new HashMap<>())));
  }
}
