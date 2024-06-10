package de.richert.estock.spot.api.v3.subaccount;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import de.richert.estock.common.JsonUtil;
import de.richert.estock.common.UserDataClient;
import de.richert.estock.spot.api.v3.pojo.SubAccount;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CreateSubAccount {


  public static SubAccount createSubAccount(Map<String, String> params) {
    return UserDataClient.post("/api/v3/sub-account/virtualSubAccount", params, new TypeReference<SubAccount>() {
    });
  }

  public static void main(String[] args) {
    //create subAccount
    SubAccount subAccount = createSubAccount(Maps.newHashMap(ImmutableMap.<String, String>builder()
        .put("subAccount", "subAccount0421")
        .put("note", "note1")
        .build()));
    log.info("==>>subAccount:{}", JsonUtil.toJson(subAccount));
  }
}
