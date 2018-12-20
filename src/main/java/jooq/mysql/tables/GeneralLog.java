/*
 * This file is generated by jOOQ.
 */
package jooq.mysql.tables;


import jooq.mysql.Mysql;
import jooq.mysql.tables.records.GeneralLogRecord;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;
import org.jooq.types.UInteger;
import org.jooq.types.ULong;

import javax.annotation.Generated;
import java.sql.Timestamp;


/**
 * General log
 */
@Generated(
        value = {
                "http://www.jooq.org",
                "jOOQ version:3.11.2"
        },
        comments = "This class is generated by jOOQ"
)
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class GeneralLog extends TableImpl<GeneralLogRecord> {

    /**
     * The reference instance of <code>mysql.general_log</code>
     */
    public static final GeneralLog GENERAL_LOG = new GeneralLog();
    private static final long serialVersionUID = -1759855199;
    /**
     * The column <code>mysql.general_log.event_time</code>.
     */
    public final TableField<GeneralLogRecord, Timestamp> EVENT_TIME = createField("event_time", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaultValue(org.jooq.impl.DSL.field("CURRENT_TIMESTAMP(6)", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "");
    /**
     * The column <code>mysql.general_log.user_host</code>.
     */
    public final TableField<GeneralLogRecord, String> USER_HOST = createField("user_host", org.jooq.impl.SQLDataType.CLOB.nullable(false), this, "");
    /**
     * The column <code>mysql.general_log.thread_id</code>.
     */
    public final TableField<GeneralLogRecord, ULong> THREAD_ID = createField("thread_id", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");
    /**
     * The column <code>mysql.general_log.server_id</code>.
     */
    public final TableField<GeneralLogRecord, UInteger> SERVER_ID = createField("server_id", org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false), this, "");
    /**
     * The column <code>mysql.general_log.command_type</code>.
     */
    public final TableField<GeneralLogRecord, String> COMMAND_TYPE = createField("command_type", org.jooq.impl.SQLDataType.VARCHAR(64).nullable(false), this, "");
    /**
     * The column <code>mysql.general_log.argument</code>.
     */
    public final TableField<GeneralLogRecord, byte[]> ARGUMENT = createField("argument", org.jooq.impl.SQLDataType.BLOB.nullable(false), this, "");

    /**
     * Create a <code>mysql.general_log</code> table reference
     */
    public GeneralLog() {
        this(DSL.name("general_log"), null);
    }

    /**
     * Create an aliased <code>mysql.general_log</code> table reference
     */
    public GeneralLog(String alias) {
        this(DSL.name(alias), GENERAL_LOG);
    }

    /**
     * Create an aliased <code>mysql.general_log</code> table reference
     */
    public GeneralLog(Name alias) {
        this(alias, GENERAL_LOG);
    }

    private GeneralLog(Name alias, Table<GeneralLogRecord> aliased) {
        this(alias, aliased, null);
    }

    private GeneralLog(Name alias, Table<GeneralLogRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("General log"));
    }

    public <O extends Record> GeneralLog(Table<O> child, ForeignKey<O, GeneralLogRecord> key) {
        super(child, key, GENERAL_LOG);
    }

    /**
     * The class holding records for this type
     */
    @Override
    public Class<GeneralLogRecord> getRecordType() {
        return GeneralLogRecord.class;
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
    public GeneralLog as(String alias) {
        return new GeneralLog(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GeneralLog as(Name alias) {
        return new GeneralLog(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public GeneralLog rename(String name) {
        return new GeneralLog(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public GeneralLog rename(Name name) {
        return new GeneralLog(name, null);
    }
}
