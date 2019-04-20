/*
 * This file is generated by jOOQ.
 */
package jooq.black_poker.tables;


import jooq.black_poker.BlackPoker;
import jooq.black_poker.tables.records.InnerRecord;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;

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
public class Inner extends TableImpl<InnerRecord> {

    private static final long serialVersionUID = -46576839;

    /**
     * The reference instance of <code>black_poker.inner</code>
     */
    public static final Inner INNER = new Inner();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<InnerRecord> getRecordType() {
        return InnerRecord.class;
    }

    /**
     * The column <code>black_poker.inner.user</code>.
     */
    public final TableField<InnerRecord, String> USER = createField("user", org.jooq.impl.SQLDataType.CHAR(10), this, "");

    /**
     * Create a <code>black_poker.inner</code> table reference
     */
    public Inner() {
        this(DSL.name("inner"), null);
    }

    /**
     * Create an aliased <code>black_poker.inner</code> table reference
     */
    public Inner(String alias) {
        this(DSL.name(alias), INNER);
    }

    /**
     * Create an aliased <code>black_poker.inner</code> table reference
     */
    public Inner(Name alias) {
        this(alias, INNER);
    }

    private Inner(Name alias, Table<InnerRecord> aliased) {
        this(alias, aliased, null);
    }

    private Inner(Name alias, Table<InnerRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> Inner(Table<O> child, ForeignKey<O, InnerRecord> key) {
        super(child, key, INNER);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return BlackPoker.BLACK_POKER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Inner as(String alias) {
        return new Inner(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Inner as(Name alias) {
        return new Inner(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Inner rename(String name) {
        return new Inner(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Inner rename(Name name) {
        return new Inner(name, null);
    }
}
