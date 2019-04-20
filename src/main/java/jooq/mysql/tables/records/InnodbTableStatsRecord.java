/*
 * This file is generated by jOOQ.
 */
package jooq.mysql.tables.records;


import jooq.mysql.tables.InnodbTableStats;
import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Record6;
import org.jooq.Row6;
import org.jooq.impl.UpdatableRecordImpl;
import org.jooq.types.ULong;

import javax.annotation.Generated;
import java.sql.Timestamp;


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
public class InnodbTableStatsRecord extends UpdatableRecordImpl<InnodbTableStatsRecord> implements Record6<String, String, Timestamp, ULong, ULong, ULong> {

    private static final long serialVersionUID = -660610049;

    /**
     * Setter for <code>mysql.innodb_table_stats.database_name</code>.
     */
    public void setDatabaseName(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>mysql.innodb_table_stats.database_name</code>.
     */
    public String getDatabaseName() {
        return (String) get(0);
    }

    /**
     * Setter for <code>mysql.innodb_table_stats.table_name</code>.
     */
    public void setTableName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>mysql.innodb_table_stats.table_name</code>.
     */
    public String getTableName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>mysql.innodb_table_stats.last_update</code>.
     */
    public void setLastUpdate(Timestamp value) {
        set(2, value);
    }

    /**
     * Getter for <code>mysql.innodb_table_stats.last_update</code>.
     */
    public Timestamp getLastUpdate() {
        return (Timestamp) get(2);
    }

    /**
     * Setter for <code>mysql.innodb_table_stats.n_rows</code>.
     */
    public void setNRows(ULong value) {
        set(3, value);
    }

    /**
     * Getter for <code>mysql.innodb_table_stats.n_rows</code>.
     */
    public ULong getNRows() {
        return (ULong) get(3);
    }

    /**
     * Setter for <code>mysql.innodb_table_stats.clustered_index_size</code>.
     */
    public void setClusteredIndexSize(ULong value) {
        set(4, value);
    }

    /**
     * Getter for <code>mysql.innodb_table_stats.clustered_index_size</code>.
     */
    public ULong getClusteredIndexSize() {
        return (ULong) get(4);
    }

    /**
     * Setter for <code>mysql.innodb_table_stats.sum_of_other_index_sizes</code>.
     */
    public void setSumOfOtherIndexSizes(ULong value) {
        set(5, value);
    }

    /**
     * Getter for <code>mysql.innodb_table_stats.sum_of_other_index_sizes</code>.
     */
    public ULong getSumOfOtherIndexSizes() {
        return (ULong) get(5);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record2<String, String> key() {
        return (Record2) super.key();
    }

    // -------------------------------------------------------------------------
    // Record6 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row6<String, String, Timestamp, ULong, ULong, ULong> fieldsRow() {
        return (Row6) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row6<String, String, Timestamp, ULong, ULong, ULong> valuesRow() {
        return (Row6) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return InnodbTableStats.INNODB_TABLE_STATS.DATABASE_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return InnodbTableStats.INNODB_TABLE_STATS.TABLE_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field3() {
        return InnodbTableStats.INNODB_TABLE_STATS.LAST_UPDATE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<ULong> field4() {
        return InnodbTableStats.INNODB_TABLE_STATS.N_ROWS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<ULong> field5() {
        return InnodbTableStats.INNODB_TABLE_STATS.CLUSTERED_INDEX_SIZE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<ULong> field6() {
        return InnodbTableStats.INNODB_TABLE_STATS.SUM_OF_OTHER_INDEX_SIZES;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component1() {
        return getDatabaseName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getTableName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component3() {
        return getLastUpdate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong component4() {
        return getNRows();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong component5() {
        return getClusteredIndexSize();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong component6() {
        return getSumOfOtherIndexSizes();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value1() {
        return getDatabaseName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getTableName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value3() {
        return getLastUpdate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong value4() {
        return getNRows();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong value5() {
        return getClusteredIndexSize();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong value6() {
        return getSumOfOtherIndexSizes();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InnodbTableStatsRecord value1(String value) {
        setDatabaseName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InnodbTableStatsRecord value2(String value) {
        setTableName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InnodbTableStatsRecord value3(Timestamp value) {
        setLastUpdate(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InnodbTableStatsRecord value4(ULong value) {
        setNRows(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InnodbTableStatsRecord value5(ULong value) {
        setClusteredIndexSize(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InnodbTableStatsRecord value6(ULong value) {
        setSumOfOtherIndexSizes(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InnodbTableStatsRecord values(String value1, String value2, Timestamp value3, ULong value4, ULong value5, ULong value6) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached InnodbTableStatsRecord
     */
    public InnodbTableStatsRecord() {
        super(InnodbTableStats.INNODB_TABLE_STATS);
    }

    /**
     * Create a detached, initialised InnodbTableStatsRecord
     */
    public InnodbTableStatsRecord(String databaseName, String tableName, Timestamp lastUpdate, ULong nRows, ULong clusteredIndexSize, ULong sumOfOtherIndexSizes) {
        super(InnodbTableStats.INNODB_TABLE_STATS);

        set(0, databaseName);
        set(1, tableName);
        set(2, lastUpdate);
        set(3, nRows);
        set(4, clusteredIndexSize);
        set(5, sumOfOtherIndexSizes);
    }
}
