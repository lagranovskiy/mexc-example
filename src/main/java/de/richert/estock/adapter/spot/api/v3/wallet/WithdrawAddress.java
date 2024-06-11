package de.richert.estock.adapter.spot.api.v3.wallet;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import de.richert.estock.adapter.spot.api.v3.pojo.WithdrawAddressResp;
import de.richert.estock.common.JsonUtil;
import de.richert.estock.common.UserDataClient;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public class WithdrawAddress {
    public static WithdrawAddressResp getWithdrawAddress(Map<String, String> params) {
        return UserDataClient.get("/api/v3/capital/withdraw/address", params, new TypeReference<WithdrawAddressResp>() {
        });
    }

    public static void main(String[] args) {
        //get withdraw address
        WithdrawAddressResp withdrawAddress = getWithdrawAddress(Maps.newHashMap(ImmutableMap.<String, String>builder()
                .put("coin", "USDT")
                .build()));
        log.info("==>>withdrawAddress:{}", JsonUtil.toJson(withdrawAddress));
    }
}
