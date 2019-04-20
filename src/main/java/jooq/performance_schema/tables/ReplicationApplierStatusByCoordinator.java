/*
 * This file is generated by jOOQ.
 */
package jooq.performance_schema.tables;


import jooq.performance_schema.PerformanceSchema;
import jooq.performance_schema.enums.ReplicationApplierStatusByCoordinatorServiceState;
import jooq.performance_schema.tables.records.ReplicationApplierStatusByCoordinatorRecord;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;
import org.jooq.types.ULong;

import javax.annotation.Generated;
import java.sql.Timestamp;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
            "jOOQ version:3.11.9"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ReplicationApplierStatusByCoordinator extends TableImpl<ReplicationApplierStatusByCoordinatorRecord> {

    private static final long serialVersionUID = 597244099;

    /**
     * The reference instance of <code>performance_schema.replication_applier_status_by_coordinator</code>
     */
    public static final ReplicationApplierStatusByCoordinator REPLICATION_APPLIER_STATUS_BY_COORDINATOR = new ReplicationApplierStatusByCoordinator();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ReplicationApplierStatusByCoordinatorRecord> getRecordType() {
        return ReplicationApplierStatusByCoordinatorRecord.class;
    }

    /**
     * The column <code>performance_schema.replication_applier_status_by_coordinator.CHANNEL_NAME</code>.
     */
    public final TableField<ReplicationApplierStatusByCoordinatorRecord, String> CHANNEL_NAME = createField("CHANNEL_NAME", org.jooq.impl.SQLDataType.CHAR(64).nullable(false), this, "");

    /**
     * The column <code>performance_schema.replication_applier_status_by_coordinator.THREAD_ID</code>.
     */
    public final TableField<ReplicationApplierStatusByCoordinatorRecord, ULong> THREAD_ID = createField("THREAD_ID", org.jooq.impl.SQLDataType.BIGINTUNSIGNED, this, "");

    /**
     * The column <code>performance_schema.replication_applier_status_by_coordinator.SERVICE_STATE</code>.
     */
    public final TableField<ReplicationApplierStatusByCoordinatorRecord, ReplicationApplierStatusByCoordinatorServiceState> SERVICE_STATE = createField("SERVICE_STATE", org.jooq.impl.SQLDataType.VARCHAR(3).nullable(false).asEnumDataType(jooq.performance_schema.enums.ReplicationApplierStatusByCoordinatorServiceState.class), this, "");

    /**
     * The column <code>performance_schema.replication_applier_status_by_coordinator.LAST_ERROR_NUMBER</code>.
     */
    public final TableField<ReplicationApplierStatusByCoordinatorRecord, Integer> LAST_ERROR_NUMBER = createField("LAST_ERROR_NUMBER", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>performance_schema.replication_applier_status_by_coordinator.LAST_ERROR_MESSAGE</code>.
     */
    public final TableField<ReplicationApplierStatusByCoordinatorRecord, String> LAST_ERROR_MESSAGE = createField("LAST_ERROR_MESSAGE", org.jooq.impl.SQLDataType.VARCHAR(1024).nullable(false), this, "");

    /**
     * The column <code>performance_schema.replication_applier_status_by_coordinator.LAST_ERROR_TIMESTAMP</code>.
     */
    public final TableField<ReplicationApplierStatusByCoordinatorRecord, Timestamp> LAST_ERROR_TIMESTAMP = createField("LAST_ERROR_TIMESTAMP", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaultValue(org.jooq.impl.DSL.field("CURRENT_TIMESTAMP", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "");

    /**
     * Create a <code>performance_schema.replication_applier_status_by_coordinator</code> table reference
     */
    public ReplicationApplierStatusByCoordinator() {
        this(DSL.name("replication_applier_status_by_coordinator"), null);
    }

    /**
     * Create an aliased <code>performance_schema.replication_applier_status_by_coordinator</code> table reference
     */
    public ReplicationApplierStatusByCoordinator(String alias) {
        this(DSL.name(alias), REPLICATION_APPLIER_STATUS_BY_COORDINATOR);
    }

    /**
     * Create an aliased <code>performance_schema.replication_applier_status_by_coordinator</code> table reference
     */
    public ReplicationApplierStatusByCoordinator(Name alias) {
        this(alias, REPLICATION_APPLIER_STATUS_BY_COORDINATOR);
    }

    private ReplicationApplierStatusByCoordinator(Name alias, Table<ReplicationApplierStatusByCoordinatorRecord> aliased) {
        this(alias, aliased, null);
    }

    private ReplicationApplierStatusByCoordinator(Name alias, Table<ReplicationApplierStatusByCoordinatorRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> ReplicationApplierStatusByCoordinator(Table<O> child, ForeignKey<O, ReplicationApplierStatusByCoordinatorRecord> key) {
        super(child, key, REPLICATION_APPLIER_STATUS_BY_COORDINATOR);
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
    public ReplicationApplierStatusByCoordinator as(String alias) {
        return new ReplicationApplierStatusByCoordinator(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ReplicationApplierStatusByCoordinator as(Name alias) {
        return new ReplicationApplierStatusByCoordinator(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public ReplicationApplierStatusByCoordinator rename(String name) {
        return new ReplicationApplierStatusByCoordinator(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public ReplicationApplierStatusByCoordinator rename(Name name) {
        return new ReplicationApplierStatusByCoordinator(name, null);
    }
}
