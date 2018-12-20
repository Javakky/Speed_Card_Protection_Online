/*
 * This file is generated by jOOQ.
 */
package jooq.mysql.tables;


import jooq.mysql.Mysql;
import jooq.mysql.tables.records.SlowLogRecord;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;
import org.jooq.types.UInteger;
import org.jooq.types.ULong;

import javax.annotation.Generated;
import java.sql.Time;
import java.sql.Timestamp;


/**
 * Slow log
 */
@Generated(
        value = {
                "http://www.jooq.org",
                "jOOQ version:3.11.2"
        },
        comments = "This class is generated by jOOQ"
)
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class SlowLog extends TableImpl<SlowLogRecord> {

    /**
     * The reference instance of <code>mysql.slow_log</code>
     */
    public static final SlowLog SLOW_LOG = new SlowLog();
    private static final long serialVersionUID = -579776947;
    /**
     * The column <code>mysql.slow_log.start_time</code>.
     */
    public final TableField<SlowLogRecord, Timestamp> START_TIME = createField("start_time", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaultValue(org.jooq.impl.DSL.field("CURRENT_TIMESTAMP(6)", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "");
    /**
     * The column <code>mysql.slow_log.user_host</code>.
     */
    public final TableField<SlowLogRecord, String> USER_HOST = createField("user_host", org.jooq.impl.SQLDataType.CLOB.nullable(false), this, "");
    /**
     * The column <code>mysql.slow_log.query_time</code>.
     */
    public final TableField<SlowLogRecord, Time> QUERY_TIME = createField("query_time", org.jooq.impl.SQLDataType.TIME.nullable(false), this, "");
    /**
     * The column <code>mysql.slow_log.lock_time</code>.
     */
    public final TableField<SlowLogRecord, Time> LOCK_TIME = createField("lock_time", org.jooq.impl.SQLDataType.TIME.nullable(false), this, "");
    /**
     * The column <code>mysql.slow_log.rows_sent</code>.
     */
    public final TableField<SlowLogRecord, Integer> ROWS_SENT = createField("rows_sent", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");
    /**
     * The column <code>mysql.slow_log.rows_examined</code>.
     */
    public final TableField<SlowLogRecord, Integer> ROWS_EXAMINED = createField("rows_examined", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");
    /**
     * The column <code>mysql.slow_log.db</code>.
     */
    public final TableField<SlowLogRecord, String> DB = createField("db", org.jooq.impl.SQLDataType.VARCHAR(512).nullable(false), this, "");
    /**
     * The column <code>mysql.slow_log.last_insert_id</code>.
     */
    public final TableField<SlowLogRecord, Integer> LAST_INSERT_ID = createField("last_insert_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");
    /**
     * The column <code>mysql.slow_log.insert_id</code>.
     */
    public final TableField<SlowLogRecord, Integer> INSERT_ID = createField("insert_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");
    /**
     * The column <code>mysql.slow_log.server_id</code>.
     */
    public final TableField<SlowLogRecord, UInteger> SERVER_ID = createField("server_id", org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false), this, "");
    /**
     * The column <code>mysql.slow_log.sql_text</code>.
     */
    public final TableField<SlowLogRecord, byte[]> SQL_TEXT = createField("sql_text", org.jooq.impl.SQLDataType.BLOB.nullable(false), this, "");
    /**
     * The column <code>mysql.slow_log.thread_id</code>.
     */
    public final TableField<SlowLogRecord, ULong> THREAD_ID = createField("thread_id", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");

    /**
     * Create a <code>mysql.slow_log</code> table reference
     */
    public SlowLog() {
        this(DSL.name("slow_log"), null);
    }

    /**
     * Create an aliased <code>mysql.slow_log</code> table reference
     */
    public SlowLog(String alias) {
        this(DSL.name(alias), SLOW_LOG);
    }

    /**
     * Create an aliased <code>mysql.slow_log</code> table reference
     */
    public SlowLog(Name alias) {
        this(alias, SLOW_LOG);
    }

    private SlowLog(Name alias, Table<SlowLogRecord> aliased) {
        this(alias, aliased, null);
    }

    private SlowLog(Name alias, Table<SlowLogRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("Slow log"));
    }

    public <O extends Record> SlowLog(Table<O> child, ForeignKey<O, SlowLogRecord> key) {
        super(child, key, SLOW_LOG);
    }

    /**
     * The class holding records for this type
     */
    @Override
    public Class<SlowLogRecord> getRecordType() {
        return SlowLogRecord.class;
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
    public SlowLog as(String alias) {
        return new SlowLog(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SlowLog as(Name alias) {
        return new SlowLog(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public SlowLog rename(String name) {
        return new SlowLog(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public SlowLog rename(Name name) {
        return new SlowLog(name, null);
    }
}
