/*
 * This file is generated by jOOQ.
 */
package jooq.performance_schema.tables;


import jooq.performance_schema.PerformanceSchema;
import jooq.performance_schema.tables.records.SocketSummaryByEventNameRecord;
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
public class SocketSummaryByEventName extends TableImpl<SocketSummaryByEventNameRecord> {

    /**
     * The reference instance of <code>performance_schema.socket_summary_by_event_name</code>
     */
    public static final SocketSummaryByEventName SOCKET_SUMMARY_BY_EVENT_NAME = new SocketSummaryByEventName();
    private static final long serialVersionUID = -114981138;
    /**
     * The column <code>performance_schema.socket_summary_by_event_name.EVENT_NAME</code>.
     */
    public final TableField<SocketSummaryByEventNameRecord, String> EVENT_NAME = createField("EVENT_NAME", org.jooq.impl.SQLDataType.VARCHAR(128).nullable(false), this, "");
    /**
     * The column <code>performance_schema.socket_summary_by_event_name.COUNT_STAR</code>.
     */
    public final TableField<SocketSummaryByEventNameRecord, ULong> COUNT_STAR = createField("COUNT_STAR", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");
    /**
     * The column <code>performance_schema.socket_summary_by_event_name.SUM_TIMER_WAIT</code>.
     */
    public final TableField<SocketSummaryByEventNameRecord, ULong> SUM_TIMER_WAIT = createField("SUM_TIMER_WAIT", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");
    /**
     * The column <code>performance_schema.socket_summary_by_event_name.MIN_TIMER_WAIT</code>.
     */
    public final TableField<SocketSummaryByEventNameRecord, ULong> MIN_TIMER_WAIT = createField("MIN_TIMER_WAIT", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");
    /**
     * The column <code>performance_schema.socket_summary_by_event_name.AVG_TIMER_WAIT</code>.
     */
    public final TableField<SocketSummaryByEventNameRecord, ULong> AVG_TIMER_WAIT = createField("AVG_TIMER_WAIT", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");
    /**
     * The column <code>performance_schema.socket_summary_by_event_name.MAX_TIMER_WAIT</code>.
     */
    public final TableField<SocketSummaryByEventNameRecord, ULong> MAX_TIMER_WAIT = createField("MAX_TIMER_WAIT", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");
    /**
     * The column <code>performance_schema.socket_summary_by_event_name.COUNT_READ</code>.
     */
    public final TableField<SocketSummaryByEventNameRecord, ULong> COUNT_READ = createField("COUNT_READ", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");
    /**
     * The column <code>performance_schema.socket_summary_by_event_name.SUM_TIMER_READ</code>.
     */
    public final TableField<SocketSummaryByEventNameRecord, ULong> SUM_TIMER_READ = createField("SUM_TIMER_READ", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");
    /**
     * The column <code>performance_schema.socket_summary_by_event_name.MIN_TIMER_READ</code>.
     */
    public final TableField<SocketSummaryByEventNameRecord, ULong> MIN_TIMER_READ = createField("MIN_TIMER_READ", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");
    /**
     * The column <code>performance_schema.socket_summary_by_event_name.AVG_TIMER_READ</code>.
     */
    public final TableField<SocketSummaryByEventNameRecord, ULong> AVG_TIMER_READ = createField("AVG_TIMER_READ", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");
    /**
     * The column <code>performance_schema.socket_summary_by_event_name.MAX_TIMER_READ</code>.
     */
    public final TableField<SocketSummaryByEventNameRecord, ULong> MAX_TIMER_READ = createField("MAX_TIMER_READ", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");
    /**
     * The column <code>performance_schema.socket_summary_by_event_name.SUM_NUMBER_OF_BYTES_READ</code>.
     */
    public final TableField<SocketSummaryByEventNameRecord, ULong> SUM_NUMBER_OF_BYTES_READ = createField("SUM_NUMBER_OF_BYTES_READ", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");
    /**
     * The column <code>performance_schema.socket_summary_by_event_name.COUNT_WRITE</code>.
     */
    public final TableField<SocketSummaryByEventNameRecord, ULong> COUNT_WRITE = createField("COUNT_WRITE", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");
    /**
     * The column <code>performance_schema.socket_summary_by_event_name.SUM_TIMER_WRITE</code>.
     */
    public final TableField<SocketSummaryByEventNameRecord, ULong> SUM_TIMER_WRITE = createField("SUM_TIMER_WRITE", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");
    /**
     * The column <code>performance_schema.socket_summary_by_event_name.MIN_TIMER_WRITE</code>.
     */
    public final TableField<SocketSummaryByEventNameRecord, ULong> MIN_TIMER_WRITE = createField("MIN_TIMER_WRITE", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");
    /**
     * The column <code>performance_schema.socket_summary_by_event_name.AVG_TIMER_WRITE</code>.
     */
    public final TableField<SocketSummaryByEventNameRecord, ULong> AVG_TIMER_WRITE = createField("AVG_TIMER_WRITE", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");
    /**
     * The column <code>performance_schema.socket_summary_by_event_name.MAX_TIMER_WRITE</code>.
     */
    public final TableField<SocketSummaryByEventNameRecord, ULong> MAX_TIMER_WRITE = createField("MAX_TIMER_WRITE", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");
    /**
     * The column <code>performance_schema.socket_summary_by_event_name.SUM_NUMBER_OF_BYTES_WRITE</code>.
     */
    public final TableField<SocketSummaryByEventNameRecord, ULong> SUM_NUMBER_OF_BYTES_WRITE = createField("SUM_NUMBER_OF_BYTES_WRITE", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");
    /**
     * The column <code>performance_schema.socket_summary_by_event_name.COUNT_MISC</code>.
     */
    public final TableField<SocketSummaryByEventNameRecord, ULong> COUNT_MISC = createField("COUNT_MISC", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");
    /**
     * The column <code>performance_schema.socket_summary_by_event_name.SUM_TIMER_MISC</code>.
     */
    public final TableField<SocketSummaryByEventNameRecord, ULong> SUM_TIMER_MISC = createField("SUM_TIMER_MISC", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");
    /**
     * The column <code>performance_schema.socket_summary_by_event_name.MIN_TIMER_MISC</code>.
     */
    public final TableField<SocketSummaryByEventNameRecord, ULong> MIN_TIMER_MISC = createField("MIN_TIMER_MISC", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");
    /**
     * The column <code>performance_schema.socket_summary_by_event_name.AVG_TIMER_MISC</code>.
     */
    public final TableField<SocketSummaryByEventNameRecord, ULong> AVG_TIMER_MISC = createField("AVG_TIMER_MISC", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");
    /**
     * The column <code>performance_schema.socket_summary_by_event_name.MAX_TIMER_MISC</code>.
     */
    public final TableField<SocketSummaryByEventNameRecord, ULong> MAX_TIMER_MISC = createField("MAX_TIMER_MISC", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");

    /**
     * Create a <code>performance_schema.socket_summary_by_event_name</code> table reference
     */
    public SocketSummaryByEventName() {
        this(DSL.name("socket_summary_by_event_name"), null);
    }

    /**
     * Create an aliased <code>performance_schema.socket_summary_by_event_name</code> table reference
     */
    public SocketSummaryByEventName(String alias) {
        this(DSL.name(alias), SOCKET_SUMMARY_BY_EVENT_NAME);
    }

    /**
     * Create an aliased <code>performance_schema.socket_summary_by_event_name</code> table reference
     */
    public SocketSummaryByEventName(Name alias) {
        this(alias, SOCKET_SUMMARY_BY_EVENT_NAME);
    }

    private SocketSummaryByEventName(Name alias, Table<SocketSummaryByEventNameRecord> aliased) {
        this(alias, aliased, null);
    }

    private SocketSummaryByEventName(Name alias, Table<SocketSummaryByEventNameRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> SocketSummaryByEventName(Table<O> child, ForeignKey<O, SocketSummaryByEventNameRecord> key) {
        super(child, key, SOCKET_SUMMARY_BY_EVENT_NAME);
    }

    /**
     * The class holding records for this type
     */
    @Override
    public Class<SocketSummaryByEventNameRecord> getRecordType() {
        return SocketSummaryByEventNameRecord.class;
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
    public SocketSummaryByEventName as(String alias) {
        return new SocketSummaryByEventName(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SocketSummaryByEventName as(Name alias) {
        return new SocketSummaryByEventName(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public SocketSummaryByEventName rename(String name) {
        return new SocketSummaryByEventName(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public SocketSummaryByEventName rename(Name name) {
        return new SocketSummaryByEventName(name, null);
    }
}
