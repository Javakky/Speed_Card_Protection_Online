/*
 * This file is generated by jOOQ.
 */
package jooq.performance_schema.tables;


import javax.annotation.Generated;

import jooq.performance_schema.PerformanceSchema;
import jooq.performance_schema.enums.ReplicationConnectionConfigurationAutoPosition;
import jooq.performance_schema.enums.ReplicationConnectionConfigurationSslAllowed;
import jooq.performance_schema.enums.ReplicationConnectionConfigurationSslVerifyServerCertificate;
import jooq.performance_schema.tables.records.ReplicationConnectionConfigurationRecord;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;
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
public class ReplicationConnectionConfiguration extends TableImpl<ReplicationConnectionConfigurationRecord> {

    private static final long serialVersionUID = -417762400;

    /**
     * The reference instance of <code>performance_schema.replication_connection_configuration</code>
     */
    public static final ReplicationConnectionConfiguration REPLICATION_CONNECTION_CONFIGURATION = new ReplicationConnectionConfiguration();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ReplicationConnectionConfigurationRecord> getRecordType() {
        return ReplicationConnectionConfigurationRecord.class;
    }

    /**
     * The column <code>performance_schema.replication_connection_configuration.CHANNEL_NAME</code>.
     */
    public final TableField<ReplicationConnectionConfigurationRecord, String> CHANNEL_NAME = createField("CHANNEL_NAME", org.jooq.impl.SQLDataType.CHAR(64).nullable(false), this, "");

    /**
     * The column <code>performance_schema.replication_connection_configuration.HOST</code>.
     */
    public final TableField<ReplicationConnectionConfigurationRecord, String> HOST = createField("HOST", org.jooq.impl.SQLDataType.CHAR(60).nullable(false), this, "");

