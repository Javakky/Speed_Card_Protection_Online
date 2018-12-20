/*
 * This file is generated by jOOQ.
 */
package jooq.sys.tables.records;


import jooq.sys.tables.IoGlobalByWaitByLatency;
import org.jooq.Field;
import org.jooq.Record14;
import org.jooq.Row14;
import org.jooq.impl.TableRecordImpl;
import org.jooq.types.ULong;

import javax.annotation.Generated;


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
public class IoGlobalByWaitByLatencyRecord extends TableRecordImpl<IoGlobalByWaitByLatencyRecord> implements Record14<String, ULong, String, String, String, String, String, String, ULong, String, String, ULong, String, String> {

    private static final long serialVersionUID = -1504108898;

    /**
     * Create a detached IoGlobalByWaitByLatencyRecord
     */
    public IoGlobalByWaitByLatencyRecord() {
        super(IoGlobalByWaitByLatency.IO_GLOBAL_BY_WAIT_BY_LATENCY);
    }

    /**
     * Create a detached, initialised IoGlobalByWaitByLatencyRecord
     */
    public IoGlobalByWaitByLatencyRecord(String eventName, ULong total, String totalLatency, String avgLatency, String maxLatency, String readLatency, String writeLatency, String miscLatency, ULong countRead, String totalRead, String avgRead, ULong countWrite, String totalWritten, String avgWritten) {
        super(IoGlobalByWaitByLatency.IO_GLOBAL_BY_WAIT_BY_LATENCY);

        set(0, eventName);
        set(1, total);
        set(2, totalLatency);
        set(3, avgLatency);
        set(4, maxLatency);
        set(5, readLatency);
        set(6, writeLatency);
        set(7, miscLatency);
        set(8, countRead);
        set(9, totalRead);
        set(10, avgRead);
        set(11, countWrite);
        set(12, totalWritten);
        set(13, avgWritten);
    }

    /**
     * Getter for <code>sys.io_global_by_wait_by_latency.event_name</code>.
     */
    public String getEventName() {
        return (String) get(0);
    }

