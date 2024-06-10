package de.richert.estock.spot.api.v3.rebate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import de.richert.estock.common.JsonUtil;
import de.richert.estock.common.UserDataClient;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public class AffiliateSubAffiliates {

    public static Object affiliateSubAffiliates(Map<String, String> params) {
        return UserDataClient.get("/api/v3/rebate/affiliate/subaffiliates", params, new TypeReference<Map<String, String>>() {
        });
    }

    public static void main(String[] args) {

        //Get SubAffiliates Data (affiliate only)
        Object subAffiliatesRecord = affiliateSubAffiliates(Maps.newHashMap(ImmutableMap.<String, String>builder()
                .put("startTime", "1566921600000")
                .build()));

        log.info("==>>subAffiliatesRecord:{}", JsonUtil.toJson(subAffiliatesRecord));
    }
}