    /**
     * The column <code>performance_schema.replication_connection_configuration.PORT</code>.
     */
    public final TableField<ReplicationConnectionConfigurationRecord, Integer> PORT = createField("PORT", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>performance_schema.replication_connection_configuration.USER</code>.
     */
    public final TableField<ReplicationConnectionConfigurationRecord, String> USER = createField("USER", org.jooq.impl.SQLDataType.CHAR(32).nullable(false), this, "");

    /**
     * The column <code>performance_schema.replication_connection_configuration.NETWORK_INTERFACE</code>.
     */
    public final TableField<ReplicationConnectionConfigurationRecord, String> NETWORK_INTERFACE = createField("NETWORK_INTERFACE", org.jooq.impl.SQLDataType.CHAR(60).nullable(false), this, "");

    /**
     * The column <code>performance_schema.replication_connection_configuration.AUTO_POSITION</code>.
     */
    public final TableField<ReplicationConnectionConfigurationRecord, ReplicationConnectionConfigurationAutoPosition> AUTO_POSITION = createField("AUTO_POSITION", org.jooq.impl.SQLDataType.VARCHAR(1).nullable(false).asEnumDataType(jooq.performance_schema.enums.ReplicationConnectionConfigurationAutoPosition.class), this, "");

    /**
     * The column <code>performance_schema.replication_connection_configuration.SSL_ALLOWED</code>.
     */
    public final TableField<ReplicationConnectionConfigurationRecord, ReplicationConnectionConfigurationSslAllowed> SSL_ALLOWED = createField("SSL_ALLOWED", org.jooq.impl.SQLDataType.VARCHAR(7).nullable(false).asEnumDataType(jooq.performance_schema.enums.ReplicationConnectionConfigurationSslAllowed.class), this, "");

    /**
     * The column <code>performance_schema.replication_connection_configuration.SSL_CA_FILE</code>.
     */
    public final TableField<ReplicationConnectionConfigurationRecord, String> SSL_CA_FILE = createField("SSL_CA_FILE", org.jooq.impl.SQLDataType.VARCHAR(512).nullable(false), this, "");

    /**
     * The column <code>performance_schema.replication_connection_configuration.SSL_CA_PATH</code>.
     */
    public final TableField<ReplicationConnectionConfigurationRecord, String> SSL_CA_PATH = createField("SSL_CA_PATH", org.jooq.impl.SQLDataType.VARCHAR(512).nullable(false), this, "");

    /**
     * The column <code>performance_schema.replication_connection_configuration.SSL_CERTIFICATE</code>.
     */
    public final TableField<ReplicationConnectionConfigurationRecord, String> SSL_CERTIFICATE = createField("SSL_CERTIFICATE", org.jooq.impl.SQLDataType.VARCHAR(512).nullable(false), this, "");

    /**
     * The column <code>performance_schema.replication_connection_configuration.SSL_CIPHER</code>.
     */
    public final TableField<ReplicationConnectionConfigurationRecord, String> SSL_CIPHER = createField("SSL_CIPHER", org.jooq.impl.SQLDataType.VARCHAR(512).nullable(false), this, "");

    /**
     * The column <code>performance_schema.replication_connection_configuration.SSL_KEY</code>.
     */
    public final TableField<ReplicationConnectionConfigurationRecord, String> SSL_KEY = createField("SSL_KEY", org.jooq.impl.SQLDataType.VARCHAR(512).nullable(false), this, "");

    /**
     * The column <code>performance_schema.replication_connection_configuration.SSL_VERIFY_SERVER_CERTIFICATE</code>.
     */
    public final TableField<ReplicationConnectionConfigurationRecord, ReplicationConnectionConfigurationSslVerifyServerCertificate> SSL_VERIFY_SERVER_CERTIFICATE = createField("SSL_VERIFY_SERVER_CERTIFICATE", org.jooq.impl.SQLDataType.VARCHAR(3).nullable(false).asEnumDataType(jooq.performance_schema.enums.ReplicationConnectionConfigurationSslVerifyServerCertificate.class), this, "");

    /**
     * The column <code>performance_schema.replication_connection_configuration.SSL_CRL_FILE</code>.
     */
    public final TableField<ReplicationConnectionConfigurationRecord, String> SSL_CRL_FILE = createField("SSL_CRL_FILE", org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>performance_schema.replication_connection_configuration.SSL_CRL_PATH</code>.
     */
    public final TableField<ReplicationConnectionConfigurationRecord, String> SSL_CRL_PATH = createField("SSL_CRL_PATH", org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>performance_schema.replication_connection_configuration.CONNECTION_RETRY_INTERVAL</code>.
     */
    public final TableField<ReplicationConnectionConfigurationRecord, Integer> CONNECTION_RETRY_INTERVAL = createField("CONNECTION_RETRY_INTERVAL", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>performance_schema.replication_connection_configuration.CONNECTION_RETRY_COUNT</code>.
     */
    public final TableField<ReplicationConnectionConfigurationRecord, ULong> CONNECTION_RETRY_COUNT = createField("CONNECTION_RETRY_COUNT", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>performance_schema.replication_connection_configuration.HEARTBEAT_INTERVAL</code>. Number of seconds after which a heartbeat will be sent .
     */
    public final TableField<ReplicationConnectionConfigurationRecord, Double> HEARTBEAT_INTERVAL = createField("HEARTBEAT_INTERVAL", org.jooq.impl.SQLDataType.DOUBLE.nullable(false), this, "Number of seconds after which a heartbeat will be sent .");

    /**
     * The column <code>performance_schema.replication_connection_configuration.TLS_VERSION</code>.
     */
    public final TableField<ReplicationConnectionConfigurationRecord, String> TLS_VERSION = createField("TLS_VERSION", org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * Create a <code>performance_schema.replication_connection_configuration</code> table reference
     */
    public ReplicationConnectionConfiguration() {
        this(DSL.name("replication_connection_configuration"), null);
    }

    /**
     * Create an aliased <code>performance_schema.replication_connection_configuration</code> table reference
     */
    public ReplicationConnectionConfiguration(String alias) {
        this(DSL.name(alias), REPLICATION_CONNECTION_CONFIGURATION);
    }

    /**
     * Create an aliased <code>performance_schema.replication_connection_configuration</code> table reference
     */
    public ReplicationConnectionConfiguration(Name alias) {
        this(alias, REPLICATION_CONNECTION_CONFIGURATION);
    }

    private ReplicationConnectionConfiguration(Name alias, Table<ReplicationConnectionConfigurationRecord> aliased) {
        this(alias, aliased, null);
    }

    private ReplicationConnectionConfiguration(Name alias, Table<ReplicationConnectionConfigurationRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> ReplicationConnectionConfiguration(Table<O> child, ForeignKey<O, ReplicationConnectionConfigurationRecord> key) {
        super(child, key, REPLICATION_CONNECTION_CONFIGURATION);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return PerformanceSchema.PERFORMANCE_SCHEMA;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ReplicationConnectionConfiguration as(String alias) {
        return new ReplicationConnectionConfiguration(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ReplicationConnectionConfiguration as(Name alias) {
        return new ReplicationConnectionConfiguration(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public ReplicationConnectionConfiguration rename(String name) {
        return new ReplicationConnectionConfiguration(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public ReplicationConnectionConfiguration rename(Name name) {
        return new ReplicationConnectionConfiguration(name, null);
    }
}
