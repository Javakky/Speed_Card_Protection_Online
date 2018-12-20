/*
 * This file is generated by jOOQ.
 */
package jooq.performance_schema.tables;


import jooq.performance_schema.PerformanceSchema;
import jooq.performance_schema.tables.records.SessionVariablesRecord;
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
                "jOOQ version:3.11.2"
        },
        comments = "This class is generated by jOOQ"
)
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class SessionVariables extends TableImpl<SessionVariablesRecord> {

    /**
     * The reference instance of <code>performance_schema.session_variables</code>
     */
    public static final SessionVariables SESSION_VARIABLES = new SessionVariables();
    private static final long serialVersionUID = -917273905;
    /**
     * The column <code>performance_schema.session_variables.VARIABLE_NAME</code>.
     */
    public final TableField<SessionVariablesRecord, String> VARIABLE_NAME = createField("VARIABLE_NAME", org.jooq.impl.SQLDataType.VARCHAR(64).nullable(false), this, "");
    /**
     * The column <code>performance_schema.session_variables.VARIABLE_VALUE</code>.
     */
    public final TableField<SessionVariablesRecord, String> VARIABLE_VALUE = createField("VARIABLE_VALUE", org.jooq.impl.SQLDataType.VARCHAR(1024), this, "");

    /**
     * Create a <code>performance_schema.session_variables</code> table reference
     */
    public SessionVariables() {
        this(DSL.name("session_variables"), null);
    }

    /**
     * Create an aliased <code>performance_schema.session_variables</code> table reference
     */
    public SessionVariables(String alias) {
        this(DSL.name(alias), SESSION_VARIABLES);
    }

    /**
     * Create an aliased <code>performance_schema.session_variables</code> table reference
     */
    public SessionVariables(Name alias) {
        this(alias, SESSION_VARIABLES);
    }

    private SessionVariables(Name alias, Table<SessionVariablesRecord> aliased) {
        this(alias, aliased, null);
    }

    private SessionVariables(Name alias, Table<SessionVariablesRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> SessionVariables(Table<O> child, ForeignKey<O, SessionVariablesRecord> key) {
        super(child, key, SESSION_VARIABLES);
    }

    /**
     * The class holding records for this type
     */
    @Override
    public Class<SessionVariablesRecord> getRecordType() {
        return SessionVariablesRecord.class;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return PerformanceSchema.PERFORMANCE_SCHEMA;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SessionVariables as(String alias) {
        return new SessionVariables(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SessionVariables as(Name alias) {
        return new SessionVariables(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public SessionVariables rename(String name) {
        return new SessionVariables(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public SessionVariables rename(Name name) {
        return new SessionVariables(name, null);
    }
}
