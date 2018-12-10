/*
 * This file is generated by jOOQ.
 */
package jooq.sys.tables;


import javax.annotation.Generated;

import jooq.sys.Sys;
import jooq.sys.tables.records.X$waitsByHostByLatencyRecord;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;
import org.jooq.types.ULong;


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
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class X$waitsByHostByLatency extends TableImpl<X$waitsByHostByLatencyRecord> {

    private static final long serialVersionUID = -1859923650;

    /**
     * The reference instance of <code>sys.x$waits_by_host_by_latency</code>
     */
    public static final X$waitsByHostByLatency X$WAITS_BY_HOST_BY_LATENCY = new X$waitsByHostByLatency();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<X$waitsByHostByLatencyRecord> getRecordType() {
        return X$waitsByHostByLatencyRecord.class;
    }

    /**
     * The column <code>sys.x$waits_by_host_by_latency.host</code>.
     */
    public final TableField<X$waitsByHostByLatencyRecord, String> HOST = createField("host", org.jooq.impl.SQLDataType.VARCHAR(60), this, "");

    /**
     * The column <code>sys.x$waits_by_host_by_latency.event</code>.
     */
    public final TableField<X$waitsByHostByLatencyRecord, String> EVENT = createField("event", org.jooq.impl.SQLDataType.VARCHAR(128).nullable(false), this, "");

    /**
     * The column <code>sys.x$waits_by_host_by_latency.total</code>.
     */
    public final TableField<X$waitsByHostByLatencyRecord, ULong> TOTAL = createField("total", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>sys.x$waits_by_host_by_latency.total_latency</code>.
     */
    public final TableField<X$waitsByHostByLatencyRecord, ULong> TOTAL_LATENCY = createField("total_latency", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>sys.x$waits_by_host_by_latency.avg_latency</code>.
     */
    public final TableField<X$waitsByHostByLatencyRecord, ULong> AVG_LATENCY = createField("avg_latency", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>sys.x$waits_by_host_by_latency.max_latency</code>.
     */
    public final TableField<X$waitsByHostByLatencyRecord, ULong> MAX_LATENCY = createField("max_latency", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");

    /**
     * Create a <code>sys.x$waits_by_host_by_latency</code> table reference
     */
    public X$waitsByHostByLatency() {
        this(DSL.name("x$waits_by_host_by_latency"), null);
    }

    /**
     * Create an aliased <code>sys.x$waits_by_host_by_latency</code> table reference
     */
    public X$waitsByHostByLatency(String alias) {
        this(DSL.name(alias), X$WAITS_BY_HOST_BY_LATENCY);
    }

    /**
     * Create an aliased <code>sys.x$waits_by_host_by_latency</code> table reference
     */
    public X$waitsByHostByLatency(Name alias) {
        this(alias, X$WAITS_BY_HOST_BY_LATENCY);
    }

    private X$waitsByHostByLatency(Name alias, Table<X$waitsByHostByLatencyRecord> aliased) {
        this(alias, aliased, null);
    }

    private X$waitsByHostByLatency(Name alias, Table<X$waitsByHostByLatencyRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("VIEW"));
    }

    public <O extends Record> X$waitsByHostByLatency(Table<O> child, ForeignKey<O, X$waitsByHostByLatencyRecord> key) {
        super(child, key, X$WAITS_BY_HOST_BY_LATENCY);
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
    public X$waitsByHostByLatency as(String alias) {
        return new X$waitsByHostByLatency(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X$waitsByHostByLatency as(Name alias) {
        return new X$waitsByHostByLatency(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public X$waitsByHostByLatency rename(String name) {
        return new X$waitsByHostByLatency(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public X$waitsByHostByLatency rename(Name name) {
        return new X$waitsByHostByLatency(name, null);
    }
}
