/*
 * This file is generated by jOOQ.
 */
package jooq.performance_schema.tables.records;


import javax.annotation.Generated;

import jooq.performance_schema.tables.MemorySummaryByAccountByEventName;

import org.jooq.Field;
import org.jooq.Record13;
import org.jooq.Row13;
import org.jooq.impl.TableRecordImpl;
import org.jooq.types.ULong;


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
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class MemorySummaryByAccountByEventNameRecord extends TableRecordImpl<MemorySummaryByAccountByEventNameRecord> implements Record13<String, String, String, ULong, ULong, ULong, ULong, Long, Long, Long, Long, Long, Long> {

    private static final long serialVersionUID = 1362112562;

    /**
     * Setter for <code>performance_schema.memory_summary_by_account_by_event_name.USER</code>.
     */
    public void setUser(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>performance_schema.memory_summary_by_account_by_event_name.USER</code>.
     */
    public String getUser() {
        return (String) get(0);
    }

    /**
     * Setter for <code>performance_schema.memory_summary_by_account_by_event_name.HOST</code>.
     */
    public void setHost(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>performance_schema.memory_summary_by_account_by_event_name.HOST</code>.
     */
    public String getHost() {
        return (String) get(1);
    }

    /**
     * Setter for <code>performance_schema.memory_summary_by_account_by_event_name.EVENT_NAME</code>.
     */
    public void setEventName(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>performance_schema.memory_summary_by_account_by_event_name.EVENT_NAME</code>.
     */
    public String getEventName() {
        return (String) get(2);
    }

    /**
     * Setter for <code>performance_schema.memory_summary_by_account_by_event_name.COUNT_ALLOC</code>.
     */
    public void setCountAlloc(ULong value) {
        set(3, value);
    }

    /**
     * Getter for <code>performance_schema.memory_summary_by_account_by_event_name.COUNT_ALLOC</code>.
     */
    public ULong getCountAlloc() {
        return (ULong) get(3);
    }

    /**
     * Setter for <code>performance_schema.memory_summary_by_account_by_event_name.COUNT_FREE</code>.
     */
    public void setCountFree(ULong value) {
        set(4, value);
    }

    /**
     * Getter for <code>performance_schema.memory_summary_by_account_by_event_name.COUNT_FREE</code>.
     */
    public ULong getCountFree() {
        return (ULong) get(4);
    }

    /**
     * Setter for <code>performance_schema.memory_summary_by_account_by_event_name.SUM_NUMBER_OF_BYTES_ALLOC</code>.
     */
    public void setSumNumberOfBytesAlloc(ULong value) {
        set(5, value);
    }

    /**
     * Getter for <code>performance_schema.memory_summary_by_account_by_event_name.SUM_NUMBER_OF_BYTES_ALLOC</code>.
     */
    public ULong getSumNumberOfBytesAlloc() {
        return (ULong) get(5);
    }

    /**
     * Setter for <code>performance_schema.memory_summary_by_account_by_event_name.SUM_NUMBER_OF_BYTES_FREE</code>.
     */
    public void setSumNumberOfBytesFree(ULong value) {
        set(6, value);
    }

    /**
     * Getter for <code>performance_schema.memory_summary_by_account_by_event_name.SUM_NUMBER_OF_BYTES_FREE</code>.
     */
    public ULong getSumNumberOfBytesFree() {
        return (ULong) get(6);
    }

    /**
     * Setter for <code>performance_schema.memory_summary_by_account_by_event_name.LOW_COUNT_USED</code>.
     */
    public void setLowCountUsed(Long value) {
        set(7, value);
    }

    /**
     * Getter for <code>performance_schema.memory_summary_by_account_by_event_name.LOW_COUNT_USED</code>.
     */
    public Long getLowCountUsed() {
        return (Long) get(7);
    }

    /**
     * Setter for <code>performance_schema.memory_summary_by_account_by_event_name.CURRENT_COUNT_USED</code>.
     */
    public void setCurrentCountUsed(Long value) {
        set(8, value);
    }

    /**
     * Getter for <code>performance_schema.memory_summary_by_account_by_event_name.CURRENT_COUNT_USED</code>.
     */
    public Long getCurrentCountUsed() {
        return (Long) get(8);
    }

    /**
     * Setter for <code>performance_schema.memory_summary_by_account_by_event_name.HIGH_COUNT_USED</code>.
     */
    public void setHighCountUsed(Long value) {
        set(9, value);
    }

    /**
     * Getter for <code>performance_schema.memory_summary_by_account_by_event_name.HIGH_COUNT_USED</code>.
     */
    public Long getHighCountUsed() {
        return (Long) get(9);
    }

    /**
     * Setter for <code>performance_schema.memory_summary_by_account_by_event_name.LOW_NUMBER_OF_BYTES_USED</code>.
     */
    public void setLowNumberOfBytesUsed(Long value) {
        set(10, value);
    }

    /**
     * Getter for <code>performance_schema.memory_summary_by_account_by_event_name.LOW_NUMBER_OF_BYTES_USED</code>.
     */
    public Long getLowNumberOfBytesUsed() {
        return (Long) get(10);
    }

    /**
     * Setter for <code>performance_schema.memory_summary_by_account_by_event_name.CURRENT_NUMBER_OF_BYTES_USED</code>.
     */
    public void setCurrentNumberOfBytesUsed(Long value) {
        set(11, value);
    }

    /**
     * Getter for <code>performance_schema.memory_summary_by_account_by_event_name.CURRENT_NUMBER_OF_BYTES_USED</code>.
     */
    public Long getCurrentNumberOfBytesUsed() {
        return (Long) get(11);
    }

    /**
     * Setter for <code>performance_schema.memory_summary_by_account_by_event_name.HIGH_NUMBER_OF_BYTES_USED</code>.
     */
    public void setHighNumberOfBytesUsed(Long value) {
        set(12, value);
    }

    /**
     * Getter for <code>performance_schema.memory_summary_by_account_by_event_name.HIGH_NUMBER_OF_BYTES_USED</code>.
     */
    public Long getHighNumberOfBytesUsed() {
        return (Long) get(12);
    }

    // -------------------------------------------------------------------------
    // Record13 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row13<String, String, String, ULong, ULong, ULong, ULong, Long, Long, Long, Long, Long, Long> fieldsRow() {
        return (Row13) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row13<String, String, String, ULong, ULong, ULong, ULong, Long, Long, Long, Long, Long, Long> valuesRow() {
        return (Row13) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return MemorySummaryByAccountByEventName.MEMORY_SUMMARY_BY_ACCOUNT_BY_EVENT_NAME.USER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return MemorySummaryByAccountByEventName.MEMORY_SUMMARY_BY_ACCOUNT_BY_EVENT_NAME.HOST;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return MemorySummaryByAccountByEventName.MEMORY_SUMMARY_BY_ACCOUNT_BY_EVENT_NAME.EVENT_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<ULong> field4() {
        return MemorySummaryByAccountByEventName.MEMORY_SUMMARY_BY_ACCOUNT_BY_EVENT_NAME.COUNT_ALLOC;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<ULong> field5() {
        return MemorySummaryByAccountByEventName.MEMORY_SUMMARY_BY_ACCOUNT_BY_EVENT_NAME.COUNT_FREE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<ULong> field6() {
        return MemorySummaryByAccountByEventName.MEMORY_SUMMARY_BY_ACCOUNT_BY_EVENT_NAME.SUM_NUMBER_OF_BYTES_ALLOC;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<ULong> field7() {
        return MemorySummaryByAccountByEventName.MEMORY_SUMMARY_BY_ACCOUNT_BY_EVENT_NAME.SUM_NUMBER_OF_BYTES_FREE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field8() {
        return MemorySummaryByAccountByEventName.MEMORY_SUMMARY_BY_ACCOUNT_BY_EVENT_NAME.LOW_COUNT_USED;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field9() {
        return MemorySummaryByAccountByEventName.MEMORY_SUMMARY_BY_ACCOUNT_BY_EVENT_NAME.CURRENT_COUNT_USED;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field10() {
        return MemorySummaryByAccountByEventName.MEMORY_SUMMARY_BY_ACCOUNT_BY_EVENT_NAME.HIGH_COUNT_USED;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field11() {
        return MemorySummaryByAccountByEventName.MEMORY_SUMMARY_BY_ACCOUNT_BY_EVENT_NAME.LOW_NUMBER_OF_BYTES_USED;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field12() {
        return MemorySummaryByAccountByEventName.MEMORY_SUMMARY_BY_ACCOUNT_BY_EVENT_NAME.CURRENT_NUMBER_OF_BYTES_USED;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field13() {
        return MemorySummaryByAccountByEventName.MEMORY_SUMMARY_BY_ACCOUNT_BY_EVENT_NAME.HIGH_NUMBER_OF_BYTES_USED;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component1() {
        return getUser();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getHost();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getEventName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong component4() {
        return getCountAlloc();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong component5() {
        return getCountFree();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong component6() {
        return getSumNumberOfBytesAlloc();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong component7() {
        return getSumNumberOfBytesFree();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component8() {
        return getLowCountUsed();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component9() {
        return getCurrentCountUsed();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component10() {
        return getHighCountUsed();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component11() {
        return getLowNumberOfBytesUsed();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component12() {
        return getCurrentNumberOfBytesUsed();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component13() {
        return getHighNumberOfBytesUsed();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value1() {
        return getUser();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getHost();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getEventName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong value4() {
        return getCountAlloc();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong value5() {
        return getCountFree();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong value6() {
        return getSumNumberOfBytesAlloc();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong value7() {
        return getSumNumberOfBytesFree();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value8() {
        return getLowCountUsed();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value9() {
        return getCurrentCountUsed();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value10() {
        return getHighCountUsed();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value11() {
        return getLowNumberOfBytesUsed();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value12() {
        return getCurrentNumberOfBytesUsed();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value13() {
        return getHighNumberOfBytesUsed();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MemorySummaryByAccountByEventNameRecord value1(String value) {
        setUser(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MemorySummaryByAccountByEventNameRecord value2(String value) {
        setHost(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MemorySummaryByAccountByEventNameRecord value3(String value) {
        setEventName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MemorySummaryByAccountByEventNameRecord value4(ULong value) {
        setCountAlloc(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MemorySummaryByAccountByEventNameRecord value5(ULong value) {
        setCountFree(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MemorySummaryByAccountByEventNameRecord value6(ULong value) {
        setSumNumberOfBytesAlloc(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MemorySummaryByAccountByEventNameRecord value7(ULong value) {
        setSumNumberOfBytesFree(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MemorySummaryByAccountByEventNameRecord value8(Long value) {
        setLowCountUsed(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MemorySummaryByAccountByEventNameRecord value9(Long value) {
        setCurrentCountUsed(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MemorySummaryByAccountByEventNameRecord value10(Long value) {
        setHighCountUsed(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MemorySummaryByAccountByEventNameRecord value11(Long value) {
        setLowNumberOfBytesUsed(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MemorySummaryByAccountByEventNameRecord value12(Long value) {
        setCurrentNumberOfBytesUsed(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MemorySummaryByAccountByEventNameRecord value13(Long value) {
        setHighNumberOfBytesUsed(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MemorySummaryByAccountByEventNameRecord values(String value1, String value2, String value3, ULong value4, ULong value5, ULong value6, ULong value7, Long value8, Long value9, Long value10, Long value11, Long value12, Long value13) {
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
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached MemorySummaryByAccountByEventNameRecord
     */
    public MemorySummaryByAccountByEventNameRecord() {
        super(MemorySummaryByAccountByEventName.MEMORY_SUMMARY_BY_ACCOUNT_BY_EVENT_NAME);
    }

    /**
     * Create a detached, initialised MemorySummaryByAccountByEventNameRecord
     */
    public MemorySummaryByAccountByEventNameRecord(String user, String host, String eventName, ULong countAlloc, ULong countFree, ULong sumNumberOfBytesAlloc, ULong sumNumberOfBytesFree, Long lowCountUsed, Long currentCountUsed, Long highCountUsed, Long lowNumberOfBytesUsed, Long currentNumberOfBytesUsed, Long highNumberOfBytesUsed) {
        super(MemorySummaryByAccountByEventName.MEMORY_SUMMARY_BY_ACCOUNT_BY_EVENT_NAME);

        set(0, user);
        set(1, host);
        set(2, eventName);
        set(3, countAlloc);
        set(4, countFree);
        set(5, sumNumberOfBytesAlloc);
        set(6, sumNumberOfBytesFree);
        set(7, lowCountUsed);
        set(8, currentCountUsed);
        set(9, highCountUsed);
        set(10, lowNumberOfBytesUsed);
        set(11, currentNumberOfBytesUsed);
        set(12, highNumberOfBytesUsed);
    }
}
