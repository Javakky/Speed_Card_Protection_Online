import java.net.*;
import javax.websocket.*;

@ClientEndpoint

public class BattleTest
{
    static boolean connected = false;

    // - - - - - - -
    @OnError
    public void onError(Session session, Throwable cause) {
        // エラー
        System.out.println("error : " + session.getId() + ", " + cause.getMessage());
    }

    // - - - - - - -

    @OnMessage
    public void onMessage(String msg, Session session) {
        // 文字列を受け取る
        System.out.println("onMessage: " + msg);
    }

    // - - - - - - -
    @OnClose
    public void onClose(Session session, CloseReason closeReason) {
        // 接続が閉じられた
        System.out.println("closed");
        connected = false;
    }

    // - - - - - - -
    @OnOpen
    public void onOpen(Session session) {
        // 接続した
        System.out.println("opened");
    }

    // - - - - - - -
    public static void connect(String url) {
        WebSocketContainer container = ContainerProvider.getWebSocketContainer();

        // 接続
        try (Session session = container.connectToServer(container, URI.create(url))) {

            while (session.isOpen()) {
                session.getBasicRemote().sendText("message");
            }

        } catch (Exception e) {
            System.err.println(e);
        }
    }
}