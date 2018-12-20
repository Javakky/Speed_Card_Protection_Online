/*
 * This file is generated by jOOQ.
 */
package jooq.sys.tables;


import javax.annotation.Generated;

import jooq.sys.Sys;
import jooq.sys.tables.records.HostSummaryByFileIoTypeRecord;

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
public class HostSummaryByFileIoType extends TableImpl<HostSummaryByFileIoTypeRecord> {

    private static final long serialVersionUID = -894081587;

    /**
     * The reference instance of <code>sys.host_summary_by_file_io_type</code>
     */
    public static final HostSummaryByFileIoType HOST_SUMMARY_BY_FILE_IO_TYPE = new HostSummaryByFileIoType();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<HostSummaryByFileIoTypeRecord> getRecordType() {
        return HostSummaryByFileIoTypeRecord.class;
    }

    /**
     * The column <code>sys.host_summary_by_file_io_type.host</code>.
     */
    public final TableField<HostSummaryByFileIoTypeRecord, String> HOST = createField("host", org.jooq.impl.SQLDataType.VARCHAR(60), this, "");

    /**
     * The column <code>sys.host_summary_by_file_io_type.event_name</code>.
     */
    public final TableField<HostSummaryByFileIoTypeRecord, String> EVENT_NAME = createField("event_name", org.jooq.impl.SQLDataType.VARCHAR(128).nullable(false), this, "");

    /**
     * The column <code>sys.host_summary_by_file_io_type.total</code>.
     */
    public final TableField<HostSummaryByFileIoTypeRecord, ULong> TOTAL = createField("total", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>sys.host_summary_by_file_io_type.total_latency</code>.
     */
    public final TableField<HostSummaryByFileIoTypeRecord, String> TOTAL_LATENCY = createField("total_latency", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>sys.host_summary_by_file_io_type.max_latency</code>.
     */
    public final TableField<HostSummaryByFileIoTypeRecord, String> MAX_LATENCY = createField("max_latency", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * Create a <code>sys.host_summary_by_file_io_type</code> table reference
     */
    public HostSummaryByFileIoType() {
        this(DSL.name("host_summary_by_file_io_type"), null);
    }

    /**
     * Create an aliased <code>sys.host_summary_by_file_io_type</code> table reference
     */
    public HostSummaryByFileIoType(String alias) {
        this(DSL.name(alias), HOST_SUMMARY_BY_FILE_IO_TYPE);
    }

    /**
     * Create an aliased <code>sys.host_summary_by_file_io_type</code> table reference
     */
    public HostSummaryByFileIoType(Name alias) {
        this(alias, HOST_SUMMARY_BY_FILE_IO_TYPE);
    }

    private HostSummaryByFileIoType(Name alias, Table<HostSummaryByFileIoTypeRecord> aliased) {
        this(alias, aliased, null);
    }

    private HostSummaryByFileIoType(Name alias, Table<HostSummaryByFileIoTypeRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("VIEW"));
    }

    public <O extends Record> HostSummaryByFileIoType(Table<O> child, ForeignKey<O, HostSummaryByFileIoTypeRecord> key) {
        super(child, key, HOST_SUMMARY_BY_FILE_IO_TYPE);
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
    public HostSummaryByFileIoType as(String alias) {
        return new HostSummaryByFileIoType(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HostSummaryByFileIoType as(Name alias) {
        return new HostSummaryByFileIoType(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public HostSummaryByFileIoType rename(String name) {
        return new HostSummaryByFileIoType(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public HostSummaryByFileIoType rename(Name name) {
        return new HostSummaryByFileIoType(name, null);
    }
}
