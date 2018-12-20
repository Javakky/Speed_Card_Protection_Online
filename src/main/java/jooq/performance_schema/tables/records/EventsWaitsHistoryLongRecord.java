/*
 * This file is generated by jOOQ.
 */
package jooq.performance_schema.tables.records;


import jooq.performance_schema.enums.EventsWaitsHistoryLongNestingEventType;
import jooq.performance_schema.tables.EventsWaitsHistoryLong;
import org.jooq.Field;
import org.jooq.Record19;
import org.jooq.Row19;
import org.jooq.impl.TableRecordImpl;
import org.jooq.types.UInteger;
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
public class EventsWaitsHistoryLongRecord extends TableRecordImpl<EventsWaitsHistoryLongRecord> implements Record19<ULong, ULong, ULong, String, String, ULong, ULong, ULong, UInteger, String, String, String, String, ULong, ULong, EventsWaitsHistoryLongNestingEventType, String, Long, UInteger> {

    private static final long serialVersionUID = -280462223;

    /**
     * Create a detached EventsWaitsHistoryLongRecord
     */
    public EventsWaitsHistoryLongRecord() {
        super(EventsWaitsHistoryLong.EVENTS_WAITS_HISTORY_LONG);
    }

    /**
     * Create a detached, initialised EventsWaitsHistoryLongRecord
     */
    public EventsWaitsHistoryLongRecord(ULong threadId, ULong eventId, ULong endEventId, String eventName, String source, ULong timerStart, ULong timerEnd, ULong timerWait, UInteger spins, String objectSchema, String objectName, String indexName, String objectType, ULong objectInstanceBegin, ULong nestingEventId, EventsWaitsHistoryLongNestingEventType nestingEventType, String operation, Long numberOfBytes, UInteger flags) {
        super(EventsWaitsHistoryLong.EVENTS_WAITS_HISTORY_LONG);

        set(0, threadId);
        set(1, eventId);
        set(2, endEventId);
        set(3, eventName);
        set(4, source);
        set(5, timerStart);
        set(6, timerEnd);
        set(7, timerWait);
        set(8, spins);
        set(9, objectSchema);
        set(10, objectName);
        set(11, indexName);
        set(12, objectType);
        set(13, objectInstanceBegin);
        set(14, nestingEventId);
        set(15, nestingEventType);
        set(16, operation);
        set(17, numberOfBytes);
        set(18, flags);
    }

    /**
     * Getter for <code>performance_schema.events_waits_history_long.THREAD_ID</code>.
     */
    public ULong getThreadId() {
        return (ULong) get(0);
    }

    /**
     * Setter for <code>performance_schema.events_waits_history_long.THREAD_ID</code>.
     */
    public void setThreadId(ULong value) {
        set(0, value);
    }

    /**
     * Getter for <code>performance_schema.events_waits_history_long.EVENT_ID</code>.
     */
    public ULong getEventId() {
        return (ULong) get(1);
    }

    /**
     * Setter for <code>performance_schema.events_waits_history_long.EVENT_ID</code>.
     */
    public void setEventId(ULong value) {
        set(1, value);
    }

    /**
     * Getter for <code>performance_schema.events_waits_history_long.END_EVENT_ID</code>.
     */
    public ULong getEndEventId() {
        return (ULong) get(2);
    }

    /**
     * Setter for <code>performance_schema.events_waits_history_long.END_EVENT_ID</code>.
     */
    public void setEndEventId(ULong value) {
        set(2, value);
    }

    /**
     * Getter for <code>performance_schema.events_waits_history_long.EVENT_NAME</code>.
     */
    public String getEventName() {
        return (String) get(3);
    }

