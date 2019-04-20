/*
 * This file is generated by jOOQ.
 */
package jooq.mysql.tables;


import jooq.mysql.Indexes;
import jooq.mysql.Keys;
import jooq.mysql.Mysql;
import jooq.mysql.enums.TimeZoneUseLeapSeconds;
import jooq.mysql.tables.records.TimeZoneRecord;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;
import org.jooq.types.UInteger;

import javax.annotation.Generated;
import java.util.Arrays;
import java.util.List;


/**
 * Time zones
 */
@Generated(
    value = {
        "http://www.jooq.org",
            "jOOQ version:3.11.9"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TimeZone extends TableImpl<TimeZoneRecord> {

    private static final long serialVersionUID = -327783905;

    /**
     * The reference instance of <code>mysql.time_zone</code>
     */
    public static final TimeZone TIME_ZONE = new TimeZone();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TimeZoneRecord> getRecordType() {
        return TimeZoneRecord.class;
    }

    /**
     * The column <code>mysql.time_zone.Time_zone_id</code>.
     */
    public final TableField<TimeZoneRecord, UInteger> TIME_ZONE_ID = createField("Time_zone_id", org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false).identity(true), this, "");

    /**
     * The column <code>mysql.time_zone.Use_leap_seconds</code>.
     */
    public final TableField<TimeZoneRecord, TimeZoneUseLeapSeconds> USE_LEAP_SECONDS = createField("Use_leap_seconds", org.jooq.impl.SQLDataType.VARCHAR(1).nullable(false).defaultValue(org.jooq.impl.DSL.inline("N", org.jooq.impl.SQLDataType.VARCHAR)).asEnumDataType(jooq.mysql.enums.TimeZoneUseLeapSeconds.class), this, "");

    /**
     * Create a <code>mysql.time_zone</code> table reference
     */
    public TimeZone() {
        this(DSL.name("time_zone"), null);
    }

    /**
     * Create an aliased <code>mysql.time_zone</code> table reference
     */
    public TimeZone(String alias) {
        this(DSL.name(alias), TIME_ZONE);
    }

    /**
     * Create an aliased <code>mysql.time_zone</code> table reference
     */
    public TimeZone(Name alias) {
        this(alias, TIME_ZONE);
    }

    private TimeZone(Name alias, Table<TimeZoneRecord> aliased) {
        this(alias, aliased, null);
    }

    private TimeZone(Name alias, Table<TimeZoneRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("Time zones"));
    }

    public <O extends Record> TimeZone(Table<O> child, ForeignKey<O, TimeZoneRecord> key) {
        super(child, key, TIME_ZONE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Mysql.MYSQL;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.TIME_ZONE_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<TimeZoneRecord, UInteger> getIdentity() {
        return Keys.IDENTITY_TIME_ZONE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<TimeZoneRecord> getPrimaryKey() {
        return Keys.KEY_TIME_ZONE_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<TimeZoneRecord>> getKeys() {
        return Arrays.<UniqueKey<TimeZoneRecord>>asList(Keys.KEY_TIME_ZONE_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TimeZone as(String alias) {
        return new TimeZone(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TimeZone as(Name alias) {
        return new TimeZone(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public TimeZone rename(String name) {
        return new TimeZone(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public TimeZone rename(Name name) {
        return new TimeZone(name, null);
    }
}
