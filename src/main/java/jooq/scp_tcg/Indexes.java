/*
 * This file is generated by jOOQ.
 */
package jooq.scp_tcg;


import jooq.scp_tcg.tables.Deck;
import jooq.scp_tcg.tables.Id;
import org.jooq.Index;
import org.jooq.OrderField;
import org.jooq.impl.Internal;

import javax.annotation.Generated;


/**
 * A class modelling indexes of tables of the <code>scp_tcg</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
            "jOOQ version:3.11.9"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Indexes {

    // -------------------------------------------------------------------------
    // INDEX definitions
    // -------------------------------------------------------------------------

    public static final Index DECK_PRIMARY = Indexes0.DECK_PRIMARY;
    public static final Index ID_PRIMARY = Indexes0.ID_PRIMARY;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Indexes0 {
        public static Index DECK_PRIMARY = Internal.createIndex("PRIMARY", Deck.DECK, new OrderField[] { Deck.DECK.ID, Deck.DECK.NAME }, true);
        public static Index ID_PRIMARY = Internal.createIndex("PRIMARY", Id.ID, new OrderField[] { Id.ID.ID_ }, true);
    }
}
