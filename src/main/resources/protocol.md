# SCPOの通信プロトコル

## WebSocket(バトル)
基本URL : ws://localhost:8080/SCP/

## HttpClient(ユーザーデータ)
基本URL : http://localhost:8080/SCP/Deck/

### カードプールの取得
URL : `/getCardPool`
パラメータ : なし
戻り値 : デッキリスト(Exclusionを除く)

### デッキ保存
URL : `/saveDeck`
パラメータ :
+ プレイヤーID
    * Id : String
+ デッキ名
    * Name : String
+ メインカード
    * Main : String
+ メインカードの種類
    * MainType : String
+ デッキに入るカード名一覧
    * DeckList : デッキリスト
戻り値 : なし

## JSONの形式

### デッキリスト
+ SCP
    * Safe : `String[]`
    * Keter : `String[]`
    * Euclid : `String[]`
+ 人事カード
    * Personnel : `String[]`
+ テイル or インシデント
    * Tale : `String[]`
+ Anomalousオブジェクト
    * Anomalous : `String[]`
+ ゲーム開始時点で除外されているカード
    * Exclusion : `String[]`