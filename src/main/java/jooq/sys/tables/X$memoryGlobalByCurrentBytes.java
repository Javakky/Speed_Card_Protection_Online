/*
 * This file is generated by jOOQ.
 */
package jooq.sys.tables;


import jooq.sys.Sys;
import jooq.sys.tables.records.X$memoryGlobalByCurrentBytesRecord;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;

import javax.annotation.Generated;
import java.math.BigDecimal;


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
public class X$memoryGlobalByCurrentBytes extends TableImpl<X$memoryGlobalByCurrentBytesRecord> {

    /**
     * The reference instance of <code>sys.x$memory_global_by_current_bytes</code>
     */
    public static final X$memoryGlobalByCurrentBytes X$MEMORY_GLOBAL_BY_CURRENT_BYTES = new X$memoryGlobalByCurrentBytes();
    private static final long serialVersionUID = -997543505;
    /**
     * The column <code>sys.x$memory_global_by_current_bytes.event_name</code>.
     */
    public final TableField<X$memoryGlobalByCurrentBytesRecord, String> EVENT_NAME = createField("event_name", org.jooq.impl.SQLDataType.VARCHAR(128).nullable(false), this, "");
    /**
     * The column <code>sys.x$memory_global_by_current_bytes.current_count</code>.
     */
    public final TableField<X$memoryGlobalByCurrentBytesRecord, Long> CURRENT_COUNT = createField("current_count", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");
    /**
     * The column <code>sys.x$memory_global_by_current_bytes.current_alloc</code>.
     */
    public final TableField<X$memoryGlobalByCurrentBytesRecord, Long> CURRENT_ALLOC = createField("current_alloc", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");
    /**
     * The column <code>sys.x$memory_global_by_current_bytes.current_avg_alloc</code>.
     */
    public final TableField<X$memoryGlobalByCurrentBytesRecord, BigDecimal> CURRENT_AVG_ALLOC = createField("current_avg_alloc", org.jooq.impl.SQLDataType.DECIMAL(23, 4).nullable(false).defaultValue(org.jooq.impl.DSL.inline("0.0000", org.jooq.impl.SQLDataType.DECIMAL)), this, "");
    /**
     * The column <code>sys.x$memory_global_by_current_bytes.high_count</code>.
     */
    public final TableField<X$memoryGlobalByCurrentBytesRecord, Long> HIGH_COUNT = createField("high_count", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");
    /**
     * The column <code>sys.x$memory_global_by_current_bytes.high_alloc</code>.
     */
    public final TableField<X$memoryGlobalByCurrentBytesRecord, Long> HIGH_ALLOC = createField("high_alloc", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");
    /**
     * The column <code>sys.x$memory_global_by_current_bytes.high_avg_alloc</code>.
     */
    public final TableField<X$memoryGlobalByCurrentBytesRecord, BigDecimal> HIGH_AVG_ALLOC = createField("high_avg_alloc", org.jooq.impl.SQLDataType.DECIMAL(23, 4).nullable(false).defaultValue(org.jooq.impl.DSL.inline("0.0000", org.jooq.impl.SQLDataType.DECIMAL)), this, "");

    /**
     * Create a <code>sys.x$memory_global_by_current_bytes</code> table reference
     */
    public X$memoryGlobalByCurrentBytes() {
        this(DSL.name("x$memory_global_by_current_bytes"), null);
    }

    /**
     * Create an aliased <code>sys.x$memory_global_by_current_bytes</code> table reference
     */
    public X$memoryGlobalByCurrentBytes(String alias) {
        this(DSL.name(alias), X$MEMORY_GLOBAL_BY_CURRENT_BYTES);
    }

    /**
     * Create an aliased <code>sys.x$memory_global_by_current_bytes</code> table reference
     */
    public X$memoryGlobalByCurrentBytes(Name alias) {
        this(alias, X$MEMORY_GLOBAL_BY_CURRENT_BYTES);
    }

    private X$memoryGlobalByCurrentBytes(Name alias, Table<X$memoryGlobalByCurrentBytesRecord> aliased) {
        this(alias, aliased, null);
    }

    private X$memoryGlobalByCurrentBytes(Name alias, Table<X$memoryGlobalByCurrentBytesRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("VIEW"));
    }

    public <O extends Record> X$memoryGlobalByCurrentBytes(Table<O> child, ForeignKey<O, X$memoryGlobalByCurrentBytesRecord> key) {
        super(child, key, X$MEMORY_GLOBAL_BY_CURRENT_BYTES);
    }

    /**
     * The class holding records for this type
     */
    @Override
    public Class<X$memoryGlobalByCurrentBytesRecord> getRecordType() {
        return X$memoryGlobalByCurrentBytesRecord.class;
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
    public X$memoryGlobalByCurrentBytes as(String alias) {
        return new X$memoryGlobalByCurrentBytes(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X$memoryGlobalByCurrentBytes as(Name alias) {
        return new X$memoryGlobalByCurrentBytes(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public X$memoryGlobalByCurrentBytes rename(String name) {
        return new X$memoryGlobalByCurrentBytes(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public X$memoryGlobalByCurrentBytes rename(Name name) {
        return new X$memoryGlobalByCurrentBytes(name, null);
    }
}