    /**
     * Setter for <code>sys.io_global_by_wait_by_latency.event_name</code>.
     */
    public void setEventName(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>sys.io_global_by_wait_by_latency.total</code>.
     */
    public ULong getTotal() {
        return (ULong) get(1);
    }

    /**
     * Setter for <code>sys.io_global_by_wait_by_latency.total</code>.
     */
    public void setTotal(ULong value) {
        set(1, value);
    }

    /**
     * Getter for <code>sys.io_global_by_wait_by_latency.total_latency</code>.
     */
    public String getTotalLatency() {
        return (String) get(2);
    }

    /**
     * Setter for <code>sys.io_global_by_wait_by_latency.total_latency</code>.
     */
    public void setTotalLatency(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>sys.io_global_by_wait_by_latency.avg_latency</code>.
     */
    public String getAvgLatency() {
        return (String) get(3);
    }

    /**
     * Setter for <code>sys.io_global_by_wait_by_latency.avg_latency</code>.
     */
    public void setAvgLatency(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>sys.io_global_by_wait_by_latency.max_latency</code>.
     */
    public String getMaxLatency() {
        return (String) get(4);
    }

    /**
     * Setter for <code>sys.io_global_by_wait_by_latency.max_latency</code>.
     */
    public void setMaxLatency(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>sys.io_global_by_wait_by_latency.read_latency</code>.
     */
    public String getReadLatency() {
        return (String) get(5);
    }

    /**
     * Setter for <code>sys.io_global_by_wait_by_latency.read_latency</code>.
     */
    public void setReadLatency(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>sys.io_global_by_wait_by_latency.write_latency</code>.
     */
    public String getWriteLatency() {
        return (String) get(6);
    }

    /**
     * Setter for <code>sys.io_global_by_wait_by_latency.write_latency</code>.
     */
    public void setWriteLatency(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>sys.io_global_by_wait_by_latency.misc_latency</code>.
     */
    public String getMiscLatency() {
        return (String) get(7);
    }

    /**
     * Setter for <code>sys.io_global_by_wait_by_latency.misc_latency</code>.
     */
    public void setMiscLatency(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>sys.io_global_by_wait_by_latency.count_read</code>.
     */
    public ULong getCountRead() {
        return (ULong) get(8);
    }

    /**
     * Setter for <code>sys.io_global_by_wait_by_latency.count_read</code>.
     */
    public void setCountRead(ULong value) {
        set(8, value);
    }

    /**
     * Getter for <code>sys.io_global_by_wait_by_latency.total_read</code>.
     */
    public String getTotalRead() {
        return (String) get(9);
    }

    /**
     * Setter for <code>sys.io_global_by_wait_by_latency.total_read</code>.
     */
    public void setTotalRead(String value) {
        set(9, value);
    }

    /**
     * Getter for <code>sys.io_global_by_wait_by_latency.avg_read</code>.
     */
    public String getAvgRead() {
        return (String) get(10);
    }

    /**
     * Setter for <code>sys.io_global_by_wait_by_latency.avg_read</code>.
     */
    public void setAvgRead(String value) {
        set(10, value);
    }

    /**
     * Getter for <code>sys.io_global_by_wait_by_latency.count_write</code>.
     */
    public ULong getCountWrite() {
        return (ULong) get(11);
    }

    /**
     * Setter for <code>sys.io_global_by_wait_by_latency.count_write</code>.
     */
    public void setCountWrite(ULong value) {
        set(11, value);
    }

    /**
     * Getter for <code>sys.io_global_by_wait_by_latency.total_written</code>.
     */
    public String getTotalWritten() {
        return (String) get(12);
    }

    /**
     * Setter for <code>sys.io_global_by_wait_by_latency.total_written</code>.
     */
    public void setTotalWritten(String value) {
        set(12, value);
    }

    // -------------------------------------------------------------------------
    // Record14 type implementation
    // -------------------------------------------------------------------------

    /**
     * Getter for <code>sys.io_global_by_wait_by_latency.avg_written</code>.
     */
    public String getAvgWritten() {
        return (String) get(13);
    }

    /**
     * Setter for <code>sys.io_global_by_wait_by_latency.avg_written</code>.
     */
    public void setAvgWritten(String value) {
        set(13, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row14<String, ULong, String, String, String, String, String, String, ULong, String, String, ULong, String, String> fieldsRow() {
        return (Row14) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row14<String, ULong, String, String, String, String, String, String, ULong, String, String, ULong, String, String> valuesRow() {
        return (Row14) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return IoGlobalByWaitByLatency.IO_GLOBAL_BY_WAIT_BY_LATENCY.EVENT_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<ULong> field2() {
        return IoGlobalByWaitByLatency.IO_GLOBAL_BY_WAIT_BY_LATENCY.TOTAL;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return IoGlobalByWaitByLatency.IO_GLOBAL_BY_WAIT_BY_LATENCY.TOTAL_LATENCY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return IoGlobalByWaitByLatency.IO_GLOBAL_BY_WAIT_BY_LATENCY.AVG_LATENCY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return IoGlobalByWaitByLatency.IO_GLOBAL_BY_WAIT_BY_LATENCY.MAX_LATENCY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return IoGlobalByWaitByLatency.IO_GLOBAL_BY_WAIT_BY_LATENCY.READ_LATENCY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field7() {
        return IoGlobalByWaitByLatency.IO_GLOBAL_BY_WAIT_BY_LATENCY.WRITE_LATENCY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field8() {
        return IoGlobalByWaitByLatency.IO_GLOBAL_BY_WAIT_BY_LATENCY.MISC_LATENCY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<ULong> field9() {
        return IoGlobalByWaitByLatency.IO_GLOBAL_BY_WAIT_BY_LATENCY.COUNT_READ;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field10() {
        return IoGlobalByWaitByLatency.IO_GLOBAL_BY_WAIT_BY_LATENCY.TOTAL_READ;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field11() {
        return IoGlobalByWaitByLatency.IO_GLOBAL_BY_WAIT_BY_LATENCY.AVG_READ;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<ULong> field12() {
        return IoGlobalByWaitByLatency.IO_GLOBAL_BY_WAIT_BY_LATENCY.COUNT_WRITE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field13() {
        return IoGlobalByWaitByLatency.IO_GLOBAL_BY_WAIT_BY_LATENCY.TOTAL_WRITTEN;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field14() {
        return IoGlobalByWaitByLatency.IO_GLOBAL_BY_WAIT_BY_LATENCY.AVG_WRITTEN;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component1() {
        return getEventName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong component2() {
        return getTotal();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getTotalLatency();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getAvgLatency();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component5() {
        return getMaxLatency();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component6() {
        return getReadLatency();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component7() {
        return getWriteLatency();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component8() {
        return getMiscLatency();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong component9() {
        return getCountRead();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component10() {
        return getTotalRead();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component11() {
        return getAvgRead();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong component12() {
        return getCountWrite();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component13() {
        return getTotalWritten();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component14() {
        return getAvgWritten();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value1() {
        return getEventName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong value2() {
        return getTotal();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getTotalLatency();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getAvgLatency();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getMaxLatency();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value6() {
        return getReadLatency();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value7() {
        return getWriteLatency();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value8() {
        return getMiscLatency();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong value9() {
        return getCountRead();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value10() {
        return getTotalRead();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value11() {
        return getAvgRead();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong value12() {
        return getCountWrite();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value13() {
        return getTotalWritten();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value14() {
        return getAvgWritten();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IoGlobalByWaitByLatencyRecord value1(String value) {
        setEventName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IoGlobalByWaitByLatencyRecord value2(ULong value) {
        setTotal(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IoGlobalByWaitByLatencyRecord value3(String value) {
        setTotalLatency(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IoGlobalByWaitByLatencyRecord value4(String value) {
        setAvgLatency(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IoGlobalByWaitByLatencyRecord value5(String value) {
        setMaxLatency(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IoGlobalByWaitByLatencyRecord value6(String value) {
        setReadLatency(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IoGlobalByWaitByLatencyRecord value7(String value) {
        setWriteLatency(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IoGlobalByWaitByLatencyRecord value8(String value) {
        setMiscLatency(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IoGlobalByWaitByLatencyRecord value9(ULong value) {
        setCountRead(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IoGlobalByWaitByLatencyRecord value10(String value) {
        setTotalRead(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IoGlobalByWaitByLatencyRecord value11(String value) {
        setAvgRead(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IoGlobalByWaitByLatencyRecord value12(ULong value) {
        setCountWrite(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IoGlobalByWaitByLatencyRecord value13(String value) {
        setTotalWritten(value);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public IoGlobalByWaitByLatencyRecord value14(String value) {
        setAvgWritten(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IoGlobalByWaitByLatencyRecord values(String value1, ULong value2, String value3, String value4, String value5, String value6, String value7, String value8, ULong value9, String value10, String value11, ULong value12, String value13, String value14) {
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
}
