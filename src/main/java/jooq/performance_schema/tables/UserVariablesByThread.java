/*
 * This file is generated by jOOQ.
 */
package jooq.performance_schema.tables;


import jooq.performance_schema.PerformanceSchema;
import jooq.performance_schema.tables.records.UserVariablesByThreadRecord;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;
import org.jooq.types.ULong;

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
public class UserVariablesByThread extends TableImpl<UserVariablesByThreadRecord> {

    /**
     * The reference instance of <code>performance_schema.user_variables_by_thread</code>
     */
    public static final UserVariablesByThread USER_VARIABLES_BY_THREAD = new UserVariablesByThread();
    private static final long serialVersionUID = 72602150;
    /**
     * The column <code>performance_schema.user_variables_by_thread.THREAD_ID</code>.
     */
    public final TableField<UserVariablesByThreadRecord, ULong> THREAD_ID = createField("THREAD_ID", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");
    /**
     * The column <code>performance_schema.user_variables_by_thread.VARIABLE_NAME</code>.
     */
    public final TableField<UserVariablesByThreadRecord, String> VARIABLE_NAME = createField("VARIABLE_NAME", org.jooq.impl.SQLDataType.VARCHAR(64).nullable(false), this, "");
    /**
     * The column <code>performance_schema.user_variables_by_thread.VARIABLE_VALUE</code>.
     */
    public final TableField<UserVariablesByThreadRecord, byte[]> VARIABLE_VALUE = createField("VARIABLE_VALUE", org.jooq.impl.SQLDataType.BLOB, this, "");

    /**
     * Create a <code>performance_schema.user_variables_by_thread</code> table reference
     */
    public UserVariablesByThread() {
        this(DSL.name("user_variables_by_thread"), null);
    }

    /**
     * Create an aliased <code>performance_schema.user_variables_by_thread</code> table reference
     */
    public UserVariablesByThread(String alias) {
        this(DSL.name(alias), USER_VARIABLES_BY_THREAD);
    }

    /**
     * Create an aliased <code>performance_schema.user_variables_by_thread</code> table reference
     */
    public UserVariablesByThread(Name alias) {
        this(alias, USER_VARIABLES_BY_THREAD);
    }

    private UserVariablesByThread(Name alias, Table<UserVariablesByThreadRecord> aliased) {
        this(alias, aliased, null);
    }

    private UserVariablesByThread(Name alias, Table<UserVariablesByThreadRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> UserVariablesByThread(Table<O> child, ForeignKey<O, UserVariablesByThreadRecord> key) {
        super(child, key, USER_VARIABLES_BY_THREAD);
    }

    /**
     * The class holding records for this type
     */
    @Override
    public Class<UserVariablesByThreadRecord> getRecordType() {
        return UserVariablesByThreadRecord.class;
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
    public UserVariablesByThread as(String alias) {
        return new UserVariablesByThread(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserVariablesByThread as(Name alias) {
        return new UserVariablesByThread(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public UserVariablesByThread rename(String name) {
        return new UserVariablesByThread(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public UserVariablesByThread rename(Name name) {
        return new UserVariablesByThread(name, null);
    }
}
