package scptcg.log;

import java.io.PrintStream;

public class LogPrintStream implements Logger {

    private PrintStream out;

    public LogPrintStream(final PrintStream out) {
        this.out = out;
    }

    public void setPrintStream(final PrintStream out) {
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
