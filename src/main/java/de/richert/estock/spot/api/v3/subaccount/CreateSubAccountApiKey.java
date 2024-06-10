package de.richert.estock.spot.api.v3.subaccount;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import de.richert.estock.common.JsonUtil;
import de.richert.estock.common.UserDataClient;
import de.richert.estock.spot.api.v3.pojo.SubAccountApiKey;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CreateSubAccountApiKey {

  public static SubAccountApiKey createSubAccountApiKey(Map<String, String> params) {
    return UserDataClient.post("/api/v3/sub-account/apiKey", params, new TypeReference<SubAccountApiKey>() {
    });
  }

  public static void main(String[] args) {
    //create subAccount
    SubAccountApiKey subAccountApiKey = createSubAccountApiKey(Maps.newHashMap(ImmutableMap.<String, String>builder()
        .put("subAccount", "subAccount0421")
        .put("permissions", "SPOT_ACCOUNT_READ")
        .put("note", "note1")
        .put("ip", "127.0.0.1")
        .build()));

    log.info("==>>subAccountApiKey:{}", JsonUtil.toJson(subAccountApiKey));
  }
}
