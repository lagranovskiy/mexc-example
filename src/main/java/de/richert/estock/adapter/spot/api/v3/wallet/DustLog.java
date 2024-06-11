package de.richert.estock.adapter.spot.api.v3.wallet;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import de.richert.estock.adapter.spot.api.v3.pojo.ConvertRecordItem;
import de.richert.estock.adapter.spot.api.v3.pojo.PageRecords;
import de.richert.estock.common.JsonUtil;
import de.richert.estock.common.UserDataClient;
import lombok.extern.slf4j.Slf4j;


import java.util.Map;

@Slf4j
public class DustLog {

    public static PageRecords<ConvertRecordItem> getConvertHisRec(Map<String, String> params) {
        return UserDataClient.get("/api/v3/capital/convert", params, new TypeReference<PageRecords<ConvertRecordItem>>() {
        });
    }

    public static void main(String[] args) {
        //get convert history record
        PageRecords<ConvertRecordItem> convertRecords = getConvertHisRec(Maps.newHashMap(ImmutableMap.<String, String>builder()
                .put("page", "1")
                .put("limit", "10")
                .build()));
        log.info("==>>convertRecords:{}", JsonUtil.toJson(convertRecords));
    }
}
