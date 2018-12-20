/*
 * This file is generated by jOOQ.
 */
package jooq.information_schema.tables.records;


import jooq.information_schema.tables.SessionVariables;
import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Row2;
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
public class SessionVariablesRecord extends TableRecordImpl<SessionVariablesRecord> implements Record2<String, String> {

    private static final long serialVersionUID = -557524965;

    /**
     * Create a detached SessionVariablesRecord
     */
    public SessionVariablesRecord() {
        super(SessionVariables.SESSION_VARIABLES);
    }

    /**
     * Create a detached, initialised SessionVariablesRecord
     */
    public SessionVariablesRecord(String variableName, String variableValue) {
        super(SessionVariables.SESSION_VARIABLES);

        set(0, variableName);
        set(1, variableValue);
    }

    /**
     * Getter for <code>information_schema.SESSION_VARIABLES.VARIABLE_NAME</code>.
     */
    public String getVariableName() {
        return (String) get(0);
    }

    /**
     * Setter for <code>information_schema.SESSION_VARIABLES.VARIABLE_NAME</code>.
     */
    public void setVariableName(String value) {
        set(0, value);
    }

    // -------------------------------------------------------------------------
    // Record2 type implementation
    // -------------------------------------------------------------------------

    /**
     * Getter for <code>information_schema.SESSION_VARIABLES.VARIABLE_VALUE</code>.
     */
    public String getVariableValue() {
        return (String) get(1);
    }

    /**
     * Setter for <code>information_schema.SESSION_VARIABLES.VARIABLE_VALUE</code>.
     */
    public void setVariableValue(String value) {
        set(1, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row2<String, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row2<String, String> valuesRow() {
        return (Row2) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return SessionVariables.SESSION_VARIABLES.VARIABLE_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return SessionVariables.SESSION_VARIABLES.VARIABLE_VALUE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component1() {
        return getVariableName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getVariableValue();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value1() {
        return getVariableName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getVariableValue();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SessionVariablesRecord value1(String value) {
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
    public SessionVariablesRecord value2(String value) {
        setVariableValue(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SessionVariablesRecord values(String value1, String value2) {
        value1(value1);
        value2(value2);
        return this;
    }
}
