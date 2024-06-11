package de.richert.estock.adapter.websocket;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.richert.estock.adapter.spot.websocket.WebsocketV3;
import de.richert.estock.adapter.websocket.model.BookTickerDto;
import de.richert.estock.domain.OrderService;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BookTickerWebsocketAdapter extends WebSocketListener {

  private final OrderService orderService;
  private final ObjectMapper objectMapper;

  BookTickerWebsocketAdapter(OrderService orderService, ObjectMapper objectMapper) {
    this.orderService = orderService;
    this.objectMapper = objectMapper;

    WebsocketV3 websocketV3 = new WebsocketV3();
    //sub public channel
    WebSocket publicClient = websocketV3.publicClient(this);
    publicClient.send("""
         {
           "method": "SUBSCRIPTION",
           "params": [
             "spot@public.bookTicker.v3.api@BTCUSDC"
           ]
         }
        """);
  }


  @Override
  public void onOpen(@NotNull WebSocket webSocket, @NotNull Response response) {
    log.info("Verbindung mit BookTicker ist aufgebaut");
  }

  @Override
  public void onMessage(@NotNull WebSocket webSocket, @NotNull String text) {
    try {
      var bookTicker = objectMapper.readValue(text, BookTickerDto.class);
      log.info("body {} aus {}", bookTicker, text);
      if (bookTicker.d() != null) {
        orderService.pruefeObKaufNoetig(bookTicker);
      }
    } catch (JsonProcessingException e) {
      log.error("Fehler beim parsen der BookTicker {} ist aufgetreten", text, e);
    }

  }

  @Override
  public void onMessage(@NotNull WebSocket webSocket, @NotNull ByteString bytes) {
    log.info("Verbindung", bytes);
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
