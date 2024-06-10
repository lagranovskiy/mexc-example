package de.richert.estock.spot.api.v3.wallet;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import de.richert.estock.common.JsonUtil;
import de.richert.estock.common.UserDataClient;
import de.richert.estock.spot.api.v3.pojo.ConvertResp;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public class DustTransfer {
    public static ConvertResp convert(Map<String, String> params) {
        return UserDataClient.post("/api/v3/capital/convert", params, new TypeReference<ConvertResp>() {
        });
    }

    public static void main(String[] args) {
        //dust transfer
        ConvertResp convertResp = convert(Maps.newHashMap(ImmutableMap.<String, String>builder()
                .put("asset", "GPT")
                .build()));
        log.info("==>>convertResp:{}", JsonUtil.toJson(convertResp));
    }

}
