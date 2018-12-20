/*
 * This file is generated by jOOQ.
 */
package jooq.sys.tables;


import jooq.sys.Sys;
import jooq.sys.tables.records.IoGlobalByWaitByLatencyRecord;
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
                "jOOQ version:3.11.2"
        },
        comments = "This class is generated by jOOQ"
)
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class IoGlobalByWaitByLatency extends TableImpl<IoGlobalByWaitByLatencyRecord> {

    /**
     * The reference instance of <code>sys.io_global_by_wait_by_latency</code>
     */
    public static final IoGlobalByWaitByLatency IO_GLOBAL_BY_WAIT_BY_LATENCY = new IoGlobalByWaitByLatency();
    private static final long serialVersionUID = 1397735312;
    /**
     * The column <code>sys.io_global_by_wait_by_latency.event_name</code>.
     */
    public final TableField<IoGlobalByWaitByLatencyRecord, String> EVENT_NAME = createField("event_name", org.jooq.impl.SQLDataType.VARCHAR(128), this, "");
    /**
     * The column <code>sys.io_global_by_wait_by_latency.total</code>.
     */
    public final TableField<IoGlobalByWaitByLatencyRecord, ULong> TOTAL = createField("total", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");
    /**
     * The column <code>sys.io_global_by_wait_by_latency.total_latency</code>.
     */
    public final TableField<IoGlobalByWaitByLatencyRecord, String> TOTAL_LATENCY = createField("total_latency", org.jooq.impl.SQLDataType.CLOB, this, "");
    /**
     * The column <code>sys.io_global_by_wait_by_latency.avg_latency</code>.
     */
    public final TableField<IoGlobalByWaitByLatencyRecord, String> AVG_LATENCY = createField("avg_latency", org.jooq.impl.SQLDataType.CLOB, this, "");
    /**
     * The column <code>sys.io_global_by_wait_by_latency.max_latency</code>.
     */
    public final TableField<IoGlobalByWaitByLatencyRecord, String> MAX_LATENCY = createField("max_latency", org.jooq.impl.SQLDataType.CLOB, this, "");
    /**
     * The column <code>sys.io_global_by_wait_by_latency.read_latency</code>.
     */
    public final TableField<IoGlobalByWaitByLatencyRecord, String> READ_LATENCY = createField("read_latency", org.jooq.impl.SQLDataType.CLOB, this, "");
    /**
     * The column <code>sys.io_global_by_wait_by_latency.write_latency</code>.
     */
    public final TableField<IoGlobalByWaitByLatencyRecord, String> WRITE_LATENCY = createField("write_latency", org.jooq.impl.SQLDataType.CLOB, this, "");
    /**
     * The column <code>sys.io_global_by_wait_by_latency.misc_latency</code>.
     */
    public final TableField<IoGlobalByWaitByLatencyRecord, String> MISC_LATENCY = createField("misc_latency", org.jooq.impl.SQLDataType.CLOB, this, "");
    /**
     * The column <code>sys.io_global_by_wait_by_latency.count_read</code>.
     */
    public final TableField<IoGlobalByWaitByLatencyRecord, ULong> COUNT_READ = createField("count_read", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");
    /**
     * The column <code>sys.io_global_by_wait_by_latency.total_read</code>.
     */
    public final TableField<IoGlobalByWaitByLatencyRecord, String> TOTAL_READ = createField("total_read", org.jooq.impl.SQLDataType.CLOB, this, "");
    /**
     * The column <code>sys.io_global_by_wait_by_latency.avg_read</code>.
     */
    public final TableField<IoGlobalByWaitByLatencyRecord, String> AVG_READ = createField("avg_read", org.jooq.impl.SQLDataType.CLOB, this, "");
    /**
     * The column <code>sys.io_global_by_wait_by_latency.count_write</code>.
     */
    public final TableField<IoGlobalByWaitByLatencyRecord, ULong> COUNT_WRITE = createField("count_write", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");
    /**
     * The column <code>sys.io_global_by_wait_by_latency.total_written</code>.
     */
    public final TableField<IoGlobalByWaitByLatencyRecord, String> TOTAL_WRITTEN = createField("total_written", org.jooq.impl.SQLDataType.CLOB, this, "");
    /**
     * The column <code>sys.io_global_by_wait_by_latency.avg_written</code>.
     */
    public final TableField<IoGlobalByWaitByLatencyRecord, String> AVG_WRITTEN = createField("avg_written", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * Create a <code>sys.io_global_by_wait_by_latency</code> table reference
     */
    public IoGlobalByWaitByLatency() {
        this(DSL.name("io_global_by_wait_by_latency"), null);
    }

    /**
     * Create an aliased <code>sys.io_global_by_wait_by_latency</code> table reference
     */
    public IoGlobalByWaitByLatency(String alias) {
        this(DSL.name(alias), IO_GLOBAL_BY_WAIT_BY_LATENCY);
    }

    /**
     * Create an aliased <code>sys.io_global_by_wait_by_latency</code> table reference
     */
    public IoGlobalByWaitByLatency(Name alias) {
        this(alias, IO_GLOBAL_BY_WAIT_BY_LATENCY);
    }

    private IoGlobalByWaitByLatency(Name alias, Table<IoGlobalByWaitByLatencyRecord> aliased) {
        this(alias, aliased, null);
    }

    private IoGlobalByWaitByLatency(Name alias, Table<IoGlobalByWaitByLatencyRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("VIEW"));
    }

    public <O extends Record> IoGlobalByWaitByLatency(Table<O> child, ForeignKey<O, IoGlobalByWaitByLatencyRecord> key) {
        super(child, key, IO_GLOBAL_BY_WAIT_BY_LATENCY);
    }

    /**
     * The class holding records for this type
     */
    @Override
    public Class<IoGlobalByWaitByLatencyRecord> getRecordType() {
        return IoGlobalByWaitByLatencyRecord.class;
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
    public IoGlobalByWaitByLatency as(String alias) {
        return new IoGlobalByWaitByLatency(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IoGlobalByWaitByLatency as(Name alias) {
        return new IoGlobalByWaitByLatency(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public IoGlobalByWaitByLatency rename(String name) {
        return new IoGlobalByWaitByLatency(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public IoGlobalByWaitByLatency rename(Name name) {
        return new IoGlobalByWaitByLatency(name, null);
    }
}
