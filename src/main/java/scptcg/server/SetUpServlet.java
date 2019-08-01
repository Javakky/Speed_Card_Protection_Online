package scptcg.server;

import org.jooq.DSLContext;
import org.jooq.impl.SQLDataType;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import static jooq.tables.Deck.*;
import static jooq.tables.Id.*;
import static org.jooq.impl.DSL.*;
import static scptcg.server.DeckMakeServlet.*;

@WebServlet(
        name = "SetUpServlet",
        urlPatterns = {"/SetUp"})
public class SetUpServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        PrintWriter out;

        res.setContentType("text/html; charset=UTF-8");
        out = res.getWriter();
        try {
            DSLContext con = connectionDB();
            con.createTable(DECK)
                    .column(DECK.ID, SQLDataType.CHAR(10).nullable(false))
                    .column(DECK.NAME, SQLDataType.CHAR(10).nullable(false))
                    .column(DECK.MAIN, SQLDataType.VARCHAR(255))
                    .column(DECK.MAINTYPE, SQLDataType.VARCHAR(255))
                    .column(DECK.DECK_, SQLDataType.VARCHAR(4095))
                    .constraints(
                            constraint("PRI").primaryKey(DECK.NAME, DECK.ID))
                    .execute();
            con.createTable(ID)
                    .column(ID.ID_, SQLDataType.CHAR(10).nullable(false))
                    .column(ID.PASS, SQLDataType.VARCHAR(255).nullable(false))
                    .constraints(
                            constraint("PRI").primaryKey(ID.ID_))
                    .execute();
            out.println("Success!");
        } catch (SQLException e) {
            out.println(e.getSQLState());
            e.printStackTrace(out);
            e.printStackTrace();
        }
    }
}
