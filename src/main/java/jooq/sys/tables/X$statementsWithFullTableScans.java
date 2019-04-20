/*
 * This file is generated by jOOQ.
 */
package jooq.sys.tables;


import jooq.sys.Sys;
import jooq.sys.tables.records.X$statementsWithFullTableScansRecord;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;
import org.jooq.types.ULong;

import javax.annotation.Generated;
import java.math.BigInteger;
import java.sql.Timestamp;


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
public class X$statementsWithFullTableScans extends TableImpl<X$statementsWithFullTableScansRecord> {

    private static final long serialVersionUID = -1023117007;

    /**
     * The reference instance of <code>sys.x$statements_with_full_table_scans</code>
     */
    public static final X$statementsWithFullTableScans X$STATEMENTS_WITH_FULL_TABLE_SCANS = new X$statementsWithFullTableScans();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<X$statementsWithFullTableScansRecord> getRecordType() {
        return X$statementsWithFullTableScansRecord.class;
    }

    /**
     * The column <code>sys.x$statements_with_full_table_scans.query</code>.
     */
    public final TableField<X$statementsWithFullTableScansRecord, String> QUERY = createField("query", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>sys.x$statements_with_full_table_scans.db</code>.
     */
    public final TableField<X$statementsWithFullTableScansRecord, String> DB = createField("db", org.jooq.impl.SQLDataType.VARCHAR(64), this, "");

    /**
     * The column <code>sys.x$statements_with_full_table_scans.exec_count</code>.
     */
    public final TableField<X$statementsWithFullTableScansRecord, ULong> EXEC_COUNT = createField("exec_count", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>sys.x$statements_with_full_table_scans.total_latency</code>.
     */
    public final TableField<X$statementsWithFullTableScansRecord, ULong> TOTAL_LATENCY = createField("total_latency", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>sys.x$statements_with_full_table_scans.no_index_used_count</code>.
     */
    public final TableField<X$statementsWithFullTableScansRecord, ULong> NO_INDEX_USED_COUNT = createField("no_index_used_count", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>sys.x$statements_with_full_table_scans.no_good_index_used_count</code>.
     */
    public final TableField<X$statementsWithFullTableScansRecord, ULong> NO_GOOD_INDEX_USED_COUNT = createField("no_good_index_used_count", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>sys.x$statements_with_full_table_scans.no_index_used_pct</code>.
     */
    public final TableField<X$statementsWithFullTableScansRecord, BigInteger> NO_INDEX_USED_PCT = createField("no_index_used_pct", org.jooq.impl.SQLDataType.DECIMAL_INTEGER.precision(24).nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.DECIMAL_INTEGER)), this, "");

    /**
     * The column <code>sys.x$statements_with_full_table_scans.rows_sent</code>.
     */
    public final TableField<X$statementsWithFullTableScansRecord, ULong> ROWS_SENT = createField("rows_sent", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>sys.x$statements_with_full_table_scans.rows_examined</code>.
     */
    public final TableField<X$statementsWithFullTableScansRecord, ULong> ROWS_EXAMINED = createField("rows_examined", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>sys.x$statements_with_full_table_scans.rows_sent_avg</code>.
     */
    public final TableField<X$statementsWithFullTableScansRecord, BigInteger> ROWS_SENT_AVG = createField("rows_sent_avg", org.jooq.impl.SQLDataType.DECIMAL_INTEGER.precision(21), this, "");

    /**
     * The column <code>sys.x$statements_with_full_table_scans.rows_examined_avg</code>.
     */
    public final TableField<X$statementsWithFullTableScansRecord, BigInteger> ROWS_EXAMINED_AVG = createField("rows_examined_avg", org.jooq.impl.SQLDataType.DECIMAL_INTEGER.precision(21), this, "");

    /**
     * The column <code>sys.x$statements_with_full_table_scans.first_seen</code>.
     */
    public final TableField<X$statementsWithFullTableScansRecord, Timestamp> FIRST_SEEN = createField("first_seen", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0000-00-00 00:00:00", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "");

    /**
     * The column <code>sys.x$statements_with_full_table_scans.last_seen</code>.
     */
    public final TableField<X$statementsWithFullTableScansRecord, Timestamp> LAST_SEEN = createField("last_seen", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0000-00-00 00:00:00", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "");

    /**
     * The column <code>sys.x$statements_with_full_table_scans.digest</code>.
     */
    public final TableField<X$statementsWithFullTableScansRecord, String> DIGEST = createField("digest", org.jooq.impl.SQLDataType.VARCHAR(32), this, "");

    /**
     * Create a <code>sys.x$statements_with_full_table_scans</code> table reference
     */
    public X$statementsWithFullTableScans() {
        this(DSL.name("x$statements_with_full_table_scans"), null);
    }

    /**
     * Create an aliased <code>sys.x$statements_with_full_table_scans</code> table reference
     */
    public X$statementsWithFullTableScans(String alias) {
        this(DSL.name(alias), X$STATEMENTS_WITH_FULL_TABLE_SCANS);
    }

    /**
     * Create an aliased <code>sys.x$statements_with_full_table_scans</code> table reference
     */
    public X$statementsWithFullTableScans(Name alias) {
        this(alias, X$STATEMENTS_WITH_FULL_TABLE_SCANS);
    }

    private X$statementsWithFullTableScans(Name alias, Table<X$statementsWithFullTableScansRecord> aliased) {
        this(alias, aliased, null);
    }

    private X$statementsWithFullTableScans(Name alias, Table<X$statementsWithFullTableScansRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("VIEW"));
    }

    public <O extends Record> X$statementsWithFullTableScans(Table<O> child, ForeignKey<O, X$statementsWithFullTableScansRecord> key) {
        super(child, key, X$STATEMENTS_WITH_FULL_TABLE_SCANS);
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
    public X$statementsWithFullTableScans as(String alias) {
        return new X$statementsWithFullTableScans(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X$statementsWithFullTableScans as(Name alias) {
        return new X$statementsWithFullTableScans(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public X$statementsWithFullTableScans rename(String name) {
        return new X$statementsWithFullTableScans(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public X$statementsWithFullTableScans rename(Name name) {
        return new X$statementsWithFullTableScans(name, null);
    }
}
