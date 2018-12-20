/*
 * This file is generated by jOOQ.
 */
package jooq.sys.tables;


import jooq.sys.Sys;
import jooq.sys.tables.records.X$schemaFlattenedKeysRecord;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;

import javax.annotation.Generated;


/**
 * VIEW
 */
@Generated(
        value = {
                "http://www.jooq.org",
                "jOOQ version:3.11.2"
        },
        comments = "This class is generated by jOOQ"
)
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class X$schemaFlattenedKeys extends TableImpl<X$schemaFlattenedKeysRecord> {

    /**
     * The reference instance of <code>sys.x$schema_flattened_keys</code>
     */
    public static final X$schemaFlattenedKeys X$SCHEMA_FLATTENED_KEYS = new X$schemaFlattenedKeys();
    private static final long serialVersionUID = 1367696443;
    /**
     * The column <code>sys.x$schema_flattened_keys.table_schema</code>.
     */
    public final TableField<X$schemaFlattenedKeysRecord, String> TABLE_SCHEMA = createField("table_schema", org.jooq.impl.SQLDataType.VARCHAR(64).nullable(false).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "");
    /**
     * The column <code>sys.x$schema_flattened_keys.table_name</code>.
     */
    public final TableField<X$schemaFlattenedKeysRecord, String> TABLE_NAME = createField("table_name", org.jooq.impl.SQLDataType.VARCHAR(64).nullable(false).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "");
    /**
     * The column <code>sys.x$schema_flattened_keys.index_name</code>.
     */
    public final TableField<X$schemaFlattenedKeysRecord, String> INDEX_NAME = createField("index_name", org.jooq.impl.SQLDataType.VARCHAR(64).nullable(false).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "");
    /**
     * The column <code>sys.x$schema_flattened_keys.non_unique</code>.
     */
    public final TableField<X$schemaFlattenedKeysRecord, Long> NON_UNIQUE = createField("non_unique", org.jooq.impl.SQLDataType.BIGINT, this, "");
    /**
     * The column <code>sys.x$schema_flattened_keys.subpart_exists</code>.
     */
    public final TableField<X$schemaFlattenedKeysRecord, Long> SUBPART_EXISTS = createField("subpart_exists", org.jooq.impl.SQLDataType.BIGINT, this, "");
    /**
     * The column <code>sys.x$schema_flattened_keys.index_columns</code>.
     */
    public final TableField<X$schemaFlattenedKeysRecord, String> INDEX_COLUMNS = createField("index_columns", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * Create a <code>sys.x$schema_flattened_keys</code> table reference
     */
    public X$schemaFlattenedKeys() {
        this(DSL.name("x$schema_flattened_keys"), null);
    }

    /**
     * Create an aliased <code>sys.x$schema_flattened_keys</code> table reference
     */
    public X$schemaFlattenedKeys(String alias) {
        this(DSL.name(alias), X$SCHEMA_FLATTENED_KEYS);
    }

    /**
     * Create an aliased <code>sys.x$schema_flattened_keys</code> table reference
     */
    public X$schemaFlattenedKeys(Name alias) {
        this(alias, X$SCHEMA_FLATTENED_KEYS);
    }

    private X$schemaFlattenedKeys(Name alias, Table<X$schemaFlattenedKeysRecord> aliased) {
        this(alias, aliased, null);
    }

    private X$schemaFlattenedKeys(Name alias, Table<X$schemaFlattenedKeysRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("VIEW"));
    }

    public <O extends Record> X$schemaFlattenedKeys(Table<O> child, ForeignKey<O, X$schemaFlattenedKeysRecord> key) {
        super(child, key, X$SCHEMA_FLATTENED_KEYS);
    }

    /**
     * The class holding records for this type
     */
    @Override
    public Class<X$schemaFlattenedKeysRecord> getRecordType() {
        return X$schemaFlattenedKeysRecord.class;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Sys.SYS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X$schemaFlattenedKeys as(String alias) {
        return new X$schemaFlattenedKeys(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X$schemaFlattenedKeys as(Name alias) {
        return new X$schemaFlattenedKeys(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public X$schemaFlattenedKeys rename(String name) {
        return new X$schemaFlattenedKeys(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public X$schemaFlattenedKeys rename(Name name) {
        return new X$schemaFlattenedKeys(name, null);
    }
}
