/*
 * This file is generated by jOOQ.
 */
package jooq.information_schema.tables;


import jooq.information_schema.InformationSchema;
import jooq.information_schema.tables.records.TableConstraintsRecord;
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
public class TableConstraints extends TableImpl<TableConstraintsRecord> {

    private static final long serialVersionUID = -741140328;

    /**
     * The reference instance of <code>information_schema.TABLE_CONSTRAINTS</code>
     */
    public static final TableConstraints TABLE_CONSTRAINTS = new TableConstraints();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TableConstraintsRecord> getRecordType() {
        return TableConstraintsRecord.class;
    }

    /**
     * The column <code>information_schema.TABLE_CONSTRAINTS.CONSTRAINT_CATALOG</code>.
     */
    public final TableField<TableConstraintsRecord, String> CONSTRAINT_CATALOG = createField("CONSTRAINT_CATALOG", org.jooq.impl.SQLDataType.VARCHAR(512).nullable(false).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>information_schema.TABLE_CONSTRAINTS.CONSTRAINT_SCHEMA</code>.
     */
    public final TableField<TableConstraintsRecord, String> CONSTRAINT_SCHEMA = createField("CONSTRAINT_SCHEMA", org.jooq.impl.SQLDataType.VARCHAR(64).nullable(false).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>information_schema.TABLE_CONSTRAINTS.CONSTRAINT_NAME</code>.
     */
    public final TableField<TableConstraintsRecord, String> CONSTRAINT_NAME = createField("CONSTRAINT_NAME", org.jooq.impl.SQLDataType.VARCHAR(64).nullable(false).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>information_schema.TABLE_CONSTRAINTS.TABLE_SCHEMA</code>.
     */
    public final TableField<TableConstraintsRecord, String> TABLE_SCHEMA = createField("TABLE_SCHEMA", org.jooq.impl.SQLDataType.VARCHAR(64).nullable(false).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>information_schema.TABLE_CONSTRAINTS.TABLE_NAME</code>.
     */
    public final TableField<TableConstraintsRecord, String> TABLE_NAME = createField("TABLE_NAME", org.jooq.impl.SQLDataType.VARCHAR(64).nullable(false).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>information_schema.TABLE_CONSTRAINTS.CONSTRAINT_TYPE</code>.
     */
    public final TableField<TableConstraintsRecord, String> CONSTRAINT_TYPE = createField("CONSTRAINT_TYPE", org.jooq.impl.SQLDataType.VARCHAR(64).nullable(false).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * Create a <code>information_schema.TABLE_CONSTRAINTS</code> table reference
     */
    public TableConstraints() {
        this(DSL.name("TABLE_CONSTRAINTS"), null);
    }

    /**
     * Create an aliased <code>information_schema.TABLE_CONSTRAINTS</code> table reference
     */
    public TableConstraints(String alias) {
        this(DSL.name(alias), TABLE_CONSTRAINTS);
    }

    /**
     * Create an aliased <code>information_schema.TABLE_CONSTRAINTS</code> table reference
     */
    public TableConstraints(Name alias) {
        this(alias, TABLE_CONSTRAINTS);
    }

    private TableConstraints(Name alias, Table<TableConstraintsRecord> aliased) {
        this(alias, aliased, null);
    }

    private TableConstraints(Name alias, Table<TableConstraintsRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> TableConstraints(Table<O> child, ForeignKey<O, TableConstraintsRecord> key) {
        super(child, key, TABLE_CONSTRAINTS);
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
    public TableConstraints as(String alias) {
        return new TableConstraints(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TableConstraints as(Name alias) {
        return new TableConstraints(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public TableConstraints rename(String name) {
        return new TableConstraints(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public TableConstraints rename(Name name) {
        return new TableConstraints(name, null);
    }
}
