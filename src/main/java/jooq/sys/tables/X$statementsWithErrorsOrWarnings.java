/*
 * This file is generated by jOOQ.
 */
package jooq.sys.tables;


import jooq.sys.Sys;
import jooq.sys.tables.records.X$statementsWithErrorsOrWarningsRecord;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;
import org.jooq.types.ULong;

import javax.annotation.Generated;
import java.math.BigDecimal;
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
public class X$statementsWithErrorsOrWarnings extends TableImpl<X$statementsWithErrorsOrWarningsRecord> {

    private static final long serialVersionUID = -1276352109;

    /**
     * The reference instance of <code>sys.x$statements_with_errors_or_warnings</code>
     */
    public static final X$statementsWithErrorsOrWarnings X$STATEMENTS_WITH_ERRORS_OR_WARNINGS = new X$statementsWithErrorsOrWarnings();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<X$statementsWithErrorsOrWarningsRecord> getRecordType() {
        return X$statementsWithErrorsOrWarningsRecord.class;
    }

    /**
     * The column <code>sys.x$statements_with_errors_or_warnings.query</code>.
     */
    public final TableField<X$statementsWithErrorsOrWarningsRecord, String> QUERY = createField("query", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>sys.x$statements_with_errors_or_warnings.db</code>.
     */
    public final TableField<X$statementsWithErrorsOrWarningsRecord, String> DB = createField("db", org.jooq.impl.SQLDataType.VARCHAR(64), this, "");

    /**
     * The column <code>sys.x$statements_with_errors_or_warnings.exec_count</code>.
     */
    public final TableField<X$statementsWithErrorsOrWarningsRecord, ULong> EXEC_COUNT = createField("exec_count", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>sys.x$statements_with_errors_or_warnings.errors</code>.
     */
    public final TableField<X$statementsWithErrorsOrWarningsRecord, ULong> ERRORS = createField("errors", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>sys.x$statements_with_errors_or_warnings.error_pct</code>.
     */
    public final TableField<X$statementsWithErrorsOrWarningsRecord, BigDecimal> ERROR_PCT = createField("error_pct", org.jooq.impl.SQLDataType.DECIMAL(27, 4).nullable(false).defaultValue(org.jooq.impl.DSL.inline("0.0000", org.jooq.impl.SQLDataType.DECIMAL)), this, "");

    /**
     * The column <code>sys.x$statements_with_errors_or_warnings.warnings</code>.
     */
    public final TableField<X$statementsWithErrorsOrWarningsRecord, ULong> WARNINGS = createField("warnings", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>sys.x$statements_with_errors_or_warnings.warning_pct</code>.
     */
    public final TableField<X$statementsWithErrorsOrWarningsRecord, BigDecimal> WARNING_PCT = createField("warning_pct", org.jooq.impl.SQLDataType.DECIMAL(27, 4).nullable(false).defaultValue(org.jooq.impl.DSL.inline("0.0000", org.jooq.impl.SQLDataType.DECIMAL)), this, "");

    /**
     * The column <code>sys.x$statements_with_errors_or_warnings.first_seen</code>.
     */
    public final TableField<X$statementsWithErrorsOrWarningsRecord, Timestamp> FIRST_SEEN = createField("first_seen", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0000-00-00 00:00:00", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "");

    /**
     * The column <code>sys.x$statements_with_errors_or_warnings.last_seen</code>.
     */
    public final TableField<X$statementsWithErrorsOrWarningsRecord, Timestamp> LAST_SEEN = createField("last_seen", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0000-00-00 00:00:00", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "");

    /**
     * The column <code>sys.x$statements_with_errors_or_warnings.digest</code>.
     */
    public final TableField<X$statementsWithErrorsOrWarningsRecord, String> DIGEST = createField("digest", org.jooq.impl.SQLDataType.VARCHAR(32), this, "");

    /**
     * Create a <code>sys.x$statements_with_errors_or_warnings</code> table reference
     */
    public X$statementsWithErrorsOrWarnings() {
        this(DSL.name("x$statements_with_errors_or_warnings"), null);
    }

    /**
     * Create an aliased <code>sys.x$statements_with_errors_or_warnings</code> table reference
     */
    public X$statementsWithErrorsOrWarnings(String alias) {
        this(DSL.name(alias), X$STATEMENTS_WITH_ERRORS_OR_WARNINGS);
    }

    /**
     * Create an aliased <code>sys.x$statements_with_errors_or_warnings</code> table reference
     */
    public X$statementsWithErrorsOrWarnings(Name alias) {
        this(alias, X$STATEMENTS_WITH_ERRORS_OR_WARNINGS);
    }

    private X$statementsWithErrorsOrWarnings(Name alias, Table<X$statementsWithErrorsOrWarningsRecord> aliased) {
        this(alias, aliased, null);
    }

    private X$statementsWithErrorsOrWarnings(Name alias, Table<X$statementsWithErrorsOrWarningsRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("VIEW"));
    }

    public <O extends Record> X$statementsWithErrorsOrWarnings(Table<O> child, ForeignKey<O, X$statementsWithErrorsOrWarningsRecord> key) {
        super(child, key, X$STATEMENTS_WITH_ERRORS_OR_WARNINGS);
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
    public X$statementsWithErrorsOrWarnings as(String alias) {
        return new X$statementsWithErrorsOrWarnings(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X$statementsWithErrorsOrWarnings as(Name alias) {
        return new X$statementsWithErrorsOrWarnings(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public X$statementsWithErrorsOrWarnings rename(String name) {
        return new X$statementsWithErrorsOrWarnings(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public X$statementsWithErrorsOrWarnings rename(Name name) {
        return new X$statementsWithErrorsOrWarnings(name, null);
    }
}
