/*
 * This file is generated by jOOQ.
 */
package jooq.information_schema.tables;


import jooq.information_schema.InformationSchema;
import jooq.information_schema.tables.records.TriggersRecord;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;

import javax.annotation.Generated;
import java.sql.Timestamp;


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
public class Triggers extends TableImpl<TriggersRecord> {

    private static final long serialVersionUID = -462681517;

    /**
     * The reference instance of <code>information_schema.TRIGGERS</code>
     */
    public static final Triggers TRIGGERS = new Triggers();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TriggersRecord> getRecordType() {
        return TriggersRecord.class;
    }

    /**
     * The column <code>information_schema.TRIGGERS.TRIGGER_CATALOG</code>.
     */
    public final TableField<TriggersRecord, String> TRIGGER_CATALOG = createField("TRIGGER_CATALOG", org.jooq.impl.SQLDataType.VARCHAR(512).nullable(false).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>information_schema.TRIGGERS.TRIGGER_SCHEMA</code>.
     */
    public final TableField<TriggersRecord, String> TRIGGER_SCHEMA = createField("TRIGGER_SCHEMA", org.jooq.impl.SQLDataType.VARCHAR(64).nullable(false).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>information_schema.TRIGGERS.TRIGGER_NAME</code>.
     */
    public final TableField<TriggersRecord, String> TRIGGER_NAME = createField("TRIGGER_NAME", org.jooq.impl.SQLDataType.VARCHAR(64).nullable(false).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>information_schema.TRIGGERS.EVENT_MANIPULATION</code>.
     */
    public final TableField<TriggersRecord, String> EVENT_MANIPULATION = createField("EVENT_MANIPULATION", org.jooq.impl.SQLDataType.VARCHAR(6).nullable(false).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>information_schema.TRIGGERS.EVENT_OBJECT_CATALOG</code>.
     */
    public final TableField<TriggersRecord, String> EVENT_OBJECT_CATALOG = createField("EVENT_OBJECT_CATALOG", org.jooq.impl.SQLDataType.VARCHAR(512).nullable(false).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>information_schema.TRIGGERS.EVENT_OBJECT_SCHEMA</code>.
     */
    public final TableField<TriggersRecord, String> EVENT_OBJECT_SCHEMA = createField("EVENT_OBJECT_SCHEMA", org.jooq.impl.SQLDataType.VARCHAR(64).nullable(false).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>information_schema.TRIGGERS.EVENT_OBJECT_TABLE</code>.
     */
    public final TableField<TriggersRecord, String> EVENT_OBJECT_TABLE = createField("EVENT_OBJECT_TABLE", org.jooq.impl.SQLDataType.VARCHAR(64).nullable(false).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>information_schema.TRIGGERS.ACTION_ORDER</code>.
     */
    public final TableField<TriggersRecord, Long> ACTION_ORDER = createField("ACTION_ORDER", org.jooq.impl.SQLDataType.BIGINT.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.BIGINT)), this, "");

    /**
     * The column <code>information_schema.TRIGGERS.ACTION_CONDITION</code>.
     */
    public final TableField<TriggersRecord, String> ACTION_CONDITION = createField("ACTION_CONDITION", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>information_schema.TRIGGERS.ACTION_STATEMENT</code>.
     */
    public final TableField<TriggersRecord, String> ACTION_STATEMENT = createField("ACTION_STATEMENT", org.jooq.impl.SQLDataType.CLOB.nullable(false), this, "");

    /**
     * The column <code>information_schema.TRIGGERS.ACTION_ORIENTATION</code>.
     */
    public final TableField<TriggersRecord, String> ACTION_ORIENTATION = createField("ACTION_ORIENTATION", org.jooq.impl.SQLDataType.VARCHAR(9).nullable(false).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>information_schema.TRIGGERS.ACTION_TIMING</code>.
     */
    public final TableField<TriggersRecord, String> ACTION_TIMING = createField("ACTION_TIMING", org.jooq.impl.SQLDataType.VARCHAR(6).nullable(false).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>information_schema.TRIGGERS.ACTION_REFERENCE_OLD_TABLE</code>.
     */
    public final TableField<TriggersRecord, String> ACTION_REFERENCE_OLD_TABLE = createField("ACTION_REFERENCE_OLD_TABLE", org.jooq.impl.SQLDataType.VARCHAR(64), this, "");

    /**
     * The column <code>information_schema.TRIGGERS.ACTION_REFERENCE_NEW_TABLE</code>.
     */
    public final TableField<TriggersRecord, String> ACTION_REFERENCE_NEW_TABLE = createField("ACTION_REFERENCE_NEW_TABLE", org.jooq.impl.SQLDataType.VARCHAR(64), this, "");

    /**
     * The column <code>information_schema.TRIGGERS.ACTION_REFERENCE_OLD_ROW</code>.
     */
    public final TableField<TriggersRecord, String> ACTION_REFERENCE_OLD_ROW = createField("ACTION_REFERENCE_OLD_ROW", org.jooq.impl.SQLDataType.VARCHAR(3).nullable(false).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>information_schema.TRIGGERS.ACTION_REFERENCE_NEW_ROW</code>.
     */
    public final TableField<TriggersRecord, String> ACTION_REFERENCE_NEW_ROW = createField("ACTION_REFERENCE_NEW_ROW", org.jooq.impl.SQLDataType.VARCHAR(3).nullable(false).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>information_schema.TRIGGERS.CREATED</code>.
     */
    public final TableField<TriggersRecord, Timestamp> CREATED = createField("CREATED", org.jooq.impl.SQLDataType.TIMESTAMP, this, "");

    /**
     * The column <code>information_schema.TRIGGERS.SQL_MODE</code>.
     */
    public final TableField<TriggersRecord, String> SQL_MODE = createField("SQL_MODE", org.jooq.impl.SQLDataType.VARCHAR(8192).nullable(false).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>information_schema.TRIGGERS.DEFINER</code>.
     */
    public final TableField<TriggersRecord, String> DEFINER = createField("DEFINER", org.jooq.impl.SQLDataType.VARCHAR(93).nullable(false).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>information_schema.TRIGGERS.CHARACTER_SET_CLIENT</code>.
     */
    public final TableField<TriggersRecord, String> CHARACTER_SET_CLIENT = createField("CHARACTER_SET_CLIENT", org.jooq.impl.SQLDataType.VARCHAR(32).nullable(false).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>information_schema.TRIGGERS.COLLATION_CONNECTION</code>.
     */
    public final TableField<TriggersRecord, String> COLLATION_CONNECTION = createField("COLLATION_CONNECTION", org.jooq.impl.SQLDataType.VARCHAR(32).nullable(false).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>information_schema.TRIGGERS.DATABASE_COLLATION</code>.
     */
    public final TableField<TriggersRecord, String> DATABASE_COLLATION = createField("DATABASE_COLLATION", org.jooq.impl.SQLDataType.VARCHAR(32).nullable(false).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * Create a <code>information_schema.TRIGGERS</code> table reference
     */
    public Triggers() {
        this(DSL.name("TRIGGERS"), null);
    }

    /**
     * Create an aliased <code>information_schema.TRIGGERS</code> table reference
     */
    public Triggers(String alias) {
        this(DSL.name(alias), TRIGGERS);
    }

    /**
     * Create an aliased <code>information_schema.TRIGGERS</code> table reference
     */
    public Triggers(Name alias) {
        this(alias, TRIGGERS);
    }

    private Triggers(Name alias, Table<TriggersRecord> aliased) {
        this(alias, aliased, null);
    }

    private Triggers(Name alias, Table<TriggersRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> Triggers(Table<O> child, ForeignKey<O, TriggersRecord> key) {
        super(child, key, TRIGGERS);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return InformationSchema.INFORMATION_SCHEMA;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Triggers as(String alias) {
        return new Triggers(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Triggers as(Name alias) {
        return new Triggers(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Triggers rename(String name) {
        return new Triggers(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Triggers rename(Name name) {
        return new Triggers(name, null);
    }
}
