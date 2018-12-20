/*
 * This file is generated by jOOQ.
 */
package jooq.sys.tables;


import jooq.sys.Sys;
import jooq.sys.tables.records.X$ioGlobalByFileByBytesRecord;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;
import org.jooq.types.ULong;

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
public class X$ioGlobalByFileByBytes extends TableImpl<X$ioGlobalByFileByBytesRecord> {

    /**
     * The reference instance of <code>sys.x$io_global_by_file_by_bytes</code>
     */
    public static final X$ioGlobalByFileByBytes X$IO_GLOBAL_BY_FILE_BY_BYTES = new X$ioGlobalByFileByBytes();
    private static final long serialVersionUID = -1251709795;
    /**
     * The column <code>sys.x$io_global_by_file_by_bytes.file</code>.
     */
    public final TableField<X$ioGlobalByFileByBytesRecord, String> FILE = createField("file", org.jooq.impl.SQLDataType.VARCHAR(512).nullable(false), this, "");
    /**
     * The column <code>sys.x$io_global_by_file_by_bytes.count_read</code>.
     */
    public final TableField<X$ioGlobalByFileByBytesRecord, ULong> COUNT_READ = createField("count_read", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");
    /**
     * The column <code>sys.x$io_global_by_file_by_bytes.total_read</code>.
     */
    public final TableField<X$ioGlobalByFileByBytesRecord, Long> TOTAL_READ = createField("total_read", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");
    /**
     * The column <code>sys.x$io_global_by_file_by_bytes.avg_read</code>.
     */
    public final TableField<X$ioGlobalByFileByBytesRecord, BigDecimal> AVG_READ = createField("avg_read", org.jooq.impl.SQLDataType.DECIMAL(23, 4).nullable(false).defaultValue(org.jooq.impl.DSL.inline("0.0000", org.jooq.impl.SQLDataType.DECIMAL)), this, "");
    /**
     * The column <code>sys.x$io_global_by_file_by_bytes.count_write</code>.
     */
    public final TableField<X$ioGlobalByFileByBytesRecord, ULong> COUNT_WRITE = createField("count_write", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");
    /**
     * The column <code>sys.x$io_global_by_file_by_bytes.total_written</code>.
     */
    public final TableField<X$ioGlobalByFileByBytesRecord, Long> TOTAL_WRITTEN = createField("total_written", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");
    /**
     * The column <code>sys.x$io_global_by_file_by_bytes.avg_write</code>.
     */
    public final TableField<X$ioGlobalByFileByBytesRecord, BigDecimal> AVG_WRITE = createField("avg_write", org.jooq.impl.SQLDataType.DECIMAL(23, 4).nullable(false).defaultValue(org.jooq.impl.DSL.inline("0.0000", org.jooq.impl.SQLDataType.DECIMAL)), this, "");
    /**
     * The column <code>sys.x$io_global_by_file_by_bytes.total</code>.
     */
    public final TableField<X$ioGlobalByFileByBytesRecord, Long> TOTAL = createField("total", org.jooq.impl.SQLDataType.BIGINT.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.BIGINT)), this, "");
    /**
     * The column <code>sys.x$io_global_by_file_by_bytes.write_pct</code>.
     */
    public final TableField<X$ioGlobalByFileByBytesRecord, BigDecimal> WRITE_PCT = createField("write_pct", org.jooq.impl.SQLDataType.DECIMAL(26, 2).nullable(false).defaultValue(org.jooq.impl.DSL.inline("0.00", org.jooq.impl.SQLDataType.DECIMAL)), this, "");

    /**
     * Create a <code>sys.x$io_global_by_file_by_bytes</code> table reference
     */
    public X$ioGlobalByFileByBytes() {
        this(DSL.name("x$io_global_by_file_by_bytes"), null);
    }

    /**
     * Create an aliased <code>sys.x$io_global_by_file_by_bytes</code> table reference
     */
    public X$ioGlobalByFileByBytes(String alias) {
        this(DSL.name(alias), X$IO_GLOBAL_BY_FILE_BY_BYTES);
    }

    /**
     * Create an aliased <code>sys.x$io_global_by_file_by_bytes</code> table reference
     */
    public X$ioGlobalByFileByBytes(Name alias) {
        this(alias, X$IO_GLOBAL_BY_FILE_BY_BYTES);
    }

    private X$ioGlobalByFileByBytes(Name alias, Table<X$ioGlobalByFileByBytesRecord> aliased) {
        this(alias, aliased, null);
    }

    private X$ioGlobalByFileByBytes(Name alias, Table<X$ioGlobalByFileByBytesRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("VIEW"));
    }

    public <O extends Record> X$ioGlobalByFileByBytes(Table<O> child, ForeignKey<O, X$ioGlobalByFileByBytesRecord> key) {
        super(child, key, X$IO_GLOBAL_BY_FILE_BY_BYTES);
    }

    /**
     * The class holding records for this type
     */
    @Override
    public Class<X$ioGlobalByFileByBytesRecord> getRecordType() {
        return X$ioGlobalByFileByBytesRecord.class;
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
    public X$ioGlobalByFileByBytes as(String alias) {
        return new X$ioGlobalByFileByBytes(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X$ioGlobalByFileByBytes as(Name alias) {
        return new X$ioGlobalByFileByBytes(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public X$ioGlobalByFileByBytes rename(String name) {
        return new X$ioGlobalByFileByBytes(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public X$ioGlobalByFileByBytes rename(Name name) {
        return new X$ioGlobalByFileByBytes(name, null);
    }
}
