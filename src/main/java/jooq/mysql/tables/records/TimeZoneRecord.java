/*
 * This file is generated by jOOQ.
 */
package jooq.mysql.tables.records;


import jooq.mysql.enums.TimeZoneUseLeapSeconds;
import jooq.mysql.tables.TimeZone;
import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.UpdatableRecordImpl;
import org.jooq.types.UInteger;

import javax.annotation.Generated;


/**
 * Time zones
 */
@Generated(
        value = {
                "http://www.jooq.org",
                "jOOQ version:3.11.2"
        },
        comments = "This class is generated by jOOQ"
)
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class TimeZoneRecord extends UpdatableRecordImpl<TimeZoneRecord> implements Record2<UInteger, TimeZoneUseLeapSeconds> {

    private static final long serialVersionUID = 732279435;

    /**
     * Create a detached TimeZoneRecord
     */
    public TimeZoneRecord() {
        super(TimeZone.TIME_ZONE);
    }

    /**
     * Create a detached, initialised TimeZoneRecord
     */
    public TimeZoneRecord(UInteger timeZoneId, TimeZoneUseLeapSeconds useLeapSeconds) {
        super(TimeZone.TIME_ZONE);

        set(0, timeZoneId);
        set(1, useLeapSeconds);
    }

    /**
     * Getter for <code>mysql.time_zone.Time_zone_id</code>.
     */
    public UInteger getTimeZoneId() {
        return (UInteger) get(0);
    }

    /**
     * Setter for <code>mysql.time_zone.Time_zone_id</code>.
     */
    public void setTimeZoneId(UInteger value) {
        set(0, value);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * Getter for <code>mysql.time_zone.Use_leap_seconds</code>.
     */
    public TimeZoneUseLeapSeconds getUseLeapSeconds() {
        return (TimeZoneUseLeapSeconds) get(1);
    }

    // -------------------------------------------------------------------------
    // Record2 type implementation
    // -------------------------------------------------------------------------

    /**
     * Setter for <code>mysql.time_zone.Use_leap_seconds</code>.
     */
    public void setUseLeapSeconds(TimeZoneUseLeapSeconds value) {
        set(1, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<UInteger> key() {
        return (Record1) super.key();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row2<UInteger, TimeZoneUseLeapSeconds> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row2<UInteger, TimeZoneUseLeapSeconds> valuesRow() {
        return (Row2) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<UInteger> field1() {
        return TimeZone.TIME_ZONE.TIME_ZONE_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<TimeZoneUseLeapSeconds> field2() {
        return TimeZone.TIME_ZONE.USE_LEAP_SECONDS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UInteger component1() {
        return getTimeZoneId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TimeZoneUseLeapSeconds component2() {
        return getUseLeapSeconds();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UInteger value1() {
        return getTimeZoneId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TimeZoneUseLeapSeconds value2() {
        return getUseLeapSeconds();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TimeZoneRecord value1(UInteger value) {
        setTimeZoneId(value);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public TimeZoneRecord value2(TimeZoneUseLeapSeconds value) {
        setUseLeapSeconds(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TimeZoneRecord values(UInteger value1, TimeZoneUseLeapSeconds value2) {
        value1(value1);
        value2(value2);
        return this;
    }
}
