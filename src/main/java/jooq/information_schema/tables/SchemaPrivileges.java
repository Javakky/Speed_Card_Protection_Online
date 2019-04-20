/*
 * This file is generated by jOOQ.
 */
package jooq.information_schema.tables;


import jooq.information_schema.InformationSchema;
import jooq.information_schema.tables.records.SchemaPrivilegesRecord;
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
public class SchemaPrivileges extends TableImpl<SchemaPrivilegesRecord> {

    private static final long serialVersionUID = -1027452839;

    /**
     * The reference instance of <code>information_schema.SCHEMA_PRIVILEGES</code>
     */
    public static final SchemaPrivileges SCHEMA_PRIVILEGES = new SchemaPrivileges();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<SchemaPrivilegesRecord> getRecordType() {
        return SchemaPrivilegesRecord.class;
    }

    /**
     * The column <code>information_schema.SCHEMA_PRIVILEGES.GRANTEE</code>.
     */
    public final TableField<SchemaPrivilegesRecord, String> GRANTEE = createField("GRANTEE", org.jooq.impl.SQLDataType.VARCHAR(81).nullable(false).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>information_schema.SCHEMA_PRIVILEGES.TABLE_CATALOG</code>.
     */
    public final TableField<SchemaPrivilegesRecord, String> TABLE_CATALOG = createField("TABLE_CATALOG", org.jooq.impl.SQLDataType.VARCHAR(512).nullable(false).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>information_schema.SCHEMA_PRIVILEGES.TABLE_SCHEMA</code>.
     */
    public final TableField<SchemaPrivilegesRecord, String> TABLE_SCHEMA = createField("TABLE_SCHEMA", org.jooq.impl.SQLDataType.VARCHAR(64).nullable(false).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>information_schema.SCHEMA_PRIVILEGES.PRIVILEGE_TYPE</code>.
     */
    public final TableField<SchemaPrivilegesRecord, String> PRIVILEGE_TYPE = createField("PRIVILEGE_TYPE", org.jooq.impl.SQLDataType.VARCHAR(64).nullable(false).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>information_schema.SCHEMA_PRIVILEGES.IS_GRANTABLE</code>.
     */
    public final TableField<SchemaPrivilegesRecord, String> IS_GRANTABLE = createField("IS_GRANTABLE", org.jooq.impl.SQLDataType.VARCHAR(3).nullable(false).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * Create a <code>information_schema.SCHEMA_PRIVILEGES</code> table reference
     */
    public SchemaPrivileges() {
        this(DSL.name("SCHEMA_PRIVILEGES"), null);
    }

    /**
     * Create an aliased <code>information_schema.SCHEMA_PRIVILEGES</code> table reference
     */
    public SchemaPrivileges(String alias) {
        this(DSL.name(alias), SCHEMA_PRIVILEGES);
    }

    /**
     * Create an aliased <code>information_schema.SCHEMA_PRIVILEGES</code> table reference
     */
    public SchemaPrivileges(Name alias) {
        this(alias, SCHEMA_PRIVILEGES);
    }

    private SchemaPrivileges(Name alias, Table<SchemaPrivilegesRecord> aliased) {
        this(alias, aliased, null);
    }

    private SchemaPrivileges(Name alias, Table<SchemaPrivilegesRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> SchemaPrivileges(Table<O> child, ForeignKey<O, SchemaPrivilegesRecord> key) {
        super(child, key, SCHEMA_PRIVILEGES);
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
    public SchemaPrivileges as(String alias) {
        return new SchemaPrivileges(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SchemaPrivileges as(Name alias) {
        return new SchemaPrivileges(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public SchemaPrivileges rename(String name) {
        return new SchemaPrivileges(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public SchemaPrivileges rename(Name name) {
        return new SchemaPrivileges(name, null);
    }
}
