package de.richert.estock.spot.websocket;

import de.richert.estock.spot.api.v3.wslistenkey.CreateListenKey;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;


@Getter
@Slf4j
public final class WebsocketV3 {

  public WebSocket privateClient(WebSocketListener listener) {
    var client = new OkHttpClient.Builder()
        .readTimeout(0, TimeUnit.MILLISECONDS)
        .build();
    Map<String, String> params = new HashMap<>();
    params.put("recWindow", "60000");
    String listenKey = CreateListenKey.postUserDataStream(params).get("listenKey");

    Request request = new Request.Builder()
        .url("wss://wbs.mexc.com/ws?listenKey=" + listenKey)
        .build();
    WebSocket webSocket = client.newWebSocket(request, listener);

    //Trigger shutdown of the dispatcher's executor so this process can exit cleanly.
    client.dispatcher().executorService().shutdown();
    return webSocket;
  }

  public WebSocket publicClient(WebSocketListener listener) {
    OkHttpClient client = new OkHttpClient.Builder()
        .readTimeout(0, TimeUnit.MILLISECONDS)
        .build();

    Request request = new Request.Builder()
        .url("wss://wbs.mexc.com/ws")
        .build();
    WebSocket webSocket = client.newWebSocket(request, listener);

    //Trigger shutdown of the dispatcher's executor so this process can exit cleanly.
    client.dispatcher().executorService().shutdown();
    return webSocket;
  }

}