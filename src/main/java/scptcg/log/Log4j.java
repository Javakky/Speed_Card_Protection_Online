package scptcg.log;

        import org.apache.logging.log4j.LogManager;

        import java.io.File;

/**
 * ロギング処理を行う
 */
public class Log4j implements Logger {

    private static Log4j logger = null;

    /**
     * コンストラクタ
     * Singleton実装の為、コンストラクタは隠蔽します
     */
    private Log4j() {
    }

    public static synchronized Log4j getInstance() {
        //インスタンスが無ければ作成する
        if (logger == null) {
            logger = new Log4j();
        }
        return logger;
    }

    /**
     * デバッグの情報をロギングする
     *
     * @param msg : 出力メッセージ
     */
    public void debug(final String msg) {
        LogManager.getLogger(this.getClass()).debug(getMessage(msg));
    }

    /**
     * infoレベルの情報をロギングする
     *
     * @param msg : 出力メッセージ
     */
    public void info(final String msg) {
        LogManager.getLogger(this.getClass()).info(getMessage(msg));
    }

    /**
     * infoレベルの情報をロギングする
     *
     * @param obj : ログが出力される Class Object
     * @param msg : 出力メッセージ
     */
    public void info(final Object obj, final String msg) {
        LogManager.getLogger(obj.getClass()).info(msg);
    }

    /**
     * 警告レベルの情報をロギングする
     *
     * @param msg : 警告メッセージ
     */
    public void warn(final String msg) {
        LogManager.getLogger(this.getClass()).warn(getMessage(msg));
    }

    /**
     * エラーレベル情報ををロギングする
     *
     * @param e : 例外情報
     */
    public void error(final Throwable e) {
        LogManager.getLogger(e.getClass()).error(getErrorMessage(e));
    }

    public void trace(final String msg) {
        LogManager.getLogger(this.getClass()).trace(getMessage(msg));
    }

    public void fatal(final String msg) {
        LogManager.getLogger(this.getClass()).fatal(getMessage(msg));
    }

}