package scptcg.log;

import java.io.PrintWriter;

public class LogPrintWriter implements Logger {

    private PrintWriter out;

    public LogPrintWriter(final PrintWriter out) {
        this.out = out;
    }

    public void setPrintWriter(final PrintWriter out) {
        this.out = out;
    }

    @Override
    public void debug(final String msg) {
        out.println("debug:\n" + getMessage(msg));
    }

    @Override
    public void info(final String msg) {
        out.println("info:\n" + getMessage(msg));
    }

    @Override
    public void info(final Object obj, final String msg) {
        out.println("info:\n" + getMessage(msg));
    }

    @Override
    public void warn(final String msg) {
        out.println("warn:\n" + getMessage(msg));
    }

    @Override
    public void error(final Throwable e) {
        out.println("error:\n" + getErrorMessage(e));
    }
}
