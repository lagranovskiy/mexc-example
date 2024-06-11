package de.richert.estock.adapter.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import de.richert.estock.adapter.spot.api.v2.MexcApiV2Example;
import de.richert.estock.adapter.spot.api.v3.pojo.Symbols;
import de.richert.estock.common.MarketDataClient;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HandelspaareRestController {

  @GetMapping("symbols")
  public Symbols getSymbols() {
    return MarketDataClient.get("/api/v3/defaultSymbols", new HashMap<>(), new TypeReference<Symbols>() {
    });
  }

  private static final String accessKey = "---";
  private static final String secretKey = "---";

  @GetMapping("symbols2")
  public Map<String, List<String>> getSymbols2() {
    return new MexcApiV2Example(accessKey, secretKey).defaultSymbols().getData();
  }
}
