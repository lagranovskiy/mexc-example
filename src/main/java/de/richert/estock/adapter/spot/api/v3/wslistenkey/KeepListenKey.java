package de.richert.estock.adapter.spot.api.v3.wslistenkey;

import com.fasterxml.jackson.core.type.TypeReference;
import de.richert.estock.common.JsonUtil;
import de.richert.estock.common.UserDataClient;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class KeepListenKey {
    public static Map<String, String> putUserDataStream(Map<String, String> params) {
        //todo
        return UserDataClient.put("/api/v3/userDataStream", params, new TypeReference<Map<String, String>>() {
        });
    }

    public static void main(String[] args) {
        Map<String, String> params = new HashMap<>();
        params.put("listenKey", "listenKey1");
        log.info("=>>result:{}", JsonUtil.toJson(putUserDataStream(params)));
    }
}
