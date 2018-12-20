/*
 * This file is generated by jOOQ.
 */
package jooq.sys.tables.records;


import jooq.sys.tables.X$waitClassesGlobalByLatency;
import org.jooq.Field;
import org.jooq.Record6;
import org.jooq.Row6;
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
                "jOOQ version:3.11.2"
        },
        comments = "This class is generated by jOOQ"
)
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class X$waitClassesGlobalByLatencyRecord extends TableRecordImpl<X$waitClassesGlobalByLatencyRecord> implements Record6<String, BigInteger, BigInteger, ULong, BigDecimal, ULong> {

    private static final long serialVersionUID = -522294946;

    /**
     * Create a detached X$waitClassesGlobalByLatencyRecord
     */
    public X$waitClassesGlobalByLatencyRecord() {
        super(X$waitClassesGlobalByLatency.X$WAIT_CLASSES_GLOBAL_BY_LATENCY);
    }

    /**
     * Create a detached, initialised X$waitClassesGlobalByLatencyRecord
     */
    public X$waitClassesGlobalByLatencyRecord(String eventClass, BigInteger total, BigInteger totalLatency, ULong minLatency, BigDecimal avgLatency, ULong maxLatency) {
        super(X$waitClassesGlobalByLatency.X$WAIT_CLASSES_GLOBAL_BY_LATENCY);

        set(0, eventClass);
        set(1, total);
        set(2, totalLatency);
        set(3, minLatency);
        set(4, avgLatency);
        set(5, maxLatency);
    }

    /**
     * Getter for <code>sys.x$wait_classes_global_by_latency.event_class</code>.
     */
    public String getEventClass() {
        return (String) get(0);
    }

    /**
     * Setter for <code>sys.x$wait_classes_global_by_latency.event_class</code>.
     */
    public void setEventClass(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>sys.x$wait_classes_global_by_latency.total</code>.
     */
    public BigInteger getTotal() {
        return (BigInteger) get(1);
    }

    /**
     * Setter for <code>sys.x$wait_classes_global_by_latency.total</code>.
     */
    public void setTotal(BigInteger value) {
        set(1, value);
    }

    /**
     * Getter for <code>sys.x$wait_classes_global_by_latency.total_latency</code>.
     */
    public BigInteger getTotalLatency() {
        return (BigInteger) get(2);
    }

    /**
     * Setter for <code>sys.x$wait_classes_global_by_latency.total_latency</code>.
     */
    public void setTotalLatency(BigInteger value) {
        set(2, value);
    }

    /**
     * Getter for <code>sys.x$wait_classes_global_by_latency.min_latency</code>.
     */
    public ULong getMinLatency() {
        return (ULong) get(3);
    }

    /**
     * Setter for <code>sys.x$wait_classes_global_by_latency.min_latency</code>.
     */
    public void setMinLatency(ULong value) {
        set(3, value);
    }

    /**
     * Getter for <code>sys.x$wait_classes_global_by_latency.avg_latency</code>.
     */
    public BigDecimal getAvgLatency() {
        return (BigDecimal) get(4);
    }

    /**
     * Setter for <code>sys.x$wait_classes_global_by_latency.avg_latency</code>.
     */
    public void setAvgLatency(BigDecimal value) {
        set(4, value);
    }

    // -------------------------------------------------------------------------
    // Record6 type implementation
    // -------------------------------------------------------------------------

    /**
     * Getter for <code>sys.x$wait_classes_global_by_latency.max_latency</code>.
     */
    public ULong getMaxLatency() {
        return (ULong) get(5);
    }

    /**
     * Setter for <code>sys.x$wait_classes_global_by_latency.max_latency</code>.
     */
    public void setMaxLatency(ULong value) {
        set(5, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row6<String, BigInteger, BigInteger, ULong, BigDecimal, ULong> fieldsRow() {
        return (Row6) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row6<String, BigInteger, BigInteger, ULong, BigDecimal, ULong> valuesRow() {
        return (Row6) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return X$waitClassesGlobalByLatency.X$WAIT_CLASSES_GLOBAL_BY_LATENCY.EVENT_CLASS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<BigInteger> field2() {
        return X$waitClassesGlobalByLatency.X$WAIT_CLASSES_GLOBAL_BY_LATENCY.TOTAL;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<BigInteger> field3() {
        return X$waitClassesGlobalByLatency.X$WAIT_CLASSES_GLOBAL_BY_LATENCY.TOTAL_LATENCY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<ULong> field4() {
        return X$waitClassesGlobalByLatency.X$WAIT_CLASSES_GLOBAL_BY_LATENCY.MIN_LATENCY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<BigDecimal> field5() {
        return X$waitClassesGlobalByLatency.X$WAIT_CLASSES_GLOBAL_BY_LATENCY.AVG_LATENCY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<ULong> field6() {
        return X$waitClassesGlobalByLatency.X$WAIT_CLASSES_GLOBAL_BY_LATENCY.MAX_LATENCY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component1() {
        return getEventClass();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigInteger component2() {
        return getTotal();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigInteger component3() {
        return getTotalLatency();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong component4() {
        return getMinLatency();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal component5() {
        return getAvgLatency();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong component6() {
        return getMaxLatency();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value1() {
        return getEventClass();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigInteger value2() {
        return getTotal();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigInteger value3() {
        return getTotalLatency();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong value4() {
        return getMinLatency();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal value5() {
        return getAvgLatency();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong value6() {
        return getMaxLatency();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X$waitClassesGlobalByLatencyRecord value1(String value) {
        setEventClass(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X$waitClassesGlobalByLatencyRecord value2(BigInteger value) {
        setTotal(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X$waitClassesGlobalByLatencyRecord value3(BigInteger value) {
        setTotalLatency(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X$waitClassesGlobalByLatencyRecord value4(ULong value) {
        setMinLatency(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X$waitClassesGlobalByLatencyRecord value5(BigDecimal value) {
        setAvgLatency(value);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public X$waitClassesGlobalByLatencyRecord value6(ULong value) {
        setMaxLatency(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X$waitClassesGlobalByLatencyRecord values(String value1, BigInteger value2, BigInteger value3, ULong value4, BigDecimal value5, ULong value6) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        return this;
    }
}
