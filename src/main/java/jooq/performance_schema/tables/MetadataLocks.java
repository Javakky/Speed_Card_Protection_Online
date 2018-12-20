/*
 * This file is generated by jOOQ.
 */
package jooq.performance_schema.tables;


import jooq.performance_schema.PerformanceSchema;
import jooq.performance_schema.tables.records.MetadataLocksRecord;
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
public class MetadataLocks extends TableImpl<MetadataLocksRecord> {

    /**
     * The reference instance of <code>performance_schema.metadata_locks</code>
     */
    public static final MetadataLocks METADATA_LOCKS = new MetadataLocks();
    private static final long serialVersionUID = 1209767352;
    /**
     * The column <code>performance_schema.metadata_locks.OBJECT_TYPE</code>.
     */
    public final TableField<MetadataLocksRecord, String> OBJECT_TYPE = createField("OBJECT_TYPE", org.jooq.impl.SQLDataType.VARCHAR(64).nullable(false), this, "");
    /**
     * The column <code>performance_schema.metadata_locks.OBJECT_SCHEMA</code>.
     */
    public final TableField<MetadataLocksRecord, String> OBJECT_SCHEMA = createField("OBJECT_SCHEMA", org.jooq.impl.SQLDataType.VARCHAR(64), this, "");
    /**
     * The column <code>performance_schema.metadata_locks.OBJECT_NAME</code>.
     */
    public final TableField<MetadataLocksRecord, String> OBJECT_NAME = createField("OBJECT_NAME", org.jooq.impl.SQLDataType.VARCHAR(64), this, "");
    /**
     * The column <code>performance_schema.metadata_locks.OBJECT_INSTANCE_BEGIN</code>.
     */
    public final TableField<MetadataLocksRecord, ULong> OBJECT_INSTANCE_BEGIN = createField("OBJECT_INSTANCE_BEGIN", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");
    /**
     * The column <code>performance_schema.metadata_locks.LOCK_TYPE</code>.
     */
    public final TableField<MetadataLocksRecord, String> LOCK_TYPE = createField("LOCK_TYPE", org.jooq.impl.SQLDataType.VARCHAR(32).nullable(false), this, "");
    /**
     * The column <code>performance_schema.metadata_locks.LOCK_DURATION</code>.
     */
    public final TableField<MetadataLocksRecord, String> LOCK_DURATION = createField("LOCK_DURATION", org.jooq.impl.SQLDataType.VARCHAR(32).nullable(false), this, "");
    /**
     * The column <code>performance_schema.metadata_locks.LOCK_STATUS</code>.
     */
    public final TableField<MetadataLocksRecord, String> LOCK_STATUS = createField("LOCK_STATUS", org.jooq.impl.SQLDataType.VARCHAR(32).nullable(false), this, "");
    /**
     * The column <code>performance_schema.metadata_locks.SOURCE</code>.
     */
    public final TableField<MetadataLocksRecord, String> SOURCE = createField("SOURCE", org.jooq.impl.SQLDataType.VARCHAR(64), this, "");
    /**
     * The column <code>performance_schema.metadata_locks.OWNER_THREAD_ID</code>.
     */
    public final TableField<MetadataLocksRecord, ULong> OWNER_THREAD_ID = createField("OWNER_THREAD_ID", org.jooq.impl.SQLDataType.BIGINTUNSIGNED, this, "");
    /**
     * The column <code>performance_schema.metadata_locks.OWNER_EVENT_ID</code>.
     */
    public final TableField<MetadataLocksRecord, ULong> OWNER_EVENT_ID = createField("OWNER_EVENT_ID", org.jooq.impl.SQLDataType.BIGINTUNSIGNED, this, "");

    /**
     * Create a <code>performance_schema.metadata_locks</code> table reference
     */
    public MetadataLocks() {
        this(DSL.name("metadata_locks"), null);
    }

    /**
     * Create an aliased <code>performance_schema.metadata_locks</code> table reference
     */
    public MetadataLocks(String alias) {
        this(DSL.name(alias), METADATA_LOCKS);
    }

    /**
     * Create an aliased <code>performance_schema.metadata_locks</code> table reference
     */
    public MetadataLocks(Name alias) {
        this(alias, METADATA_LOCKS);
    }

    private MetadataLocks(Name alias, Table<MetadataLocksRecord> aliased) {
        this(alias, aliased, null);
    }

    private MetadataLocks(Name alias, Table<MetadataLocksRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> MetadataLocks(Table<O> child, ForeignKey<O, MetadataLocksRecord> key) {
        super(child, key, METADATA_LOCKS);
    }

    /**
     * The class holding records for this type
     */
    @Override
    public Class<MetadataLocksRecord> getRecordType() {
        return MetadataLocksRecord.class;
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
    public MetadataLocks as(String alias) {
        return new MetadataLocks(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MetadataLocks as(Name alias) {
        return new MetadataLocks(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public MetadataLocks rename(String name) {
        return new MetadataLocks(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public MetadataLocks rename(Name name) {
        return new MetadataLocks(name, null);
    }
}
