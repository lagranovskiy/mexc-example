package de.richert.estock.adapter.spot.api.v3.rebate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import de.richert.estock.adapter.spot.api.v3.pojo.PageRecords;
import de.richert.estock.adapter.spot.api.v3.pojo.RebateHistory;
import de.richert.estock.common.JsonUtil;
import de.richert.estock.common.UserDataClient;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public class GetRebateHistoryRecords {

    public static PageRecords<RebateHistory> rebateHistory(Map<String, String> params) {
        return UserDataClient.get("/api/v3/rebate/taxQuery", params, new TypeReference<PageRecords<RebateHistory>>() {
        });
    }

    public static void main(String[] args) {

        //get rebate history
        PageRecords<RebateHistory> history = rebateHistory(Maps.newHashMap(ImmutableMap.<String, String>builder()
                .put("page", "1")
                .build()));
        log.info("==>>history:{}", JsonUtil.toJson(history));
    }
}
