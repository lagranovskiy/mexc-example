package de.richert.estock.spot.api.v3.spottrade;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import de.richert.estock.common.JsonUtil;
import de.richert.estock.common.UserDataClient;
import de.richert.estock.spot.api.v3.pojo.Order;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;

@Slf4j
public class AllOrders {
    public static List<Order> allOrders(Map<String, String> params) {
        return UserDataClient.get("/api/v3/allOrders", params, new TypeReference<List<Order>>() {
        });
    }

    public static void main(String[] args) {
        //get all orders
        List<Order> allOrders = allOrders(Maps.newHashMap(ImmutableMap.<String, String>builder()
                .put("symbol", "BTCUSDT")
                .build()));
        log.info("==>>allOrders:{}", JsonUtil.toJson(allOrders));
    }
}
