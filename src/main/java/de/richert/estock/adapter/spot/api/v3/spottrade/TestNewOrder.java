package de.richert.estock.adapter.spot.api.v3.spottrade;

import com.fasterxml.jackson.core.type.TypeReference;
import de.richert.estock.adapter.rest.model.OrderPlaceResp;
import de.richert.estock.common.JsonUtil;
import de.richert.estock.common.UserDataClient;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class TestNewOrder {
    public static OrderPlaceResp placeOrderTest(Map<String, String> params) {
        return UserDataClient.post("/api/v3/order/test", params, new TypeReference<OrderPlaceResp>() {
        });
    }

    public static void main(String[] args) {
        Map<String, String> params = new HashMap<>();
        //symbol=AEUSDT&side=SELL&type=LIMIT&timeInForce=GTC&quantity=1&price=20
        params.put("symbol", "BTCUSDT");
        params.put("side", "SELL");
        params.put("type", "LIMIT");
        params.put("quantity", "1");
        params.put("price", "100000");
        params.put("recvWindow", "60000");

        //test place order
        OrderPlaceResp placeRespTest = placeOrderTest(params);
        log.info("==>>placeRespTest:{}", JsonUtil.toJson(placeRespTest));
    }
}
