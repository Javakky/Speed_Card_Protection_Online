package scptcg.server;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

// これを付けるとWebSocketサーバーになる
// URLはワイルドカード可
@ServerEndpoint("/wsendpoint")
public final class WSEndPoint {

    // Session(通信)を保存しておくためのMap
    private static Map<String, Session> session = new HashMap<>();

    // 接続時に呼ばれるメソッド
    @OnOpen
    public void onOpen(final Session client, final EndpointConfig config) {
        String log = client.getId() + " was connected.";
        ////System.out.println(log);
    }

    // 切断時に呼ばれるメソッド
    @OnClose
    public void onClose(final Session client, final CloseReason reason) throws IOException {
        String log = client.getId() + " was closed by "
                + reason.getCloseCode() + "[" + reason.getCloseCode().getCode() + "]";
        ////System.out.println(log);
    }

    // エラー時に呼ばれるメソッド
    @OnError
    public void onError(final Session client, final Throwable error) {
        String log = client.getId() + " was error. [" + error.getMessage() + "]";
        error.printStackTrace();
    }

    // メッセージが送られたときに呼ばれるメソッド
    @OnMessage
    public void onMessage(final String text, final Session client) throws IOException {
        // メッセージの内容は、改行区切りで操作・id・データが記述されているものとする。
        String[] t = text.split(" ");
        String event = t[0];
        String id = t[1];
        ////System.out.println(text);
        //eventの内容毎に分岐
        switch (event) {
            case "login":
                //HashMapにSessionを保存しておく。
                session.put(id, client);
                //idで保存したセッションに文字列を送信。
                session.get(id).getBasicRemote().sendText(id);
                ////System.out.println(id);
                break;
            case "commit":
                // ブロードキャスト
                for (Session s : session.values()) {
                    s.getBasicRemote().sendText(t[2]);
                }
                ////System.out.println(t[2]);
                break;
            case "close":
                // セッション一覧から削除
                session.remove(t[1]);
                break;
        }

    }

}
