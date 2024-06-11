package de.richert.estock.adapter.spot.api.v3.wslistenkey;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableMap;
import de.richert.estock.common.UserDataClient;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CreateListenKey {

  public static Map<String, String> postUserDataStream(Map<String, String> params) {
    return UserDataClient.post("/api/v3/userDataStream", params, new TypeReference<>() {
    });
  }

  public static void main(String[] args) {
    //get listenKey
    String listenKey = postUserDataStream(ImmutableMap.<String, String>builder()
        .put("recvWindow", "60000")
        .build()).get("listenKey");
    log.info("==>>listenKey:{}", listenKey);
  }
}
