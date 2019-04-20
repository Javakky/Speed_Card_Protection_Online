/*
 * This file is generated by jOOQ.
 */
package jooq.sys.tables;


import jooq.sys.Sys;
import jooq.sys.tables.records.SessionSslStatusRecord;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;
import org.jooq.types.ULong;

import javax.annotation.Generated;


/**
 * VIEW
 */
@Generated(
    value = {
        "http://www.jooq.org",
            "jOOQ version:3.11.9"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SessionSslStatus extends TableImpl<SessionSslStatusRecord> {

    private static final long serialVersionUID = -680960298;

    /**
     * The reference instance of <code>sys.session_ssl_status</code>
     */
    public static final SessionSslStatus SESSION_SSL_STATUS = new SessionSslStatus();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<SessionSslStatusRecord> getRecordType() {
        return SessionSslStatusRecord.class;
    }

    /**
     * The column <code>sys.session_ssl_status.thread_id</code>.
     */
    public final TableField<SessionSslStatusRecord, ULong> THREAD_ID = createField("thread_id", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>sys.session_ssl_status.ssl_version</code>.
     */
    public final TableField<SessionSslStatusRecord, String> SSL_VERSION = createField("ssl_version", org.jooq.impl.SQLDataType.VARCHAR(1024), this, "");

    /**
     * The column <code>sys.session_ssl_status.ssl_cipher</code>.
     */
    public final TableField<SessionSslStatusRecord, String> SSL_CIPHER = createField("ssl_cipher", org.jooq.impl.SQLDataType.VARCHAR(1024), this, "");

    /**
     * The column <code>sys.session_ssl_status.ssl_sessions_reused</code>.
     */
    public final TableField<SessionSslStatusRecord, String> SSL_SESSIONS_REUSED = createField("ssl_sessions_reused", org.jooq.impl.SQLDataType.VARCHAR(1024), this, "");

    /**
     * Create a <code>sys.session_ssl_status</code> table reference
     */
    public SessionSslStatus() {
        this(DSL.name("session_ssl_status"), null);
    }

    /**
     * Create an aliased <code>sys.session_ssl_status</code> table reference
     */
    public SessionSslStatus(String alias) {
        this(DSL.name(alias), SESSION_SSL_STATUS);
    }

    /**
     * Create an aliased <code>sys.session_ssl_status</code> table reference
     */
    public SessionSslStatus(Name alias) {
        this(alias, SESSION_SSL_STATUS);
    }

    private SessionSslStatus(Name alias, Table<SessionSslStatusRecord> aliased) {
        this(alias, aliased, null);
    }

    private SessionSslStatus(Name alias, Table<SessionSslStatusRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("VIEW"));
    }

    public <O extends Record> SessionSslStatus(Table<O> child, ForeignKey<O, SessionSslStatusRecord> key) {
        super(child, key, SESSION_SSL_STATUS);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Sys.SYS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SessionSslStatus as(String alias) {
        return new SessionSslStatus(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SessionSslStatus as(Name alias) {
        return new SessionSslStatus(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public SessionSslStatus rename(String name) {
        return new SessionSslStatus(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public SessionSslStatus rename(Name name) {
        return new SessionSslStatus(name, null);
    }
}
