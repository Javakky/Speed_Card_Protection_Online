/*
 * This file is generated by jOOQ.
 */
package jooq.performance_schema.tables;


import jooq.performance_schema.PerformanceSchema;
import jooq.performance_schema.enums.SetupConsumersEnabled;
import jooq.performance_schema.tables.records.SetupConsumersRecord;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;

import javax.annotation.Generated;


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
public class SetupConsumers extends TableImpl<SetupConsumersRecord> {

    private static final long serialVersionUID = -227075152;

    /**
     * The reference instance of <code>performance_schema.setup_consumers</code>
     */
    public static final SetupConsumers SETUP_CONSUMERS = new SetupConsumers();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<SetupConsumersRecord> getRecordType() {
        return SetupConsumersRecord.class;
    }

    /**
     * The column <code>performance_schema.setup_consumers.NAME</code>.
     */
    public final TableField<SetupConsumersRecord, String> NAME = createField("NAME", org.jooq.impl.SQLDataType.VARCHAR(64).nullable(false), this, "");

    /**
     * The column <code>performance_schema.setup_consumers.ENABLED</code>.
     */
    public final TableField<SetupConsumersRecord, SetupConsumersEnabled> ENABLED = createField("ENABLED", org.jooq.impl.SQLDataType.VARCHAR(3).nullable(false).asEnumDataType(jooq.performance_schema.enums.SetupConsumersEnabled.class), this, "");

    /**
     * Create a <code>performance_schema.setup_consumers</code> table reference
     */
    public SetupConsumers() {
        this(DSL.name("setup_consumers"), null);
    }

    /**
     * Create an aliased <code>performance_schema.setup_consumers</code> table reference
     */
    public SetupConsumers(String alias) {
        this(DSL.name(alias), SETUP_CONSUMERS);
    }

    /**
     * Create an aliased <code>performance_schema.setup_consumers</code> table reference
     */
    public SetupConsumers(Name alias) {
        this(alias, SETUP_CONSUMERS);
    }

    private SetupConsumers(Name alias, Table<SetupConsumersRecord> aliased) {
        this(alias, aliased, null);
    }

    private SetupConsumers(Name alias, Table<SetupConsumersRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> SetupConsumers(Table<O> child, ForeignKey<O, SetupConsumersRecord> key) {
        super(child, key, SETUP_CONSUMERS);
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
    public SetupConsumers as(String alias) {
        return new SetupConsumers(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SetupConsumers as(Name alias) {
        return new SetupConsumers(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public SetupConsumers rename(String name) {
        return new SetupConsumers(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public SetupConsumers rename(Name name) {
        return new SetupConsumers(name, null);
    }
}
