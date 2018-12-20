/*
 * This file is generated by jOOQ.
 */
package jooq.performance_schema.tables.records;


import jooq.performance_schema.tables.Accounts;
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
                "jOOQ version:3.11.2"
        },
        comments = "This class is generated by jOOQ"
)
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class AccountsRecord extends TableRecordImpl<AccountsRecord> implements Record4<String, String, Long, Long> {

    private static final long serialVersionUID = 479348415;

    /**
     * Create a detached AccountsRecord
     */
    public AccountsRecord() {
        super(Accounts.ACCOUNTS);
    }

    /**
     * Create a detached, initialised AccountsRecord
     */
    public AccountsRecord(String user, String host, Long currentConnections, Long totalConnections) {
        super(Accounts.ACCOUNTS);

        set(0, user);
        set(1, host);
        set(2, currentConnections);
        set(3, totalConnections);
    }

    /**
     * Getter for <code>performance_schema.accounts.USER</code>.
     */
    public String getUser() {
        return (String) get(0);
    }

    /**
     * Setter for <code>performance_schema.accounts.USER</code>.
     */
    public void setUser(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>performance_schema.accounts.HOST</code>.
     */
    public String getHost() {
        return (String) get(1);
    }

    /**
     * Setter for <code>performance_schema.accounts.HOST</code>.
     */
    public void setHost(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>performance_schema.accounts.CURRENT_CONNECTIONS</code>.
     */
    public Long getCurrentConnections() {
        return (Long) get(2);
    }

    /**
     * Setter for <code>performance_schema.accounts.CURRENT_CONNECTIONS</code>.
     */
    public void setCurrentConnections(Long value) {
        set(2, value);
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    /**
     * Getter for <code>performance_schema.accounts.TOTAL_CONNECTIONS</code>.
     */
    public Long getTotalConnections() {
        return (Long) get(3);
    }

    /**
     * Setter for <code>performance_schema.accounts.TOTAL_CONNECTIONS</code>.
     */
    public void setTotalConnections(Long value) {
        set(3, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<String, String, Long, Long> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<String, String, Long, Long> valuesRow() {
        return (Row4) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return Accounts.ACCOUNTS.USER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Accounts.ACCOUNTS.HOST;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field3() {
        return Accounts.ACCOUNTS.CURRENT_CONNECTIONS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field4() {
        return Accounts.ACCOUNTS.TOTAL_CONNECTIONS;
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
    public Long component3() {
        return getCurrentConnections();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component4() {
        return getTotalConnections();
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
    public Long value3() {
        return getCurrentConnections();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value4() {
        return getTotalConnections();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccountsRecord value1(String value) {
        setUser(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccountsRecord value2(String value) {
        setHost(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccountsRecord value3(Long value) {
        setCurrentConnections(value);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public AccountsRecord value4(Long value) {
        setTotalConnections(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccountsRecord values(String value1, String value2, Long value3, Long value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }
}
