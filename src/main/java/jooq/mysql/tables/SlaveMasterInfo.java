/*
 * This file is generated by jOOQ.
 */
package jooq.mysql.tables;


import jooq.mysql.Indexes;
import jooq.mysql.Keys;
import jooq.mysql.Mysql;
import jooq.mysql.tables.records.SlaveMasterInfoRecord;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;
import org.jooq.types.UInteger;
import org.jooq.types.ULong;

import javax.annotation.Generated;
import java.util.Arrays;
import java.util.List;


/**
 * Master Information
 */
@Generated(
    value = {
        "http://www.jooq.org",
            "jOOQ version:3.11.9"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SlaveMasterInfo extends TableImpl<SlaveMasterInfoRecord> {

    private static final long serialVersionUID = 422523777;

    /**
     * The reference instance of <code>mysql.slave_master_info</code>
     */
    public static final SlaveMasterInfo SLAVE_MASTER_INFO = new SlaveMasterInfo();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<SlaveMasterInfoRecord> getRecordType() {
        return SlaveMasterInfoRecord.class;
    }

    /**
     * The column <code>mysql.slave_master_info.Number_of_lines</code>. Number of lines in the file.
     */
    public final TableField<SlaveMasterInfoRecord, UInteger> NUMBER_OF_LINES = createField("Number_of_lines", org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false), this, "Number of lines in the file.");

    /**
     * The column <code>mysql.slave_master_info.Master_log_name</code>. The name of the master binary log currently being read from the master.
     */
    public final TableField<SlaveMasterInfoRecord, String> MASTER_LOG_NAME = createField("Master_log_name", org.jooq.impl.SQLDataType.CLOB.nullable(false), this, "The name of the master binary log currently being read from the master.");

    /**
     * The column <code>mysql.slave_master_info.Master_log_pos</code>. The master log position of the last read event.
     */
    public final TableField<SlaveMasterInfoRecord, ULong> MASTER_LOG_POS = createField("Master_log_pos", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "The master log position of the last read event.");

    /**
     * The column <code>mysql.slave_master_info.Host</code>. The host name of the master.
     */
    public final TableField<SlaveMasterInfoRecord, String> HOST = createField("Host", org.jooq.impl.SQLDataType.CHAR(64), this, "The host name of the master.");

    /**
     * The column <code>mysql.slave_master_info.User_name</code>. The user name used to connect to the master.
     */
    public final TableField<SlaveMasterInfoRecord, String> USER_NAME = createField("User_name", org.jooq.impl.SQLDataType.CLOB, this, "The user name used to connect to the master.");

    /**
     * The column <code>mysql.slave_master_info.User_password</code>. The password used to connect to the master.
     */
    public final TableField<SlaveMasterInfoRecord, String> USER_PASSWORD = createField("User_password", org.jooq.impl.SQLDataType.CLOB, this, "The password used to connect to the master.");

    /**
     * The column <code>mysql.slave_master_info.Port</code>. The network port used to connect to the master.
     */
    public final TableField<SlaveMasterInfoRecord, UInteger> PORT = createField("Port", org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false), this, "The network port used to connect to the master.");

    /**
     * The column <code>mysql.slave_master_info.Connect_retry</code>. The period (in seconds) that the slave will wait before trying to reconnect to the master.
     */
    public final TableField<SlaveMasterInfoRecord, UInteger> CONNECT_RETRY = createField("Connect_retry", org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false), this, "The period (in seconds) that the slave will wait before trying to reconnect to the master.");

    /**
     * The column <code>mysql.slave_master_info.Enabled_ssl</code>. Indicates whether the server supports SSL connections.
     */
    public final TableField<SlaveMasterInfoRecord, Byte> ENABLED_SSL = createField("Enabled_ssl", org.jooq.impl.SQLDataType.TINYINT.nullable(false), this, "Indicates whether the server supports SSL connections.");

    /**
     * The column <code>mysql.slave_master_info.Ssl_ca</code>. The file used for the Certificate Authority (CA) certificate.
     */
    public final TableField<SlaveMasterInfoRecord, String> SSL_CA = createField("Ssl_ca", org.jooq.impl.SQLDataType.CLOB, this, "The file used for the Certificate Authority (CA) certificate.");

    /**
     * The column <code>mysql.slave_master_info.Ssl_capath</code>. The path to the Certificate Authority (CA) certificates.
     */
    public final TableField<SlaveMasterInfoRecord, String> SSL_CAPATH = createField("Ssl_capath", org.jooq.impl.SQLDataType.CLOB, this, "The path to the Certificate Authority (CA) certificates.");

    /**
     * The column <code>mysql.slave_master_info.Ssl_cert</code>. The name of the SSL certificate file.
     */
    public final TableField<SlaveMasterInfoRecord, String> SSL_CERT = createField("Ssl_cert", org.jooq.impl.SQLDataType.CLOB, this, "The name of the SSL certificate file.");

    /**
     * The column <code>mysql.slave_master_info.Ssl_cipher</code>. The name of the cipher in use for the SSL connection.
     */
    public final TableField<SlaveMasterInfoRecord, String> SSL_CIPHER = createField("Ssl_cipher", org.jooq.impl.SQLDataType.CLOB, this, "The name of the cipher in use for the SSL connection.");

    /**
     * The column <code>mysql.slave_master_info.Ssl_key</code>. The name of the SSL key file.
     */
    public final TableField<SlaveMasterInfoRecord, String> SSL_KEY = createField("Ssl_key", org.jooq.impl.SQLDataType.CLOB, this, "The name of the SSL key file.");

    /**
     * The column <code>mysql.slave_master_info.Ssl_verify_server_cert</code>. Whether to verify the server certificate.
     */
    public final TableField<SlaveMasterInfoRecord, Byte> SSL_VERIFY_SERVER_CERT = createField("Ssl_verify_server_cert", org.jooq.impl.SQLDataType.TINYINT.nullable(false), this, "Whether to verify the server certificate.");

    /**
     * The column <code>mysql.slave_master_info.Heartbeat</code>.
     */
    public final TableField<SlaveMasterInfoRecord, Double> HEARTBEAT = createField("Heartbeat", org.jooq.impl.SQLDataType.FLOAT.nullable(false), this, "");

    /**
     * The column <code>mysql.slave_master_info.Bind</code>. Displays which interface is employed when connecting to the MySQL server
     */
    public final TableField<SlaveMasterInfoRecord, String> BIND = createField("Bind", org.jooq.impl.SQLDataType.CLOB, this, "Displays which interface is employed when connecting to the MySQL server");

    /**
     * The column <code>mysql.slave_master_info.Ignored_server_ids</code>. The number of server IDs to be ignored, followed by the actual server IDs
     */
    public final TableField<SlaveMasterInfoRecord, String> IGNORED_SERVER_IDS = createField("Ignored_server_ids", org.jooq.impl.SQLDataType.CLOB, this, "The number of server IDs to be ignored, followed by the actual server IDs");

    /**
     * The column <code>mysql.slave_master_info.Uuid</code>. The master server uuid.
     */
    public final TableField<SlaveMasterInfoRecord, String> UUID = createField("Uuid", org.jooq.impl.SQLDataType.CLOB, this, "The master server uuid.");

    /**
     * The column <code>mysql.slave_master_info.Retry_count</code>. Number of reconnect attempts, to the master, before giving up.
     */
    public final TableField<SlaveMasterInfoRecord, ULong> RETRY_COUNT = createField("Retry_count", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "Number of reconnect attempts, to the master, before giving up.");

    /**
     * The column <code>mysql.slave_master_info.Ssl_crl</code>. The file used for the Certificate Revocation List (CRL)
     */
    public final TableField<SlaveMasterInfoRecord, String> SSL_CRL = createField("Ssl_crl", org.jooq.impl.SQLDataType.CLOB, this, "The file used for the Certificate Revocation List (CRL)");

    /**
     * The column <code>mysql.slave_master_info.Ssl_crlpath</code>. The path used for Certificate Revocation List (CRL) files
     */
    public final TableField<SlaveMasterInfoRecord, String> SSL_CRLPATH = createField("Ssl_crlpath", org.jooq.impl.SQLDataType.CLOB, this, "The path used for Certificate Revocation List (CRL) files");

    /**
     * The column <code>mysql.slave_master_info.Enabled_auto_position</code>. Indicates whether GTIDs will be used to retrieve events from the master.
     */
    public final TableField<SlaveMasterInfoRecord, Byte> ENABLED_AUTO_POSITION = createField("Enabled_auto_position", org.jooq.impl.SQLDataType.TINYINT.nullable(false), this, "Indicates whether GTIDs will be used to retrieve events from the master.");

    /**
     * The column <code>mysql.slave_master_info.Channel_name</code>. The channel on which the slave is connected to a source. Used in Multisource Replication
     */
    public final TableField<SlaveMasterInfoRecord, String> CHANNEL_NAME = createField("Channel_name", org.jooq.impl.SQLDataType.CHAR(64).nullable(false), this, "The channel on which the slave is connected to a source. Used in Multisource Replication");

    /**
     * The column <code>mysql.slave_master_info.Tls_version</code>. Tls version
     */
    public final TableField<SlaveMasterInfoRecord, String> TLS_VERSION = createField("Tls_version", org.jooq.impl.SQLDataType.CLOB, this, "Tls version");

    /**
     * Create a <code>mysql.slave_master_info</code> table reference
     */
    public SlaveMasterInfo() {
        this(DSL.name("slave_master_info"), null);
    }

    /**
     * Create an aliased <code>mysql.slave_master_info</code> table reference
     */
    public SlaveMasterInfo(String alias) {
        this(DSL.name(alias), SLAVE_MASTER_INFO);
    }

    /**
     * Create an aliased <code>mysql.slave_master_info</code> table reference
     */
    public SlaveMasterInfo(Name alias) {
        this(alias, SLAVE_MASTER_INFO);
    }

    private SlaveMasterInfo(Name alias, Table<SlaveMasterInfoRecord> aliased) {
        this(alias, aliased, null);
    }

    private SlaveMasterInfo(Name alias, Table<SlaveMasterInfoRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("Master Information"));
    }

    public <O extends Record> SlaveMasterInfo(Table<O> child, ForeignKey<O, SlaveMasterInfoRecord> key) {
        super(child, key, SLAVE_MASTER_INFO);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Mysql.MYSQL;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.SLAVE_MASTER_INFO_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<SlaveMasterInfoRecord> getPrimaryKey() {
        return Keys.KEY_SLAVE_MASTER_INFO_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<SlaveMasterInfoRecord>> getKeys() {
        return Arrays.<UniqueKey<SlaveMasterInfoRecord>>asList(Keys.KEY_SLAVE_MASTER_INFO_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SlaveMasterInfo as(String alias) {
        return new SlaveMasterInfo(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SlaveMasterInfo as(Name alias) {
        return new SlaveMasterInfo(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public SlaveMasterInfo rename(String name) {
        return new SlaveMasterInfo(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public SlaveMasterInfo rename(Name name) {
        return new SlaveMasterInfo(name, null);
    }
}
