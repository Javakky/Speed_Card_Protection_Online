/*
 * This file is generated by jOOQ.
 */
package jooq.sys.tables;


import jooq.sys.Sys;
import jooq.sys.tables.records.X$memoryByUserByCurrentBytesRecord;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;

import javax.annotation.Generated;
import java.math.BigDecimal;
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
public class X$memoryByUserByCurrentBytes extends TableImpl<X$memoryByUserByCurrentBytesRecord> {

    private static final long serialVersionUID = 240517290;

    /**
     * The reference instance of <code>sys.x$memory_by_user_by_current_bytes</code>
     */
    public static final X$memoryByUserByCurrentBytes X$MEMORY_BY_USER_BY_CURRENT_BYTES = new X$memoryByUserByCurrentBytes();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<X$memoryByUserByCurrentBytesRecord> getRecordType() {
        return X$memoryByUserByCurrentBytesRecord.class;
    }

    /**
     * The column <code>sys.x$memory_by_user_by_current_bytes.user</code>.
     */
    public final TableField<X$memoryByUserByCurrentBytesRecord, String> USER = createField("user", org.jooq.impl.SQLDataType.VARCHAR(32), this, "");

    /**
     * The column <code>sys.x$memory_by_user_by_current_bytes.current_count_used</code>.
     */
    public final TableField<X$memoryByUserByCurrentBytesRecord, BigInteger> CURRENT_COUNT_USED = createField("current_count_used", org.jooq.impl.SQLDataType.DECIMAL_INTEGER.precision(41), this, "");

    /**
     * The column <code>sys.x$memory_by_user_by_current_bytes.current_allocated</code>.
     */
    public final TableField<X$memoryByUserByCurrentBytesRecord, BigInteger> CURRENT_ALLOCATED = createField("current_allocated", org.jooq.impl.SQLDataType.DECIMAL_INTEGER.precision(41), this, "");

    /**
     * The column <code>sys.x$memory_by_user_by_current_bytes.current_avg_alloc</code>.
     */
    public final TableField<X$memoryByUserByCurrentBytesRecord, BigDecimal> CURRENT_AVG_ALLOC = createField("current_avg_alloc", org.jooq.impl.SQLDataType.DECIMAL(45, 4).nullable(false).defaultValue(org.jooq.impl.DSL.inline("0.0000", org.jooq.impl.SQLDataType.DECIMAL)), this, "");

    /**
     * The column <code>sys.x$memory_by_user_by_current_bytes.current_max_alloc</code>.
     */
    public final TableField<X$memoryByUserByCurrentBytesRecord, Long> CURRENT_MAX_ALLOC = createField("current_max_alloc", org.jooq.impl.SQLDataType.BIGINT, this, "");

    /**
     * The column <code>sys.x$memory_by_user_by_current_bytes.total_allocated</code>.
     */
    public final TableField<X$memoryByUserByCurrentBytesRecord, BigInteger> TOTAL_ALLOCATED = createField("total_allocated", org.jooq.impl.SQLDataType.DECIMAL_INTEGER.precision(42), this, "");

    /**
     * Create a <code>sys.x$memory_by_user_by_current_bytes</code> table reference
     */
    public X$memoryByUserByCurrentBytes() {
        this(DSL.name("x$memory_by_user_by_current_bytes"), null);
    }

    /**
     * Create an aliased <code>sys.x$memory_by_user_by_current_bytes</code> table reference
     */
    public X$memoryByUserByCurrentBytes(String alias) {
        this(DSL.name(alias), X$MEMORY_BY_USER_BY_CURRENT_BYTES);
    }

    /**
     * Create an aliased <code>sys.x$memory_by_user_by_current_bytes</code> table reference
     */
    public X$memoryByUserByCurrentBytes(Name alias) {
        this(alias, X$MEMORY_BY_USER_BY_CURRENT_BYTES);
    }

    private X$memoryByUserByCurrentBytes(Name alias, Table<X$memoryByUserByCurrentBytesRecord> aliased) {
        this(alias, aliased, null);
    }

    private X$memoryByUserByCurrentBytes(Name alias, Table<X$memoryByUserByCurrentBytesRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("VIEW"));
    }

    public <O extends Record> X$memoryByUserByCurrentBytes(Table<O> child, ForeignKey<O, X$memoryByUserByCurrentBytesRecord> key) {
        super(child, key, X$MEMORY_BY_USER_BY_CURRENT_BYTES);
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
    public X$memoryByUserByCurrentBytes as(String alias) {
        return new X$memoryByUserByCurrentBytes(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X$memoryByUserByCurrentBytes as(Name alias) {
        return new X$memoryByUserByCurrentBytes(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public X$memoryByUserByCurrentBytes rename(String name) {
        return new X$memoryByUserByCurrentBytes(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public X$memoryByUserByCurrentBytes rename(Name name) {
        return new X$memoryByUserByCurrentBytes(name, null);
    }
}
