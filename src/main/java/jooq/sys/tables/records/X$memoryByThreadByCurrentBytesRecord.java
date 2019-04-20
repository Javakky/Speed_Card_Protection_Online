/*
 * This file is generated by jOOQ.
 */
package jooq.sys.tables.records;


import jooq.sys.tables.X$memoryByThreadByCurrentBytes;
import org.jooq.Field;
import org.jooq.Record7;
import org.jooq.Row7;
import org.jooq.impl.TableRecordImpl;
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
public class X$memoryByThreadByCurrentBytesRecord extends TableRecordImpl<X$memoryByThreadByCurrentBytesRecord> implements Record7<ULong, String, BigInteger, BigInteger, BigDecimal, Long, BigInteger> {

    private static final long serialVersionUID = 2061070538;

    /**
     * Setter for <code>sys.x$memory_by_thread_by_current_bytes.thread_id</code>.
     */
    public void setThreadId(ULong value) {
        set(0, value);
    }

    /**
     * Getter for <code>sys.x$memory_by_thread_by_current_bytes.thread_id</code>.
     */
    public ULong getThreadId() {
        return (ULong) get(0);
    }

    /**
     * Setter for <code>sys.x$memory_by_thread_by_current_bytes.user</code>.
     */
    public void setUser(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>sys.x$memory_by_thread_by_current_bytes.user</code>.
     */
    public String getUser() {
        return (String) get(1);
    }

    /**
     * Setter for <code>sys.x$memory_by_thread_by_current_bytes.current_count_used</code>.
     */
    public void setCurrentCountUsed(BigInteger value) {
        set(2, value);
    }

    /**
     * Getter for <code>sys.x$memory_by_thread_by_current_bytes.current_count_used</code>.
     */
    public BigInteger getCurrentCountUsed() {
        return (BigInteger) get(2);
    }

    /**
     * Setter for <code>sys.x$memory_by_thread_by_current_bytes.current_allocated</code>.
     */
    public void setCurrentAllocated(BigInteger value) {
        set(3, value);
    }

    /**
     * Getter for <code>sys.x$memory_by_thread_by_current_bytes.current_allocated</code>.
     */
    public BigInteger getCurrentAllocated() {
        return (BigInteger) get(3);
    }

    /**
     * Setter for <code>sys.x$memory_by_thread_by_current_bytes.current_avg_alloc</code>.
     */
    public void setCurrentAvgAlloc(BigDecimal value) {
        set(4, value);
    }

    /**
     * Getter for <code>sys.x$memory_by_thread_by_current_bytes.current_avg_alloc</code>.
     */
    public BigDecimal getCurrentAvgAlloc() {
        return (BigDecimal) get(4);
    }

    /**
     * Setter for <code>sys.x$memory_by_thread_by_current_bytes.current_max_alloc</code>.
     */
    public void setCurrentMaxAlloc(Long value) {
        set(5, value);
    }

    /**
     * Getter for <code>sys.x$memory_by_thread_by_current_bytes.current_max_alloc</code>.
     */
    public Long getCurrentMaxAlloc() {
        return (Long) get(5);
    }

    /**
     * Setter for <code>sys.x$memory_by_thread_by_current_bytes.total_allocated</code>.
     */
    public void setTotalAllocated(BigInteger value) {
        set(6, value);
    }

    /**
     * Getter for <code>sys.x$memory_by_thread_by_current_bytes.total_allocated</code>.
     */
    public BigInteger getTotalAllocated() {
        return (BigInteger) get(6);
    }

    // -------------------------------------------------------------------------
    // Record7 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row7<ULong, String, BigInteger, BigInteger, BigDecimal, Long, BigInteger> fieldsRow() {
        return (Row7) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row7<ULong, String, BigInteger, BigInteger, BigDecimal, Long, BigInteger> valuesRow() {
        return (Row7) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<ULong> field1() {
        return X$memoryByThreadByCurrentBytes.X$MEMORY_BY_THREAD_BY_CURRENT_BYTES.THREAD_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return X$memoryByThreadByCurrentBytes.X$MEMORY_BY_THREAD_BY_CURRENT_BYTES.USER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<BigInteger> field3() {
        return X$memoryByThreadByCurrentBytes.X$MEMORY_BY_THREAD_BY_CURRENT_BYTES.CURRENT_COUNT_USED;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<BigInteger> field4() {
        return X$memoryByThreadByCurrentBytes.X$MEMORY_BY_THREAD_BY_CURRENT_BYTES.CURRENT_ALLOCATED;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<BigDecimal> field5() {
        return X$memoryByThreadByCurrentBytes.X$MEMORY_BY_THREAD_BY_CURRENT_BYTES.CURRENT_AVG_ALLOC;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field6() {
        return X$memoryByThreadByCurrentBytes.X$MEMORY_BY_THREAD_BY_CURRENT_BYTES.CURRENT_MAX_ALLOC;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<BigInteger> field7() {
        return X$memoryByThreadByCurrentBytes.X$MEMORY_BY_THREAD_BY_CURRENT_BYTES.TOTAL_ALLOCATED;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong component1() {
        return getThreadId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getUser();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigInteger component3() {
        return getCurrentCountUsed();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigInteger component4() {
        return getCurrentAllocated();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal component5() {
        return getCurrentAvgAlloc();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component6() {
        return getCurrentMaxAlloc();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigInteger component7() {
        return getTotalAllocated();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong value1() {
        return getThreadId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getUser();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigInteger value3() {
        return getCurrentCountUsed();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigInteger value4() {
        return getCurrentAllocated();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal value5() {
        return getCurrentAvgAlloc();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value6() {
        return getCurrentMaxAlloc();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigInteger value7() {
        return getTotalAllocated();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X$memoryByThreadByCurrentBytesRecord value1(ULong value) {
        setThreadId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X$memoryByThreadByCurrentBytesRecord value2(String value) {
        setUser(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X$memoryByThreadByCurrentBytesRecord value3(BigInteger value) {
        setCurrentCountUsed(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X$memoryByThreadByCurrentBytesRecord value4(BigInteger value) {
        setCurrentAllocated(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X$memoryByThreadByCurrentBytesRecord value5(BigDecimal value) {
        setCurrentAvgAlloc(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X$memoryByThreadByCurrentBytesRecord value6(Long value) {
        setCurrentMaxAlloc(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X$memoryByThreadByCurrentBytesRecord value7(BigInteger value) {
        setTotalAllocated(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X$memoryByThreadByCurrentBytesRecord values(ULong value1, String value2, BigInteger value3, BigInteger value4, BigDecimal value5, Long value6, BigInteger value7) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached X$memoryByThreadByCurrentBytesRecord
     */
    public X$memoryByThreadByCurrentBytesRecord() {
        super(X$memoryByThreadByCurrentBytes.X$MEMORY_BY_THREAD_BY_CURRENT_BYTES);
    }

    /**
     * Create a detached, initialised X$memoryByThreadByCurrentBytesRecord
     */
    public X$memoryByThreadByCurrentBytesRecord(ULong threadId, String user, BigInteger currentCountUsed, BigInteger currentAllocated, BigDecimal currentAvgAlloc, Long currentMaxAlloc, BigInteger totalAllocated) {
        super(X$memoryByThreadByCurrentBytes.X$MEMORY_BY_THREAD_BY_CURRENT_BYTES);

        set(0, threadId);
        set(1, user);
        set(2, currentCountUsed);
        set(3, currentAllocated);
        set(4, currentAvgAlloc);
        set(5, currentMaxAlloc);
        set(6, totalAllocated);
    }
}