    /**
     * Setter for <code>performance_schema.events_waits_history_long.EVENT_NAME</code>.
     */
    public void setEventName(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>performance_schema.events_waits_history_long.SOURCE</code>.
     */
    public String getSource() {
        return (String) get(4);
    }

    /**
     * Setter for <code>performance_schema.events_waits_history_long.SOURCE</code>.
     */
    public void setSource(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>performance_schema.events_waits_history_long.TIMER_START</code>.
     */
    public ULong getTimerStart() {
        return (ULong) get(5);
    }

    /**
     * Setter for <code>performance_schema.events_waits_history_long.TIMER_START</code>.
     */
    public void setTimerStart(ULong value) {
        set(5, value);
    }

    /**
     * Getter for <code>performance_schema.events_waits_history_long.TIMER_END</code>.
     */
    public ULong getTimerEnd() {
        return (ULong) get(6);
    }

    /**
     * Setter for <code>performance_schema.events_waits_history_long.TIMER_END</code>.
     */
    public void setTimerEnd(ULong value) {
        set(6, value);
    }

    /**
     * Getter for <code>performance_schema.events_waits_history_long.TIMER_WAIT</code>.
     */
    public ULong getTimerWait() {
        return (ULong) get(7);
    }

    /**
     * Setter for <code>performance_schema.events_waits_history_long.TIMER_WAIT</code>.
     */
    public void setTimerWait(ULong value) {
        set(7, value);
    }

    /**
     * Getter for <code>performance_schema.events_waits_history_long.SPINS</code>.
     */
    public UInteger getSpins() {
        return (UInteger) get(8);
    }

    /**
     * Setter for <code>performance_schema.events_waits_history_long.SPINS</code>.
     */
    public void setSpins(UInteger value) {
        set(8, value);
    }

    /**
     * Getter for <code>performance_schema.events_waits_history_long.OBJECT_SCHEMA</code>.
     */
    public String getObjectSchema() {
        return (String) get(9);
    }

    /**
     * Setter for <code>performance_schema.events_waits_history_long.OBJECT_SCHEMA</code>.
     */
    public void setObjectSchema(String value) {
        set(9, value);
    }

    /**
     * Getter for <code>performance_schema.events_waits_history_long.OBJECT_NAME</code>.
     */
    public String getObjectName() {
        return (String) get(10);
    }

    /**
     * Setter for <code>performance_schema.events_waits_history_long.OBJECT_NAME</code>.
     */
    public void setObjectName(String value) {
        set(10, value);
    }

    /**
     * Getter for <code>performance_schema.events_waits_history_long.INDEX_NAME</code>.
     */
    public String getIndexName() {
        return (String) get(11);
    }

    /**
     * Setter for <code>performance_schema.events_waits_history_long.INDEX_NAME</code>.
     */
    public void setIndexName(String value) {
        set(11, value);
    }

    /**
     * Getter for <code>performance_schema.events_waits_history_long.OBJECT_TYPE</code>.
     */
    public String getObjectType() {
        return (String) get(12);
    }

    /**
     * Setter for <code>performance_schema.events_waits_history_long.OBJECT_TYPE</code>.
     */
    public void setObjectType(String value) {
        set(12, value);
    }

    /**
     * Getter for <code>performance_schema.events_waits_history_long.OBJECT_INSTANCE_BEGIN</code>.
     */
    public ULong getObjectInstanceBegin() {
        return (ULong) get(13);
    }

    /**
     * Setter for <code>performance_schema.events_waits_history_long.OBJECT_INSTANCE_BEGIN</code>.
     */
    public void setObjectInstanceBegin(ULong value) {
        set(13, value);
    }

    /**
     * Getter for <code>performance_schema.events_waits_history_long.NESTING_EVENT_ID</code>.
     */
    public ULong getNestingEventId() {
        return (ULong) get(14);
    }

    /**
     * Setter for <code>performance_schema.events_waits_history_long.NESTING_EVENT_ID</code>.
     */
    public void setNestingEventId(ULong value) {
        set(14, value);
    }

    /**
     * Getter for <code>performance_schema.events_waits_history_long.NESTING_EVENT_TYPE</code>.
     */
    public EventsWaitsHistoryLongNestingEventType getNestingEventType() {
        return (EventsWaitsHistoryLongNestingEventType) get(15);
    }

    /**
     * Setter for <code>performance_schema.events_waits_history_long.NESTING_EVENT_TYPE</code>.
     */
    public void setNestingEventType(EventsWaitsHistoryLongNestingEventType value) {
        set(15, value);
    }

    /**
     * Getter for <code>performance_schema.events_waits_history_long.OPERATION</code>.
     */
    public String getOperation() {
        return (String) get(16);
    }

    /**
     * Setter for <code>performance_schema.events_waits_history_long.OPERATION</code>.
     */
    public void setOperation(String value) {
        set(16, value);
    }

    /**
     * Getter for <code>performance_schema.events_waits_history_long.NUMBER_OF_BYTES</code>.
     */
    public Long getNumberOfBytes() {
        return (Long) get(17);
    }

    /**
     * Setter for <code>performance_schema.events_waits_history_long.NUMBER_OF_BYTES</code>.
     */
    public void setNumberOfBytes(Long value) {
        set(17, value);
    }

    // -------------------------------------------------------------------------
    // Record19 type implementation
    // -------------------------------------------------------------------------

    /**
     * Getter for <code>performance_schema.events_waits_history_long.FLAGS</code>.
     */
    public UInteger getFlags() {
        return (UInteger) get(18);
    }

    /**
     * Setter for <code>performance_schema.events_waits_history_long.FLAGS</code>.
     */
    public void setFlags(UInteger value) {
        set(18, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row19<ULong, ULong, ULong, String, String, ULong, ULong, ULong, UInteger, String, String, String, String, ULong, ULong, EventsWaitsHistoryLongNestingEventType, String, Long, UInteger> fieldsRow() {
        return (Row19) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row19<ULong, ULong, ULong, String, String, ULong, ULong, ULong, UInteger, String, String, String, String, ULong, ULong, EventsWaitsHistoryLongNestingEventType, String, Long, UInteger> valuesRow() {
        return (Row19) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<ULong> field1() {
        return EventsWaitsHistoryLong.EVENTS_WAITS_HISTORY_LONG.THREAD_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<ULong> field2() {
        return EventsWaitsHistoryLong.EVENTS_WAITS_HISTORY_LONG.EVENT_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<ULong> field3() {
        return EventsWaitsHistoryLong.EVENTS_WAITS_HISTORY_LONG.END_EVENT_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return EventsWaitsHistoryLong.EVENTS_WAITS_HISTORY_LONG.EVENT_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return EventsWaitsHistoryLong.EVENTS_WAITS_HISTORY_LONG.SOURCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<ULong> field6() {
        return EventsWaitsHistoryLong.EVENTS_WAITS_HISTORY_LONG.TIMER_START;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<ULong> field7() {
        return EventsWaitsHistoryLong.EVENTS_WAITS_HISTORY_LONG.TIMER_END;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<ULong> field8() {
        return EventsWaitsHistoryLong.EVENTS_WAITS_HISTORY_LONG.TIMER_WAIT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<UInteger> field9() {
        return EventsWaitsHistoryLong.EVENTS_WAITS_HISTORY_LONG.SPINS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field10() {
        return EventsWaitsHistoryLong.EVENTS_WAITS_HISTORY_LONG.OBJECT_SCHEMA;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field11() {
        return EventsWaitsHistoryLong.EVENTS_WAITS_HISTORY_LONG.OBJECT_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field12() {
        return EventsWaitsHistoryLong.EVENTS_WAITS_HISTORY_LONG.INDEX_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field13() {
        return EventsWaitsHistoryLong.EVENTS_WAITS_HISTORY_LONG.OBJECT_TYPE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<ULong> field14() {
        return EventsWaitsHistoryLong.EVENTS_WAITS_HISTORY_LONG.OBJECT_INSTANCE_BEGIN;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<ULong> field15() {
        return EventsWaitsHistoryLong.EVENTS_WAITS_HISTORY_LONG.NESTING_EVENT_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<EventsWaitsHistoryLongNestingEventType> field16() {
        return EventsWaitsHistoryLong.EVENTS_WAITS_HISTORY_LONG.NESTING_EVENT_TYPE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field17() {
        return EventsWaitsHistoryLong.EVENTS_WAITS_HISTORY_LONG.OPERATION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field18() {
        return EventsWaitsHistoryLong.EVENTS_WAITS_HISTORY_LONG.NUMBER_OF_BYTES;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<UInteger> field19() {
        return EventsWaitsHistoryLong.EVENTS_WAITS_HISTORY_LONG.FLAGS;
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
    public ULong component2() {
        return getEventId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong component3() {
        return getEndEventId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getEventName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component5() {
        return getSource();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong component6() {
        return getTimerStart();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong component7() {
        return getTimerEnd();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong component8() {
        return getTimerWait();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UInteger component9() {
        return getSpins();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component10() {
        return getObjectSchema();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component11() {
        return getObjectName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component12() {
        return getIndexName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component13() {
        return getObjectType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong component14() {
        return getObjectInstanceBegin();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong component15() {
        return getNestingEventId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EventsWaitsHistoryLongNestingEventType component16() {
        return getNestingEventType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component17() {
        return getOperation();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component18() {
        return getNumberOfBytes();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UInteger component19() {
        return getFlags();
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
    public ULong value2() {
        return getEventId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong value3() {
        return getEndEventId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getEventName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getSource();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong value6() {
        return getTimerStart();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong value7() {
        return getTimerEnd();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong value8() {
        return getTimerWait();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UInteger value9() {
        return getSpins();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value10() {
        return getObjectSchema();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value11() {
        return getObjectName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value12() {
        return getIndexName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value13() {
        return getObjectType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong value14() {
        return getObjectInstanceBegin();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong value15() {
        return getNestingEventId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EventsWaitsHistoryLongNestingEventType value16() {
        return getNestingEventType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value17() {
        return getOperation();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value18() {
        return getNumberOfBytes();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UInteger value19() {
        return getFlags();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EventsWaitsHistoryLongRecord value1(ULong value) {
        setThreadId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EventsWaitsHistoryLongRecord value2(ULong value) {
        setEventId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EventsWaitsHistoryLongRecord value3(ULong value) {
        setEndEventId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EventsWaitsHistoryLongRecord value4(String value) {
        setEventName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EventsWaitsHistoryLongRecord value5(String value) {
        setSource(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EventsWaitsHistoryLongRecord value6(ULong value) {
        setTimerStart(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EventsWaitsHistoryLongRecord value7(ULong value) {
        setTimerEnd(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EventsWaitsHistoryLongRecord value8(ULong value) {
        setTimerWait(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EventsWaitsHistoryLongRecord value9(UInteger value) {
        setSpins(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EventsWaitsHistoryLongRecord value10(String value) {
        setObjectSchema(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EventsWaitsHistoryLongRecord value11(String value) {
        setObjectName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EventsWaitsHistoryLongRecord value12(String value) {
        setIndexName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EventsWaitsHistoryLongRecord value13(String value) {
        setObjectType(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EventsWaitsHistoryLongRecord value14(ULong value) {
        setObjectInstanceBegin(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EventsWaitsHistoryLongRecord value15(ULong value) {
        setNestingEventId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EventsWaitsHistoryLongRecord value16(EventsWaitsHistoryLongNestingEventType value) {
        setNestingEventType(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EventsWaitsHistoryLongRecord value17(String value) {
        setOperation(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EventsWaitsHistoryLongRecord value18(Long value) {
        setNumberOfBytes(value);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public EventsWaitsHistoryLongRecord value19(UInteger value) {
        setFlags(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EventsWaitsHistoryLongRecord values(ULong value1, ULong value2, ULong value3, String value4, String value5, ULong value6, ULong value7, ULong value8, UInteger value9, String value10, String value11, String value12, String value13, ULong value14, ULong value15, EventsWaitsHistoryLongNestingEventType value16, String value17, Long value18, UInteger value19) {
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
        value15(value15);
        value16(value16);
        value17(value17);
        value18(value18);
        value19(value19);
        return this;
    }
}
