/*
 * This file is generated by jOOQ.
 */
package jooq.tables.records;


import javax.annotation.Generated;

import jooq.tables.Deck;

import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Record5;
import org.jooq.Row5;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.9"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class DeckRecord extends UpdatableRecordImpl<DeckRecord> implements Record5<String, String, String, String, String> {

    private static final long serialVersionUID = -828932907;

    /**
     * Setter for <code>scp_tcg.deck.id</code>.
     */
    public void setId(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>scp_tcg.deck.id</code>.
     */
    public String getId() {
        return (String) get(0);
    }

    /**
     * Setter for <code>scp_tcg.deck.name</code>.
     */
    public void setName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>scp_tcg.deck.name</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>scp_tcg.deck.main</code>.
     */
    public void setMain(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>scp_tcg.deck.main</code>.
     */
    public String getMain() {
        return (String) get(2);
    }

    /**
     * Setter for <code>scp_tcg.deck.mainType</code>.
     */
    public void setMaintype(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>scp_tcg.deck.mainType</code>.
     */
    public String getMaintype() {
        return (String) get(3);
    }

    /**
     * Setter for <code>scp_tcg.deck.deck</code>.
     */
    public void setDeck(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>scp_tcg.deck.deck</code>.
     */
    public String getDeck() {
        return (String) get(4);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record2<String, String> key() {
        return (Record2) super.key();
    }

    // -------------------------------------------------------------------------
    // Record5 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row5<String, String, String, String, String> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row5<String, String, String, String, String> valuesRow() {
        return (Row5) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return Deck.DECK.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Deck.DECK.NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Deck.DECK.MAIN;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return Deck.DECK.MAINTYPE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return Deck.DECK.DECK_;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getMain();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getMaintype();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component5() {
        return getDeck();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getMain();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getMaintype();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getDeck();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DeckRecord value1(String value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DeckRecord value2(String value) {
        setName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DeckRecord value3(String value) {
        setMain(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DeckRecord value4(String value) {
        setMaintype(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DeckRecord value5(String value) {
        setDeck(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DeckRecord values(String value1, String value2, String value3, String value4, String value5) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached DeckRecord
     */
    public DeckRecord() {
        super(Deck.DECK);
    }

    /**
     * Create a detached, initialised DeckRecord
     */
    public DeckRecord(String id, String name, String main, String maintype, String deck) {
        super(Deck.DECK);

        set(0, id);
        set(1, name);
        set(2, main);
        set(3, maintype);
        set(4, deck);
    }
}