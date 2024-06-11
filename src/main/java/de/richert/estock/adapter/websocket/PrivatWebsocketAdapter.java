package de.richert.estock.adapter.websocket;

import de.richert.estock.adapter.spot.websocket.WebsocketV3;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PrivatWebsocketAdapter extends WebSocketListener {

  PrivatWebsocketAdapter() {
    WebsocketV3 websocketV3 = new WebsocketV3();

    //sub private channel
    WebSocket privateClient = websocketV3.privateClient(this);

    privateClient.send("""
        {"id":1,
        "method":"SUBSCRIPTION",
        "params":[
          "spot@private.deals.v3.api",
          "spot@private.orders.v3.api",
          "spot@private.account.v3.api"
        ]}
        """);


  }


  @Override
  public void onOpen(@NotNull WebSocket webSocket, @NotNull Response response) {
    log.info("MEXC-WS CONNECTED ....");
  }

  @Override
  public void onMessage(@NotNull WebSocket webSocket, @NotNull String text) {
    log.info("MEXC-WS MESSAGE: {}", text);
  }

  @Override
  public void onMessage(@NotNull WebSocket webSocket, @NotNull ByteString bytes) {
    log.info("MEXC-WS MESSAGE: {}", bytes);
  }

  @Override
  public void onClosing(WebSocket webSocket, int code, @NotNull String reason) {
    webSocket.close(1000, null);
    System.out.println("CLOSE: " + code + " " + reason);
    log
        .info("Closing connection {} {}", code, reason);
  }

  @Override
  public void onFailure(@NotNull WebSocket webSocket, @NotNull Throwable t, Response response) {
    log.error("Fehler beim Laden des WebSockets", t);
  }

}
