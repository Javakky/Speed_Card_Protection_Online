/*
 * This file is generated by jOOQ.
 */
package jooq.performance_schema.tables.records;


import jooq.performance_schema.tables.StatusByHost;
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
public class StatusByHostRecord extends TableRecordImpl<StatusByHostRecord> implements Record3<String, String, String> {

    private static final long serialVersionUID = 1858444279;

    /**
     * Create a detached StatusByHostRecord
     */
    public StatusByHostRecord() {
        super(StatusByHost.STATUS_BY_HOST);
    }

    /**
     * Create a detached, initialised StatusByHostRecord
     */
    public StatusByHostRecord(String host, String variableName, String variableValue) {
        super(StatusByHost.STATUS_BY_HOST);

        set(0, host);
        set(1, variableName);
        set(2, variableValue);
    }

    /**
     * Getter for <code>performance_schema.status_by_host.HOST</code>.
     */
    public String getHost() {
        return (String) get(0);
    }

    /**
     * Setter for <code>performance_schema.status_by_host.HOST</code>.
     */
    public void setHost(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>performance_schema.status_by_host.VARIABLE_NAME</code>.
     */
    public String getVariableName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>performance_schema.status_by_host.VARIABLE_NAME</code>.
     */
    public void setVariableName(String value) {
        set(1, value);
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    /**
     * Getter for <code>performance_schema.status_by_host.VARIABLE_VALUE</code>.
     */
    public String getVariableValue() {
        return (String) get(2);
    }

    /**
     * Setter for <code>performance_schema.status_by_host.VARIABLE_VALUE</code>.
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
        return StatusByHost.STATUS_BY_HOST.HOST;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return StatusByHost.STATUS_BY_HOST.VARIABLE_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return StatusByHost.STATUS_BY_HOST.VARIABLE_VALUE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component1() {
        return getHost();
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
        return getHost();
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
    public StatusByHostRecord value1(String value) {
        setHost(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StatusByHostRecord value2(String value) {
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
    public StatusByHostRecord value3(String value) {
        setVariableValue(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StatusByHostRecord values(String value1, String value2, String value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }
}
