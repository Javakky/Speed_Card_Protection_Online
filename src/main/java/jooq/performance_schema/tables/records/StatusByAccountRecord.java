/*
 * This file is generated by jOOQ.
 */
package jooq.performance_schema.tables.records;


import jooq.performance_schema.tables.StatusByAccount;
import org.jooq.Field;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.TableRecordImpl;

import javax.annotation.Generated;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
            "jOOQ version:3.11.9"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class StatusByAccountRecord extends TableRecordImpl<StatusByAccountRecord> implements Record4<String, String, String, String> {

    private static final long serialVersionUID = 80334078;

    /**
     * Setter for <code>performance_schema.status_by_account.USER</code>.
     */
    public void setUser(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>performance_schema.status_by_account.USER</code>.
     */
    public String getUser() {
        return (String) get(0);
    }

    /**
     * Setter for <code>performance_schema.status_by_account.HOST</code>.
     */
    public void setHost(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>performance_schema.status_by_account.HOST</code>.
     */
    public String getHost() {
        return (String) get(1);
    }

    /**
     * Setter for <code>performance_schema.status_by_account.VARIABLE_NAME</code>.
     */
    public void setVariableName(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>performance_schema.status_by_account.VARIABLE_NAME</code>.
     */
    public String getVariableName() {
        return (String) get(2);
    }

    /**
     * Setter for <code>performance_schema.status_by_account.VARIABLE_VALUE</code>.
     */
    public void setVariableValue(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>performance_schema.status_by_account.VARIABLE_VALUE</code>.
     */
    public String getVariableValue() {
        return (String) get(3);
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<String, String, String, String> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<String, String, String, String> valuesRow() {
        return (Row4) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return StatusByAccount.STATUS_BY_ACCOUNT.USER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return StatusByAccount.STATUS_BY_ACCOUNT.HOST;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return StatusByAccount.STATUS_BY_ACCOUNT.VARIABLE_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return StatusByAccount.STATUS_BY_ACCOUNT.VARIABLE_VALUE;
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
        return getVariableName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getVariableValue();
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
        return getVariableName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getVariableValue();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StatusByAccountRecord value1(String value) {
        setUser(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StatusByAccountRecord value2(String value) {
        setHost(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StatusByAccountRecord value3(String value) {
        setVariableName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StatusByAccountRecord value4(String value) {
        setVariableValue(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StatusByAccountRecord values(String value1, String value2, String value3, String value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached StatusByAccountRecord
     */
    public StatusByAccountRecord() {
        super(StatusByAccount.STATUS_BY_ACCOUNT);
    }

    /**
     * Create a detached, initialised StatusByAccountRecord
     */
    public StatusByAccountRecord(String user, String host, String variableName, String variableValue) {
        super(StatusByAccount.STATUS_BY_ACCOUNT);

        set(0, user);
        set(1, host);
        set(2, variableName);
        set(3, variableValue);
    }
}
