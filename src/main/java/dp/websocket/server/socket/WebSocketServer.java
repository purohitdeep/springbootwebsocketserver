package dp.websocket.server.socket;

import java.io.IOException;

import javax.websocket.CloseReason;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ServerEndpoint("/websocket")
public class WebSocketServer {

    protected Logger logger = LoggerFactory.getLogger(WebSocketServer.class);

    @OnMessage
    public void handleMessage(Session session, String message) throws IOException {
        logger.info("Message received from client {}", message);
        session.getBasicRemote().sendText("Received : " + new StringBuilder(message));
    }

    @OnOpen
    public void onOpen(Session session, EndpointConfig config) {
        logger.info("Socket has opened with Session {} \n EndpointConfig {}", session, config);
    }

    @OnError
    public void errorOcured(Throwable throwable) throws IOException {
        logger.error("Error occured on socket connection", throwable);
    }

    @OnClose
    public void onClose(CloseReason closeReason) {
        logger.info("Socket has closed. Reason {}", closeReason);
    }

}
