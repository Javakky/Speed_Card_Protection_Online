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

    static public void main(String[] args) throws Exception {

        // 初期化のため WebSocket コンテナのオブジェクトを取得する
        WebSocketContainer container = ContainerProvider
                .getWebSocketContainer();
        // サーバー・エンドポイントの URI
        URI uri = URI
                .create("ws://localhost:8080/SCP/ws");
        // サーバー・エンドポイントとのセッションを確立する
        Session session = container.connectToServer(SCPClient.class, uri);

        while (!session.isOpen()) Thread.sleep(500);
        ////System.out.println("open");

        try (Scanner s = new Scanner(System.in)) {
            StringBuilder sb = new StringBuilder();
            String str;
            loop:
            while (true) {
                str = s.nextLine();
                switch (str) {
                    case "exit":
                        break loop;
                    case "\\e":
                        session.getBasicRemote().sendText(sb.toString());
                        break;
                    default:
                        sb.append(str).append("\n");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @OnOpen
    public void onOpen(Session session) {
        /* セッション確立時の処理 */
        ////System.out.println("[セッション確立]");
    }

    @OnMessage
    public void onMessage(String message) {
        /* メッセージ受信時の処理 */
        ////System.out.println("[受信]:" + message);
    }

    @OnError
    public void onError(Throwable th) {
        /* メッセージ受信時の処理 */
        System.err.println(th.getMessage());
    }

    @OnClose
    public void onClose(Session session) {
        /* セッション解放時の処理 */
        ////System.out.println("[切断]");
    }

}

//90000