/*
 * This file is generated by jOOQ.
 */
package jooq.mysql.tables;


import jooq.mysql.Indexes;
import jooq.mysql.Keys;
import jooq.mysql.Mysql;
import jooq.mysql.tables.records.TimeZoneTransitionRecord;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;
import org.jooq.types.UInteger;

import javax.annotation.Generated;
import java.util.Arrays;
import java.util.List;


/**
 * Time zone transitions
 */
@Generated(
        value = {
                "http://www.jooq.org",
                "jOOQ version:3.11.2"
        },
        comments = "This class is generated by jOOQ"
)
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class TimeZoneTransition extends TableImpl<TimeZoneTransitionRecord> {

    /**
     * The reference instance of <code>mysql.time_zone_transition</code>
     */
    public static final TimeZoneTransition TIME_ZONE_TRANSITION = new TimeZoneTransition();
    private static final long serialVersionUID = 918483233;
    /**
     * The column <code>mysql.time_zone_transition.Time_zone_id</code>.
     */
    public final TableField<TimeZoneTransitionRecord, UInteger> TIME_ZONE_ID = createField("Time_zone_id", org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false), this, "");
    /**
     * The column <code>mysql.time_zone_transition.Transition_time</code>.
     */
    public final TableField<TimeZoneTransitionRecord, Long> TRANSITION_TIME = createField("Transition_time", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");
    /**
     * The column <code>mysql.time_zone_transition.Transition_type_id</code>.
     */
    public final TableField<TimeZoneTransitionRecord, UInteger> TRANSITION_TYPE_ID = createField("Transition_type_id", org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false), this, "");

    /**
     * Create a <code>mysql.time_zone_transition</code> table reference
     */
    public TimeZoneTransition() {
        this(DSL.name("time_zone_transition"), null);
    }

    /**
     * Create an aliased <code>mysql.time_zone_transition</code> table reference
     */
    public TimeZoneTransition(String alias) {
        this(DSL.name(alias), TIME_ZONE_TRANSITION);
    }

    /**
     * Create an aliased <code>mysql.time_zone_transition</code> table reference
     */
    public TimeZoneTransition(Name alias) {
        this(alias, TIME_ZONE_TRANSITION);
    }

    private TimeZoneTransition(Name alias, Table<TimeZoneTransitionRecord> aliased) {
        this(alias, aliased, null);
    }

    private TimeZoneTransition(Name alias, Table<TimeZoneTransitionRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("Time zone transitions"));
    }

    public <O extends Record> TimeZoneTransition(Table<O> child, ForeignKey<O, TimeZoneTransitionRecord> key) {
        super(child, key, TIME_ZONE_TRANSITION);
    }

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TimeZoneTransitionRecord> getRecordType() {
        return TimeZoneTransitionRecord.class;
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
        return Arrays.<Index>asList(Indexes.TIME_ZONE_TRANSITION_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<TimeZoneTransitionRecord> getPrimaryKey() {
        return Keys.KEY_TIME_ZONE_TRANSITION_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<TimeZoneTransitionRecord>> getKeys() {
        return Arrays.<UniqueKey<TimeZoneTransitionRecord>>asList(Keys.KEY_TIME_ZONE_TRANSITION_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TimeZoneTransition as(String alias) {
        return new TimeZoneTransition(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TimeZoneTransition as(Name alias) {
        return new TimeZoneTransition(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public TimeZoneTransition rename(String name) {
        return new TimeZoneTransition(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public TimeZoneTransition rename(Name name) {
        return new TimeZoneTransition(name, null);
    }
}
