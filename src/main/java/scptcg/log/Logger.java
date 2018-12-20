package scptcg.log;

public interface Logger {

    default String getMessage(final String msg) {
        //クラス名を取得
        String thisClassName = this.getClass().getName();
        //クラス名を取得
        String SuperClassName = Logger.class.getName();
        //カレントスレッドを取得
        Thread t = Thread.currentThread();
        //StackTraceElementの配列を取得
        StackTraceElement[] stackTraceElements = t.getStackTrace();
        int pos = 0;
        for (StackTraceElement stackTraceElement : stackTraceElements) {
            //クラス名比較
            String steClassName = stackTraceElement.getClassName();
            if (thisClassName.equals(steClassName) || SuperClassName.equals(steClassName)) {
                break;    //stackTraceElementsから自分と同じクラス名だったら終了
            }
            pos++;
        }
        pos += 2;
        StackTraceElement m = stackTraceElements[pos];
        //ログ出力対象のクラス名:[メソッド名] + log message
        return m.getClassName() + ":" + m.getMethodName() + "() \n" + msg;
    }

    default String getErrorMessage(final Exception e) {
        StringBuilder sb = new StringBuilder();
        StackTraceElement[] st = e.getStackTrace();
        if (st != null && st.length > 0) {
            sb.append("Class:")
                    .append(e.getClass().getName())
                    .append("¥n")
                    .append("Detail:")
                    .append(e.getMessage())
                    .append("¥n");
            for (StackTraceElement s : st) {
                sb.append(s.toString())
                        .append("¥n");
            }
        }
        return sb.toString();
    }

    /**
     * デバッグの情報をロギングする
     *
     * @param msg : 出力メッセージ
     */
    public void debug(final String msg);

    /**
     * infoレベルの情報をロギングする
     *
     * @param msg : 出力メッセージ
     */
    public void info(final String msg);

    /**
     * infoレベルの情報をロギングする
     *
     * @param obj : ログが出力される Class Object
     * @param msg : 出力メッセージ
     */
    public void info(final Object obj, final String msg);

    /**
     * 警告レベルの情報をロギングする
     *
     * @param msg : 警告メッセージ
     */
    public void warn(final String msg);

    /**
     * エラーレベル情報ををロギングする
     *
     * @param e : 例外情報
     */
    public void error(final Exception e);
}
