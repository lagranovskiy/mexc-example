package de.richert.estock.adapter.spot.api.v3.wallet;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import de.richert.estock.adapter.spot.api.v3.pojo.TransferRec;
import de.richert.estock.common.JsonUtil;
import de.richert.estock.common.UserDataClient;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
@Slf4j
public class TransferHistory {
    public static TransferRec getTransferRec(Map<String, String> params) {
        return UserDataClient.get("/api/v3/capital/transfer", params, new TypeReference<TransferRec>() {
        });
    }

    public static void main(String[] args) {
        //get transfer record
        TransferRec transferRec = getTransferRec(Maps.newHashMap(ImmutableMap.<String, String>builder()
                .put("fromAccountType", "SPOT")
                .put("toAccountType", "SPOT")
                .build()));
        log.info("==>>transferRec:{}", JsonUtil.toJson(transferRec));
    }
}
