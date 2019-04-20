/*
 * This file is generated by jOOQ.
 */
package jooq.sys.tables;


import jooq.sys.Sys;
import jooq.sys.tables.records.WaitsByHostByLatencyRecord;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;
import org.jooq.types.ULong;

import javax.annotation.Generated;


/**
 * VIEW
 */
@Generated(
    value = {
        "http://www.jooq.org",
            "jOOQ version:3.11.9"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class WaitsByHostByLatency extends TableImpl<WaitsByHostByLatencyRecord> {

    private static final long serialVersionUID = 1734049032;

    /**
     * The reference instance of <code>sys.waits_by_host_by_latency</code>
     */
    public static final WaitsByHostByLatency WAITS_BY_HOST_BY_LATENCY = new WaitsByHostByLatency();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<WaitsByHostByLatencyRecord> getRecordType() {
        return WaitsByHostByLatencyRecord.class;
    }

    /**
     * The column <code>sys.waits_by_host_by_latency.host</code>.
     */
    public final TableField<WaitsByHostByLatencyRecord, String> HOST = createField("host", org.jooq.impl.SQLDataType.VARCHAR(60), this, "");

    /**
     * The column <code>sys.waits_by_host_by_latency.event</code>.
     */
    public final TableField<WaitsByHostByLatencyRecord, String> EVENT = createField("event", org.jooq.impl.SQLDataType.VARCHAR(128).nullable(false), this, "");

    /**
     * The column <code>sys.waits_by_host_by_latency.total</code>.
     */
    public final TableField<WaitsByHostByLatencyRecord, ULong> TOTAL = createField("total", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>sys.waits_by_host_by_latency.total_latency</code>.
     */
    public final TableField<WaitsByHostByLatencyRecord, String> TOTAL_LATENCY = createField("total_latency", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>sys.waits_by_host_by_latency.avg_latency</code>.
     */
    public final TableField<WaitsByHostByLatencyRecord, String> AVG_LATENCY = createField("avg_latency", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>sys.waits_by_host_by_latency.max_latency</code>.
     */
    public final TableField<WaitsByHostByLatencyRecord, String> MAX_LATENCY = createField("max_latency", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * Create a <code>sys.waits_by_host_by_latency</code> table reference
     */
    public WaitsByHostByLatency() {
        this(DSL.name("waits_by_host_by_latency"), null);
    }

    /**
     * Create an aliased <code>sys.waits_by_host_by_latency</code> table reference
     */
    public WaitsByHostByLatency(String alias) {
        this(DSL.name(alias), WAITS_BY_HOST_BY_LATENCY);
    }

    /**
     * Create an aliased <code>sys.waits_by_host_by_latency</code> table reference
     */
    public WaitsByHostByLatency(Name alias) {
        this(alias, WAITS_BY_HOST_BY_LATENCY);
    }

    private WaitsByHostByLatency(Name alias, Table<WaitsByHostByLatencyRecord> aliased) {
        this(alias, aliased, null);
    }

    private WaitsByHostByLatency(Name alias, Table<WaitsByHostByLatencyRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("VIEW"));
    }

    public <O extends Record> WaitsByHostByLatency(Table<O> child, ForeignKey<O, WaitsByHostByLatencyRecord> key) {
        super(child, key, WAITS_BY_HOST_BY_LATENCY);
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
    public WaitsByHostByLatency as(String alias) {
        return new WaitsByHostByLatency(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WaitsByHostByLatency as(Name alias) {
        return new WaitsByHostByLatency(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public WaitsByHostByLatency rename(String name) {
        return new WaitsByHostByLatency(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public WaitsByHostByLatency rename(Name name) {
        return new WaitsByHostByLatency(name, null);
    }
}
