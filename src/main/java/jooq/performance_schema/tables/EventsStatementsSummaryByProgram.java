/*
 * This file is generated by jOOQ.
 */
package jooq.performance_schema.tables;


import jooq.performance_schema.PerformanceSchema;
import jooq.performance_schema.enums.EventsStatementsSummaryByProgramObjectType;
import jooq.performance_schema.tables.records.EventsStatementsSummaryByProgramRecord;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;
import org.jooq.types.ULong;

import javax.annotation.Generated;


/**
 * This class is generated by jOOQ.
 */
@Generated(
        value = {
                "http://www.jooq.org",
                "jOOQ version:3.11.2"
        },
        comments = "This class is generated by jOOQ"
)
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class EventsStatementsSummaryByProgram extends TableImpl<EventsStatementsSummaryByProgramRecord> {

    /**
     * The reference instance of <code>performance_schema.events_statements_summary_by_program</code>
     */
    public static final EventsStatementsSummaryByProgram EVENTS_STATEMENTS_SUMMARY_BY_PROGRAM = new EventsStatementsSummaryByProgram();
    private static final long serialVersionUID = -148337172;
    /**
     * The column <code>performance_schema.events_statements_summary_by_program.OBJECT_TYPE</code>.
     */
    public final TableField<EventsStatementsSummaryByProgramRecord, EventsStatementsSummaryByProgramObjectType> OBJECT_TYPE = createField("OBJECT_TYPE", org.jooq.impl.SQLDataType.VARCHAR(9).asEnumDataType(jooq.performance_schema.enums.EventsStatementsSummaryByProgramObjectType.class), this, "");
    /**
     * The column <code>performance_schema.events_statements_summary_by_program.OBJECT_SCHEMA</code>.
     */
    public final TableField<EventsStatementsSummaryByProgramRecord, String> OBJECT_SCHEMA = createField("OBJECT_SCHEMA", org.jooq.impl.SQLDataType.VARCHAR(64).nullable(false), this, "");
    /**
     * The column <code>performance_schema.events_statements_summary_by_program.OBJECT_NAME</code>.
     */
    public final TableField<EventsStatementsSummaryByProgramRecord, String> OBJECT_NAME = createField("OBJECT_NAME", org.jooq.impl.SQLDataType.VARCHAR(64).nullable(false), this, "");
    /**
     * The column <code>performance_schema.events_statements_summary_by_program.COUNT_STAR</code>.
     */
    public final TableField<EventsStatementsSummaryByProgramRecord, ULong> COUNT_STAR = createField("COUNT_STAR", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");
    /**
     * The column <code>performance_schema.events_statements_summary_by_program.SUM_TIMER_WAIT</code>.
     */
    public final TableField<EventsStatementsSummaryByProgramRecord, ULong> SUM_TIMER_WAIT = createField("SUM_TIMER_WAIT", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");
    /**
     * The column <code>performance_schema.events_statements_summary_by_program.MIN_TIMER_WAIT</code>.
     */
    public final TableField<EventsStatementsSummaryByProgramRecord, ULong> MIN_TIMER_WAIT = createField("MIN_TIMER_WAIT", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");
    /**
     * The column <code>performance_schema.events_statements_summary_by_program.AVG_TIMER_WAIT</code>.
     */
    public final TableField<EventsStatementsSummaryByProgramRecord, ULong> AVG_TIMER_WAIT = createField("AVG_TIMER_WAIT", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");
    /**
     * The column <code>performance_schema.events_statements_summary_by_program.MAX_TIMER_WAIT</code>.
     */
    public final TableField<EventsStatementsSummaryByProgramRecord, ULong> MAX_TIMER_WAIT = createField("MAX_TIMER_WAIT", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");
    /**
     * The column <code>performance_schema.events_statements_summary_by_program.COUNT_STATEMENTS</code>.
     */
    public final TableField<EventsStatementsSummaryByProgramRecord, ULong> COUNT_STATEMENTS = createField("COUNT_STATEMENTS", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");
    /**
     * The column <code>performance_schema.events_statements_summary_by_program.SUM_STATEMENTS_WAIT</code>.
     */
    public final TableField<EventsStatementsSummaryByProgramRecord, ULong> SUM_STATEMENTS_WAIT = createField("SUM_STATEMENTS_WAIT", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");
    /**
     * The column <code>performance_schema.events_statements_summary_by_program.MIN_STATEMENTS_WAIT</code>.
     */
    public final TableField<EventsStatementsSummaryByProgramRecord, ULong> MIN_STATEMENTS_WAIT = createField("MIN_STATEMENTS_WAIT", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");
    /**
     * The column <code>performance_schema.events_statements_summary_by_program.AVG_STATEMENTS_WAIT</code>.
     */
    public final TableField<EventsStatementsSummaryByProgramRecord, ULong> AVG_STATEMENTS_WAIT = createField("AVG_STATEMENTS_WAIT", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");
    /**
     * The column <code>performance_schema.events_statements_summary_by_program.MAX_STATEMENTS_WAIT</code>.
     */
    public final TableField<EventsStatementsSummaryByProgramRecord, ULong> MAX_STATEMENTS_WAIT = createField("MAX_STATEMENTS_WAIT", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");
    /**
     * The column <code>performance_schema.events_statements_summary_by_program.SUM_LOCK_TIME</code>.
     */
    public final TableField<EventsStatementsSummaryByProgramRecord, ULong> SUM_LOCK_TIME = createField("SUM_LOCK_TIME", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");
    /**
     * The column <code>performance_schema.events_statements_summary_by_program.SUM_ERRORS</code>.
     */
    public final TableField<EventsStatementsSummaryByProgramRecord, ULong> SUM_ERRORS = createField("SUM_ERRORS", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");
    /**
     * The column <code>performance_schema.events_statements_summary_by_program.SUM_WARNINGS</code>.
     */
    public final TableField<EventsStatementsSummaryByProgramRecord, ULong> SUM_WARNINGS = createField("SUM_WARNINGS", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");
    /**
     * The column <code>performance_schema.events_statements_summary_by_program.SUM_ROWS_AFFECTED</code>.
     */
    public final TableField<EventsStatementsSummaryByProgramRecord, ULong> SUM_ROWS_AFFECTED = createField("SUM_ROWS_AFFECTED", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");
    /**
     * The column <code>performance_schema.events_statements_summary_by_program.SUM_ROWS_SENT</code>.
     */
    public final TableField<EventsStatementsSummaryByProgramRecord, ULong> SUM_ROWS_SENT = createField("SUM_ROWS_SENT", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");
    /**
     * The column <code>performance_schema.events_statements_summary_by_program.SUM_ROWS_EXAMINED</code>.
     */
    public final TableField<EventsStatementsSummaryByProgramRecord, ULong> SUM_ROWS_EXAMINED = createField("SUM_ROWS_EXAMINED", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");
    /**
     * The column <code>performance_schema.events_statements_summary_by_program.SUM_CREATED_TMP_DISK_TABLES</code>.
     */
    public final TableField<EventsStatementsSummaryByProgramRecord, ULong> SUM_CREATED_TMP_DISK_TABLES = createField("SUM_CREATED_TMP_DISK_TABLES", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");
    /**
     * The column <code>performance_schema.events_statements_summary_by_program.SUM_CREATED_TMP_TABLES</code>.
     */
    public final TableField<EventsStatementsSummaryByProgramRecord, ULong> SUM_CREATED_TMP_TABLES = createField("SUM_CREATED_TMP_TABLES", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");
    /**
     * The column <code>performance_schema.events_statements_summary_by_program.SUM_SELECT_FULL_JOIN</code>.
     */
    public final TableField<EventsStatementsSummaryByProgramRecord, ULong> SUM_SELECT_FULL_JOIN = createField("SUM_SELECT_FULL_JOIN", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");
    /**
     * The column <code>performance_schema.events_statements_summary_by_program.SUM_SELECT_FULL_RANGE_JOIN</code>.
     */
    public final TableField<EventsStatementsSummaryByProgramRecord, ULong> SUM_SELECT_FULL_RANGE_JOIN = createField("SUM_SELECT_FULL_RANGE_JOIN", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");
    /**
     * The column <code>performance_schema.events_statements_summary_by_program.SUM_SELECT_RANGE</code>.
     */
    public final TableField<EventsStatementsSummaryByProgramRecord, ULong> SUM_SELECT_RANGE = createField("SUM_SELECT_RANGE", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");
    /**
     * The column <code>performance_schema.events_statements_summary_by_program.SUM_SELECT_RANGE_CHECK</code>.
     */
    public final TableField<EventsStatementsSummaryByProgramRecord, ULong> SUM_SELECT_RANGE_CHECK = createField("SUM_SELECT_RANGE_CHECK", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");
    /**
     * The column <code>performance_schema.events_statements_summary_by_program.SUM_SELECT_SCAN</code>.
     */
    public final TableField<EventsStatementsSummaryByProgramRecord, ULong> SUM_SELECT_SCAN = createField("SUM_SELECT_SCAN", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");
    /**
     * The column <code>performance_schema.events_statements_summary_by_program.SUM_SORT_MERGE_PASSES</code>.
     */
    public final TableField<EventsStatementsSummaryByProgramRecord, ULong> SUM_SORT_MERGE_PASSES = createField("SUM_SORT_MERGE_PASSES", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");
    /**
     * The column <code>performance_schema.events_statements_summary_by_program.SUM_SORT_RANGE</code>.
     */
    public final TableField<EventsStatementsSummaryByProgramRecord, ULong> SUM_SORT_RANGE = createField("SUM_SORT_RANGE", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");
    /**
     * The column <code>performance_schema.events_statements_summary_by_program.SUM_SORT_ROWS</code>.
     */
    public final TableField<EventsStatementsSummaryByProgramRecord, ULong> SUM_SORT_ROWS = createField("SUM_SORT_ROWS", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");
    /**
     * The column <code>performance_schema.events_statements_summary_by_program.SUM_SORT_SCAN</code>.
     */
    public final TableField<EventsStatementsSummaryByProgramRecord, ULong> SUM_SORT_SCAN = createField("SUM_SORT_SCAN", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");
    /**
     * The column <code>performance_schema.events_statements_summary_by_program.SUM_NO_INDEX_USED</code>.
     */
    public final TableField<EventsStatementsSummaryByProgramRecord, ULong> SUM_NO_INDEX_USED = createField("SUM_NO_INDEX_USED", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");
    /**
     * The column <code>performance_schema.events_statements_summary_by_program.SUM_NO_GOOD_INDEX_USED</code>.
     */
    public final TableField<EventsStatementsSummaryByProgramRecord, ULong> SUM_NO_GOOD_INDEX_USED = createField("SUM_NO_GOOD_INDEX_USED", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");

    /**
     * Create a <code>performance_schema.events_statements_summary_by_program</code> table reference
     */
    public EventsStatementsSummaryByProgram() {
        this(DSL.name("events_statements_summary_by_program"), null);
    }

    /**
     * Create an aliased <code>performance_schema.events_statements_summary_by_program</code> table reference
     */
    public EventsStatementsSummaryByProgram(String alias) {
        this(DSL.name(alias), EVENTS_STATEMENTS_SUMMARY_BY_PROGRAM);
    }

    /**
     * Create an aliased <code>performance_schema.events_statements_summary_by_program</code> table reference
     */
    public EventsStatementsSummaryByProgram(Name alias) {
        this(alias, EVENTS_STATEMENTS_SUMMARY_BY_PROGRAM);
    }

    private EventsStatementsSummaryByProgram(Name alias, Table<EventsStatementsSummaryByProgramRecord> aliased) {
        this(alias, aliased, null);
    }

    private EventsStatementsSummaryByProgram(Name alias, Table<EventsStatementsSummaryByProgramRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> EventsStatementsSummaryByProgram(Table<O> child, ForeignKey<O, EventsStatementsSummaryByProgramRecord> key) {
        super(child, key, EVENTS_STATEMENTS_SUMMARY_BY_PROGRAM);
    }

    /**
     * The class holding records for this type
     */
    @Override
    public Class<EventsStatementsSummaryByProgramRecord> getRecordType() {
        return EventsStatementsSummaryByProgramRecord.class;
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
    public EventsStatementsSummaryByProgram as(String alias) {
        return new EventsStatementsSummaryByProgram(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EventsStatementsSummaryByProgram as(Name alias) {
        return new EventsStatementsSummaryByProgram(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public EventsStatementsSummaryByProgram rename(String name) {
        return new EventsStatementsSummaryByProgram(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public EventsStatementsSummaryByProgram rename(Name name) {
        return new EventsStatementsSummaryByProgram(name, null);
    }
}
