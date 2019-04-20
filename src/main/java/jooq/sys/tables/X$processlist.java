/*
 * This file is generated by jOOQ.
 */
package jooq.sys.tables;


import jooq.sys.Sys;
import jooq.sys.enums.X$processlistTrxAutocommit;
import jooq.sys.enums.X$processlistTrxState;
import jooq.sys.tables.records.X$processlistRecord;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;
import org.jooq.types.ULong;

import javax.annotation.Generated;
import java.math.BigDecimal;
import java.math.BigInteger;


/**
 * VIEW
 */
@Generated(
    value = {
        "http://www.jooq.org",
            "jOOQ version:3.11.9"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class X$processlist extends TableImpl<X$processlistRecord> {

    private static final long serialVersionUID = -245066363;

    /**
     * The reference instance of <code>sys.x$processlist</code>
     */
    public static final X$processlist X$PROCESSLIST = new X$processlist();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<X$processlistRecord> getRecordType() {
        return X$processlistRecord.class;
    }

    /**
     * The column <code>sys.x$processlist.thd_id</code>.
     */
    public final TableField<X$processlistRecord, ULong> THD_ID = createField("thd_id", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>sys.x$processlist.conn_id</code>.
     */
    public final TableField<X$processlistRecord, ULong> CONN_ID = createField("conn_id", org.jooq.impl.SQLDataType.BIGINTUNSIGNED, this, "");

    /**
     * The column <code>sys.x$processlist.user</code>.
     */
    public final TableField<X$processlistRecord, String> USER = createField("user", org.jooq.impl.SQLDataType.VARCHAR(128), this, "");

    /**
     * The column <code>sys.x$processlist.db</code>.
     */
    public final TableField<X$processlistRecord, String> DB = createField("db", org.jooq.impl.SQLDataType.VARCHAR(64), this, "");

    /**
     * The column <code>sys.x$processlist.command</code>.
     */
    public final TableField<X$processlistRecord, String> COMMAND = createField("command", org.jooq.impl.SQLDataType.VARCHAR(16), this, "");

    /**
     * The column <code>sys.x$processlist.state</code>.
     */
    public final TableField<X$processlistRecord, String> STATE = createField("state", org.jooq.impl.SQLDataType.VARCHAR(64), this, "");

    /**
     * The column <code>sys.x$processlist.time</code>.
     */
    public final TableField<X$processlistRecord, Long> TIME = createField("time", org.jooq.impl.SQLDataType.BIGINT, this, "");

    /**
     * The column <code>sys.x$processlist.current_statement</code>.
     */
    public final TableField<X$processlistRecord, String> CURRENT_STATEMENT = createField("current_statement", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>sys.x$processlist.statement_latency</code>.
     */
    public final TableField<X$processlistRecord, ULong> STATEMENT_LATENCY = createField("statement_latency", org.jooq.impl.SQLDataType.BIGINTUNSIGNED, this, "");

    /**
     * The column <code>sys.x$processlist.progress</code>.
     */
    public final TableField<X$processlistRecord, BigDecimal> PROGRESS = createField("progress", org.jooq.impl.SQLDataType.DECIMAL(26, 2), this, "");

    /**
     * The column <code>sys.x$processlist.lock_latency</code>.
     */
    public final TableField<X$processlistRecord, ULong> LOCK_LATENCY = createField("lock_latency", org.jooq.impl.SQLDataType.BIGINTUNSIGNED, this, "");

    /**
     * The column <code>sys.x$processlist.rows_examined</code>.
     */
    public final TableField<X$processlistRecord, ULong> ROWS_EXAMINED = createField("rows_examined", org.jooq.impl.SQLDataType.BIGINTUNSIGNED, this, "");

    /**
     * The column <code>sys.x$processlist.rows_sent</code>.
     */
    public final TableField<X$processlistRecord, ULong> ROWS_SENT = createField("rows_sent", org.jooq.impl.SQLDataType.BIGINTUNSIGNED, this, "");

    /**
     * The column <code>sys.x$processlist.rows_affected</code>.
     */
    public final TableField<X$processlistRecord, ULong> ROWS_AFFECTED = createField("rows_affected", org.jooq.impl.SQLDataType.BIGINTUNSIGNED, this, "");

    /**
     * The column <code>sys.x$processlist.tmp_tables</code>.
     */
    public final TableField<X$processlistRecord, ULong> TMP_TABLES = createField("tmp_tables", org.jooq.impl.SQLDataType.BIGINTUNSIGNED, this, "");

    /**
     * The column <code>sys.x$processlist.tmp_disk_tables</code>.
     */
    public final TableField<X$processlistRecord, ULong> TMP_DISK_TABLES = createField("tmp_disk_tables", org.jooq.impl.SQLDataType.BIGINTUNSIGNED, this, "");

    /**
     * The column <code>sys.x$processlist.full_scan</code>.
     */
    public final TableField<X$processlistRecord, String> FULL_SCAN = createField("full_scan", org.jooq.impl.SQLDataType.VARCHAR(3).nullable(false).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>sys.x$processlist.last_statement</code>.
     */
    public final TableField<X$processlistRecord, String> LAST_STATEMENT = createField("last_statement", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>sys.x$processlist.last_statement_latency</code>.
     */
    public final TableField<X$processlistRecord, ULong> LAST_STATEMENT_LATENCY = createField("last_statement_latency", org.jooq.impl.SQLDataType.BIGINTUNSIGNED, this, "");

    /**
     * The column <code>sys.x$processlist.current_memory</code>.
     */
    public final TableField<X$processlistRecord, BigInteger> CURRENT_MEMORY = createField("current_memory", org.jooq.impl.SQLDataType.DECIMAL_INTEGER.precision(41), this, "");

    /**
     * The column <code>sys.x$processlist.last_wait</code>.
     */
    public final TableField<X$processlistRecord, String> LAST_WAIT = createField("last_wait", org.jooq.impl.SQLDataType.VARCHAR(128), this, "");

    /**
     * The column <code>sys.x$processlist.last_wait_latency</code>.
     */
    public final TableField<X$processlistRecord, String> LAST_WAIT_LATENCY = createField("last_wait_latency", org.jooq.impl.SQLDataType.VARCHAR(20), this, "");

    /**
     * The column <code>sys.x$processlist.source</code>.
     */
    public final TableField<X$processlistRecord, String> SOURCE = createField("source", org.jooq.impl.SQLDataType.VARCHAR(64), this, "");

    /**
     * The column <code>sys.x$processlist.trx_latency</code>.
     */
    public final TableField<X$processlistRecord, ULong> TRX_LATENCY = createField("trx_latency", org.jooq.impl.SQLDataType.BIGINTUNSIGNED, this, "");

    /**
     * The column <code>sys.x$processlist.trx_state</code>.
     */
    public final TableField<X$processlistRecord, X$processlistTrxState> TRX_STATE = createField("trx_state", org.jooq.impl.SQLDataType.VARCHAR(11).asEnumDataType(jooq.sys.enums.X$processlistTrxState.class), this, "");

    /**
     * The column <code>sys.x$processlist.trx_autocommit</code>.
     */
    public final TableField<X$processlistRecord, X$processlistTrxAutocommit> TRX_AUTOCOMMIT = createField("trx_autocommit", org.jooq.impl.SQLDataType.VARCHAR(3).asEnumDataType(jooq.sys.enums.X$processlistTrxAutocommit.class), this, "");

    /**
     * The column <code>sys.x$processlist.pid</code>.
     */
    public final TableField<X$processlistRecord, String> PID = createField("pid", org.jooq.impl.SQLDataType.VARCHAR(1024), this, "");

    /**
     * The column <code>sys.x$processlist.program_name</code>.
     */
    public final TableField<X$processlistRecord, String> PROGRAM_NAME = createField("program_name", org.jooq.impl.SQLDataType.VARCHAR(1024), this, "");

    /**
     * Create a <code>sys.x$processlist</code> table reference
     */
    public X$processlist() {
        this(DSL.name("x$processlist"), null);
    }

    /**
     * Create an aliased <code>sys.x$processlist</code> table reference
     */
    public X$processlist(String alias) {
        this(DSL.name(alias), X$PROCESSLIST);
    }

    /**
     * Create an aliased <code>sys.x$processlist</code> table reference
     */
    public X$processlist(Name alias) {
        this(alias, X$PROCESSLIST);
    }

    private X$processlist(Name alias, Table<X$processlistRecord> aliased) {
        this(alias, aliased, null);
    }

    private X$processlist(Name alias, Table<X$processlistRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("VIEW"));
    }

    public <O extends Record> X$processlist(Table<O> child, ForeignKey<O, X$processlistRecord> key) {
        super(child, key, X$PROCESSLIST);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Sys.SYS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X$processlist as(String alias) {
        return new X$processlist(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X$processlist as(Name alias) {
        return new X$processlist(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public X$processlist rename(String name) {
        return new X$processlist(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public X$processlist rename(Name name) {
        return new X$processlist(name, null);
    }
}
