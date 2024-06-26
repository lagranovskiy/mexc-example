package de.richert.estock.adapter.spot.api.v3.subaccount;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import de.richert.estock.adapter.spot.api.v3.pojo.SubAccount;
import de.richert.estock.common.JsonUtil;
import de.richert.estock.common.UserDataClient;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class SubAccountList {

  public static Map<String, List<SubAccount>> getSubAccountList(Map<String, String> params) {
    return UserDataClient.get("/api/v3/sub-account/list", params, new TypeReference<Map<String, List<SubAccount>>>() {
    });
  }

  public static void main(String[] args) {
    //get subAccount list
    Map<String, List<SubAccount>> subAccounts = getSubAccountList(Maps.newHashMap(ImmutableMap.<String, String>builder()
        .put("page", "1")
        .put("limit", "10")
        .build()));
    log.info("==>>subAccounts:{}", JsonUtil.toJson(subAccounts));
  }
}
