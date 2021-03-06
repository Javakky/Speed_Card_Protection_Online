/*
 * This file is generated by jOOQ.
 */
package jooq.tables;


import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import jooq.Indexes;
import jooq.Keys;
import jooq.ScpTcg;
import jooq.tables.records.IdRecord;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


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
public class Id extends TableImpl<IdRecord> {

    private static final long serialVersionUID = 177170557;

    /**
     * The reference instance of <code>scp_tcg.id</code>
     */
    public static final Id ID = new Id();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<IdRecord> getRecordType() {
        return IdRecord.class;
    }

    /**
     * The column <code>scp_tcg.id.id</code>.
     */
    public final TableField<IdRecord, String> ID_ = createField("id", org.jooq.impl.SQLDataType.CHAR(10).nullable(false), this, "");

    /**
     * The column <code>scp_tcg.id.pass</code>.
     */
    public final TableField<IdRecord, String> PASS = createField("pass", org.jooq.impl.SQLDataType.VARCHAR(255), this, "");

    /**
     * Create a <code>scp_tcg.id</code> table reference
     */
    public Id() {
        this(DSL.name("id"), null);
    }

    /**
     * Create an aliased <code>scp_tcg.id</code> table reference
     */
    public Id(String alias) {
        this(DSL.name(alias), ID);
    }

    /**
     * Create an aliased <code>scp_tcg.id</code> table reference
     */
    public Id(Name alias) {
        this(alias, ID);
    }

    private Id(Name alias, Table<IdRecord> aliased) {
        this(alias, aliased, null);
    }

    private Id(Name alias, Table<IdRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> Id(Table<O> child, ForeignKey<O, IdRecord> key) {
        super(child, key, ID);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return ScpTcg.SCP_TCG;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.ID_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<IdRecord> getPrimaryKey() {
        return Keys.KEY_ID_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<IdRecord>> getKeys() {
        return Arrays.<UniqueKey<IdRecord>>asList(Keys.KEY_ID_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Id as(String alias) {
        return new Id(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Id as(Name alias) {
        return new Id(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Id rename(String name) {
        return new Id(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Id rename(Name name) {
        return new Id(name, null);
    }
}
