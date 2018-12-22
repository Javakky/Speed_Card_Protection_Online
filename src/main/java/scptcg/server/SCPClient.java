package scptcg.server;

import javax.websocket.*;
import java.net.URI;
import java.util.Scanner;

/**
 * Websocket Endpoint implementation class WebSocketClientMain
 */

@ClientEndpoint
public class SCPClient {

    public SCPClient() {
        super();
    }

    @OnOpen
    public void onOpen(Session session) {
        /* セッション確立時の処理 */
        System.out.println("[セッション確立]");
    }

    @OnMessage
    public void onMessage(String message) {
        /* メッセージ受信時の処理 */
        System.out.println("[受信]:" + message);
    }

    @OnError
    public void onError(Throwable th) {
        /* メッセージ受信時の処理 */
        System.err.println(th.getMessage());
    }

    @OnClose
    public void onClose(Session session) {
        /* セッション解放時の処理 */
        System.out.println("[切断]");
    }

    static public void main(String[] args) throws Exception {

        // 初期化のため WebSocket コンテナのオブジェクトを取得する
        WebSocketContainer container = ContainerProvider
                .getWebSocketContainer();
        // サーバー・エンドポイントの URI
        URI uri = URI
                .create("ws://localhost:8080/SCP/wsendpoint");
        // サーバー・エンドポイントとのセッションを確立する
        Session session = container.connectToServer(SCPClient.class, uri);

        while (!session.isOpen()) {
            System.out.println("open");
        }

        try (Scanner s = new Scanner(System.in)) {
            String str;
            System.out.println("start loop");
            while (true) {
                str = s.nextLine();
                if(str.equals("exit")) break;
                session.getBasicRemote().sendText(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

//90000