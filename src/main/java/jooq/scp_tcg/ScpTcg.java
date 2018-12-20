/*
 * This file is generated by jOOQ.
 */
package jooq.scp_tcg;


import jooq.DefaultCatalog;
import jooq.scp_tcg.tables.Deck;
import jooq.scp_tcg.tables.Id;
import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;

import javax.annotation.Generated;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * This class is generated by jOOQ.
 */
@Generated(
        value = {
                "http://www.jooq.org",
                "jOOQ version:3.11.2"
        },
        comments = "This class is generated by jOOQ"
)
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class ScpTcg extends SchemaImpl {

    /**
     * The reference instance of <code>scp_tcg</code>
     */
    public static final ScpTcg SCP_TCG = new ScpTcg();
    private static final long serialVersionUID = -399183060;
    /**
     * The table <code>scp_tcg.deck</code>.
     */
    public final Deck DECK = jooq.scp_tcg.tables.Deck.DECK;

    /**
     * The table <code>scp_tcg.id</code>.
     */
    public final Id ID = jooq.scp_tcg.tables.Id.ID;

    /**
     * No further instances allowed
     */
    private ScpTcg() {
        super("scp_tcg", null);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        List result = new ArrayList();
        result.addAll(getTables0());
        return result;
    }

    private final List<Table<?>> getTables0() {
        return Arrays.<Table<?>>asList(
                Deck.DECK,
                Id.ID);
    }
}
