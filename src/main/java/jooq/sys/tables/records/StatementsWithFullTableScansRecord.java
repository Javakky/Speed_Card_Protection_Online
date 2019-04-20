/*
 * This file is generated by jOOQ.
 */
package jooq.sys.tables.records;


import jooq.sys.tables.StatementsWithFullTableScans;
import org.jooq.Field;
import org.jooq.Record14;
import org.jooq.Row14;
import org.jooq.impl.TableRecordImpl;
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
public class StatementsWithFullTableScansRecord extends TableRecordImpl<StatementsWithFullTableScansRecord> implements Record14<String, String, ULong, String, ULong, ULong, BigInteger, ULong, ULong, BigInteger, BigInteger, Timestamp, Timestamp, String> {

    private static final long serialVersionUID = 1333092830;

    /**
     * Setter for <code>sys.statements_with_full_table_scans.query</code>.
     */
    public void setQuery(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>sys.statements_with_full_table_scans.query</code>.
     */
    public String getQuery() {
        return (String) get(0);
    }

    /**
     * Setter for <code>sys.statements_with_full_table_scans.db</code>.
     */
    public void setDb(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>sys.statements_with_full_table_scans.db</code>.
     */
    public String getDb() {
        return (String) get(1);
    }

    /**
     * Setter for <code>sys.statements_with_full_table_scans.exec_count</code>.
     */
    public void setExecCount(ULong value) {
        set(2, value);
    }

    /**
     * Getter for <code>sys.statements_with_full_table_scans.exec_count</code>.
     */
    public ULong getExecCount() {
        return (ULong) get(2);
    }

    /**
     * Setter for <code>sys.statements_with_full_table_scans.total_latency</code>.
     */
    public void setTotalLatency(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>sys.statements_with_full_table_scans.total_latency</code>.
     */
    public String getTotalLatency() {
        return (String) get(3);
    }

    /**
     * Setter for <code>sys.statements_with_full_table_scans.no_index_used_count</code>.
     */
    public void setNoIndexUsedCount(ULong value) {
        set(4, value);
    }

    /**
     * Getter for <code>sys.statements_with_full_table_scans.no_index_used_count</code>.
     */
    public ULong getNoIndexUsedCount() {
        return (ULong) get(4);
    }

    /**
     * Setter for <code>sys.statements_with_full_table_scans.no_good_index_used_count</code>.
     */
    public void setNoGoodIndexUsedCount(ULong value) {
        set(5, value);
    }

    /**
     * Getter for <code>sys.statements_with_full_table_scans.no_good_index_used_count</code>.
     */
    public ULong getNoGoodIndexUsedCount() {
        return (ULong) get(5);
    }

    /**
     * Setter for <code>sys.statements_with_full_table_scans.no_index_used_pct</code>.
     */
    public void setNoIndexUsedPct(BigInteger value) {
        set(6, value);
    }

    /**
     * Getter for <code>sys.statements_with_full_table_scans.no_index_used_pct</code>.
     */
    public BigInteger getNoIndexUsedPct() {
        return (BigInteger) get(6);
    }

    /**
     * Setter for <code>sys.statements_with_full_table_scans.rows_sent</code>.
     */
    public void setRowsSent(ULong value) {
        set(7, value);
    }

    /**
     * Getter for <code>sys.statements_with_full_table_scans.rows_sent</code>.
     */
    public ULong getRowsSent() {
        return (ULong) get(7);
    }

    /**
     * Setter for <code>sys.statements_with_full_table_scans.rows_examined</code>.
     */
    public void setRowsExamined(ULong value) {
        set(8, value);
    }

    /**
     * Getter for <code>sys.statements_with_full_table_scans.rows_examined</code>.
     */
    public ULong getRowsExamined() {
        return (ULong) get(8);
    }

    /**
     * Setter for <code>sys.statements_with_full_table_scans.rows_sent_avg</code>.
     */
    public void setRowsSentAvg(BigInteger value) {
        set(9, value);
    }

    /**
     * Getter for <code>sys.statements_with_full_table_scans.rows_sent_avg</code>.
     */
    public BigInteger getRowsSentAvg() {
        return (BigInteger) get(9);
    }

    /**
     * Setter for <code>sys.statements_with_full_table_scans.rows_examined_avg</code>.
     */
    public void setRowsExaminedAvg(BigInteger value) {
        set(10, value);
    }

    /**
     * Getter for <code>sys.statements_with_full_table_scans.rows_examined_avg</code>.
     */
    public BigInteger getRowsExaminedAvg() {
        return (BigInteger) get(10);
    }

    /**
     * Setter for <code>sys.statements_with_full_table_scans.first_seen</code>.
     */
    public void setFirstSeen(Timestamp value) {
        set(11, value);
    }

    /**
     * Getter for <code>sys.statements_with_full_table_scans.first_seen</code>.
     */
    public Timestamp getFirstSeen() {
        return (Timestamp) get(11);
    }

    /**
     * Setter for <code>sys.statements_with_full_table_scans.last_seen</code>.
     */
    public void setLastSeen(Timestamp value) {
        set(12, value);
    }

    /**
     * Getter for <code>sys.statements_with_full_table_scans.last_seen</code>.
     */
    public Timestamp getLastSeen() {
        return (Timestamp) get(12);
    }

    /**
     * Setter for <code>sys.statements_with_full_table_scans.digest</code>.
     */
    public void setDigest(String value) {
        set(13, value);
    }

    /**
     * Getter for <code>sys.statements_with_full_table_scans.digest</code>.
     */
    public String getDigest() {
        return (String) get(13);
    }

    // -------------------------------------------------------------------------
    // Record14 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row14<String, String, ULong, String, ULong, ULong, BigInteger, ULong, ULong, BigInteger, BigInteger, Timestamp, Timestamp, String> fieldsRow() {
        return (Row14) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row14<String, String, ULong, String, ULong, ULong, BigInteger, ULong, ULong, BigInteger, BigInteger, Timestamp, Timestamp, String> valuesRow() {
        return (Row14) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return StatementsWithFullTableScans.STATEMENTS_WITH_FULL_TABLE_SCANS.QUERY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return StatementsWithFullTableScans.STATEMENTS_WITH_FULL_TABLE_SCANS.DB;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<ULong> field3() {
        return StatementsWithFullTableScans.STATEMENTS_WITH_FULL_TABLE_SCANS.EXEC_COUNT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return StatementsWithFullTableScans.STATEMENTS_WITH_FULL_TABLE_SCANS.TOTAL_LATENCY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<ULong> field5() {
        return StatementsWithFullTableScans.STATEMENTS_WITH_FULL_TABLE_SCANS.NO_INDEX_USED_COUNT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<ULong> field6() {
        return StatementsWithFullTableScans.STATEMENTS_WITH_FULL_TABLE_SCANS.NO_GOOD_INDEX_USED_COUNT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<BigInteger> field7() {
        return StatementsWithFullTableScans.STATEMENTS_WITH_FULL_TABLE_SCANS.NO_INDEX_USED_PCT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<ULong> field8() {
        return StatementsWithFullTableScans.STATEMENTS_WITH_FULL_TABLE_SCANS.ROWS_SENT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<ULong> field9() {
        return StatementsWithFullTableScans.STATEMENTS_WITH_FULL_TABLE_SCANS.ROWS_EXAMINED;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<BigInteger> field10() {
        return StatementsWithFullTableScans.STATEMENTS_WITH_FULL_TABLE_SCANS.ROWS_SENT_AVG;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<BigInteger> field11() {
        return StatementsWithFullTableScans.STATEMENTS_WITH_FULL_TABLE_SCANS.ROWS_EXAMINED_AVG;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field12() {
        return StatementsWithFullTableScans.STATEMENTS_WITH_FULL_TABLE_SCANS.FIRST_SEEN;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field13() {
        return StatementsWithFullTableScans.STATEMENTS_WITH_FULL_TABLE_SCANS.LAST_SEEN;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field14() {
        return StatementsWithFullTableScans.STATEMENTS_WITH_FULL_TABLE_SCANS.DIGEST;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component1() {
        return getQuery();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getDb();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong component3() {
        return getExecCount();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getTotalLatency();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong component5() {
        return getNoIndexUsedCount();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong component6() {
        return getNoGoodIndexUsedCount();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigInteger component7() {
        return getNoIndexUsedPct();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong component8() {
        return getRowsSent();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong component9() {
        return getRowsExamined();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigInteger component10() {
        return getRowsSentAvg();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigInteger component11() {
        return getRowsExaminedAvg();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component12() {
        return getFirstSeen();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component13() {
        return getLastSeen();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component14() {
        return getDigest();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value1() {
        return getQuery();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getDb();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong value3() {
        return getExecCount();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getTotalLatency();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong value5() {
        return getNoIndexUsedCount();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong value6() {
        return getNoGoodIndexUsedCount();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigInteger value7() {
        return getNoIndexUsedPct();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong value8() {
        return getRowsSent();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong value9() {
        return getRowsExamined();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigInteger value10() {
        return getRowsSentAvg();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigInteger value11() {
        return getRowsExaminedAvg();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value12() {
        return getFirstSeen();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value13() {
        return getLastSeen();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value14() {
        return getDigest();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StatementsWithFullTableScansRecord value1(String value) {
        setQuery(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StatementsWithFullTableScansRecord value2(String value) {
        setDb(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StatementsWithFullTableScansRecord value3(ULong value) {
        setExecCount(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StatementsWithFullTableScansRecord value4(String value) {
        setTotalLatency(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StatementsWithFullTableScansRecord value5(ULong value) {
        setNoIndexUsedCount(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StatementsWithFullTableScansRecord value6(ULong value) {
        setNoGoodIndexUsedCount(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StatementsWithFullTableScansRecord value7(BigInteger value) {
        setNoIndexUsedPct(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StatementsWithFullTableScansRecord value8(ULong value) {
        setRowsSent(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StatementsWithFullTableScansRecord value9(ULong value) {
        setRowsExamined(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StatementsWithFullTableScansRecord value10(BigInteger value) {
        setRowsSentAvg(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StatementsWithFullTableScansRecord value11(BigInteger value) {
        setRowsExaminedAvg(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StatementsWithFullTableScansRecord value12(Timestamp value) {
        setFirstSeen(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StatementsWithFullTableScansRecord value13(Timestamp value) {
        setLastSeen(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StatementsWithFullTableScansRecord value14(String value) {
        setDigest(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StatementsWithFullTableScansRecord values(String value1, String value2, ULong value3, String value4, ULong value5, ULong value6, BigInteger value7, ULong value8, ULong value9, BigInteger value10, BigInteger value11, Timestamp value12, Timestamp value13, String value14) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        value12(value12);
        value13(value13);
        value14(value14);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached StatementsWithFullTableScansRecord
     */
    public StatementsWithFullTableScansRecord() {
        super(StatementsWithFullTableScans.STATEMENTS_WITH_FULL_TABLE_SCANS);
    }

    /**
     * Create a detached, initialised StatementsWithFullTableScansRecord
     */
    public StatementsWithFullTableScansRecord(String query, String db, ULong execCount, String totalLatency, ULong noIndexUsedCount, ULong noGoodIndexUsedCount, BigInteger noIndexUsedPct, ULong rowsSent, ULong rowsExamined, BigInteger rowsSentAvg, BigInteger rowsExaminedAvg, Timestamp firstSeen, Timestamp lastSeen, String digest) {
        super(StatementsWithFullTableScans.STATEMENTS_WITH_FULL_TABLE_SCANS);

        set(0, query);
        set(1, db);
        set(2, execCount);
        set(3, totalLatency);
        set(4, noIndexUsedCount);
        set(5, noGoodIndexUsedCount);
        set(6, noIndexUsedPct);
        set(7, rowsSent);
        set(8, rowsExamined);
        set(9, rowsSentAvg);
        set(10, rowsExaminedAvg);
        set(11, firstSeen);
        set(12, lastSeen);
        set(13, digest);
    }
}
