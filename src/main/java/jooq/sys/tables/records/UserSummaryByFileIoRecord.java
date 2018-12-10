/*
 * This file is generated by jOOQ.
 */
package jooq.sys.tables.records;


import java.math.BigInteger;

import javax.annotation.Generated;

import jooq.sys.tables.UserSummaryByFileIo;

import org.jooq.Field;
import org.jooq.Record3;
import org.jooq.Row3;
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
public class UserSummaryByFileIoRecord extends TableRecordImpl<UserSummaryByFileIoRecord> implements Record3<String, BigInteger, String> {

    private static final long serialVersionUID = 2057061995;

    /**
     * Setter for <code>sys.user_summary_by_file_io.user</code>.
     */
    public void setUser(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>sys.user_summary_by_file_io.user</code>.
     */
    public String getUser() {
        return (String) get(0);
    }

    /**
     * Setter for <code>sys.user_summary_by_file_io.ios</code>.
     */
    public void setIos(BigInteger value) {
        set(1, value);
    }

    /**
     * Getter for <code>sys.user_summary_by_file_io.ios</code>.
     */
    public BigInteger getIos() {
        return (BigInteger) get(1);
    }

    /**
     * Setter for <code>sys.user_summary_by_file_io.io_latency</code>.
     */
    public void setIoLatency(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>sys.user_summary_by_file_io.io_latency</code>.
     */
    public String getIoLatency() {
        return (String) get(2);
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<String, BigInteger, String> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<String, BigInteger, String> valuesRow() {
        return (Row3) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return UserSummaryByFileIo.USER_SUMMARY_BY_FILE_IO.USER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<BigInteger> field2() {
        return UserSummaryByFileIo.USER_SUMMARY_BY_FILE_IO.IOS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return UserSummaryByFileIo.USER_SUMMARY_BY_FILE_IO.IO_LATENCY;
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
    public BigInteger component2() {
        return getIos();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getIoLatency();
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
    public BigInteger value2() {
        return getIos();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getIoLatency();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserSummaryByFileIoRecord value1(String value) {
        setUser(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserSummaryByFileIoRecord value2(BigInteger value) {
        setIos(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserSummaryByFileIoRecord value3(String value) {
        setIoLatency(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserSummaryByFileIoRecord values(String value1, BigInteger value2, String value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached UserSummaryByFileIoRecord
     */
    public UserSummaryByFileIoRecord() {
        super(UserSummaryByFileIo.USER_SUMMARY_BY_FILE_IO);
    }

    /**
     * Create a detached, initialised UserSummaryByFileIoRecord
     */
    public UserSummaryByFileIoRecord(String user, BigInteger ios, String ioLatency) {
        super(UserSummaryByFileIo.USER_SUMMARY_BY_FILE_IO);

        set(0, user);
        set(1, ios);
        set(2, ioLatency);
    }
}
