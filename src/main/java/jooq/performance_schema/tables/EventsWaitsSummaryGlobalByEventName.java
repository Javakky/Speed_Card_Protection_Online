/*
 * This file is generated by jOOQ.
 */
package jooq.performance_schema.tables;


import jooq.performance_schema.PerformanceSchema;
import jooq.performance_schema.tables.records.EventsWaitsSummaryGlobalByEventNameRecord;
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
            "jOOQ version:3.11.9"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class EventsWaitsSummaryGlobalByEventName extends TableImpl<EventsWaitsSummaryGlobalByEventNameRecord> {

    private static final long serialVersionUID = 1827621107;

    /**
     * The reference instance of <code>performance_schema.events_waits_summary_global_by_event_name</code>
     */
    public static final EventsWaitsSummaryGlobalByEventName EVENTS_WAITS_SUMMARY_GLOBAL_BY_EVENT_NAME = new EventsWaitsSummaryGlobalByEventName();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<EventsWaitsSummaryGlobalByEventNameRecord> getRecordType() {
        return EventsWaitsSummaryGlobalByEventNameRecord.class;
    }

    /**
     * The column <code>performance_schema.events_waits_summary_global_by_event_name.EVENT_NAME</code>.
     */
    public final TableField<EventsWaitsSummaryGlobalByEventNameRecord, String> EVENT_NAME = createField("EVENT_NAME", org.jooq.impl.SQLDataType.VARCHAR(128).nullable(false), this, "");

    /**
     * The column <code>performance_schema.events_waits_summary_global_by_event_name.COUNT_STAR</code>.
     */
    public final TableField<EventsWaitsSummaryGlobalByEventNameRecord, ULong> COUNT_STAR = createField("COUNT_STAR", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>performance_schema.events_waits_summary_global_by_event_name.SUM_TIMER_WAIT</code>.
     */
    public final TableField<EventsWaitsSummaryGlobalByEventNameRecord, ULong> SUM_TIMER_WAIT = createField("SUM_TIMER_WAIT", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>performance_schema.events_waits_summary_global_by_event_name.MIN_TIMER_WAIT</code>.
     */
    public final TableField<EventsWaitsSummaryGlobalByEventNameRecord, ULong> MIN_TIMER_WAIT = createField("MIN_TIMER_WAIT", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>performance_schema.events_waits_summary_global_by_event_name.AVG_TIMER_WAIT</code>.
     */
    public final TableField<EventsWaitsSummaryGlobalByEventNameRecord, ULong> AVG_TIMER_WAIT = createField("AVG_TIMER_WAIT", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>performance_schema.events_waits_summary_global_by_event_name.MAX_TIMER_WAIT</code>.
     */
    public final TableField<EventsWaitsSummaryGlobalByEventNameRecord, ULong> MAX_TIMER_WAIT = createField("MAX_TIMER_WAIT", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");

    /**
     * Create a <code>performance_schema.events_waits_summary_global_by_event_name</code> table reference
     */
    public EventsWaitsSummaryGlobalByEventName() {
        this(DSL.name("events_waits_summary_global_by_event_name"), null);
    }

    /**
     * Create an aliased <code>performance_schema.events_waits_summary_global_by_event_name</code> table reference
     */
    public EventsWaitsSummaryGlobalByEventName(String alias) {
        this(DSL.name(alias), EVENTS_WAITS_SUMMARY_GLOBAL_BY_EVENT_NAME);
    }

    /**
     * Create an aliased <code>performance_schema.events_waits_summary_global_by_event_name</code> table reference
     */
    public EventsWaitsSummaryGlobalByEventName(Name alias) {
        this(alias, EVENTS_WAITS_SUMMARY_GLOBAL_BY_EVENT_NAME);
    }

    private EventsWaitsSummaryGlobalByEventName(Name alias, Table<EventsWaitsSummaryGlobalByEventNameRecord> aliased) {
        this(alias, aliased, null);
    }

    private EventsWaitsSummaryGlobalByEventName(Name alias, Table<EventsWaitsSummaryGlobalByEventNameRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> EventsWaitsSummaryGlobalByEventName(Table<O> child, ForeignKey<O, EventsWaitsSummaryGlobalByEventNameRecord> key) {
        super(child, key, EVENTS_WAITS_SUMMARY_GLOBAL_BY_EVENT_NAME);
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
    public EventsWaitsSummaryGlobalByEventName as(String alias) {
        return new EventsWaitsSummaryGlobalByEventName(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EventsWaitsSummaryGlobalByEventName as(Name alias) {
        return new EventsWaitsSummaryGlobalByEventName(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public EventsWaitsSummaryGlobalByEventName rename(String name) {
        return new EventsWaitsSummaryGlobalByEventName(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public EventsWaitsSummaryGlobalByEventName rename(Name name) {
        return new EventsWaitsSummaryGlobalByEventName(name, null);
    }
}
