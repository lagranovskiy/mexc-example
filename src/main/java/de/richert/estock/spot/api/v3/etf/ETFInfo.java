package de.richert.estock.spot.api.v3.etf;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import de.richert.estock.common.JsonUtil;
import de.richert.estock.common.MarketDataClient;
import de.richert.estock.spot.api.v3.pojo.EtfInfo;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class ETFInfo {

    public static EtfInfo etfInfo(Map<String, String> params) {
        return MarketDataClient.get("/api/v3/etf/info", params, new TypeReference<EtfInfo>() {
        });
    }

    public static void main(String[] args) {

        HashMap<String, String> symbolParams = Maps.newHashMap(ImmutableMap.<String, String>builder()
                .put("symbol", "BTCUSDT3L")
                .build());

        log.info("=>>etfInfo:{}", JsonUtil.toJson(etfInfo(symbolParams)));
    }
}
