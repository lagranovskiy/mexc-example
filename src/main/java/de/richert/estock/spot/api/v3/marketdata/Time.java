package de.richert.estock.spot.api.v3.marketdata;

import com.fasterxml.jackson.core.type.TypeReference;
import de.richert.estock.common.JsonUtil;
import de.richert.estock.common.MarketDataClient;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class Time {

    public static Map<String, Long> time() {
        return MarketDataClient.get("/api/v3/time", new HashMap<>(), new TypeReference<Map<String, Long>>() {
        });
    }

    public static void main(String[] args) {
        log.info("=>>time:{}", JsonUtil.toJson(time()));
    }
}
