/*
 * This file is generated by jOOQ.
 */
package jooq.sys.tables;


import jooq.sys.Sys;
import jooq.sys.tables.records.X$psSchemaTableStatisticsIoRecord;
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
public class X$psSchemaTableStatisticsIo extends TableImpl<X$psSchemaTableStatisticsIoRecord> {

    /**
     * The reference instance of <code>sys.x$ps_schema_table_statistics_io</code>
     */
    public static final X$psSchemaTableStatisticsIo X$PS_SCHEMA_TABLE_STATISTICS_IO = new X$psSchemaTableStatisticsIo();
    private static final long serialVersionUID = 431703110;
    /**
     * The column <code>sys.x$ps_schema_table_statistics_io.table_schema</code>.
     */
    public final TableField<X$psSchemaTableStatisticsIoRecord, String> TABLE_SCHEMA = createField("table_schema", org.jooq.impl.SQLDataType.VARCHAR(64), this, "");
    /**
     * The column <code>sys.x$ps_schema_table_statistics_io.table_name</code>.
     */
    public final TableField<X$psSchemaTableStatisticsIoRecord, String> TABLE_NAME = createField("table_name", org.jooq.impl.SQLDataType.VARCHAR(64), this, "");
    /**
     * The column <code>sys.x$ps_schema_table_statistics_io.count_read</code>.
     */
    public final TableField<X$psSchemaTableStatisticsIoRecord, BigInteger> COUNT_READ = createField("count_read", org.jooq.impl.SQLDataType.DECIMAL_INTEGER.precision(42), this, "");
    /**
     * The column <code>sys.x$ps_schema_table_statistics_io.sum_number_of_bytes_read</code>.
     */
    public final TableField<X$psSchemaTableStatisticsIoRecord, BigInteger> SUM_NUMBER_OF_BYTES_READ = createField("sum_number_of_bytes_read", org.jooq.impl.SQLDataType.DECIMAL_INTEGER.precision(41), this, "");
    /**
     * The column <code>sys.x$ps_schema_table_statistics_io.sum_timer_read</code>.
     */
    public final TableField<X$psSchemaTableStatisticsIoRecord, BigInteger> SUM_TIMER_READ = createField("sum_timer_read", org.jooq.impl.SQLDataType.DECIMAL_INTEGER.precision(42), this, "");
    /**
     * The column <code>sys.x$ps_schema_table_statistics_io.count_write</code>.
     */
    public final TableField<X$psSchemaTableStatisticsIoRecord, BigInteger> COUNT_WRITE = createField("count_write", org.jooq.impl.SQLDataType.DECIMAL_INTEGER.precision(42), this, "");
    /**
     * The column <code>sys.x$ps_schema_table_statistics_io.sum_number_of_bytes_write</code>.
     */
    public final TableField<X$psSchemaTableStatisticsIoRecord, BigInteger> SUM_NUMBER_OF_BYTES_WRITE = createField("sum_number_of_bytes_write", org.jooq.impl.SQLDataType.DECIMAL_INTEGER.precision(41), this, "");
    /**
     * The column <code>sys.x$ps_schema_table_statistics_io.sum_timer_write</code>.
     */
    public final TableField<X$psSchemaTableStatisticsIoRecord, BigInteger> SUM_TIMER_WRITE = createField("sum_timer_write", org.jooq.impl.SQLDataType.DECIMAL_INTEGER.precision(42), this, "");
    /**
     * The column <code>sys.x$ps_schema_table_statistics_io.count_misc</code>.
     */
    public final TableField<X$psSchemaTableStatisticsIoRecord, BigInteger> COUNT_MISC = createField("count_misc", org.jooq.impl.SQLDataType.DECIMAL_INTEGER.precision(42), this, "");
    /**
     * The column <code>sys.x$ps_schema_table_statistics_io.sum_timer_misc</code>.
     */
    public final TableField<X$psSchemaTableStatisticsIoRecord, BigInteger> SUM_TIMER_MISC = createField("sum_timer_misc", org.jooq.impl.SQLDataType.DECIMAL_INTEGER.precision(42), this, "");

    /**
     * Create a <code>sys.x$ps_schema_table_statistics_io</code> table reference
     */
    public X$psSchemaTableStatisticsIo() {
        this(DSL.name("x$ps_schema_table_statistics_io"), null);
    }

    /**
     * Create an aliased <code>sys.x$ps_schema_table_statistics_io</code> table reference
     */
    public X$psSchemaTableStatisticsIo(String alias) {
        this(DSL.name(alias), X$PS_SCHEMA_TABLE_STATISTICS_IO);
    }

    /**
     * Create an aliased <code>sys.x$ps_schema_table_statistics_io</code> table reference
     */
    public X$psSchemaTableStatisticsIo(Name alias) {
        this(alias, X$PS_SCHEMA_TABLE_STATISTICS_IO);
    }

    private X$psSchemaTableStatisticsIo(Name alias, Table<X$psSchemaTableStatisticsIoRecord> aliased) {
        this(alias, aliased, null);
    }

    private X$psSchemaTableStatisticsIo(Name alias, Table<X$psSchemaTableStatisticsIoRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("VIEW"));
    }

    public <O extends Record> X$psSchemaTableStatisticsIo(Table<O> child, ForeignKey<O, X$psSchemaTableStatisticsIoRecord> key) {
        super(child, key, X$PS_SCHEMA_TABLE_STATISTICS_IO);
    }

    /**
     * The class holding records for this type
     */
    @Override
    public Class<X$psSchemaTableStatisticsIoRecord> getRecordType() {
        return X$psSchemaTableStatisticsIoRecord.class;
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
    public X$psSchemaTableStatisticsIo as(String alias) {
        return new X$psSchemaTableStatisticsIo(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X$psSchemaTableStatisticsIo as(Name alias) {
        return new X$psSchemaTableStatisticsIo(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public X$psSchemaTableStatisticsIo rename(String name) {
        return new X$psSchemaTableStatisticsIo(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public X$psSchemaTableStatisticsIo rename(Name name) {
        return new X$psSchemaTableStatisticsIo(name, null);
    }
}
