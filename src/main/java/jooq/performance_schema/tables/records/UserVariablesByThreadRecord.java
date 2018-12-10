/*
 * This file is generated by jOOQ.
 */
package jooq.performance_schema.tables.records;


import javax.annotation.Generated;

import jooq.performance_schema.tables.UserVariablesByThread;

import org.jooq.Field;
import org.jooq.Record3;
import org.jooq.Row3;
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
public class UserVariablesByThreadRecord extends TableRecordImpl<UserVariablesByThreadRecord> implements Record3<ULong, String, byte[]> {

    private static final long serialVersionUID = -1985032818;

    /**
     * Setter for <code>performance_schema.user_variables_by_thread.THREAD_ID</code>.
     */
    public void setThreadId(ULong value) {
        set(0, value);
    }

    /**
     * Getter for <code>performance_schema.user_variables_by_thread.THREAD_ID</code>.
     */
    public ULong getThreadId() {
        return (ULong) get(0);
    }

    /**
     * Setter for <code>performance_schema.user_variables_by_thread.VARIABLE_NAME</code>.
     */
    public void setVariableName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>performance_schema.user_variables_by_thread.VARIABLE_NAME</code>.
     */
    public String getVariableName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>performance_schema.user_variables_by_thread.VARIABLE_VALUE</code>.
     */
    public void setVariableValue(byte... value) {
        set(2, value);
    }

    /**
     * Getter for <code>performance_schema.user_variables_by_thread.VARIABLE_VALUE</code>.
     */
    public byte[] getVariableValue() {
        return (byte[]) get(2);
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<ULong, String, byte[]> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<ULong, String, byte[]> valuesRow() {
        return (Row3) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<ULong> field1() {
        return UserVariablesByThread.USER_VARIABLES_BY_THREAD.THREAD_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return UserVariablesByThread.USER_VARIABLES_BY_THREAD.VARIABLE_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<byte[]> field3() {
        return UserVariablesByThread.USER_VARIABLES_BY_THREAD.VARIABLE_VALUE;
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
        return getVariableName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public byte[] component3() {
        return getVariableValue();
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
        return getVariableName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public byte[] value3() {
        return getVariableValue();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserVariablesByThreadRecord value1(ULong value) {
        setThreadId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserVariablesByThreadRecord value2(String value) {
        setVariableName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserVariablesByThreadRecord value3(byte... value) {
        setVariableValue(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserVariablesByThreadRecord values(ULong value1, String value2, byte[] value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached UserVariablesByThreadRecord
     */
    public UserVariablesByThreadRecord() {
        super(UserVariablesByThread.USER_VARIABLES_BY_THREAD);
    }

    /**
     * Create a detached, initialised UserVariablesByThreadRecord
     */
    public UserVariablesByThreadRecord(ULong threadId, String variableName, byte[] variableValue) {
        super(UserVariablesByThread.USER_VARIABLES_BY_THREAD);

        set(0, threadId);
        set(1, variableName);
        set(2, variableValue);
    }
}
