package scptcg.server;

import com.google.gson.Gson;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.conf.Settings;
import org.jooq.exception.DataAccessException;
import scptcg.game.card.CardFactory;
import scptcg.json.Login;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.stream.Collectors;

import static jooq.tables.Deck.*;
import static jooq.tables.Id.*;
import static org.jooq.impl.DSL.*;
import static scptcg.server.CharsetCode.*;

@WebServlet(
        name = "DeckMakeServlet",
        urlPatterns = {"/Deck/*"})

public class DeckMakeServlet extends HttpServlet {
    public static DSLContext connectionDB() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Scanner s =
                null;
        try {
            s = new Scanner(
                    CardFactory.class.getResource(
                            "/login.json"
                    ).openStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        StringBuilder sb = new StringBuilder();
        while (s.hasNextLine()) {
            sb.append(s.nextLine());
        }
        s.close();

        Login tmp = (new Gson()).fromJson(sb.toString(), Login.class);
        String userName = tmp.id;
        String password = tmp.password;
        String url = "jdbc:mysql://localhost:3306/" + tmp.database;

        Connection conn = DriverManager.getConnection(url, userName, password);

        Settings settings = new Settings();
        settings.setExecuteLogging(true);
        settings.withRenderFormatted(true);
        settings.withRenderSchema(false);

        return using(conn, SQLDialect.MYSQL, settings);
    }


    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/plain");
        res.addHeader("Access-Control-Allow-Origin", "*");
        String body = req.getReader().lines().collect(Collectors.joining("\r\n"));
        System.out.println(body);

        PrintWriter out = res.getWriter();
        String path = req.getPathInfo();
        switch (path) {
            case "/saveDeck": {
                try {
                    DSLContext con = connectionDB();
                    System.out.println(req.getParameter("Id"));
                    System.out.println(req.getParameter("Name"));
                    System.out.println(URLDecoder.decode(to(req.getParameter("Main"), "ISO8859_1", "UTF-8")));
                    System.out.println(req.getParameter("MainType"));
                    con.insertInto(
                            DECK,
                            DECK.ID,
                            DECK.NAME,
                            DECK.MAIN,
                            DECK.MAINTYPE,
                            DECK.DECK_
                    ).values(
                            to(req.getParameter("Id"), "ISO8859_1", "UTF-8"),
                            URLDecoder.decode(to(req.getParameter("Name"), "ISO8859_1", "UTF-8")),
                            URLDecoder.decode(to(req.getParameter("Main"), "ISO8859_1", "UTF-8")),
                            to(req.getParameter("MainType"), "ISO8859_1", "UTF-8"),
                            URLDecoder.decode(body, "UTF-8")
                    ).onDuplicateKeyUpdate()
                            .set(DECK.MAIN, URLDecoder.decode(to(req.getParameter("Main"), "ISO8859_1", "UTF-8")))
                            .set(DECK.MAINTYPE, to(req.getParameter("MainType"), "ISO8859_1", "UTF-8"))
                            .set(DECK.DECK_, URLDecoder.decode(body, "UTF-8"))
                            .execute();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                break;
            }
        }
        System.out.println(path);
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        PrintWriter out;

        res.setContentType("text/html; charset=UTF-8");

        out = res.getWriter();

        String path = req.getPathInfo();

        switch (path) {
            case "/getCardPool": {
                Scanner s = new Scanner(DeckMakeServlet.class.getResource("/list.json").openStream());
                StringBuilder sb = new StringBuilder();
                while (s.hasNext()) {
                    sb.append(s.nextLine());
                    sb.append("\n");
                }
                s.close();
                String deck = sb.toString();
                out.print(deck);
                System.out.println(deck);
                break;
            }
            case "/getDeckList": {
                StringBuilder sb = new StringBuilder();
                try {
                    DSLContext con = connectionDB();
                    Result<Record> result = con.select().from(DECK)
                            .where(DECK.ID.eq(req.getParameter("Id")))
                            .fetch();
                    for (Record record : result) {
                        sb.append(record.getValue(DECK.NAME))
                                .append(",")
                                .append(record.getValue(DECK.MAIN))
                                .append(",").append(record.getValue(DECK.MAINTYPE)).append("\n");
                    }
                    if (sb.length() >= 1)
                        sb.setLength(sb.length() - 1);
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                out.print(sb.toString());
                break;
            }

            case "/signUp": {
                try {
                    DSLContext con = connectionDB();
                    con.insertInto(
                            ID,
                            ID.ID_,
                            ID.PASS
                    ).values(
                            req.getParameter("Id"),
                            req.getParameter("Pass")
                    ).execute();
                    out.print(true);
                } catch (SQLException | DataAccessException e) {
                    out.print(false);
                }
                break;
            }

            case "/deleteID": {
                try {
                    DSLContext con = connectionDB();
                    con.delete(DECK)
                            .where(DECK.ID.eq(req.getParameter("Id")))
                            .execute();
                    con.delete(ID)
                            .where(ID.ID_.eq(req.getParameter("Id")))
                            .execute();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            }

            case "/changePass": {
                try {
                    DSLContext con = connectionDB();
                    con.update(ID)
                            .set(ID.PASS, req.getParameter("Pass"))
                            .where(ID.ID_.eq(req.getParameter("Id")))
                            .execute();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            }

            case "/renameDeck": {
                try {
                    DSLContext con = connectionDB();
                    con.update(DECK)
                            .set(DECK.NAME, req.getParameter("Name"))
                            .where(DECK.ID.eq(req.getParameter("Id")))
                            .and(DECK.NAME.eq(req.getParameter("Old")))
                            .execute();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            }

            case "/login": {
                ////System.out.println("login");
                try {
                    DSLContext con = connectionDB();
                    Result<Record> result = con.select().from(ID)
                            .where(ID.ID_.eq(req.getParameter("Id")))
                            .fetch();
                    if (result.isEmpty()) {
                        out.print(false);
                        return;
                    }
                    boolean flg = false;
                    for (Record r : result) {
                        ////System.out.println(r.getValue(ID.PASS));
                        if (r.getValue(ID.PASS).equals(req.getParameter("Pass"))) {
                            flg = true;
                        }
                    }
                    out.print(flg);

                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            }

            case "/removeDeck": {
                try {
                    DSLContext con = connectionDB();
                    con.delete(DECK)
                            .where(DECK.ID.eq(req.getParameter("Id")))
                            .and(DECK.NAME.eq(req.getParameter("Name")))
                            .execute();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            }

            case "/getDeck": {
                try {
                    System.out.println(req.getParameter("Id"));
                    System.out.println(req.getParameter("Name"));
                    DSLContext con = connectionDB();
                    String json = con.select().from(DECK)
                            .where(DECK.ID.eq(req.getParameter("Id")))
                            .and(DECK.NAME.eq(URLDecoder.decode(to(req.getParameter("Name"), "ISO8859_1", "UTF-8"))))
                            .fetch().get(0).getValue(DECK.DECK_);
                    System.out.println(json);
                    out.println(json);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }

}

