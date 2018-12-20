/*
 * This file is generated by jOOQ.
 */
package jooq.sys.tables.records;


import java.math.BigInteger;

import javax.annotation.Generated;

import jooq.sys.tables.X$innodbBufferStatsByTable;

import org.jooq.Field;
import org.jooq.Record8;
import org.jooq.Row8;
import org.jooq.impl.TableRecordImpl;


/**
 * VIEW
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.2"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class X$innodbBufferStatsByTableRecord extends TableRecordImpl<X$innodbBufferStatsByTableRecord> implements Record8<String, String, BigInteger, BigInteger, Long, Long, Long, BigInteger> {

    private static final long serialVersionUID = 1708174808;

    /**
     * Setter for <code>sys.x$innodb_buffer_stats_by_table.object_schema</code>.
     */
    public void setObjectSchema(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>sys.x$innodb_buffer_stats_by_table.object_schema</code>.
     */
    public String getObjectSchema() {
        return (String) get(0);
    }

    /**
     * Setter for <code>sys.x$innodb_buffer_stats_by_table.object_name</code>.
     */
    public void setObjectName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>sys.x$innodb_buffer_stats_by_table.object_name</code>.
     */
    public String getObjectName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>sys.x$innodb_buffer_stats_by_table.allocated</code>.
     */
    public void setAllocated(BigInteger value) {
        set(2, value);
    }

    /**
     * Getter for <code>sys.x$innodb_buffer_stats_by_table.allocated</code>.
     */
    public BigInteger getAllocated() {
        return (BigInteger) get(2);
    }

    /**
     * Setter for <code>sys.x$innodb_buffer_stats_by_table.data</code>.
     */
    public void setData(BigInteger value) {
        set(3, value);
    }

    /**
     * Getter for <code>sys.x$innodb_buffer_stats_by_table.data</code>.
     */
    public BigInteger getData() {
        return (BigInteger) get(3);
    }

    /**
     * Setter for <code>sys.x$innodb_buffer_stats_by_table.pages</code>.
     */
    public void setPages(Long value) {
        set(4, value);
    }

    /**
     * Getter for <code>sys.x$innodb_buffer_stats_by_table.pages</code>.
     */
    public Long getPages() {
        return (Long) get(4);
    }

    /**
     * Setter for <code>sys.x$innodb_buffer_stats_by_table.pages_hashed</code>.
     */
    public void setPagesHashed(Long value) {
        set(5, value);
    }

    /**
     * Getter for <code>sys.x$innodb_buffer_stats_by_table.pages_hashed</code>.
     */
    public Long getPagesHashed() {
        return (Long) get(5);
    }

    /**
     * Setter for <code>sys.x$innodb_buffer_stats_by_table.pages_old</code>.
     */
    public void setPagesOld(Long value) {
        set(6, value);
    }

    /**
     * Getter for <code>sys.x$innodb_buffer_stats_by_table.pages_old</code>.
     */
    public Long getPagesOld() {
        return (Long) get(6);
    }

    /**
     * Setter for <code>sys.x$innodb_buffer_stats_by_table.rows_cached</code>.
     */
    public void setRowsCached(BigInteger value) {
        set(7, value);
    }

    /**
     * Getter for <code>sys.x$innodb_buffer_stats_by_table.rows_cached</code>.
     */
    public BigInteger getRowsCached() {
        return (BigInteger) get(7);
    }

    // -------------------------------------------------------------------------
    // Record8 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row8<String, String, BigInteger, BigInteger, Long, Long, Long, BigInteger> fieldsRow() {
        return (Row8) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row8<String, String, BigInteger, BigInteger, Long, Long, Long, BigInteger> valuesRow() {
        return (Row8) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return X$innodbBufferStatsByTable.X$INNODB_BUFFER_STATS_BY_TABLE.OBJECT_SCHEMA;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return X$innodbBufferStatsByTable.X$INNODB_BUFFER_STATS_BY_TABLE.OBJECT_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<BigInteger> field3() {
        return X$innodbBufferStatsByTable.X$INNODB_BUFFER_STATS_BY_TABLE.ALLOCATED;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<BigInteger> field4() {
        return X$innodbBufferStatsByTable.X$INNODB_BUFFER_STATS_BY_TABLE.DATA;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field5() {
        return X$innodbBufferStatsByTable.X$INNODB_BUFFER_STATS_BY_TABLE.PAGES;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field6() {
        return X$innodbBufferStatsByTable.X$INNODB_BUFFER_STATS_BY_TABLE.PAGES_HASHED;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field7() {
        return X$innodbBufferStatsByTable.X$INNODB_BUFFER_STATS_BY_TABLE.PAGES_OLD;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<BigInteger> field8() {
        return X$innodbBufferStatsByTable.X$INNODB_BUFFER_STATS_BY_TABLE.ROWS_CACHED;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component1() {
        return getObjectSchema();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getObjectName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigInteger component3() {
        return getAllocated();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigInteger component4() {
        return getData();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component5() {
        return getPages();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component6() {
        return getPagesHashed();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component7() {
        return getPagesOld();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigInteger component8() {
        return getRowsCached();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value1() {
        return getObjectSchema();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getObjectName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigInteger value3() {
        return getAllocated();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigInteger value4() {
        return getData();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value5() {
        return getPages();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value6() {
        return getPagesHashed();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value7() {
        return getPagesOld();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigInteger value8() {
        return getRowsCached();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X$innodbBufferStatsByTableRecord value1(String value) {
        setObjectSchema(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X$innodbBufferStatsByTableRecord value2(String value) {
        setObjectName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X$innodbBufferStatsByTableRecord value3(BigInteger value) {
        setAllocated(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X$innodbBufferStatsByTableRecord value4(BigInteger value) {
        setData(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X$innodbBufferStatsByTableRecord value5(Long value) {
        setPages(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X$innodbBufferStatsByTableRecord value6(Long value) {
        setPagesHashed(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X$innodbBufferStatsByTableRecord value7(Long value) {
        setPagesOld(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X$innodbBufferStatsByTableRecord value8(BigInteger value) {
        setRowsCached(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X$innodbBufferStatsByTableRecord values(String value1, String value2, BigInteger value3, BigInteger value4, Long value5, Long value6, Long value7, BigInteger value8) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached X$innodbBufferStatsByTableRecord
     */
    public X$innodbBufferStatsByTableRecord() {
        super(X$innodbBufferStatsByTable.X$INNODB_BUFFER_STATS_BY_TABLE);
    }

    /**
     * Create a detached, initialised X$innodbBufferStatsByTableRecord
     */
    public X$innodbBufferStatsByTableRecord(String objectSchema, String objectName, BigInteger allocated, BigInteger data, Long pages, Long pagesHashed, Long pagesOld, BigInteger rowsCached) {
        super(X$innodbBufferStatsByTable.X$INNODB_BUFFER_STATS_BY_TABLE);

        set(0, objectSchema);
        set(1, objectName);
        set(2, allocated);
        set(3, data);
        set(4, pages);
        set(5, pagesHashed);
        set(6, pagesOld);
        set(7, rowsCached);
    }
}
