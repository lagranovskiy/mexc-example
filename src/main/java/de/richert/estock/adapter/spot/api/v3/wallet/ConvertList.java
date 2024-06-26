package de.richert.estock.adapter.spot.api.v3.wallet;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import de.richert.estock.adapter.spot.api.v3.pojo.ConvertItem;
import de.richert.estock.common.JsonUtil;
import de.richert.estock.common.UserDataClient;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;

@Slf4j
public class ConvertList {
    public static List<ConvertItem> convertList(Map<String, String> params) {
        return UserDataClient.get("/api/v3/capital/convert/list", params, new TypeReference<List<ConvertItem>>() {
        });
    }

    public static void main(String[] args) {
        //get convert list
        List<ConvertItem> convertList = convertList(Maps.newHashMap(ImmutableMap.<String, String>builder()
                .put("recvWindow", "60000")
                .build()));
        log.info("==>>convertList:{}", JsonUtil.toJson(convertList));
    }
}
