/*
 * This file is generated by jOOQ.
 */
package jooq.performance_schema.tables;


import jooq.performance_schema.PerformanceSchema;
import jooq.performance_schema.enums.SetupTimersTimerName;
import jooq.performance_schema.tables.records.SetupTimersRecord;
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
public class SetupTimers extends TableImpl<SetupTimersRecord> {

    /**
     * The reference instance of <code>performance_schema.setup_timers</code>
     */
    public static final SetupTimers SETUP_TIMERS = new SetupTimers();
    private static final long serialVersionUID = 307233007;
    /**
     * The column <code>performance_schema.setup_timers.NAME</code>.
     */
    public final TableField<SetupTimersRecord, String> NAME = createField("NAME", org.jooq.impl.SQLDataType.VARCHAR(64).nullable(false), this, "");
    /**
     * The column <code>performance_schema.setup_timers.TIMER_NAME</code>.
     */
    public final TableField<SetupTimersRecord, SetupTimersTimerName> TIMER_NAME = createField("TIMER_NAME", org.jooq.impl.SQLDataType.VARCHAR(11).nullable(false).asEnumDataType(jooq.performance_schema.enums.SetupTimersTimerName.class), this, "");

    /**
     * Create a <code>performance_schema.setup_timers</code> table reference
     */
    public SetupTimers() {
        this(DSL.name("setup_timers"), null);
    }

    /**
     * Create an aliased <code>performance_schema.setup_timers</code> table reference
     */
    public SetupTimers(String alias) {
        this(DSL.name(alias), SETUP_TIMERS);
    }

    /**
     * Create an aliased <code>performance_schema.setup_timers</code> table reference
     */
    public SetupTimers(Name alias) {
        this(alias, SETUP_TIMERS);
    }

    private SetupTimers(Name alias, Table<SetupTimersRecord> aliased) {
        this(alias, aliased, null);
    }

    private SetupTimers(Name alias, Table<SetupTimersRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> SetupTimers(Table<O> child, ForeignKey<O, SetupTimersRecord> key) {
        super(child, key, SETUP_TIMERS);
    }

    /**
     * The class holding records for this type
     */
    @Override
    public Class<SetupTimersRecord> getRecordType() {
        return SetupTimersRecord.class;
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
    public SetupTimers as(String alias) {
        return new SetupTimers(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SetupTimers as(Name alias) {
        return new SetupTimers(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public SetupTimers rename(String name) {
        return new SetupTimers(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public SetupTimers rename(Name name) {
        return new SetupTimers(name, null);
    }
}
