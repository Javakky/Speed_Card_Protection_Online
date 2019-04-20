/*
 * This file is generated by jOOQ.
 */
package jooq.sys.tables;


import jooq.sys.Sys;
import jooq.sys.tables.records.StatementAnalysisRecord;
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
public class StatementAnalysis extends TableImpl<StatementAnalysisRecord> {

    private static final long serialVersionUID = -945679876;

    /**
     * The reference instance of <code>sys.statement_analysis</code>
     */
    public static final StatementAnalysis STATEMENT_ANALYSIS = new StatementAnalysis();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<StatementAnalysisRecord> getRecordType() {
        return StatementAnalysisRecord.class;
    }

    /**
     * The column <code>sys.statement_analysis.query</code>.
     */
    public final TableField<StatementAnalysisRecord, String> QUERY = createField("query", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>sys.statement_analysis.db</code>.
     */
    public final TableField<StatementAnalysisRecord, String> DB = createField("db", org.jooq.impl.SQLDataType.VARCHAR(64), this, "");

    /**
     * The column <code>sys.statement_analysis.full_scan</code>.
     */
    public final TableField<StatementAnalysisRecord, String> FULL_SCAN = createField("full_scan", org.jooq.impl.SQLDataType.VARCHAR(1).nullable(false).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>sys.statement_analysis.exec_count</code>.
     */
    public final TableField<StatementAnalysisRecord, ULong> EXEC_COUNT = createField("exec_count", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>sys.statement_analysis.err_count</code>.
     */
    public final TableField<StatementAnalysisRecord, ULong> ERR_COUNT = createField("err_count", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>sys.statement_analysis.warn_count</code>.
     */
    public final TableField<StatementAnalysisRecord, ULong> WARN_COUNT = createField("warn_count", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>sys.statement_analysis.total_latency</code>.
     */
    public final TableField<StatementAnalysisRecord, String> TOTAL_LATENCY = createField("total_latency", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>sys.statement_analysis.max_latency</code>.
     */
    public final TableField<StatementAnalysisRecord, String> MAX_LATENCY = createField("max_latency", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>sys.statement_analysis.avg_latency</code>.
     */
    public final TableField<StatementAnalysisRecord, String> AVG_LATENCY = createField("avg_latency", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>sys.statement_analysis.lock_latency</code>.
     */
    public final TableField<StatementAnalysisRecord, String> LOCK_LATENCY = createField("lock_latency", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>sys.statement_analysis.rows_sent</code>.
     */
    public final TableField<StatementAnalysisRecord, ULong> ROWS_SENT = createField("rows_sent", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>sys.statement_analysis.rows_sent_avg</code>.
     */
    public final TableField<StatementAnalysisRecord, BigInteger> ROWS_SENT_AVG = createField("rows_sent_avg", org.jooq.impl.SQLDataType.DECIMAL_INTEGER.precision(21).nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.DECIMAL_INTEGER)), this, "");

    /**
     * The column <code>sys.statement_analysis.rows_examined</code>.
     */
    public final TableField<StatementAnalysisRecord, ULong> ROWS_EXAMINED = createField("rows_examined", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>sys.statement_analysis.rows_examined_avg</code>.
     */
    public final TableField<StatementAnalysisRecord, BigInteger> ROWS_EXAMINED_AVG = createField("rows_examined_avg", org.jooq.impl.SQLDataType.DECIMAL_INTEGER.precision(21).nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.DECIMAL_INTEGER)), this, "");

    /**
     * The column <code>sys.statement_analysis.rows_affected</code>.
     */
    public final TableField<StatementAnalysisRecord, ULong> ROWS_AFFECTED = createField("rows_affected", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>sys.statement_analysis.rows_affected_avg</code>.
     */
    public final TableField<StatementAnalysisRecord, BigInteger> ROWS_AFFECTED_AVG = createField("rows_affected_avg", org.jooq.impl.SQLDataType.DECIMAL_INTEGER.precision(21).nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.DECIMAL_INTEGER)), this, "");

    /**
     * The column <code>sys.statement_analysis.tmp_tables</code>.
     */
    public final TableField<StatementAnalysisRecord, ULong> TMP_TABLES = createField("tmp_tables", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>sys.statement_analysis.tmp_disk_tables</code>.
     */
    public final TableField<StatementAnalysisRecord, ULong> TMP_DISK_TABLES = createField("tmp_disk_tables", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>sys.statement_analysis.rows_sorted</code>.
     */
    public final TableField<StatementAnalysisRecord, ULong> ROWS_SORTED = createField("rows_sorted", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>sys.statement_analysis.sort_merge_passes</code>.
     */
    public final TableField<StatementAnalysisRecord, ULong> SORT_MERGE_PASSES = createField("sort_merge_passes", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>sys.statement_analysis.digest</code>.
     */
    public final TableField<StatementAnalysisRecord, String> DIGEST = createField("digest", org.jooq.impl.SQLDataType.VARCHAR(32), this, "");

    /**
     * The column <code>sys.statement_analysis.first_seen</code>.
     */
    public final TableField<StatementAnalysisRecord, Timestamp> FIRST_SEEN = createField("first_seen", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0000-00-00 00:00:00", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "");

    /**
     * The column <code>sys.statement_analysis.last_seen</code>.
     */
    public final TableField<StatementAnalysisRecord, Timestamp> LAST_SEEN = createField("last_seen", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0000-00-00 00:00:00", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "");

    /**
     * Create a <code>sys.statement_analysis</code> table reference
     */
    public StatementAnalysis() {
        this(DSL.name("statement_analysis"), null);
    }

    /**
     * Create an aliased <code>sys.statement_analysis</code> table reference
     */
    public StatementAnalysis(String alias) {
        this(DSL.name(alias), STATEMENT_ANALYSIS);
    }

    /**
     * Create an aliased <code>sys.statement_analysis</code> table reference
     */
    public StatementAnalysis(Name alias) {
        this(alias, STATEMENT_ANALYSIS);
    }

    private StatementAnalysis(Name alias, Table<StatementAnalysisRecord> aliased) {
        this(alias, aliased, null);
    }

    private StatementAnalysis(Name alias, Table<StatementAnalysisRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("VIEW"));
    }

    public <O extends Record> StatementAnalysis(Table<O> child, ForeignKey<O, StatementAnalysisRecord> key) {
        super(child, key, STATEMENT_ANALYSIS);
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
    public StatementAnalysis as(String alias) {
        return new StatementAnalysis(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StatementAnalysis as(Name alias) {
        return new StatementAnalysis(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public StatementAnalysis rename(String name) {
        return new StatementAnalysis(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public StatementAnalysis rename(Name name) {
        return new StatementAnalysis(name, null);
    }
}
