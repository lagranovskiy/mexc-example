package de.richert.estock.adapter.spot.api.v3.subaccount;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import de.richert.estock.adapter.spot.api.v3.pojo.TransferId;
import de.richert.estock.common.JsonUtil;
import de.richert.estock.common.UserDataClient;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UniversalTransfer {

  public static TransferId universalTransfer(Map<String, String> params) {
    return UserDataClient.post("/api/v3/capital/sub-account/universalTransfer", params, new TypeReference<TransferId>() {
    });
  }

  public static void main(String[] args) {

    //subAccount universalTransfer
    TransferId transferId = universalTransfer(Maps.newHashMap(ImmutableMap.<String, String>builder()
        .put("toAccount", "toAccount1")
        .put("fromAccountType", "SPOT")
        .put("toAccountType", "FUTURES")
        .put("asset", "USDT")
        .put("amount", "3")
        .build()));

    log.info("==>>transferResult:{}", JsonUtil.toJson(transferId));
  }
}
