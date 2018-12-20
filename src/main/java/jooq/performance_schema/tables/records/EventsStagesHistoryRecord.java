/*
 * This file is generated by jOOQ.
 */
package jooq.performance_schema.tables.records;


import jooq.performance_schema.enums.EventsStagesHistoryNestingEventType;
import jooq.performance_schema.tables.EventsStagesHistory;
import org.jooq.Field;
import org.jooq.Record12;
import org.jooq.Row12;
import org.jooq.impl.TableRecordImpl;
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
public class EventsStagesHistoryRecord extends TableRecordImpl<EventsStagesHistoryRecord> implements Record12<ULong, ULong, ULong, String, String, ULong, ULong, ULong, ULong, ULong, ULong, EventsStagesHistoryNestingEventType> {

    private static final long serialVersionUID = 843835368;

    /**
     * Create a detached EventsStagesHistoryRecord
     */
    public EventsStagesHistoryRecord() {
        super(EventsStagesHistory.EVENTS_STAGES_HISTORY);
    }

    /**
     * Create a detached, initialised EventsStagesHistoryRecord
     */
    public EventsStagesHistoryRecord(ULong threadId, ULong eventId, ULong endEventId, String eventName, String source, ULong timerStart, ULong timerEnd, ULong timerWait, ULong workCompleted, ULong workEstimated, ULong nestingEventId, EventsStagesHistoryNestingEventType nestingEventType) {
        super(EventsStagesHistory.EVENTS_STAGES_HISTORY);

        set(0, threadId);
        set(1, eventId);
        set(2, endEventId);
        set(3, eventName);
        set(4, source);
        set(5, timerStart);
        set(6, timerEnd);
        set(7, timerWait);
        set(8, workCompleted);
        set(9, workEstimated);
        set(10, nestingEventId);
        set(11, nestingEventType);
    }

    /**
     * Getter for <code>performance_schema.events_stages_history.THREAD_ID</code>.
     */
    public ULong getThreadId() {
        return (ULong) get(0);
    }

    /**
     * Setter for <code>performance_schema.events_stages_history.THREAD_ID</code>.
     */
    public void setThreadId(ULong value) {
        set(0, value);
    }

    /**
     * Getter for <code>performance_schema.events_stages_history.EVENT_ID</code>.
     */
    public ULong getEventId() {
        return (ULong) get(1);
    }

    /**
     * Setter for <code>performance_schema.events_stages_history.EVENT_ID</code>.
     */
    public void setEventId(ULong value) {
        set(1, value);
    }

    /**
     * Getter for <code>performance_schema.events_stages_history.END_EVENT_ID</code>.
     */
    public ULong getEndEventId() {
        return (ULong) get(2);
    }

    /**
     * Setter for <code>performance_schema.events_stages_history.END_EVENT_ID</code>.
     */
    public void setEndEventId(ULong value) {
        set(2, value);
    }

    /**
     * Getter for <code>performance_schema.events_stages_history.EVENT_NAME</code>.
     */
    public String getEventName() {
        return (String) get(3);
    }

