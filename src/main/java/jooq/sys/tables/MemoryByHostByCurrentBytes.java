/*
 * This file is generated by jOOQ.
 */
package jooq.sys.tables;


import jooq.sys.Sys;
import jooq.sys.tables.records.MemoryByHostByCurrentBytesRecord;
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
            "jOOQ version:3.11.9"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class MemoryByHostByCurrentBytes extends TableImpl<MemoryByHostByCurrentBytesRecord> {

    private static final long serialVersionUID = 714639932;

    /**
     * The reference instance of <code>sys.memory_by_host_by_current_bytes</code>
     */
    public static final MemoryByHostByCurrentBytes MEMORY_BY_HOST_BY_CURRENT_BYTES = new MemoryByHostByCurrentBytes();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<MemoryByHostByCurrentBytesRecord> getRecordType() {
        return MemoryByHostByCurrentBytesRecord.class;
    }

    /**
     * The column <code>sys.memory_by_host_by_current_bytes.host</code>.
     */
    public final TableField<MemoryByHostByCurrentBytesRecord, String> HOST = createField("host", org.jooq.impl.SQLDataType.VARCHAR(60), this, "");

    /**
     * The column <code>sys.memory_by_host_by_current_bytes.current_count_used</code>.
     */
    public final TableField<MemoryByHostByCurrentBytesRecord, BigInteger> CURRENT_COUNT_USED = createField("current_count_used", org.jooq.impl.SQLDataType.DECIMAL_INTEGER.precision(41), this, "");

    /**
     * The column <code>sys.memory_by_host_by_current_bytes.current_allocated</code>.
     */
    public final TableField<MemoryByHostByCurrentBytesRecord, String> CURRENT_ALLOCATED = createField("current_allocated", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>sys.memory_by_host_by_current_bytes.current_avg_alloc</code>.
     */
    public final TableField<MemoryByHostByCurrentBytesRecord, String> CURRENT_AVG_ALLOC = createField("current_avg_alloc", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>sys.memory_by_host_by_current_bytes.current_max_alloc</code>.
     */
    public final TableField<MemoryByHostByCurrentBytesRecord, String> CURRENT_MAX_ALLOC = createField("current_max_alloc", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>sys.memory_by_host_by_current_bytes.total_allocated</code>.
     */
    public final TableField<MemoryByHostByCurrentBytesRecord, String> TOTAL_ALLOCATED = createField("total_allocated", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * Create a <code>sys.memory_by_host_by_current_bytes</code> table reference
     */
    public MemoryByHostByCurrentBytes() {
        this(DSL.name("memory_by_host_by_current_bytes"), null);
    }

    /**
     * Create an aliased <code>sys.memory_by_host_by_current_bytes</code> table reference
     */
    public MemoryByHostByCurrentBytes(String alias) {
        this(DSL.name(alias), MEMORY_BY_HOST_BY_CURRENT_BYTES);
    }

    /**
     * Create an aliased <code>sys.memory_by_host_by_current_bytes</code> table reference
     */
    public MemoryByHostByCurrentBytes(Name alias) {
        this(alias, MEMORY_BY_HOST_BY_CURRENT_BYTES);
    }

    private MemoryByHostByCurrentBytes(Name alias, Table<MemoryByHostByCurrentBytesRecord> aliased) {
        this(alias, aliased, null);
    }

    private MemoryByHostByCurrentBytes(Name alias, Table<MemoryByHostByCurrentBytesRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("VIEW"));
    }

    public <O extends Record> MemoryByHostByCurrentBytes(Table<O> child, ForeignKey<O, MemoryByHostByCurrentBytesRecord> key) {
        super(child, key, MEMORY_BY_HOST_BY_CURRENT_BYTES);
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
    public MemoryByHostByCurrentBytes as(String alias) {
        return new MemoryByHostByCurrentBytes(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MemoryByHostByCurrentBytes as(Name alias) {
        return new MemoryByHostByCurrentBytes(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public MemoryByHostByCurrentBytes rename(String name) {
        return new MemoryByHostByCurrentBytes(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public MemoryByHostByCurrentBytes rename(Name name) {
        return new MemoryByHostByCurrentBytes(name, null);
    }
}
