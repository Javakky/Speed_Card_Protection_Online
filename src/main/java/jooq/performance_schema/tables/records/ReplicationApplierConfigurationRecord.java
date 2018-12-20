/*
 * This file is generated by jOOQ.
 */
package jooq.performance_schema.tables.records;


import jooq.performance_schema.tables.ReplicationApplierConfiguration;
import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.TableRecordImpl;

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
public class ReplicationApplierConfigurationRecord extends TableRecordImpl<ReplicationApplierConfigurationRecord> implements Record2<String, Integer> {

    private static final long serialVersionUID = -49081805;

    /**
     * Create a detached ReplicationApplierConfigurationRecord
     */
    public ReplicationApplierConfigurationRecord() {
        super(ReplicationApplierConfiguration.REPLICATION_APPLIER_CONFIGURATION);
    }

    /**
     * Create a detached, initialised ReplicationApplierConfigurationRecord
     */
    public ReplicationApplierConfigurationRecord(String channelName, Integer desiredDelay) {
        super(ReplicationApplierConfiguration.REPLICATION_APPLIER_CONFIGURATION);

        set(0, channelName);
        set(1, desiredDelay);
    }

    /**
     * Getter for <code>performance_schema.replication_applier_configuration.CHANNEL_NAME</code>.
     */
    public String getChannelName() {
        return (String) get(0);
    }

    /**
     * Setter for <code>performance_schema.replication_applier_configuration.CHANNEL_NAME</code>.
     */
    public void setChannelName(String value) {
        set(0, value);
    }

    // -------------------------------------------------------------------------
    // Record2 type implementation
    // -------------------------------------------------------------------------

    /**
     * Getter for <code>performance_schema.replication_applier_configuration.DESIRED_DELAY</code>.
     */
    public Integer getDesiredDelay() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>performance_schema.replication_applier_configuration.DESIRED_DELAY</code>.
     */
    public void setDesiredDelay(Integer value) {
        set(1, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row2<String, Integer> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row2<String, Integer> valuesRow() {
        return (Row2) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return ReplicationApplierConfiguration.REPLICATION_APPLIER_CONFIGURATION.CHANNEL_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field2() {
        return ReplicationApplierConfiguration.REPLICATION_APPLIER_CONFIGURATION.DESIRED_DELAY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component1() {
        return getChannelName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component2() {
        return getDesiredDelay();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value1() {
        return getChannelName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value2() {
        return getDesiredDelay();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ReplicationApplierConfigurationRecord value1(String value) {
        setChannelName(value);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public ReplicationApplierConfigurationRecord value2(Integer value) {
        setDesiredDelay(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ReplicationApplierConfigurationRecord values(String value1, Integer value2) {
        value1(value1);
        value2(value2);
        return this;
    }
}
