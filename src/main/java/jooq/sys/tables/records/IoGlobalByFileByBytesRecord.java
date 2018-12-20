/*
 * This file is generated by jOOQ.
 */
package jooq.sys.tables.records;


import jooq.sys.tables.IoGlobalByFileByBytes;
import org.jooq.Field;
import org.jooq.Record9;
import org.jooq.Row9;
import org.jooq.impl.TableRecordImpl;
import org.jooq.types.ULong;

import javax.annotation.Generated;
import java.math.BigDecimal;


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
public class IoGlobalByFileByBytesRecord extends TableRecordImpl<IoGlobalByFileByBytesRecord> implements Record9<String, ULong, String, String, ULong, String, String, String, BigDecimal> {

    private static final long serialVersionUID = -1291198808;

    /**
     * Create a detached IoGlobalByFileByBytesRecord
     */
    public IoGlobalByFileByBytesRecord() {
        super(IoGlobalByFileByBytes.IO_GLOBAL_BY_FILE_BY_BYTES);
    }

    /**
     * Create a detached, initialised IoGlobalByFileByBytesRecord
     */
    public IoGlobalByFileByBytesRecord(String file, ULong countRead, String totalRead, String avgRead, ULong countWrite, String totalWritten, String avgWrite, String total, BigDecimal writePct) {
        super(IoGlobalByFileByBytes.IO_GLOBAL_BY_FILE_BY_BYTES);

        set(0, file);
        set(1, countRead);
        set(2, totalRead);
        set(3, avgRead);
        set(4, countWrite);
        set(5, totalWritten);
        set(6, avgWrite);
        set(7, total);
        set(8, writePct);
    }

    /**
     * Getter for <code>sys.io_global_by_file_by_bytes.file</code>.
     */
    public String getFile() {
        return (String) get(0);
    }

    /**
     * Setter for <code>sys.io_global_by_file_by_bytes.file</code>.
     */
    public void setFile(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>sys.io_global_by_file_by_bytes.count_read</code>.
     */
    public ULong getCountRead() {
        return (ULong) get(1);
    }

    /**
     * Setter for <code>sys.io_global_by_file_by_bytes.count_read</code>.
     */
    public void setCountRead(ULong value) {
        set(1, value);
    }

    /**
     * Getter for <code>sys.io_global_by_file_by_bytes.total_read</code>.
     */
    public String getTotalRead() {
        return (String) get(2);
    }

    /**
     * Setter for <code>sys.io_global_by_file_by_bytes.total_read</code>.
     */
    public void setTotalRead(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>sys.io_global_by_file_by_bytes.avg_read</code>.
     */
    public String getAvgRead() {
        return (String) get(3);
    }

    /**
     * Setter for <code>sys.io_global_by_file_by_bytes.avg_read</code>.
     */
    public void setAvgRead(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>sys.io_global_by_file_by_bytes.count_write</code>.
     */
    public ULong getCountWrite() {
        return (ULong) get(4);
    }

    /**
     * Setter for <code>sys.io_global_by_file_by_bytes.count_write</code>.
     */
    public void setCountWrite(ULong value) {
        set(4, value);
    }

    /**
     * Getter for <code>sys.io_global_by_file_by_bytes.total_written</code>.
     */
    public String getTotalWritten() {
        return (String) get(5);
    }

    /**
     * Setter for <code>sys.io_global_by_file_by_bytes.total_written</code>.
     */
    public void setTotalWritten(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>sys.io_global_by_file_by_bytes.avg_write</code>.
     */
    public String getAvgWrite() {
        return (String) get(6);
    }

    /**
     * Setter for <code>sys.io_global_by_file_by_bytes.avg_write</code>.
     */
    public void setAvgWrite(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>sys.io_global_by_file_by_bytes.total</code>.
     */
    public String getTotal() {
        return (String) get(7);
    }

    /**
     * Setter for <code>sys.io_global_by_file_by_bytes.total</code>.
     */
    public void setTotal(String value) {
        set(7, value);
    }

    // -------------------------------------------------------------------------
    // Record9 type implementation
    // -------------------------------------------------------------------------

    /**
     * Getter for <code>sys.io_global_by_file_by_bytes.write_pct</code>.
     */
    public BigDecimal getWritePct() {
        return (BigDecimal) get(8);
    }

    /**
     * Setter for <code>sys.io_global_by_file_by_bytes.write_pct</code>.
     */
    public void setWritePct(BigDecimal value) {
        set(8, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row9<String, ULong, String, String, ULong, String, String, String, BigDecimal> fieldsRow() {
        return (Row9) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row9<String, ULong, String, String, ULong, String, String, String, BigDecimal> valuesRow() {
        return (Row9) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return IoGlobalByFileByBytes.IO_GLOBAL_BY_FILE_BY_BYTES.FILE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<ULong> field2() {
        return IoGlobalByFileByBytes.IO_GLOBAL_BY_FILE_BY_BYTES.COUNT_READ;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return IoGlobalByFileByBytes.IO_GLOBAL_BY_FILE_BY_BYTES.TOTAL_READ;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return IoGlobalByFileByBytes.IO_GLOBAL_BY_FILE_BY_BYTES.AVG_READ;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<ULong> field5() {
        return IoGlobalByFileByBytes.IO_GLOBAL_BY_FILE_BY_BYTES.COUNT_WRITE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return IoGlobalByFileByBytes.IO_GLOBAL_BY_FILE_BY_BYTES.TOTAL_WRITTEN;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field7() {
        return IoGlobalByFileByBytes.IO_GLOBAL_BY_FILE_BY_BYTES.AVG_WRITE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field8() {
        return IoGlobalByFileByBytes.IO_GLOBAL_BY_FILE_BY_BYTES.TOTAL;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<BigDecimal> field9() {
        return IoGlobalByFileByBytes.IO_GLOBAL_BY_FILE_BY_BYTES.WRITE_PCT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component1() {
        return getFile();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong component2() {
        return getCountRead();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getTotalRead();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getAvgRead();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong component5() {
        return getCountWrite();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component6() {
        return getTotalWritten();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component7() {
        return getAvgWrite();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component8() {
        return getTotal();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal component9() {
        return getWritePct();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value1() {
        return getFile();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong value2() {
        return getCountRead();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getTotalRead();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getAvgRead();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong value5() {
        return getCountWrite();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value6() {
        return getTotalWritten();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value7() {
        return getAvgWrite();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value8() {
        return getTotal();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal value9() {
        return getWritePct();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IoGlobalByFileByBytesRecord value1(String value) {
        setFile(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IoGlobalByFileByBytesRecord value2(ULong value) {
        setCountRead(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IoGlobalByFileByBytesRecord value3(String value) {
        setTotalRead(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IoGlobalByFileByBytesRecord value4(String value) {
        setAvgRead(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IoGlobalByFileByBytesRecord value5(ULong value) {
        setCountWrite(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IoGlobalByFileByBytesRecord value6(String value) {
        setTotalWritten(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IoGlobalByFileByBytesRecord value7(String value) {
        setAvgWrite(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IoGlobalByFileByBytesRecord value8(String value) {
        setTotal(value);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public IoGlobalByFileByBytesRecord value9(BigDecimal value) {
        setWritePct(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IoGlobalByFileByBytesRecord values(String value1, ULong value2, String value3, String value4, ULong value5, String value6, String value7, String value8, BigDecimal value9) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        return this;
    }
}
