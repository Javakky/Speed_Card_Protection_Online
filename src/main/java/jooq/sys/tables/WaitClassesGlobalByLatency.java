/*
 * This file is generated by jOOQ.
 */
package jooq.sys.tables;


import jooq.sys.Sys;
import jooq.sys.tables.records.WaitClassesGlobalByLatencyRecord;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;

import javax.annotation.Generated;
import java.math.BigInteger;


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
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class WaitClassesGlobalByLatency extends TableImpl<WaitClassesGlobalByLatencyRecord> {

    /**
     * The reference instance of <code>sys.wait_classes_global_by_latency</code>
     */
    public static final WaitClassesGlobalByLatency WAIT_CLASSES_GLOBAL_BY_LATENCY = new WaitClassesGlobalByLatency();
    private static final long serialVersionUID = 1695932151;
    /**
     * The column <code>sys.wait_classes_global_by_latency.event_class</code>.
     */
    public final TableField<WaitClassesGlobalByLatencyRecord, String> EVENT_CLASS = createField("event_class", org.jooq.impl.SQLDataType.VARCHAR(128), this, "");
    /**
     * The column <code>sys.wait_classes_global_by_latency.total</code>.
     */
    public final TableField<WaitClassesGlobalByLatencyRecord, BigInteger> TOTAL = createField("total", org.jooq.impl.SQLDataType.DECIMAL_INTEGER.precision(42), this, "");
    /**
     * The column <code>sys.wait_classes_global_by_latency.total_latency</code>.
     */
    public final TableField<WaitClassesGlobalByLatencyRecord, String> TOTAL_LATENCY = createField("total_latency", org.jooq.impl.SQLDataType.CLOB, this, "");
    /**
     * The column <code>sys.wait_classes_global_by_latency.min_latency</code>.
     */
    public final TableField<WaitClassesGlobalByLatencyRecord, String> MIN_LATENCY = createField("min_latency", org.jooq.impl.SQLDataType.CLOB, this, "");
    /**
     * The column <code>sys.wait_classes_global_by_latency.avg_latency</code>.
     */
    public final TableField<WaitClassesGlobalByLatencyRecord, String> AVG_LATENCY = createField("avg_latency", org.jooq.impl.SQLDataType.CLOB, this, "");
    /**
     * The column <code>sys.wait_classes_global_by_latency.max_latency</code>.
     */
    public final TableField<WaitClassesGlobalByLatencyRecord, String> MAX_LATENCY = createField("max_latency", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * Create a <code>sys.wait_classes_global_by_latency</code> table reference
     */
    public WaitClassesGlobalByLatency() {
        this(DSL.name("wait_classes_global_by_latency"), null);
    }

    /**
     * Create an aliased <code>sys.wait_classes_global_by_latency</code> table reference
     */
    public WaitClassesGlobalByLatency(String alias) {
        this(DSL.name(alias), WAIT_CLASSES_GLOBAL_BY_LATENCY);
    }

    /**
     * Create an aliased <code>sys.wait_classes_global_by_latency</code> table reference
     */
    public WaitClassesGlobalByLatency(Name alias) {
        this(alias, WAIT_CLASSES_GLOBAL_BY_LATENCY);
    }

    private WaitClassesGlobalByLatency(Name alias, Table<WaitClassesGlobalByLatencyRecord> aliased) {
        this(alias, aliased, null);
    }

    private WaitClassesGlobalByLatency(Name alias, Table<WaitClassesGlobalByLatencyRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("VIEW"));
    }

    public <O extends Record> WaitClassesGlobalByLatency(Table<O> child, ForeignKey<O, WaitClassesGlobalByLatencyRecord> key) {
        super(child, key, WAIT_CLASSES_GLOBAL_BY_LATENCY);
    }

    /**
     * The class holding records for this type
     */
    @Override
    public Class<WaitClassesGlobalByLatencyRecord> getRecordType() {
        return WaitClassesGlobalByLatencyRecord.class;
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
    public WaitClassesGlobalByLatency as(String alias) {
        return new WaitClassesGlobalByLatency(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WaitClassesGlobalByLatency as(Name alias) {
        return new WaitClassesGlobalByLatency(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public WaitClassesGlobalByLatency rename(String name) {
        return new WaitClassesGlobalByLatency(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public WaitClassesGlobalByLatency rename(Name name) {
        return new WaitClassesGlobalByLatency(name, null);
    }
}