    /**
     * Setter for <code>performance_schema.events_stages_history.EVENT_NAME</code>.
     */
    public void setEventName(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>performance_schema.events_stages_history.SOURCE</code>.
     */
    public String getSource() {
        return (String) get(4);
    }

    /**
     * Setter for <code>performance_schema.events_stages_history.SOURCE</code>.
     */
    public void setSource(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>performance_schema.events_stages_history.TIMER_START</code>.
     */
    public ULong getTimerStart() {
        return (ULong) get(5);
    }

    /**
     * Setter for <code>performance_schema.events_stages_history.TIMER_START</code>.
     */
    public void setTimerStart(ULong value) {
        set(5, value);
    }

    /**
     * Getter for <code>performance_schema.events_stages_history.TIMER_END</code>.
     */
    public ULong getTimerEnd() {
        return (ULong) get(6);
    }

    /**
     * Setter for <code>performance_schema.events_stages_history.TIMER_END</code>.
     */
    public void setTimerEnd(ULong value) {
        set(6, value);
    }

    /**
     * Getter for <code>performance_schema.events_stages_history.TIMER_WAIT</code>.
     */
    public ULong getTimerWait() {
        return (ULong) get(7);
    }

    /**
     * Setter for <code>performance_schema.events_stages_history.TIMER_WAIT</code>.
     */
    public void setTimerWait(ULong value) {
        set(7, value);
    }

    /**
     * Getter for <code>performance_schema.events_stages_history.WORK_COMPLETED</code>.
     */
    public ULong getWorkCompleted() {
        return (ULong) get(8);
    }

    /**
     * Setter for <code>performance_schema.events_stages_history.WORK_COMPLETED</code>.
     */
    public void setWorkCompleted(ULong value) {
        set(8, value);
    }

    /**
     * Getter for <code>performance_schema.events_stages_history.WORK_ESTIMATED</code>.
     */
    public ULong getWorkEstimated() {
        return (ULong) get(9);
    }

    /**
     * Setter for <code>performance_schema.events_stages_history.WORK_ESTIMATED</code>.
     */
    public void setWorkEstimated(ULong value) {
        set(9, value);
    }

    /**
     * Getter for <code>performance_schema.events_stages_history.NESTING_EVENT_ID</code>.
     */
    public ULong getNestingEventId() {
        return (ULong) get(10);
    }

    /**
     * Setter for <code>performance_schema.events_stages_history.NESTING_EVENT_ID</code>.
     */
    public void setNestingEventId(ULong value) {
        set(10, value);
    }

    // -------------------------------------------------------------------------
    // Record12 type implementation
    // -------------------------------------------------------------------------

    /**
     * Getter for <code>performance_schema.events_stages_history.NESTING_EVENT_TYPE</code>.
     */
    public EventsStagesHistoryNestingEventType getNestingEventType() {
        return (EventsStagesHistoryNestingEventType) get(11);
    }

    /**
     * Setter for <code>performance_schema.events_stages_history.NESTING_EVENT_TYPE</code>.
     */
    public void setNestingEventType(EventsStagesHistoryNestingEventType value) {
        set(11, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row12<ULong, ULong, ULong, String, String, ULong, ULong, ULong, ULong, ULong, ULong, EventsStagesHistoryNestingEventType> fieldsRow() {
        return (Row12) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row12<ULong, ULong, ULong, String, String, ULong, ULong, ULong, ULong, ULong, ULong, EventsStagesHistoryNestingEventType> valuesRow() {
        return (Row12) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<ULong> field1() {
        return EventsStagesHistory.EVENTS_STAGES_HISTORY.THREAD_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<ULong> field2() {
        return EventsStagesHistory.EVENTS_STAGES_HISTORY.EVENT_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<ULong> field3() {
        return EventsStagesHistory.EVENTS_STAGES_HISTORY.END_EVENT_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return EventsStagesHistory.EVENTS_STAGES_HISTORY.EVENT_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return EventsStagesHistory.EVENTS_STAGES_HISTORY.SOURCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<ULong> field6() {
        return EventsStagesHistory.EVENTS_STAGES_HISTORY.TIMER_START;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<ULong> field7() {
        return EventsStagesHistory.EVENTS_STAGES_HISTORY.TIMER_END;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<ULong> field8() {
        return EventsStagesHistory.EVENTS_STAGES_HISTORY.TIMER_WAIT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<ULong> field9() {
        return EventsStagesHistory.EVENTS_STAGES_HISTORY.WORK_COMPLETED;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<ULong> field10() {
        return EventsStagesHistory.EVENTS_STAGES_HISTORY.WORK_ESTIMATED;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<ULong> field11() {
        return EventsStagesHistory.EVENTS_STAGES_HISTORY.NESTING_EVENT_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<EventsStagesHistoryNestingEventType> field12() {
        return EventsStagesHistory.EVENTS_STAGES_HISTORY.NESTING_EVENT_TYPE;
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
    public ULong component9() {
        return getWorkCompleted();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong component10() {
        return getWorkEstimated();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong component11() {
        return getNestingEventId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EventsStagesHistoryNestingEventType component12() {
        return getNestingEventType();
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
    public ULong value9() {
        return getWorkCompleted();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong value10() {
        return getWorkEstimated();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong value11() {
        return getNestingEventId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EventsStagesHistoryNestingEventType value12() {
        return getNestingEventType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EventsStagesHistoryRecord value1(ULong value) {
        setThreadId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EventsStagesHistoryRecord value2(ULong value) {
        setEventId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EventsStagesHistoryRecord value3(ULong value) {
        setEndEventId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EventsStagesHistoryRecord value4(String value) {
        setEventName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EventsStagesHistoryRecord value5(String value) {
        setSource(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EventsStagesHistoryRecord value6(ULong value) {
        setTimerStart(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EventsStagesHistoryRecord value7(ULong value) {
        setTimerEnd(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EventsStagesHistoryRecord value8(ULong value) {
        setTimerWait(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EventsStagesHistoryRecord value9(ULong value) {
        setWorkCompleted(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EventsStagesHistoryRecord value10(ULong value) {
        setWorkEstimated(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EventsStagesHistoryRecord value11(ULong value) {
        setNestingEventId(value);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public EventsStagesHistoryRecord value12(EventsStagesHistoryNestingEventType value) {
        setNestingEventType(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EventsStagesHistoryRecord values(ULong value1, ULong value2, ULong value3, String value4, String value5, ULong value6, ULong value7, ULong value8, ULong value9, ULong value10, ULong value11, EventsStagesHistoryNestingEventType value12) {
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
        return this;
    }
}
