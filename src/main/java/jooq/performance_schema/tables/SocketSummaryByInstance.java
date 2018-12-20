/*
 * This file is generated by jOOQ.
 */
package jooq.performance_schema.tables;


import jooq.performance_schema.PerformanceSchema;
import jooq.performance_schema.tables.records.SocketSummaryByInstanceRecord;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;
import org.jooq.types.ULong;

import javax.annotation.Generated;


/**
 * This class is generated by jOOQ.
 */
@Generated(
        value = {
                "http://www.jooq.org",
                "jOOQ version:3.11.2"
        },
        comments = "This class is generated by jOOQ"
)
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class SocketSummaryByInstance extends TableImpl<SocketSummaryByInstanceRecord> {

    /**
     * The reference instance of <code>performance_schema.socket_summary_by_instance</code>
     */
    public static final SocketSummaryByInstance SOCKET_SUMMARY_BY_INSTANCE = new SocketSummaryByInstance();
    private static final long serialVersionUID = 1016602632;
    /**
     * The column <code>performance_schema.socket_summary_by_instance.EVENT_NAME</code>.
     */
    public final TableField<SocketSummaryByInstanceRecord, String> EVENT_NAME = createField("EVENT_NAME", org.jooq.impl.SQLDataType.VARCHAR(128).nullable(false), this, "");
    /**
     * The column <code>performance_schema.socket_summary_by_instance.OBJECT_INSTANCE_BEGIN</code>.
     */
    public final TableField<SocketSummaryByInstanceRecord, ULong> OBJECT_INSTANCE_BEGIN = createField("OBJECT_INSTANCE_BEGIN", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");
    /**
     * The column <code>performance_schema.socket_summary_by_instance.COUNT_STAR</code>.
     */
    public final TableField<SocketSummaryByInstanceRecord, ULong> COUNT_STAR = createField("COUNT_STAR", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");
    /**
     * The column <code>performance_schema.socket_summary_by_instance.SUM_TIMER_WAIT</code>.
     */
    public final TableField<SocketSummaryByInstanceRecord, ULong> SUM_TIMER_WAIT = createField("SUM_TIMER_WAIT", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");
    /**
     * The column <code>performance_schema.socket_summary_by_instance.MIN_TIMER_WAIT</code>.
     */
    public final TableField<SocketSummaryByInstanceRecord, ULong> MIN_TIMER_WAIT = createField("MIN_TIMER_WAIT", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");
    /**
     * The column <code>performance_schema.socket_summary_by_instance.AVG_TIMER_WAIT</code>.
     */
    public final TableField<SocketSummaryByInstanceRecord, ULong> AVG_TIMER_WAIT = createField("AVG_TIMER_WAIT", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");
    /**
     * The column <code>performance_schema.socket_summary_by_instance.MAX_TIMER_WAIT</code>.
     */
    public final TableField<SocketSummaryByInstanceRecord, ULong> MAX_TIMER_WAIT = createField("MAX_TIMER_WAIT", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");
    /**
     * The column <code>performance_schema.socket_summary_by_instance.COUNT_READ</code>.
     */
    public final TableField<SocketSummaryByInstanceRecord, ULong> COUNT_READ = createField("COUNT_READ", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");
    /**
     * The column <code>performance_schema.socket_summary_by_instance.SUM_TIMER_READ</code>.
     */
    public final TableField<SocketSummaryByInstanceRecord, ULong> SUM_TIMER_READ = createField("SUM_TIMER_READ", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");
    /**
     * The column <code>performance_schema.socket_summary_by_instance.MIN_TIMER_READ</code>.
     */
    public final TableField<SocketSummaryByInstanceRecord, ULong> MIN_TIMER_READ = createField("MIN_TIMER_READ", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");
    /**
     * The column <code>performance_schema.socket_summary_by_instance.AVG_TIMER_READ</code>.
     */
    public final TableField<SocketSummaryByInstanceRecord, ULong> AVG_TIMER_READ = createField("AVG_TIMER_READ", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");
    /**
     * The column <code>performance_schema.socket_summary_by_instance.MAX_TIMER_READ</code>.
     */
    public final TableField<SocketSummaryByInstanceRecord, ULong> MAX_TIMER_READ = createField("MAX_TIMER_READ", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");
    /**
     * The column <code>performance_schema.socket_summary_by_instance.SUM_NUMBER_OF_BYTES_READ</code>.
     */
    public final TableField<SocketSummaryByInstanceRecord, ULong> SUM_NUMBER_OF_BYTES_READ = createField("SUM_NUMBER_OF_BYTES_READ", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");
    /**
     * The column <code>performance_schema.socket_summary_by_instance.COUNT_WRITE</code>.
     */
    public final TableField<SocketSummaryByInstanceRecord, ULong> COUNT_WRITE = createField("COUNT_WRITE", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");
    /**
     * The column <code>performance_schema.socket_summary_by_instance.SUM_TIMER_WRITE</code>.
     */
    public final TableField<SocketSummaryByInstanceRecord, ULong> SUM_TIMER_WRITE = createField("SUM_TIMER_WRITE", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");
    /**
     * The column <code>performance_schema.socket_summary_by_instance.MIN_TIMER_WRITE</code>.
     */
    public final TableField<SocketSummaryByInstanceRecord, ULong> MIN_TIMER_WRITE = createField("MIN_TIMER_WRITE", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");
    /**
     * The column <code>performance_schema.socket_summary_by_instance.AVG_TIMER_WRITE</code>.
     */
    public final TableField<SocketSummaryByInstanceRecord, ULong> AVG_TIMER_WRITE = createField("AVG_TIMER_WRITE", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");
    /**
     * The column <code>performance_schema.socket_summary_by_instance.MAX_TIMER_WRITE</code>.
     */
    public final TableField<SocketSummaryByInstanceRecord, ULong> MAX_TIMER_WRITE = createField("MAX_TIMER_WRITE", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");
    /**
     * The column <code>performance_schema.socket_summary_by_instance.SUM_NUMBER_OF_BYTES_WRITE</code>.
     */
    public final TableField<SocketSummaryByInstanceRecord, ULong> SUM_NUMBER_OF_BYTES_WRITE = createField("SUM_NUMBER_OF_BYTES_WRITE", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");
    /**
     * The column <code>performance_schema.socket_summary_by_instance.COUNT_MISC</code>.
     */
    public final TableField<SocketSummaryByInstanceRecord, ULong> COUNT_MISC = createField("COUNT_MISC", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");
    /**
     * The column <code>performance_schema.socket_summary_by_instance.SUM_TIMER_MISC</code>.
     */
    public final TableField<SocketSummaryByInstanceRecord, ULong> SUM_TIMER_MISC = createField("SUM_TIMER_MISC", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");
    /**
     * The column <code>performance_schema.socket_summary_by_instance.MIN_TIMER_MISC</code>.
     */
    public final TableField<SocketSummaryByInstanceRecord, ULong> MIN_TIMER_MISC = createField("MIN_TIMER_MISC", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");
    /**
     * The column <code>performance_schema.socket_summary_by_instance.AVG_TIMER_MISC</code>.
     */
    public final TableField<SocketSummaryByInstanceRecord, ULong> AVG_TIMER_MISC = createField("AVG_TIMER_MISC", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");
    /**
     * The column <code>performance_schema.socket_summary_by_instance.MAX_TIMER_MISC</code>.
     */
    public final TableField<SocketSummaryByInstanceRecord, ULong> MAX_TIMER_MISC = createField("MAX_TIMER_MISC", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");

    /**
     * Create a <code>performance_schema.socket_summary_by_instance</code> table reference
     */
    public SocketSummaryByInstance() {
        this(DSL.name("socket_summary_by_instance"), null);
    }

    /**
     * Create an aliased <code>performance_schema.socket_summary_by_instance</code> table reference
     */
    public SocketSummaryByInstance(String alias) {
        this(DSL.name(alias), SOCKET_SUMMARY_BY_INSTANCE);
    }

    /**
     * Create an aliased <code>performance_schema.socket_summary_by_instance</code> table reference
     */
    public SocketSummaryByInstance(Name alias) {
        this(alias, SOCKET_SUMMARY_BY_INSTANCE);
    }

    private SocketSummaryByInstance(Name alias, Table<SocketSummaryByInstanceRecord> aliased) {
        this(alias, aliased, null);
    }

    private SocketSummaryByInstance(Name alias, Table<SocketSummaryByInstanceRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> SocketSummaryByInstance(Table<O> child, ForeignKey<O, SocketSummaryByInstanceRecord> key) {
        super(child, key, SOCKET_SUMMARY_BY_INSTANCE);
    }

    /**
     * The class holding records for this type
     */
    @Override
    public Class<SocketSummaryByInstanceRecord> getRecordType() {
        return SocketSummaryByInstanceRecord.class;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return PerformanceSchema.PERFORMANCE_SCHEMA;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SocketSummaryByInstance as(String alias) {
        return new SocketSummaryByInstance(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SocketSummaryByInstance as(Name alias) {
        return new SocketSummaryByInstance(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public SocketSummaryByInstance rename(String name) {
        return new SocketSummaryByInstance(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public SocketSummaryByInstance rename(Name name) {
        return new SocketSummaryByInstance(name, null);
    }
}
