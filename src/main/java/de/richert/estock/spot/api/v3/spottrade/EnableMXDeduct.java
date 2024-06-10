package de.richert.estock.spot.api.v3.spottrade;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import de.richert.estock.common.JsonUtil;
import de.richert.estock.common.UserDataClient;
import de.richert.estock.spot.api.v3.pojo.MxDeductResp;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public class EnableMXDeduct {
    public static MxDeductResp mxDeduct(Map<String, String> params) {
        return UserDataClient.post("/api/v3/mxDeduct/enable", params, new TypeReference<MxDeductResp>() {
        });
    }

    public static void main(String[] args) {
        //update mx deduct
        MxDeductResp mxDeductResp = mxDeduct(Maps.newHashMap(ImmutableMap.<String, String>builder()
                .put("mxDeductEnable", "true")
                .build()));
        log.info("==>>mxDeductResp:{}", JsonUtil.toJson(mxDeductResp));
    }
}
