/*
 * This file is generated by jOOQ.
 */
package jooq.performance_schema.tables.records;


import jooq.performance_schema.tables.StatusByUser;
import org.jooq.Field;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.TableRecordImpl;

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
public class StatusByUserRecord extends TableRecordImpl<StatusByUserRecord> implements Record3<String, String, String> {

    private static final long serialVersionUID = 1339730370;

    /**
     * Create a detached StatusByUserRecord
     */
    public StatusByUserRecord() {
        super(StatusByUser.STATUS_BY_USER);
    }

    /**
     * Create a detached, initialised StatusByUserRecord
     */
    public StatusByUserRecord(String user, String variableName, String variableValue) {
        super(StatusByUser.STATUS_BY_USER);

        set(0, user);
        set(1, variableName);
        set(2, variableValue);
    }

    /**
     * Getter for <code>performance_schema.status_by_user.USER</code>.
     */
    public String getUser() {
        return (String) get(0);
    }

    /**
     * Setter for <code>performance_schema.status_by_user.USER</code>.
     */
    public void setUser(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>performance_schema.status_by_user.VARIABLE_NAME</code>.
     */
    public String getVariableName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>performance_schema.status_by_user.VARIABLE_NAME</code>.
     */
    public void setVariableName(String value) {
        set(1, value);
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    /**
     * Getter for <code>performance_schema.status_by_user.VARIABLE_VALUE</code>.
     */
    public String getVariableValue() {
        return (String) get(2);
    }

    /**
     * Setter for <code>performance_schema.status_by_user.VARIABLE_VALUE</code>.
     */
    public void setVariableValue(String value) {
        set(2, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<String, String, String> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<String, String, String> valuesRow() {
        return (Row3) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return StatusByUser.STATUS_BY_USER.USER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return StatusByUser.STATUS_BY_USER.VARIABLE_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return StatusByUser.STATUS_BY_USER.VARIABLE_VALUE;
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
        return getVariableName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
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
        return getVariableName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getVariableValue();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StatusByUserRecord value1(String value) {
        setUser(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StatusByUserRecord value2(String value) {
        setVariableName(value);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public StatusByUserRecord value3(String value) {
        setVariableValue(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StatusByUserRecord values(String value1, String value2, String value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }
}
