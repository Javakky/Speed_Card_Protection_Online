/*
 * This file is generated by jOOQ.
 */
package jooq.scp_tcg.tables.records;


import jooq.scp_tcg.tables.Id;
import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.UpdatableRecordImpl;

import javax.annotation.Generated;


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
public class IdRecord extends UpdatableRecordImpl<IdRecord> implements Record2<String, String> {

    private static final long serialVersionUID = 1625192979;

    /**
     * Setter for <code>scp_tcg.id.id</code>.
     */
    public void setId(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>scp_tcg.id.id</code>.
     */
    public String getId() {
        return (String) get(0);
    }

    /**
     * Setter for <code>scp_tcg.id.pass</code>.
     */
    public void setPass(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>scp_tcg.id.pass</code>.
     */
    public String getPass() {
        return (String) get(1);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<String> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record2 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row2<String, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row2<String, String> valuesRow() {
        return (Row2) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return Id.ID.ID_;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Id.ID.PASS;
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
        return getPass();
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
        return getPass();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IdRecord value1(String value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IdRecord value2(String value) {
        setPass(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IdRecord values(String value1, String value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached IdRecord
     */
    public IdRecord() {
        super(Id.ID);
    }

    /**
     * Create a detached, initialised IdRecord
     */
    public IdRecord(String id, String pass) {
        super(Id.ID);

        set(0, id);
        set(1, pass);
    }
}
